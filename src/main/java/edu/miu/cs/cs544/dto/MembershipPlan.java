package edu.miu.cs.cs544.dto;

import lombok.Data;
import java.util.List;

@Data
public class MembershipPlan {
    private int planId;
    private String name;
    private  String planDescription;

    private List<Location> locations;

    private List<RoleDto> roles;



}
