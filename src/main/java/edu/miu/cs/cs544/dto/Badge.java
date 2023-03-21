package edu.miu.cs.cs544.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Badge {
    private int badgeId;
    private String badgeCode;
    private boolean status;
    private List<BadgeTransaction> transaction;
}
