package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item;

import com.cyberfox21.cryptoapp.common.JavaDataClass;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

import java.util.List;

/**
 * @author t.shkolnik
 */
public class TagsDelegateItem implements DelegateItem {

    List<String> tags;

    public TagsDelegateItem(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String getId() {
        return tags.get(0);
    }

    @Override
    public JavaDataClass getContent() {
        return (JavaDataClass) tags;
    }

    public List<String> getTags() {
        return tags;
    }
}
