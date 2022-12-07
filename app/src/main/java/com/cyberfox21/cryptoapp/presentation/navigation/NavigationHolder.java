package com.cyberfox21.cryptoapp.presentation.navigation;

import androidx.fragment.app.Fragment;

/**
 * @author t.shkolnik
 */
public interface NavigationHolder {

    void replaceFragment(Fragment fragment);

    void addFragment(Fragment fragment, String tag);
}
