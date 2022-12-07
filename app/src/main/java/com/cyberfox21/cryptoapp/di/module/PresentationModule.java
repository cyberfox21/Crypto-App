package com.cyberfox21.cryptoapp.di.module;

import com.cyberfox21.cryptoapp.di.CurrencyDetailViewModelFactory;
import com.cyberfox21.cryptoapp.di.CurrencyListViewModelFactory;
import com.cyberfox21.cryptoapp.domain.usecase.get_coin.GetCoinUseCase;
import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase;
import com.cyberfox21.cryptoapp.presentation.currency_detail.DetailItemsMapper;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

/**
 * @author t.shkolnik
 */
@Module
@InstallIn(SingletonComponent.class)
public abstract class PresentationModule {

    @Provides
    static CurrencyListViewModelFactory provideCurrencyListViewModelFactory(GetCoinsUseCase getCoinsUseCase) {
        return new CurrencyListViewModelFactory(getCoinsUseCase);
    }

    @Provides
    static CurrencyDetailViewModelFactory provideCurrencyDetailViewModelFactory(
            GetCoinUseCase getCoinUseCase,
            DetailItemsMapper mapper
    ) {
        return new CurrencyDetailViewModelFactory(getCoinUseCase, mapper);
    }
}
