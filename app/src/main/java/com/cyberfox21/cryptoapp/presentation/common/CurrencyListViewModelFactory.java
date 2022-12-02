package com.cyberfox21.cryptoapp.presentation.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase;
import com.cyberfox21.cryptoapp.presentation.currency_list.CurrencyListViewModel;

import javax.inject.Inject;

public class CurrencyListViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    private final GetCoinsUseCase getCoinsUseCase;

    @Inject
    public CurrencyListViewModelFactory(@NonNull GetCoinsUseCase getCoinsUseCase) {
        this.getCoinsUseCase = getCoinsUseCase;
    }

    @NonNull
    @Override
    public CurrencyListViewModel create(@NonNull final Class modelClass) {
        return new CurrencyListViewModel(getCoinsUseCase);
    }
}
