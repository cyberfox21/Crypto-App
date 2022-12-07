package com.cyberfox21.cryptoapp.presentation.currency_detail;

import com.cyberfox21.cryptoapp.domain.entity.CoinDetail;
import com.cyberfox21.cryptoapp.domain.entity.TeamMember;
import com.cyberfox21.cryptoapp.presentation.common.DelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.DescriptionDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.SectionTitleDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.TagsDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.TeamMemberDelegateItem;
import com.cyberfox21.cryptoapp.presentation.currency_detail.recycler.delegate_item.TitleDelegateItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author t.shkolnik
 */
public class DetailItemsMapper {

    @Inject
    public DetailItemsMapper() {
    }

    List<DelegateItem> map(CoinDetail detail) {
        List<DelegateItem> resultList = new ArrayList<>();

        resultList.add(
                new TitleDelegateItem(
                        detail.getRank(),
                        detail.getName(),
                        detail.getSymbol(),
                        detail.getActive()
                )
        );

        resultList.add(
                new DescriptionDelegateItem(detail.getDescription())
        );

        resultList.add(
                new SectionTitleDelegateItem("Tags")
        );

        resultList.add(
                new TagsDelegateItem(detail.getTags())
        );

        if (detail.getTeam() != null && detail.getTeam().size() != 0) {
            resultList.add(
                    new SectionTitleDelegateItem("TeamMembers")
            );
            for (TeamMember teamMember : detail.getTeam()) {
                resultList.add(new TeamMemberDelegateItem(teamMember));
            }
        }

        return resultList;
    }
}
