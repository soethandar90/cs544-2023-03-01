package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberId")
    private int memberId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToMany
    @JoinTable(name="member_role",
    joinColumns = {@JoinColumn(name="memberId")},
    inverseJoinColumns = {@JoinColumn(name="roleId")})
    private List<Role> role=new ArrayList<>();

    @OneToMany
    @JoinColumn(name="memberId")
    private List<Badge> badge;

    @OneToMany
    @JoinColumn(name="memberId")
    private List<Membership> membership;
}
