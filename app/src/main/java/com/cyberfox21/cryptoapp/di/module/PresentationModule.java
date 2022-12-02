package com.cyberfox21.cryptoapp.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.di.ViewModelKey;
import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase;
import com.cyberfox21.cryptoapp.presentation.common.CurrencyListViewModelFactory;
import com.cyberfox21.cryptoapp.presentation.currency_list.CurrencyListViewModel;

import java.sql.PreparedStatement;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;

/**
 * @author t.shkolnik
 */
@Module
@InstallIn(SingletonComponent.class)
public abstract class PresentationModule {

//    @Binds
//    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Provides
    static CurrencyListViewModelFactory provideViewModelFactory(GetCoinsUseCase getCoinsUseCase) {
        return new CurrencyListViewModelFactory(getCoinsUseCase);
    }


//
//    @Binds
////    @IntoMap
////    @ViewModelKey(CurrencyListViewModel.class)
//    abstract ViewModel provideCurrencyListViewModel(CurrencyListViewModel currencyListViewModel);
}
