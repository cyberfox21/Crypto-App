package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.cyberfox21.cryptoapp.databinding.ItemCurrencyListBinding;
import com.cyberfox21.cryptoapp.domain.entity.Coin;

public class CurrencyListRecyclerAdapter extends ListAdapter<Coin, CurrencyListItemViewHolder> {

    CurrencyItemClickListener listener;

    public CurrencyListRecyclerAdapter(@NonNull CurrencyListDiffUtilCallback diffCallback) {
        super(diffCallback);
    }

    public void setListener(CurrencyItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CurrencyListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCurrencyListBinding binding = ItemCurrencyListBinding.inflate(
                LayoutInflater.from(parent.getContext())
        );
        binding.getRoot().setOnClickListener(v -> listener.onCurrencyClick());
        return new CurrencyListItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyListItemViewHolder holder, int position) {
        ItemCurrencyListBinding binding = holder.getBinding();
        Coin coin = getCurrentList().get(position);
        String isActive;
        if (coin.getActive()) {
            isActive = "active";
        } else {
            isActive = "inactive";
        }
        binding.title.setText("${coin.rank}. ${coin.name} (${coin.symbol})");
        binding.active.setText(isActive);
    }
}
