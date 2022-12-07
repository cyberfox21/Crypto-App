package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemDetailsTitleBinding;

/**
 * @author t.shkolnik
 */
public class TitleItemViewHolder extends RecyclerView.ViewHolder {

    private final ItemDetailsTitleBinding binding;

    public TitleItemViewHolder(@NonNull ItemDetailsTitleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ItemDetailsTitleBinding getBinding() {
        return binding;
    }
}
