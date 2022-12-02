package com.cyberfox21.cryptoapp.di.module;

import com.cyberfox21.cryptoapp.common.Constants;
import com.cyberfox21.cryptoapp.data.mapper.DtoToDomainMapper;
import com.cyberfox21.cryptoapp.data.mapper.DtoToDomainMapperImpl;
import com.cyberfox21.cryptoapp.data.remote.CoinPaprikaApi;
import com.cyberfox21.cryptoapp.data.repository.CoinRepositoryImpl;
import com.cyberfox21.cryptoapp.domain.repository.CoinRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author t.shkolnik
 */
@Module
@InstallIn(SingletonComponent.class)
public abstract class DataModule {

    @Provides
    static CoinPaprikaApi provideCoinPaprikaApi() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinPaprikaApi.class);
    }

    @Binds
    public abstract CoinRepository provideCoinRepository(CoinRepositoryImpl impl);

    @Binds
    public abstract DtoToDomainMapper provideDtoToDomainMapper(DtoToDomainMapperImpl impl);
}
