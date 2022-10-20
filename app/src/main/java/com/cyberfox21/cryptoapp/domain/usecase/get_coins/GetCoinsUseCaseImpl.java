package com.cyberfox21.cryptoapp.domain.usecase.get_coins;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.repository.CoinRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author t.shkolnik
 */
public class GetCoinsUseCaseImpl implements GetCoinsUseCase {

    private final CoinRepository repository;

    @Inject
    public GetCoinsUseCaseImpl(CoinRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Resource<ArrayList<Coin>>> invoke() {
        return repository.getCoins();
    }
}
