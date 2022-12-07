package com.cyberfox21.cryptoapp.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cyberfox21.cryptoapp.R;
import com.cyberfox21.cryptoapp.databinding.ActivityMainBinding;
import com.cyberfox21.cryptoapp.presentation.currency_list.CurrencyListFragment;
import com.cyberfox21.cryptoapp.presentation.navigation.NavigationHolder;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author t.shkolnik
 */
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements NavigationHolder {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(CurrencyListFragment.newInstance());
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        int fragment_container_id = R.id.fragment_container;
        getSupportFragmentManager().beginTransaction()
                .replace(fragment_container_id, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void addFragment(Fragment fragment, String tag) {
        int fragment_container_id = R.id.fragment_container;
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(tag)
                .add(fragment_container_id, fragment, tag)
                .commitAllowingStateLoss();
    }
}
