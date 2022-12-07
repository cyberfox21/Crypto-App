package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemDetailsTagsBinding;

/**
 * @author t.shkolnik
 */
public class TagsItemViewHolder extends RecyclerView.ViewHolder {

    private final ItemDetailsTagsBinding binding;

    public TagsItemViewHolder(@NonNull ItemDetailsTagsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ItemDetailsTagsBinding getBinding() {
        return binding;
    }
}
