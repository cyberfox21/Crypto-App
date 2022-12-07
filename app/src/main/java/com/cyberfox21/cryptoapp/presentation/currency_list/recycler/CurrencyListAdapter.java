package com.cyberfox21.cryptoapp.presentation.currency_list.recycler;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cyberfox21.cryptoapp.R;
import com.cyberfox21.cryptoapp.databinding.ItemCurrencyListBinding;
import com.cyberfox21.cryptoapp.domain.entity.Coin;
import com.cyberfox21.cryptoapp.presentation.common.DelegateAdapter;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class CurrencyListAdapter implements DelegateAdapter {

    CurrencyItemClickListener listener;

    public void setListener(CurrencyItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        ItemCurrencyListBinding binding = ItemCurrencyListBinding.inflate(
                LayoutInflater.from(parent.getContext())
        );

        binding.getRoot().setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );

        return new CurrencyListItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(
            RecyclerView.ViewHolder viewHolder,
            DelegateItem model,
            int position
    ) {
        ItemCurrencyListBinding binding = ((CurrencyListItemViewHolder) viewHolder).getBinding();
        Coin coin = (Coin) model.getContent();
        String isActive;
        if (coin.getActive()) {
            isActive = "active";
        } else {
            isActive = "inactive";
        }
        String title = coin.getRank() + ". " + coin.getName() + " " + coin.getSymbol();
        binding.title.setText(title);
        int activeTextColor = coin.getActive() ?
                viewHolder.itemView
                        .getContext()
                        .getResources()
                        .getColor(R.color.primary) : Color.RED;

        binding.active.setTextColor(activeTextColor);
        binding.active.setText(isActive);
        binding.getRoot().setOnClickListener(v -> listener.onCurrencyClick(coin.getId()));
    }

    @Override
    public boolean isCorrectViewType(DelegateItem item) {
        return item instanceof CoinDelegateItem;
    }
}
