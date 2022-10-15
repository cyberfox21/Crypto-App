package com.cyberfox21.cryptoapp.domain.entity;

/**
 * @author t.shkolnik
 */
public class TeamMember {

    String id;
    String name;
    String position;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
