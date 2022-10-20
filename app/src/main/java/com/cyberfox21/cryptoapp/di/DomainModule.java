package com.cyberfox21.cryptoapp.di;

import com.cyberfox21.cryptoapp.domain.usecase.get_coin.GetCoinUseCase;
import com.cyberfox21.cryptoapp.domain.usecase.get_coin.GetCoinUseCaseImpl;
import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCase;
import com.cyberfox21.cryptoapp.domain.usecase.get_coins.GetCoinsUseCaseImpl;

import dagger.Binds;
import dagger.Module;

/**
 * @author t.shkolnik
 */
@Module
public abstract class DomainModule {

    @Binds
    abstract GetCoinUseCase bindCoinUseCase(GetCoinUseCaseImpl impl);

    @Binds
    abstract GetCoinsUseCase bindCoinsUseCase(GetCoinsUseCaseImpl impl);
}
