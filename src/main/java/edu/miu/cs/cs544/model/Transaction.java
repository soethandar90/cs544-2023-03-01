package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

}
