package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate timeStamp;
    private String transactionType;
    @Column(name = "Location")
    private Location locaton;
    @Column(name = "Plan")
    private Plan plan;
    @Column(name = "Transaction")
    private Transaction transaction;
    @Column(name = "Badge")
    private Badge badge;

}
