package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.List;


//Please detete this class


@Data
@Entity
@Table(name="MembershipPlan")
@Validated
@NoArgsConstructor
@AllArgsConstructor
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
