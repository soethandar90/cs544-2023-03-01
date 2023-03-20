package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name="MembershipPlan")
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="planId")
    private int planId;

    @Column(name="PlanName")
    @NotNull
    private String name;

    @Column(name="planDescription")
    @NotNull
    private  String planDescription;

    @OneToMany
    @JoinTable(name="plan_location",
            joinColumns = {@JoinColumn(name="planId")},
            inverseJoinColumns = {@JoinColumn(name="locationId")})
    private List<Location> locations;

    @OneToMany
    @JoinTable(name="plan_role",
            joinColumns = {@JoinColumn(name="planId")},
            inverseJoinColumns = {@JoinColumn(name="roleId")})
    private List<Role> roles;



}
