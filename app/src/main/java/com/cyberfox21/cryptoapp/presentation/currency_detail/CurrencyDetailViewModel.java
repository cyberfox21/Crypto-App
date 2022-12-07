package com.cyberfox21.cryptoapp.presentation.currency_detail;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.domain.usecase.get_coin.GetCoinUseCase;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CoinDelegateItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author t.shkolnik
 */
@HiltViewModel
public class CurrencyDetailViewModel extends ViewModel implements LifecycleObserver {

    private final DetailItemsMapper mapper;
    private final GetCoinUseCase getCoinUseCase;

    private CompositeDisposable disposables = new CompositeDisposable();

    private MutableLiveData<Resource> coin = new MutableLiveData<>();

    public LiveData<Resource> getCoin() {
        return coin;
    }

    @Inject
    public CurrencyDetailViewModel(GetCoinUseCase getCoinUseCase, DetailItemsMapper mapper) {
        this.getCoinUseCase = getCoinUseCase;
        this.mapper = mapper;
    }

    public void requestCoin(String coinId) {

        Disposable disposable = getCoinUseCase.invoke(coinId)
                .doOnSuccess(resource ->
                        coin.postValue(new Resource.Loading())
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        arrayListResource -> {
                            List<DelegateItem> detailItems =
                                    mapper.map(arrayListResource.getData());
                            Resource.Success<ArrayList<CoinDelegateItem>> result =
                                    new Resource.Success(detailItems);
                            coin.setValue(result);
                        },
                        throwable -> coin.setValue(new Resource.Error<Throwable>(
                                throwable + " error occurred when receiving coins")
                        )
                );

        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        disposables.dispose();
    }
}

