package com.cyberfox21.cryptoapp.data.dto;

import com.google.gson.annotations.SerializedName;

public class CoinDto {

    private String id;
    @SerializedName("is_active")
    private Boolean isActive;
    @SerializedName("is_new")
    private Boolean isNew;
    private String name;
    private int rank;
    private String symbol;
    private String type;

    public String getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Boolean getNew() {
        return isNew;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }
}
