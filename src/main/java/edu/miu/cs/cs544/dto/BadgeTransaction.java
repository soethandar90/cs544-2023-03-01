package edu.miu.cs.cs544.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
public class BadgeTransaction {
    private int transactionId;
    private LocalDate transactionTime;
    private String transactionType;
    private Location location;
    private MembershipPlan plan;
    private Badge badge;

}
