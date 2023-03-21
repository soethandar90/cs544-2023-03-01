package edu.miu.cs.cs544.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Member")
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="memberId")
    private int memberId;

    @Column(name="firstName")
    @NotNull
    private String firstName;

    @Column(name="lastname")
    @NotNull
    private String lastName;

    @Column(name="email")
    @Email
    private String email;
    @Column(name="password")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="member_role",
    joinColumns = {@JoinColumn(name="memberId", referencedColumnName = "memberId")},
    inverseJoinColumns = {@JoinColumn(name="roleId", referencedColumnName = "roleId")}
    )
    private List<Role> role=new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Badge> badge;

    @OneToMany
    @JoinColumn(name="memberId")
    @JsonIgnore
    private List<Membership> membership;
}
