package by.lobanov.javagofpatterns.strategy.classic.strategy;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.service.SanctionService;
import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FinancialRiskVerification implements VerificationStrategy {
    private final SanctionService sanctionService;

    @Override
    public VerificationResult verify(ClientProfile profile) {
        logVerification(profile);

        boolean isSanctioned = sanctionService.checkSanctions(profile);
        boolean highRisk = profile.isPep() || isSanctioned;

        return new VerificationResult(
                UUID.randomUUID().toString(),
                VerificationType.FINANCIAL_RISK,
                !highRisk,
                highRisk ? "Высокий риск: PEP или санкции" : "Финансовые риски не обнаружены",
                LocalDateTime.now()
        );
    }

    @Override
    public boolean supports(VerificationType type) {
        return type == VerificationType.FINANCIAL_RISK;
    }
}
