package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPlanRoleId implements Serializable {
    @Column(name = "planId")
    private int planId;

    @Column(name = "roleId")
    private int roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        MembershipPlanRoleId that = (MembershipPlanRoleId) o;
        return Objects.equals(planId, that.planId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, roleId);
    }
}
