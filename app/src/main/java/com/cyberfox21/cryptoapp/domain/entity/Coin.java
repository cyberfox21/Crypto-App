package com.cyberfox21.cryptoapp.domain.entity;

/**
 * @author t.shkolnik
 */
public class Coin {

    private String id;
    private Boolean isActive;
    private String name;
    private int rank;
    private String symbol;

    public Coin(String id, Boolean isActive, String name, int rank, String symbol) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.rank = rank;
        this.symbol = symbol;
    }
}
