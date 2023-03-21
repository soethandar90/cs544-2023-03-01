package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class BadgeTransactionController {

    @Autowired
    private BadgeTransactionService badgeTransactionService;

 @GetMapping
 public Badge filterActiveBadgeByMemberId(int memberId) {
     return badgeTransactionService.filterActiveBadgeByMemberId(memberId);
 }
 @GetMapping("/all")
 public List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId) {
     return badgeTransactionService.findAllBadgeTransactionByMemberId(memberId);
 }

    @PostMapping
    public void addOneTransaction(BadgeTransaction badgeTransaction) {
        badgeTransactionService.addOneTransaction(badgeTransaction);
    }



}
