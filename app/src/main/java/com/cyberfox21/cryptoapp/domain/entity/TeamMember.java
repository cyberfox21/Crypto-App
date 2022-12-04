package com.cyberfox21.cryptoapp.domain.entity;

import com.cyberfox21.cryptoapp.common.recycler.JavaDataClass;

/**
 * @author t.shkolnik
 */
public class TeamMember implements JavaDataClass<TeamMember> {

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

    @Override
    public boolean isEquals(TeamMember newObject) {
        return this.id.equals(newObject.id) &&
                this.name.equals(newObject.name) &&
                this.position.equals(newObject.position);
    }
}
