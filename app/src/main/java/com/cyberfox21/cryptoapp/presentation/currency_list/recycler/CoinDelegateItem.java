package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class CoinDelegateItem implements DelegateItem<Coin> {

    String id;
    Coin coin;

    public CoinDelegateItem(String id, Coin coin) {
        this.id = id;
        this.coin = coin;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Coin getContent() {
        return coin;
    }
}
