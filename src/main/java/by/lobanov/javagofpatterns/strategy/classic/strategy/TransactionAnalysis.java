package by.lobanov.javagofpatterns.strategy.classic.strategy;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.model.Transaction;
import by.lobanov.javagofpatterns.strategy.classic.service.FraudDetectionService;
import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionAnalysis implements VerificationStrategy {
    private final FraudDetectionService fraudService;

    @Override
    public VerificationResult verify(ClientProfile profile) {
        logVerification(profile);

        if (profile.getLastTransactions().isEmpty()) {
            return new VerificationResult(
                    generateId(),
                    VerificationType.TRANSACTION,
                    true,
                    "Нет транзакций для анализа",
                    LocalDateTime.now()
            );
        }

        boolean hasSuspicious = profile.getLastTransactions().stream()
                .anyMatch(t -> t.isSuspicious() || fraudService.isSuspicious(t));

        boolean hasLargeTransactions = profile.getLastTransactions().stream()
                .anyMatch(Transaction::isLarge);

        String message = hasSuspicious ?
                "Обнаружены подозрительные транзакции" :
                hasLargeTransactions ?
                        "Крупные транзакции (требуется дополнительная проверка)" :
                        "Транзакции в норме";

        return new VerificationResult(
                generateId(),
                VerificationType.TRANSACTION,
                !hasSuspicious,
                message,
                LocalDateTime.now()
        );
    }

    @Override
    public boolean supports(VerificationType type) {
        return type == VerificationType.TRANSACTION;
    }

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
