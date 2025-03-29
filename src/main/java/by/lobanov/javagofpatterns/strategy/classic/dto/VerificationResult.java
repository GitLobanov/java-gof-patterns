package by.lobanov.javagofpatterns.strategy.classic.dto;

import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class VerificationResult {
    private String verificationId;
    private VerificationType type;
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
}
