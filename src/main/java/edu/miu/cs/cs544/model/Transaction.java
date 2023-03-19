package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "BadgeTransaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionId")
    private int transactionId;

    @Column(name="transactionTime")
    private LocalDate transactionTime;

    @Column(name="transactionType")
    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "planId")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "badgeId")
    private Badge badge;

}
