package edu.miu.cs.cs544.contract;

import lombok.Data;

import java.util.List;

@Data
public class BadgeDTO {
    private int badgeId;
    private String badgeCode;
    private boolean status;
    private List<BadgeTransactionDTO> transaction;
}
