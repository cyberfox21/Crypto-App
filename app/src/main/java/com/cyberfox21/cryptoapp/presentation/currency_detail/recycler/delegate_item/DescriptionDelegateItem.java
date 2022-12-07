package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item;

import com.cyberfox21.cryptoapp.common.JavaDataClass;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class DescriptionDelegateItem implements DelegateItem {

    String description;

    public DescriptionDelegateItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getId() {
        return description;
    }

    @Override
    public JavaDataClass getContent() {
        return (JavaDataClass) this;
    }
}
