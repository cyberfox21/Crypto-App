package com.cyberfox21.cryptoapp.presentation.currency_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.databinding.FragmentCurrencyListBinding;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CurrencyListDiffUtilCallback;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CurrencyListRecyclerAdapter;

/**
 * @author t.shkolnik
 */
public class CurrencyListFragment extends Fragment {

    CurrencyListRecyclerAdapter adapter = new CurrencyListRecyclerAdapter(
            new CurrencyListDiffUtilCallback()
    );

    private FragmentCurrencyListBinding _binding;
    public FragmentCurrencyListBinding binding;

    public FragmentCurrencyListBinding getBinding() {
        return _binding;
    }

    CurrencyListViewModel viewModel = new ViewModelProvider(
            this,
            ViewModelProvider.Factory.from(CurrencyListViewModel.initializer)
    ).get(CurrencyListViewModel.class);

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
        _binding = FragmentCurrencyListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
        addListeners();
    }

    private void setupRecyclerView() {
        binding.recyclerView.setAdapter(adapter);
    }

    private void addListeners() {
        adapter.setListener(this::navigateToDetails);
    }

    private void navigateToDetails() {

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

    public static CurrencyListFragment newInstance() {
        return new CurrencyListFragment();
    }
}
