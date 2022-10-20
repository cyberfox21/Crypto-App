package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.cyberfox21.cryptoapp.domain.entity.Coin;

public class CurrencyListDiffUtilCallback extends DiffUtil.ItemCallback<Coin> {

    @Override
    public boolean areItemsTheSame(@NonNull Coin oldItem, @NonNull Coin newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Coin oldItem, @NonNull Coin newItem) {
        return oldItem.getName().equals(newItem.getName()) &&
                oldItem.getSymbol().equals(newItem.getSymbol()) &&
                oldItem.getActive().equals(newItem.getActive()) &&
                oldItem.getRank() == (newItem.getRank());
    }
}
