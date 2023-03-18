package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Badge")
public class Badge {
    @Id
    @GeneratedValue
    private int id;
    private String badgeCode;
    private boolean status;
    @OneToMany
    private List<Transaction> transaction;
}
