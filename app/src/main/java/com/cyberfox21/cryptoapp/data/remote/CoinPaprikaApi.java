package com.cyberfox21.cryptoapp.data.remote;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

/**
 * @author t.shkolnik
 */
public interface CoinPaprikaApi {

    @GET("/v1/coins")
    Single<Resource<ArrayList<Coin>>> getCoins();

    @GET("/v1/coins/{coinId}")
    Single<Resource<CoinDetail>> getCoinById(String coinId);
}
