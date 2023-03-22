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

    @PutMapping ("/{id}")
    public void deactivateOneBadgeByBadgeId(@PathVariable int id) {
        badgeService.deactivateOneBadgeByBadgeId(id);
    }

    @PostMapping
    public void addOneBadge(@PathVariable int id,@RequestBody Badge badge) {
        badgeService.addOneBadge(badge);
    }

    @GetMapping("/{id}")
    public List<Badge> findAllBadgesOfOneMemberByMemberId(@PathVariable int id) {
        return badgeService.findAllBadgesOfOneMemberByMemberId(id);
    }
}
