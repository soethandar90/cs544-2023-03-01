package edu.miu.cs.cs544.contract;

import lombok.Data;
@Data
public class BadgeTransactionRequestDTO {


    private int location;
    private String badge;
    private int plan;
    private int checker;
}
