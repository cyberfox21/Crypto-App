package com.cyberfox21.cryptoapp.data.remote;

import com.cyberfox21.cryptoapp.data.dto.CoinDetailDto;
import com.cyberfox21.cryptoapp.data.dto.CoinDto;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

/**
 * @author t.shkolnik
 */
public interface CoinPaprikaApi {

    @GET("/v1/coins")
    Single<ArrayList<CoinDto>> getCoins();

    @GET("/v1/coins/{coinId}")
    Single<CoinDetailDto> getCoinById(String coinId);
}
