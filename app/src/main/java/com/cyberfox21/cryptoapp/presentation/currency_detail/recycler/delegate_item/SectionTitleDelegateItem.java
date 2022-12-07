package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item;

import com.cyberfox21.cryptoapp.common.JavaDataClass;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class SectionTitleDelegateItem implements DelegateItem {

    String sectionTitle;

    public SectionTitleDelegateItem(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @Override
    public String getId() {
        return sectionTitle;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    @Override
    public JavaDataClass getContent() {
        return (JavaDataClass) this;
    }
}
