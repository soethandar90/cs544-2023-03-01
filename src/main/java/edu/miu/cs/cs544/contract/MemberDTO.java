package edu.miu.cs.cs544.contract;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberDTO {
    private int memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<RoleDTO> role=new ArrayList<>();
    private List<BadgeDTO> badgeDTO;
    private List<MembershipDTO> membership;
}
