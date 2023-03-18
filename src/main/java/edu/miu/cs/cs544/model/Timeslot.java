package edu.miu.cs.cs544.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Data
@Table(name="Timeslot")
public class Timeslot {
    @Id
    private int id;
    @JoinColumn(name="StartTime")
    private Time startTime;
    @JoinColumn(name="StartTime")
    private Time endTime;
    @JoinColumn(name="DayOfWeek")
    private Day day;

}
