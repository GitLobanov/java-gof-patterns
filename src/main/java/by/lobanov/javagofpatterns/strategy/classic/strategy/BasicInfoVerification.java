package by.lobanov.javagofpatterns.strategy.classic.strategy;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.service.NameValidator;
import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasicInfoVerification implements VerificationStrategy {
    private final NameValidator nameValidator;

    @Override
    public VerificationResult verify(ClientProfile profile) {
        logVerification(profile);

        if (!nameValidator.isValid(profile.getFullName())) {
            return new VerificationResult(
                    UUID.randomUUID().toString(),
                    VerificationType.BASIC,
                    false,
                    "Невалидное ФИО",
                    LocalDateTime.now()
            );
        }

        return new VerificationResult(
                UUID.randomUUID().toString(),
                VerificationType.BASIC,
                true,
                "Базовые данные верифицированы",
                LocalDateTime.now()
        );
    }

    @Override
    public boolean supports(VerificationType type) {
        return type == VerificationType.BASIC;
    }
}
