package com.cyberfox21.cryptoapp.presentation.common;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * @author t.shkolnik
 */
public class BaseDiffUtilCallback extends DiffUtil.ItemCallback<DelegateItem> {

    @Override
    public boolean areItemsTheSame(@NonNull DelegateItem oldItem, @NonNull DelegateItem newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull DelegateItem oldItem, @NonNull DelegateItem newItem) {
        return oldItem.getId().equals(newItem.getId()) &&
                oldItem.getContent().isEquals(newItem.getContent());
    }
}
