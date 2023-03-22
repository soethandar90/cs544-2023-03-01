package edu.miu.cs.cs544.contract;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BadgeTransactionDTO {
    private int transactionId;
    private LocalDate transactionTime;
    private String transactionType;
    private LocationDTO location;
    private MembershipPlanDTO plan;
    private BadgeDTO badgeDTO;

}
