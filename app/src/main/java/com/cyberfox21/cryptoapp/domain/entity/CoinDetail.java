package com.cyberfox21.cryptoapp.domain.entity;

import com.cyberfox21.cryptoapp.common.recycler.JavaDataClass;

import java.util.ArrayList;

/**
 * @author t.shkolnik
 */
public class CoinDetail implements JavaDataClass<CoinDetail> {

    private final String coinId;
    private final String name;
    private final String description;
    private final String symbol;
    private final int rank;
    private final Boolean isActive;
    private final ArrayList<String> tags;
    private final ArrayList<TeamMember> team;

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

    @Override
    public boolean isEquals(CoinDetail newObject) {
        return this.coinId.equals(newObject.coinId) &&
                this.isActive.equals(newObject.isActive) &&
                this.name.equals(newObject.name) &&
                this.rank == newObject.rank &&
                this.symbol.equals(newObject.symbol) &&
                this.description.equals(newObject.description) &&
                this.tags.equals(newObject.tags) &&
                this.team.equals(newObject.team);
    }
}
