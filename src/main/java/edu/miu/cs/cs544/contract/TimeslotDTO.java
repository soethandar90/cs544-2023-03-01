package edu.miu.cs.cs544.contract;

import edu.miu.cs.cs544.util.Day;
import lombok.Data;
import java.sql.Time;


@Data
public class TimeslotDTO {
    private Time startTime;
    private Time endTime;
    private Day dayOfWeek;
}
