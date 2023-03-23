package edu.miu.cs.cs544.contract;

import lombok.Data;

import java.util.List;

@Data
public class MembershipPlanDTO {
    private String name;
    private String planDescription;
    private List<LocationDTO> locations;
    private List<RoleDTO> roles;


}
