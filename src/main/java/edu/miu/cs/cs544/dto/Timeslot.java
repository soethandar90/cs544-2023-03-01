package edu.miu.cs.cs544.dto;

import lombok.Data;
import java.sql.Time;


@Data
public class Timeslot {
    private int timeslotId;
    private Time startTime;
    private Time endTime;
    private Day dayOfWeek;
}
