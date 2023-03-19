package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleId")
    private int roleId;

    @Column(name="roleName")
    private String roleName;

}
