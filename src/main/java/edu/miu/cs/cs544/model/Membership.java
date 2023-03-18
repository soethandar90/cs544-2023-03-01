package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="membership")
public class Membership {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="start_date")
    private LocalDateTime startDate;
    @Column(name="end_date")
    private LocalDateTime endDate;
    @Column(name="membership_type")
    private MembershipType type;
    @OneToOne
    private Plan plan;
}
