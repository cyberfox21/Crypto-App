package com.cyberfox21.cryptoapp.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase;
import com.cyberfox21.cryptoapp.presentation.currency_list.CurrencyListViewModel;

/**
 * @author t.shkolnik
 */
public class CurrencyListViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    private final GetCoinsUseCase getCoinsUseCase;

    public CurrencyListViewModelFactory(@NonNull GetCoinsUseCase getCoinsUseCase) {
        this.getCoinsUseCase = getCoinsUseCase;
    }

    @NonNull
    @Override
    public CurrencyListViewModel create(@NonNull final Class modelClass) {
        return new CurrencyListViewModel(getCoinsUseCase);
    }
}
