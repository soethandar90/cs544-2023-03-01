package edu.miu.cs.cs544.contract;

import edu.miu.cs.cs544.util.LocationType;
import lombok.Data;

import java.util.List;


@Data
public class LocationDTO {
    private String locationName;
    private String description;
    private LocationType locationType;
    private int capacity;
    private List<TimeslotDTO> timeSlots;
    private MembershipPlanDTO plan;
}
