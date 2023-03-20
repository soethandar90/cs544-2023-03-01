package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "BadgeTransaction")
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class BadgeTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transactionId")
    private int transactionId;

    @Column(name="transactionTime")
    @NotNull
    private LocalDate transactionTime;

    @Column(name="transactionType")
    @NotNull
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
