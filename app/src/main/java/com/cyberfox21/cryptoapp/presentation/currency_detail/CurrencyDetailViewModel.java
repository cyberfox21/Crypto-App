package com.cyberfox21.cryptoapp.presentation.currency_detail;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

/**
 * @author t.shkolnik
 */
public class CurrencyDetailViewModel extends ViewModel implements LifecycleObserver {

    public CurrencyDetailViewModel() {}

    static final ViewModelInitializer<CurrencyDetailViewModel> initializer =
            new ViewModelInitializer<>(
                    CurrencyDetailViewModel.class,
                    creationExtras -> new CurrencyDetailViewModel()
            );
}
