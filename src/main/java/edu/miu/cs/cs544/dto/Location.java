package edu.miu.cs.cs544.dto;

import lombok.Data;
import java.util.List;


@Data
public class Location {
    private int locationId;
    private String locationName;
    private String description;
    private LocationType locationType;
    private int capacity;
    private List<Timeslot> timeSlots;
    private MembershipPlan plan;
}
