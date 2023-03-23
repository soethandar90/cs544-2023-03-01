package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.service.BadgeService;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
public class BadgeController {
    @Autowired
    public BadgeService badgeService;
    @Autowired
    public BadgeTransactionService badgeTransactionService;

    @PutMapping("/{id}")
    public void deactivateOneBadgeByMemberId(@PathVariable int id) {
        badgeService.deactivateOneBadgeByMemberId(id);
    }

    @PostMapping
    public void addOneBadge(@PathVariable int id, @RequestBody Badge badge) {
        badgeService.addOneBadge(badge);
    }

    @GetMapping("/{id}")
    public List<Badge> findAllBadgesOfOneMemberByMemberId(@PathVariable int id) {
        return badgeService.findAllBadgesOfOneMemberByMemberId(id);
    }
}
