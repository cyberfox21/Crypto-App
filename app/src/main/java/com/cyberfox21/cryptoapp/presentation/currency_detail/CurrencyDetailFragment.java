package com.cyberfox21.cryptoapp.presentation.currency_detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cyberfox21.cryptoapp.common.Resource;
import com.cyberfox21.cryptoapp.databinding.FragmentCurrencyDetailBinding;
import com.cyberfox21.cryptoapp.di.CurrencyDetailViewModelFactory;
import com.cyberfox21.cryptoapp.presentation.common.BaseDiffUtilCallback;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.common.MainDelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter.DescriptionDelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter.SectionTitleDelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter.TagsDelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter.TeamMemberDelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter.TitleDelegateAdapter;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * @author t.shkolnik
 */
@AndroidEntryPoint
public class CurrencyDetailFragment extends Fragment {

    MainDelegateAdapter adapter;

    static final String COIN_ID_ARGUMENT = "coin_id_argument";

    private String coinId;

    private FragmentCurrencyDetailBinding binding;

    @Inject
    CurrencyDetailViewModelFactory viewModelFactory;

    CurrencyDetailViewModel viewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

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
        binding = FragmentCurrencyDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkArguments();
        addListeners();
        setupViewModel();
        setupRecyclerView();
        observeViewModel();
    }

    private void checkArguments() {
        Bundle args = requireArguments();
        if (args.containsKey(COIN_ID_ARGUMENT)) {
            String id = args.getString(COIN_ID_ARGUMENT);
            if (id != null) {
                coinId = id;
            } else {
                showError();
                getActivity().onBackPressed();
            }
        } else {
            showError();
            getActivity().onBackPressed();
        }
    }

    private void addListeners() {
        binding.errorLayout.btnNetwork.setOnClickListener(v -> viewModel.requestCoin(coinId));
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this, viewModelFactory)
                .get(CurrencyDetailViewModel.class);
    }

    private void setupRecyclerView() {
        adapter = new MainDelegateAdapter(new BaseDiffUtilCallback());
        addDelegates();
        binding.detailsRecycler.setAdapter(adapter);
    }

    private void addDelegates() {
        adapter.addDelegate(new TitleDelegateAdapter());
        adapter.addDelegate(new DescriptionDelegateAdapter());
        adapter.addDelegate(new SectionTitleDelegateAdapter());
        adapter.addDelegate(new TagsDelegateAdapter());
        adapter.addDelegate(new TeamMemberDelegateAdapter());
    }

    private void observeViewModel() {
        viewModel.requestCoin(coinId);
        viewModel.getCoin().observe(getViewLifecycleOwner(), resource -> {
            if (resource instanceof Resource.Success) {
                showDetails();
                adapter.submitList((List<DelegateItem>) resource.getData());
            } else if (resource instanceof Resource.Loading) {
                showLoading();
            } else {
                showError();
            }
        });
    }

    private void showDetails() {
        binding.progressBar.setVisibility(View.INVISIBLE);
        binding.detailsRecycler.setVisibility(View.VISIBLE);
        binding.errorLayout.getRoot().setVisibility(View.INVISIBLE);
    }

    private void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.detailsRecycler.setVisibility(View.INVISIBLE);
        binding.errorLayout.getRoot().setVisibility(View.INVISIBLE);
    }

    private void showError() {
        binding.progressBar.setVisibility(View.INVISIBLE);
        binding.detailsRecycler.setVisibility(View.INVISIBLE);
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

    public static CurrencyDetailFragment newInstance(String coinId) {
        CurrencyDetailFragment fragment = new CurrencyDetailFragment();
        Bundle arguments = new Bundle();
        arguments.putString(COIN_ID_ARGUMENT, coinId);
        fragment.setArguments(arguments);
        return fragment;
    }
}
