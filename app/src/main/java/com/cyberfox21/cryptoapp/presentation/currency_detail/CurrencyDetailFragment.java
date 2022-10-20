package com.cyberfox21.cryptoapp.presentation.currency_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.databinding.FragmentCurrencyDetailBinding;

/**
 * @author t.shkolnik
 */
public class CurrencyDetailFragment extends Fragment {

    private FragmentCurrencyDetailBinding _binding;
    public FragmentCurrencyDetailBinding binding;

    public FragmentCurrencyDetailBinding getBinding() {
        return _binding;
    }

    CurrencyDetailViewModel viewModel = new ViewModelProvider(
            this,
            ViewModelProvider.Factory.from(CurrencyDetailViewModel.initializer)
    ).get(CurrencyDetailViewModel.class);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        _binding = FragmentCurrencyDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static CurrencyDetailFragment newInstance() {
        return new CurrencyDetailFragment();
    }
}
