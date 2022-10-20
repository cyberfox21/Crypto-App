package com.cyberfox21.cryptoapp.data.repository;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.data.remote.CoinPaprikaApi;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;
import com.cyberfox21.cryptoapp.domain.repository.CoinRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class CoinRepositoryImpl implements CoinRepository {

    private CoinPaprikaApi api;

    @Inject
    public CoinRepositoryImpl(CoinPaprikaApi api) {
        this.api = api;
    }

    @Override
    public Single<Resource<ArrayList<Coin>>> getCoins() {
        return api.getCoins();
    }

    @Override
    public Single<Resource<CoinDetail>> getCoinById(String coinId) {
        return api.getCoinById(coinId);
    }
}
