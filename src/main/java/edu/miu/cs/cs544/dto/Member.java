package edu.miu.cs.cs544.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> role=new ArrayList<>();
    private List<Badge> badge;
    private List<Membership> membership;
}
