package by.lobanov.javagofpatterns.strategy.classic.service;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.strategy.VerificationStrategy;
import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerificationService {
    private final List<VerificationStrategy> strategies;

    public List<VerificationResult> performDailyVerification(ClientProfile profile) {
        return Arrays.stream(VerificationType.values())
                .map(type -> verify(profile, type))
                .collect(Collectors.toList());
    }

    public VerificationResult verify(ClientProfile profile, VerificationType type) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No strategy for type: " + type))
                .verify(profile);
    }

    public List<VerificationResult> verifyParallel(ClientProfile profile) {
        return strategies.parallelStream()
                .map(strategy -> strategy.verify(profile))
                .collect(Collectors.toList());
    }
}
