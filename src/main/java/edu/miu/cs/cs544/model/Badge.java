package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Badge")
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badgeId")
    private int badgeId;

    @Column(name="badgeCode")
    private String badgeCode;

    @Column(name="status")
    private boolean status;

    @OneToMany(mappedBy = "badge")
    private List<Transaction> transaction;
}
