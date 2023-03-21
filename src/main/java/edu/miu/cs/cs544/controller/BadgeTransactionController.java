package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.model.Badge;
import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.model.Role;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class BadgeTransactionController {

    @Autowired
    private BadgeTransactionService badgeTransactionService;

    @GetMapping("/{memberId}/active")
    public Badge filterActiveBadgeByMemberId(@PathVariable int memberId) {
        return badgeTransactionService.filterActiveBadgeByMemberId(memberId);
    }

    @GetMapping
    public List<BadgeTransaction> findAllBadgeTransactionByMemberId(int memberId) {
        return badgeTransactionService.findAllBadgeTransactionByMemberId(memberId);
    }

    @PostMapping
    public void addOneTransaction(BadgeTransaction badgeTransaction) {
        badgeTransactionService.generateBadgeTransaction(badgeTransaction);
    }


}
