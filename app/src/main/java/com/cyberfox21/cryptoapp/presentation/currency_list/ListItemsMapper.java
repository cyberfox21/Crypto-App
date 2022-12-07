package com.cyberfox21.cryptoapp.presentation.currency_list;

import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CoinDelegateItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t.shkolnik
 */
public class ListItemsMapper {

    List<CoinDelegateItem> map(List<Coin> coins) {
        List<CoinDelegateItem> list = new ArrayList<>();
        for (Coin coin : coins) {
            list.add(new CoinDelegateItem(coin));
        }
        return list;
    }
}
