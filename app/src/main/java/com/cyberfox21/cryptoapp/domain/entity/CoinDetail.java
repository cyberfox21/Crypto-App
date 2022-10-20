package com.cyberfox21.cryptoapp.domain.entity;

import java.util.ArrayList;

/**
 * @author t.shkolnik
 */
public class CoinDetail {

    private String coinId;
    private String name;
    private String description;
    private String symbol;
    private int rank;
    private Boolean isActive;
    private ArrayList<String> tags;

    public CoinDetail(String coinId, String name, String description, String symbol, int rank, Boolean isActive, ArrayList<String> tags, ArrayList<TeamMember> team) {
        this.coinId = coinId;
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.rank = rank;
        this.isActive = isActive;
        this.tags = tags;
        this.team = team;
    }

    private ArrayList<TeamMember> team;
}
