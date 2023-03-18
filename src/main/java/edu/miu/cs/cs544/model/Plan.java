package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Plan")
public class Plan {
    @Id
    @GeneratedValue
    private int id;
    @JoinColumn(name="PlanName")
    private String name;
    @JoinColumn(name="PlanDescription")
    private  String description;
    @OneToMany
    @JoinColumn(name="LocationId")
    private List<Location> locations;

    @OneToMany
    @JoinColumn(name="RoleId")
    private List<Role> roles;



}
