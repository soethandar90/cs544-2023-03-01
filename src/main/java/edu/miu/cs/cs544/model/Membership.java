package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="membership")
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="membershipId")
    private long membershipId;
    @Column(name="startDate")
    @NotNull
    private LocalDateTime startDate;
    @Column(name="endDate")
    @NotNull
    private LocalDateTime endDate;
    @Column(name="membershipType")
    @NotNull
    private MembershipType type;

    @Column(name="currentUsage")
    @NotNull
    private int currentUsage;

    @OneToOne
    private Plan plan;
}
