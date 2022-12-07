package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemSectionTitleBinding;

/**
 * @author t.shkolnik
 */
public class SectionTitleViewHolder extends RecyclerView.ViewHolder {

    private final ItemSectionTitleBinding binding;

    public SectionTitleViewHolder(@NonNull ItemSectionTitleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ItemSectionTitleBinding getBinding() {
        return binding;
    }
}
