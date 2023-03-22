package edu.miu.cs.cs544.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name="Badge")
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badgeId")
    private int badgeId;

    @Column(name="badgeCode")
    @NotNull
    private String badgeCode;

    @Column(name="status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private BadgeStatusType status;

    @OneToMany(mappedBy = "badge")

    private List<BadgeTransaction> transaction;

    @ManyToOne
    @JoinColumn(name="memberId")
    @JsonIgnore
    private Member member;
}