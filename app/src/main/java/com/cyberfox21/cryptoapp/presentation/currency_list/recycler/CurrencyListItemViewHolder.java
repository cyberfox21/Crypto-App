package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemCurrencyListBinding;

/**
 * @author t.shkolnik
 */
public class CurrencyListItemViewHolder extends RecyclerView.ViewHolder {

    private final ItemCurrencyListBinding binding;

    public CurrencyListItemViewHolder(@NonNull ItemCurrencyListBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ItemCurrencyListBinding getBinding() {
        return binding;
    }
}
