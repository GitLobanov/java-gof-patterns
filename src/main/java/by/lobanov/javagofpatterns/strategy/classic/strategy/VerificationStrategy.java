package by.lobanov.javagofpatterns.strategy.classic.strategy;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;

import java.time.LocalDateTime;

public interface VerificationStrategy {
    VerificationResult verify(ClientProfile profile);
    boolean supports(VerificationType type);

    default void logVerification(ClientProfile profile) {
        System.out.printf("[%s] Верификация для клиента %s%n",
                LocalDateTime.now(), profile.getClientId());
    }
}
