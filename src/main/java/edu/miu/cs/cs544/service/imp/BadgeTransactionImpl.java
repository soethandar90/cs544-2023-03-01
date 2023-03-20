package edu.miu.cs.cs544.service.imp;

import edu.miu.cs.cs544.model.BadgeTransaction;
import edu.miu.cs.cs544.repository.BadgeTransactionRepository;
import edu.miu.cs.cs544.service.BadgeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BadgeTransactionImpl implements BadgeTransactionService {

     @Autowired
    private BadgeTransactionRepository badgeTransactionRepository;


    @Override
    public void addOneTransaction(BadgeTransaction badgeTransaction) {
        badgeTransactionRepository.save(badgeTransaction);
    }
}
