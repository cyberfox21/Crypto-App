package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class CoinDelegateItem implements DelegateItem<Coin> {

    Coin coin;

    public CoinDelegateItem(Coin coin) {
        this.coin = coin;
    }

    @Override
    public String getId() {
        return coin.getId();
    }

    @Override
    public Coin getContent() {
        return coin;
    }
}
