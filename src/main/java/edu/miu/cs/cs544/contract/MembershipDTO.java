package edu.miu.cs.cs544.contract;

import edu.miu.cs.cs544.util.MembershipType;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class MembershipDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private MembershipType type;
    private MembershipPlanDTO plan;
}
