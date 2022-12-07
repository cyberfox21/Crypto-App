package com.cyberfox21.cryptoapp.presentation.currency_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.databinding.FragmentCurrencyListBinding;
import com.cyberfox21.cryptoapp.di.CurrencyListViewModelFactory;
import com.cyberfox21.cryptoapp.presentation.common.BaseDiffUtilCallback;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.common.MainDelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.currency_detail.CurrencyDetailFragment;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CurrencyItemClickListener;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CurrencyListAdapter;
import com.cyberfox21.cryptoapp.presentation.navigation.NavigationHolder;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author t.shkolnik
 */
@AndroidEntryPoint
public class CurrencyListFragment extends Fragment {

    private static final String TAG = "CurrencyListFragment";

    MainDelegateAdapter adapter;

    private FragmentCurrencyListBinding binding;

    @Inject
    CurrencyListViewModelFactory viewModelFactory;

    private CurrencyListViewModel viewModel;

    private CurrencyItemClickListener listener = id -> navigateToDetails(id);

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
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewModel();
        setupRecyclerView();
        observeViewModel();
        addListeners();
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this, viewModelFactory)
                .get(CurrencyListViewModel.class);
    }

    private void setupRecyclerView() {
        adapter = new MainDelegateAdapter(new BaseDiffUtilCallback());
        addDelegates();
        binding.recyclerView.setAdapter(adapter);
    }

    private void addDelegates() {
        CurrencyListAdapter currencyListAdapter = new CurrencyListAdapter();
        currencyListAdapter.setListener(listener);
        adapter.addDelegate(currencyListAdapter);
    }

    private void navigateToDetails(String id) {
        NavigationHolder navigator = ((NavigationHolder) getActivity());
        if (navigator != null) {
            navigator.addFragment(CurrencyDetailFragment.newInstance(id), TAG);
        }
    }

    private void observeViewModel() {
        viewModel.requestCoins();
        viewModel.getCoins().observe(getViewLifecycleOwner(), resource -> {
            if (resource instanceof Resource.Success) {
                showList();
                adapter.submitList((List<DelegateItem>) resource.getData());
            } else if (resource instanceof Resource.Loading) {
                showLoading();
            } else {
                showError();
            }
        });
    }

    private void addListeners() {
        binding.errorLayout.btnNetwork.setOnClickListener(v -> viewModel.requestCoins());
    }

    private void showList() {
        binding.progressBar.setVisibility(View.INVISIBLE);
        binding.recyclerView.setVisibility(View.VISIBLE);
        binding.errorLayout.getRoot().setVisibility(View.INVISIBLE);
    }

    private void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.recyclerView.setVisibility(View.INVISIBLE);
        binding.errorLayout.getRoot().setVisibility(View.INVISIBLE);
    }

    private void showError() {
        binding.progressBar.animate();
        binding.progressBar.setVisibility(View.INVISIBLE);
        binding.recyclerView.setVisibility(View.INVISIBLE);
        binding.errorLayout.getRoot().setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static CurrencyListFragment newInstance() {
        return new CurrencyListFragment();
    }
}
