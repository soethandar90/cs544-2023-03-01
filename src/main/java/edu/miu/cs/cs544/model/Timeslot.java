package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Data
@Table(name="Timeslot")
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="timeslotId")
    private int timeslotId;
    @Column(name="startTime")
    private Time startTime;
    @Column(name="endTime")
    private Time endTime;
    @Column(name="dayOfWeek")
    private Day dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;
}
