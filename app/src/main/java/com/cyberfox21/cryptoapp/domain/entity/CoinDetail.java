package com.cyberfox21.cryptoapp.domain.entity;

import java.util.ArrayList;

/**
 * @author t.shkolnik
 */
public class CoinDetail {

    String coinId;
    String name;
    String description;
    String symbol;
    int rank;
    Boolean isActive;
    ArrayList<String> tags;
    ArrayList<TeamMember> team;
}
