package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.databinding.ItemDetailsTagsBinding;
import com.cyberfox21.cryptoapp.databinding.ItemTagBinding;
import com.cyberfox21.cryptoapp.presentation.common.DelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.TagsDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder.TagsItemViewHolder;
import com.google.android.flexbox.FlexboxLayout;

/**
 * @author t.shkolnik
 */
public class TagsDelegateAdapter implements DelegateAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new TagsItemViewHolder(ItemDetailsTagsBinding.inflate(layoutInflater));
    }

    @Override
    public void onBindViewHolder(
            RecyclerView.ViewHolder viewHolder,
            DelegateItem model,
            int position
    ) {
        TagsItemViewHolder holder = (TagsItemViewHolder) viewHolder;
        TagsDelegateItem item = (TagsDelegateItem) model;
        FlexboxLayout flexbox = holder.getBinding().flexbox;
        LayoutInflater layoutInflater =
                LayoutInflater.from(holder.itemView.getRootView().getContext());
        for (String tag : item.getTags()) {
            ItemTagBinding binding = ItemTagBinding.inflate(layoutInflater);
            binding.tagText.setText(tag);
            flexbox.addView(
                    binding.getRoot()
            );
        }

    }

    @Override
    public boolean isCorrectViewType(DelegateItem item) {
        return item instanceof TagsDelegateItem;
    }
}
