package edu.miu.cs.cs544.model;

import edu.miu.cs.cs544.util.UsageFrequencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="MembershipPlanRole")
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPlanRole {
    @EmbeddedId
    private MembershipPlanRoleId membershipPlanRoleId;

    @ManyToOne
    @MapsId("planId")
    private MembershipPlan membershipPlan;

    @ManyToOne
    @MapsId("roleId")
    private Role role;

    @Column(name="usageLimit")
    private int usageLimit;

    @Column(name="usageFrequency",columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private UsageFrequencyType usageFrequency;

}
