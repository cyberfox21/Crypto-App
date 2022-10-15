package com.cyberfox21.cryptoapp.domain.repository;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;

/**
 * @author t.shkolnik
 */
public interface CoinRepository {

    Single<Resource<ArrayList<Coin>>> getCoins();

    Single<Resource<CoinDetail>> getCoinById(String coinId);
}
