package edu.miu.cs.cs544.contract;

import lombok.Data;
import java.util.List;


@Data
public class LocationDTO {
    private int locationId;
    private String locationName;
    private String description;
    private LocationType locationType;
    private int capacity;
    private List<TimeslotDTO> timeSlots;
    private MembershipPlanDTO plan;
}
