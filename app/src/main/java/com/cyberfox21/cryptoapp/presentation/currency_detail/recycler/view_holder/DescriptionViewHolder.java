package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemDescriptionBinding;

/**
 * @author t.shkolnik
 */
public class DescriptionViewHolder extends RecyclerView.ViewHolder {

    private final ItemDescriptionBinding binding;

    public DescriptionViewHolder(@NonNull ItemDescriptionBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ItemDescriptionBinding getBinding() {
        return binding;
    }
}
