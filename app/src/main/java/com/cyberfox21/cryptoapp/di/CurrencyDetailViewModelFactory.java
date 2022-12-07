package com.cyberfox21.cryptoapp.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.domain.usecase.get_coin.GetCoinUseCase;
import com.cyberfox21.cryptoapp.presentation.currency_detail.CurrencyDetailViewModel;
import com.cyberfox21.cryptoapp.presentation.currency_detail.DetailItemsMapper;

/**
 * @author t.shkolnik
 */
public class CurrencyDetailViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    private final GetCoinUseCase getCoinUseCase;
    @NonNull
    private final DetailItemsMapper mapper;

    public CurrencyDetailViewModelFactory(
            @NonNull GetCoinUseCase getCoinUseCase,
            DetailItemsMapper mapper
    ) {
        this.getCoinUseCase = getCoinUseCase;
        this.mapper = mapper;
    }

    @NonNull
    @Override
    public CurrencyDetailViewModel create(@NonNull final Class modelClass) {
        return new CurrencyDetailViewModel(getCoinUseCase, mapper);
    }
}
