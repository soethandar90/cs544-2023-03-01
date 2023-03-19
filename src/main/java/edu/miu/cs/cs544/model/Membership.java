package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="membership")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="membershipId")
    private long membershipId;
    @Column(name="startDate")
    private LocalDateTime startDate;
    @Column(name="endDate")
    private LocalDateTime endDate;
    @Column(name="membershipType")
    private MembershipType type;

    @OneToOne
    private Plan plan;
}
