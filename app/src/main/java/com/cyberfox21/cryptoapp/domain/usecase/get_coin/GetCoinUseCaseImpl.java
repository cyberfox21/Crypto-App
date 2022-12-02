package com.cyberfox21.cryptoapp.domain.usecase.get_coin;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;
import com.cyberfox21.cryptoapp.domain.repository.CoinRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author t.shkolnik
 */
public class GetCoinUseCaseImpl implements GetCoinUseCase {

    private final CoinRepository repository;

    @Inject
    public GetCoinUseCaseImpl(CoinRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Resource<CoinDetail>> invoke(String id) {
        return repository.getCoinById(id);
    }
}
