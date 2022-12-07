package com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item;

import com.cyberfox21.cryptoapp.domain.entity.TeamMember;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;

/**
 * @author t.shkolnik
 */
public class TeamMemberDelegateItem implements DelegateItem<TeamMember> {

    TeamMember teamMember;

    public TeamMemberDelegateItem(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    @Override
    public String getId() {
        return teamMember.getId();
    }

    @Override
    public TeamMember getContent() {
        return teamMember;
    }
}
