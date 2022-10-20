package com.cyberfox21.cryptoapp.data.mapper;

import com.cyberfox21.cryptoapp.data.dto.CoinDetailDto;
import com.cyberfox21.cryptoapp.data.dto.CoinDto;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;

/**
 * @author t.shkolnik
 */
public interface DtoToDomainMapper {

    CoinDetail toCoinDetail(CoinDetailDto coinDetailDto);

    Coin toCoin(CoinDto coinDto);
}
