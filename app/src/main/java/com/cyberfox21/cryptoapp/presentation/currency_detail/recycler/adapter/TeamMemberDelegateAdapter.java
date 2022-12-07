package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemTeamMemberBinding;
import com.cyberfox21.cryptoapp.presentation.common.DelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.TeamMemberDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder.TeamMemberViewHolder;

/**
 * @author t.shkolnik
 */
public class TeamMemberDelegateAdapter implements DelegateAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new TeamMemberViewHolder(ItemTeamMemberBinding.inflate(layoutInflater));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, DelegateItem model, int position) {
        ItemTeamMemberBinding binding = ((TeamMemberViewHolder) viewHolder).getBinding();
        TeamMemberDelegateItem item = (TeamMemberDelegateItem) model;

        binding.personName.setText(item.getTeamMember().getName());
        binding.position.setText(item.getTeamMember().getPosition());
    }

    @Override
    public boolean isCorrectViewType(DelegateItem item) {
        return item instanceof TeamMemberDelegateItem;
    }
}
