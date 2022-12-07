package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item;

import com.cyberfox21.cryptoapp.common.JavaDataClass;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class TitleDelegateItem implements DelegateItem {

    int rank;
    String name;
    String symbol;
    boolean isActive;

    public TitleDelegateItem(int rank, String name, String symbol, boolean isActive) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.isActive = isActive;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public String getId() {
        return String.valueOf(rank);
    }

    @Override
    public JavaDataClass getContent() {
        return (JavaDataClass) this;
    }
}
