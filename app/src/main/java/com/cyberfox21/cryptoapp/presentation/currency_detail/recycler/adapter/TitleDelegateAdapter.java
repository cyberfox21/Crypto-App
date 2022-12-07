package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.R;
import com.cyberfox21.cryptoapp.databinding.ItemDetailsTitleBinding;
import com.cyberfox21.cryptoapp.presentation.common.DelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.TitleDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.view_holder.TitleItemViewHolder;

/**
 * @author t.shkolnik
 */
public class TitleDelegateAdapter implements DelegateAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemDetailsTitleBinding binding = ItemDetailsTitleBinding.inflate(layoutInflater);
        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        return new TitleItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, DelegateItem model, int position) {
        ItemDetailsTitleBinding binding = ((TitleItemViewHolder) viewHolder).getBinding();
        TitleDelegateItem item = (TitleDelegateItem) model;

        String isActive;
        if (item.getIsActive()) {
            isActive = "active";
        } else {
            isActive = "inactive";
        }
        String title = item.getRank() + ". " + item.getName() + " " + item.getSymbol();
        binding.title.setText(title);
        int activeTextColor = item.getIsActive() ?
                viewHolder.itemView
                        .getContext()
                        .getResources()
                        .getColor(R.color.primary) : Color.RED;

        binding.active.setTextColor(activeTextColor);
        binding.active.setText(isActive);
    }

    @Override
    public boolean isCorrectViewType(DelegateItem item) {
        return item instanceof TitleDelegateItem;
    }
}
