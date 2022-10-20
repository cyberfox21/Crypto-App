package com.cyberfox21.cryptoapp.data.mapper;

import com.cyberfox21.cryptoapp.data.dto.CoinDetailDto;
import com.cyberfox21.cryptoapp.data.dto.CoinDto;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;

import java.util.ArrayList;

public class DtoToDomainMapperImpl implements DtoToDomainMapper {

    @Override
    public CoinDetail toCoinDetail(CoinDetailDto coinDetailDto) {
        ArrayList<String> tags = new ArrayList<>();

        for (int tagIndex = 0; tagIndex < coinDetailDto.getTags().size(); tagIndex++) {
            tags.add(coinDetailDto.getTags().get(tagIndex).getName());
        }

        return new CoinDetail(
                coinDetailDto.getId(),
                coinDetailDto.getName(),
                coinDetailDto.getDescription(),
                coinDetailDto.getSymbol(),
                coinDetailDto.getRank(),
                coinDetailDto.getActive(),
                tags,
                coinDetailDto.getTeam()
        );
    }

    @Override
    public Coin toCoin(CoinDto coinDto) {
        return new Coin(
                coinDto.getId(),
                coinDto.getActive(),
                coinDto.getName(),
                coinDto.getRank(),
                coinDto.getSymbol()
        );
    }
}
