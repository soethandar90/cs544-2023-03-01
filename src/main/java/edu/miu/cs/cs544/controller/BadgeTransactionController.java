package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BadgeTransactionController {

    @Autowired
    private BadgeTransactionService badgeTransactionService;

    @PostMapping
    public void addOneTransaction(BadgeTransaction badgeTransaction) {
        badgeTransactionService.addOneTransaction(badgeTransaction);
    }

}
