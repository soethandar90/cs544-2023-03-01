package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime transactionTime;

    @Column(name="transactionType")
    @NotNull
    private BadgeTransactionType transactionType;

    @Column(name="reason")
    private String reason;

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
