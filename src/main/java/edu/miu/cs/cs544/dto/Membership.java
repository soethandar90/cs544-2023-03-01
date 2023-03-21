package edu.miu.cs.cs544.dto;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class Membership {
    private long membershipId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private MembershipType type;
    private MembershipPlan plan;
}
