package edu.miu.cs.cs544.contract;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class MembershipDTO {
    private long membershipId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private MembershipType type;
    private MembershipPlanDTO plan;
}
