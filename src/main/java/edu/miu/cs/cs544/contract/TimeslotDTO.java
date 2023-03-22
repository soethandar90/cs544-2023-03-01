package edu.miu.cs.cs544.contract;

import edu.miu.cs.cs544.common.Day;
import lombok.Data;
import java.sql.Time;


@Data
public class TimeslotDTO {
    private int timeslotId;
    private Time startTime;
    private Time endTime;
    private Day dayOfWeek;
}
