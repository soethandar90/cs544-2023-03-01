package edu.miu.cs.cs544.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
@Getter
@NoArgsConstructor
public class InvalidTransactionException extends RuntimeException{
    private String transactionId;
    private String transactionTime;
    private String status;
    private String reason;

    public InvalidTransactionException(String transactionId, String transactionTime, String status, String reason) {
        super(String.format("%s is invalid at %s. Status is %s with reason  %s", transactionId, transactionTime, status, reason));
        this.transactionId = transactionId;
        this.transactionTime = transactionTime;
        this.status = status;
        this.reason = reason;
    }
}
