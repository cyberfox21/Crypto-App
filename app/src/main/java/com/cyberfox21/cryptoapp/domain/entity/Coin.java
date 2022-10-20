package com.cyberfox21.cryptoapp.domain.entity;

/**
 * @author t.shkolnik
 */
public class Coin {

    private final String id;
    private final Boolean isActive;
    private final String name;
    private final int rank;
    private final String symbol;

    public Coin(String id, Boolean isActive, String name, int rank, String symbol) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.rank = rank;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
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
}
