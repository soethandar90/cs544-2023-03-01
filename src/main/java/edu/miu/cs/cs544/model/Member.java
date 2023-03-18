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
    @GeneratedValue
    private int id;

    private String firstName;

    private String lastName;
    private String email;
    @OneToMany
    private List<Role> role=new ArrayList<>();

    @OneToMany
    private List<Badge> badge;

}
