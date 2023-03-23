package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.contract.BadgeDTO;
import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.repository.BadgeRepository;
import edu.miu.cs.cs544.util.BadgeStatusType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class BadgeServiceImpl implements BadgeService {
    @Autowired
    public BadgeRepository badgeRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Badge addOneBadge(Badge badge) {
        deactivateOneBadgeByMemberId(badge.getMember().getMemberId());
        return badgeRepository.save(badge);
    }

    @Override
    public void deactivateOneBadgeByMemberId(int memberId) {
        Badge badge = badgeRepository.findActiveBadgeByMemberId(memberId);
        if(badge!=null){
            badge.setStatus(BadgeStatusType.INACTIVE);
            badgeRepository.save(badge);
        }
    }
    @Override
    public List<BadgeDTO> findAllBadgesOfOneMemberByMemberId(int id) {
       List<Badge> badges = badgeRepository.findAllByMemberId(id).orElse(null);
        return badges.stream().map(b -> modelMapper.map(b, BadgeDTO.class)).collect(Collectors.toList());
    }

}
