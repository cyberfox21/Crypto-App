package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemTeamMemberBinding;

/**
 * @author t.shkolnik
 */
public class TeamMemberViewHolder extends RecyclerView.ViewHolder {

    private final ItemTeamMemberBinding binding;

    public TeamMemberViewHolder(@NonNull ItemTeamMemberBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public ItemTeamMemberBinding getBinding() {
        return binding;
    }
}
