package com.cyberfox21.cryptoapp.data.dto;

public class Tag {

    int coin_counter;
    int ico_counter;
    String id;
    String name;

    public int getCoin_counter() {
        return coin_counter;
    }

    public void setCoin_counter(int coin_counter) {
        this.coin_counter = coin_counter;
    }

    public int getIco_counter() {
        return ico_counter;
    }

    public void setIco_counter(int ico_counter) {
        this.ico_counter = ico_counter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
