package com.cyberfox21.cryptoapp.presentation.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t.shkolnik
 */
public class MainDelegateAdapter extends ListAdapter<DelegateItem, RecyclerView.ViewHolder> {

    private List<DelegateAdapter> delegates = new ArrayList();

    public MainDelegateAdapter(BaseDiffUtilCallback baseDiffUtilCallback) {
        super(baseDiffUtilCallback);
    }

    public void addDelegate(DelegateAdapter adapter) {
        delegates.add(adapter);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return delegates.get(viewType).onCreateViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        delegates.get(getItemViewType(position)).onBindViewHolder(holder, getCurrentList().get(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 0;
        for (DelegateAdapter delegate : delegates) {
            if (delegate.isCorrectViewType(getCurrentList().get(position))) {
                viewType = delegates.indexOf(delegate);
            }
        }
        return viewType;
    }
}
