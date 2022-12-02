package com.cyberfox21.cryptoapp.presentation.currency_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.databinding.FragmentCurrencyListBinding;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.presentation.common.CurrencyListViewModelFactory;
import com.cyberfox21.cryptoapp.presentation.currency_detail.CurrencyDetailFragment;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CurrencyListDiffUtilCallback;
import com.cyberfox21.cryptoapp.presentation.currency_list.recycler.CurrencyListRecyclerAdapter;
import com.cyberfox21.cryptoapp.presentation.navigation.NavigationHolder;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author t.shkolnik
 */
@AndroidEntryPoint
public class CurrencyListFragment extends Fragment {

    CurrencyListRecyclerAdapter adapter = new CurrencyListRecyclerAdapter(
            new CurrencyListDiffUtilCallback()
    );

    private FragmentCurrencyListBinding binding;

    @Inject
    CurrencyListViewModelFactory viewModelFactory;

    private CurrencyListViewModel viewModel;

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
        addListeners();
        observeViewModel();
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this, viewModelFactory)
                .get(CurrencyListViewModel.class);
    }

    private void setupRecyclerView() {
        binding.recyclerView.setAdapter(adapter);
    }

    private void addListeners() {
        adapter.setListener(this::navigateToDetails);
    }

    private void navigateToDetails() {
        NavigationHolder navigator = ((NavigationHolder) getActivity());
        if (navigator != null) {
            navigator.navigateTo(CurrencyDetailFragment.newInstance());
        }
    }

    private void observeViewModel() {
        viewModel.requestCoins();
        viewModel.getCoins().observe(getViewLifecycleOwner(), resource -> {
            String text;
            if (resource instanceof Resource.Success) {
                adapter.submitList((ArrayList<Coin>) (resource.getData()));
            } else if (resource instanceof Resource.Loading) {
                text = resource.getMessage() + " loading";
//                    binding.textView.setText(text);
            } else if (resource instanceof Resource.Error) {
                text = resource.getMessage() + " error";
//                    binding.textView.setText(text);
            } else {
                text = "unknown";
//                    binding.textView.setText(text);
            }
        });
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
