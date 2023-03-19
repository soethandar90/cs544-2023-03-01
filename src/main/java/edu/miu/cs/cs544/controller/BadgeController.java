package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.Member;
import edu.miu.cs.cs544.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    public BadgeService badgeService;

    @PostMapping("/{id}")
    public void deactivateOneBadgeByBadgeId(@PathVariable int id) {
        badgeService.deactivateOneBadgeByBadgeId(id);
    }

    @PostMapping
    public void addOneBadge(@RequestBody Badge badge) {
        badgeService.addOneBadge(badge);
    }

    @GetMapping
    public List<Badge> findAllBadgesOfOneMemberByMemberId() {
        return badgeService.findAllBadgesOfOneMemberByMemberId();
    }
}
