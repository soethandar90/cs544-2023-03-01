package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue
    private int id;

 private String roleName;

}
