package com.cyberfox21.cryptoapp.presentation.common;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author t.shkolnik
 */
public interface DelegateAdapter {

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    void onBindViewHolder(RecyclerView.ViewHolder viewHolder, DelegateItem model, int position);

    boolean isCorrectViewType(DelegateItem item);
}
