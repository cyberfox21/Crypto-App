package com.cyberfox21.cryptoapp.presentation.common;

import com.cyberfox21.cryptoapp.common.recycler.JavaDataClass;

/**
 * @author t.shkolnik
 */
public interface DelegateItem<T extends JavaDataClass> {

    String getId();

    T getContent();
}
