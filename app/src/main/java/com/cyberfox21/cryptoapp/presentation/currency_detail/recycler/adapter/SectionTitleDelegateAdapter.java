package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemSectionTitleBinding;
import com.cyberfox21.cryptoapp.presentation.common.DelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.SectionTitleDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder.SectionTitleViewHolder;

/**
 * @author t.shkolnik
 */
public class SectionTitleDelegateAdapter implements DelegateAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new SectionTitleViewHolder(ItemSectionTitleBinding.inflate(layoutInflater));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, DelegateItem model, int position) {
        ItemSectionTitleBinding binding = ((SectionTitleViewHolder) viewHolder).getBinding();
        SectionTitleDelegateItem item = (SectionTitleDelegateItem) model;

        binding.sectionTitle.setText(item.getSectionTitle());
    }

    @Override
    public boolean isCorrectViewType(DelegateItem item) {
        return item instanceof SectionTitleDelegateItem;
    }
}
