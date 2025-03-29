package by.lobanov.javagofpatterns.strategy.classic.strategy;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.model.Document;
import by.lobanov.javagofpatterns.strategy.classic.strategy.enums.VerificationType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DocumentVerification implements VerificationStrategy {
    private static final Set<Document.DocumentType> REQUIRED_DOCS = Set.of(
            Document.DocumentType.PASSPORT,
            Document.DocumentType.SNILS
    );

    @Override
    public VerificationResult verify(ClientProfile profile) {
        logVerification(profile);

        // Проверка наличия обязательных документов
        Set<Document.DocumentType> existingDocTypes = profile.getDocuments().stream()
                .map(Document::getType)
                .collect(Collectors.toSet());

        if (!existingDocTypes.containsAll(REQUIRED_DOCS)) {
            return failResult("Отсутствуют обязательные документы");
        }

        // Проверка валидности всех документов
        boolean allValid = profile.getDocuments().stream()
                .allMatch(Document::isValid);

        return allValid ?
                successResult("Все документы валидны") :
                failResult("Найдены невалидные документы");
    }

    private VerificationResult successResult(String message) {
        return new VerificationResult(
                generateId(), VerificationType.DOCUMENT, true, message, LocalDateTime.now());
    }

    private VerificationResult failResult(String message) {
        return new VerificationResult(
                generateId(), VerificationType.DOCUMENT, false, message, LocalDateTime.now());
    }

    private String generateId() {
        return "DOC_" + UUID.randomUUID().toString().substring(0, 8);
    }

    @Override
    public boolean supports(VerificationType type) {
        return type == VerificationType.DOCUMENT;
    }
}