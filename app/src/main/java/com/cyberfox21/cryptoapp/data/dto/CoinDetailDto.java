package com.cyberfox21.cryptoapp.data.dto;

import com.cyberfox21.cryptoapp.domain.entity.TeamMember;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CoinDetailDto {

    String description;
    String development_status;
    String first_data_at;
    Boolean hardware_wallet;
    String hash_algorithm;
    String id;
    @SerializedName("is_active")
    Boolean isActive;
    @SerializedName("is_new")
    Boolean isNew;
    String message;
    String name;
    Boolean open_source;
    String org_structure;
    String proof_type;
    int rank;
    String started_at;
    String symbol;
    ArrayList<Tag> tags;
    ArrayList<TeamMember> team;
    String type;

    public String getDescription() {
        return description;
    }

    public String getDevelopment_status() {
        return development_status;
    }

    public String getFirst_data_at() {
        return first_data_at;
    }

    public Boolean getHardware_wallet() {
        return hardware_wallet;
    }

    public String getHash_algorithm() {
        return hash_algorithm;
    }

    public String getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Boolean getNew() {
        return isNew;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public Boolean getOpen_source() {
        return open_source;
    }

    public String getOrg_structure() {
        return org_structure;
    }

    public String getProof_type() {
        return proof_type;
    }

    public int getRank() {
        return rank;
    }

    public String getStarted_at() {
        return started_at;
    }

    public String getSymbol() {
        return symbol;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public ArrayList<TeamMember> getTeam() {
        return team;
    }

    public String getType() {
        return type;
    }
}
