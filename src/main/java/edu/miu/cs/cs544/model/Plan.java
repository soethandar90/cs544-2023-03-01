package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="MembershipPlan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="planId")
    private int planId;

    @Column(name="PlanName")
    private String name;

    @Column(name="planDescription")
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
