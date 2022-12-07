package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemDescriptionBinding;
import com.cyberfox21.cryptoapp.presentation.common.DelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.DescriptionDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder.DescriptionViewHolder;

/**
 * @author t.shkolnik
 */
public class DescriptionDelegateAdapter implements DelegateAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new DescriptionViewHolder(ItemDescriptionBinding.inflate(layoutInflater));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, DelegateItem model, int position) {
        ItemDescriptionBinding binding = ((DescriptionViewHolder) viewHolder).getBinding();
        DescriptionDelegateItem item = (DescriptionDelegateItem) model;

        binding.description.setText(item.getDescription());
    }

    @Override
    public boolean isCorrectViewType(DelegateItem item) {
        return item instanceof DescriptionDelegateItem;
    }
}
