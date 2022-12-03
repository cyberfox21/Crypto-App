package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.ListAdapter;

import com.cyberfox21.cryptoapp.R;
import com.cyberfox21.cryptoapp.databinding.ItemCurrencyListBinding;
import com.cyberfox21.cryptoapp.domain.entity.Coin;

/**
 * @author t.shkolnik
 */
public class CurrencyListRecyclerAdapter extends ListAdapter<Coin, CurrencyListItemViewHolder> {

    CurrencyItemClickListener listener;

    public CurrencyListRecyclerAdapter(@NonNull CurrencyListDiffUtilCallback diffCallback) {
        super(diffCallback);
    }

    public void setListener(CurrencyItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CurrencyListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCurrencyListBinding binding = ItemCurrencyListBinding.inflate(
                LayoutInflater.from(parent.getContext())
        );
        binding.getRoot().setOnClickListener(v -> listener.onCurrencyClick());
        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        return new CurrencyListItemViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CurrencyListItemViewHolder holder, int position) {
        ItemCurrencyListBinding binding = holder.getBinding();
        Coin coin = getCurrentList().get(position);
        String isActive;
        if (coin.getActive()) {
            isActive = "active";
        } else {
            isActive = "inactive";
        }
        String title = coin.getRank() + ". " + coin.getName() + " " + coin.getSymbol();
        binding.title.setText(title);
        int activeTextColor = coin.getActive() ?
                holder.itemView.getContext().getColor(R.color.primary) : Color.RED;

        binding.active.setTextColor(activeTextColor);
        binding.active.setText(isActive);
    }
}
