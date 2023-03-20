package edu.miu.cs.cs544.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;

@Entity
@Data
@Table(name="Timeslot")
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="timeslotId")
    private int timeslotId;
    @Column(name="startTime")
    @NotNull
    private Time startTime;
    @Column(name="endTime")
    @NotNull
    private Time endTime;
    @Column(name="dayOfWeek")
    @NotNull
    private Day dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;
}
