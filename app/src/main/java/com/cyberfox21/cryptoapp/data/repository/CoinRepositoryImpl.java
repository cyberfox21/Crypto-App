package com.cyberfox21.cryptoapp.data.repository;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.data.mapper.DtoToDomainMapper;
import com.cyberfox21.cryptoapp.data.remote.CoinPaprikaApi;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;
import com.cyberfox21.cryptoapp.domain.repository.CoinRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class CoinRepositoryImpl implements CoinRepository {

    private final CoinPaprikaApi api;
    private final DtoToDomainMapper mapper;

    @Inject
    public CoinRepositoryImpl(CoinPaprikaApi api, DtoToDomainMapper mapper) {
        this.api = api;
        this.mapper = mapper;
    }

    @Override
    public Single<Resource<ArrayList<Coin>>> getCoins() {
        ArrayList<Coin> coinsList = new ArrayList<>();
        return api.getCoins()
                .flatMap(coinDtos ->
                        {
                            for (int i = 0; i < coinDtos.size(); i++) {
                                coinsList.add(mapper.toCoin(coinDtos.get(i)));
                            }
                            return Single.just(
                                    new Resource.Success<>(coinsList)
                            );
                        }
                );
    }

    @Override
    public Single<Resource<CoinDetail>> getCoinById(String coinId) {
        return api.getCoinById(coinId).flatMap(
                coinDetailDto -> Single.just(
                        new Resource.Success<>(mapper.toCoinDetail(coinDetailDto))
                )
        );
    }
}
