package com.cyberfox21.cryptoapp.presentation.currency_list;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase;
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
public class CurrencyListViewModel extends ViewModel implements LifecycleObserver {

    private final GetCoinsUseCase getCoinsUseCase;

    private CompositeDisposable disposables = new CompositeDisposable();

    private MutableLiveData<Resource> coins = new MutableLiveData<>();

    public LiveData<Resource> getCoins() {
        return coins;
    }

    @Inject
    public CurrencyListViewModel(GetCoinsUseCase getCoinsUseCase) {
        this.getCoinsUseCase = getCoinsUseCase;
    }

    public void requestCoins() {

        Disposable disposable = getCoinsUseCase.invoke()
                .doOnSuccess(resource ->
                        coins.postValue(new Resource.Loading())
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        arrayListResource -> {
                            List<CoinDelegateItem> listItems =
                                    new ListItemsMapper().map(arrayListResource.getData());
                            Resource.Success<ArrayList<CoinDelegateItem>> result =
                                    new Resource.Success(listItems);
                            coins.setValue(result);
                        },
                        throwable -> coins.setValue(new Resource.Error<Throwable>(
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

