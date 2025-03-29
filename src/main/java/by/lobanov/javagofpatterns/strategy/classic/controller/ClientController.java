package by.lobanov.javagofpatterns.strategy.classic.controller;

import by.lobanov.javagofpatterns.strategy.classic.dto.VerificationResult;
import by.lobanov.javagofpatterns.strategy.classic.model.Address;
import by.lobanov.javagofpatterns.strategy.classic.model.BiometricData;
import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import by.lobanov.javagofpatterns.strategy.classic.model.Document;
import by.lobanov.javagofpatterns.strategy.classic.model.Transaction;
import by.lobanov.javagofpatterns.strategy.classic.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final VerificationService verificationService;

    @PostMapping("/{clientId}/verify")
    public ResponseEntity<List<VerificationResult>> verifyClient(
            @PathVariable String clientId) {

        ClientProfile profile = buildSampleProfile(clientId);
        return ResponseEntity.ok(
                verificationService.performDailyVerification(profile)
        );
    }

    private ClientProfile buildSampleProfile(String clientId) {
        List<Document> docs = List.of(
                new Document(
                        "doc1",
                        Document.DocumentType.PASSPORT,
                        "1234 567890",
                        LocalDate.of(2020, 1, 15),
                        LocalDate.of(2030, 1, 15),
                        "МВД России",
                        true
                ),
                new Document(
                        "doc2",
                        Document.DocumentType.SNILS,
                        "123-456-789 00",
                        LocalDate.of(2019, 5, 20),
                        null,
                        "ПФР",
                        true
                )
        );

        List<Transaction> transactions = List.of(
                new Transaction(
                        "txn1",
                        new BigDecimal("50000"),
                        Currency.getInstance("RUB"),
                        Transaction.TransactionType.TRANSFER,
                        LocalDateTime.now().minusDays(1),
                        "ООО Ромашка",
                        "Оплата услуг",
                        false
                )
        );

        return new ClientProfile(
                clientId,
                "Иванов Иван Иванович",
                LocalDate.of(1985, 7, 12),
                "773456789012",
                "+79161234567",
                "ivanov@example.com",
                new Address(
                        "123456",
                        "Россия",
                        "Московская область",
                        "Москва",
                        "Ленина",
                        "10",
                        "25"
                ),
                ClientProfile.ClientStatus.ACTIVE,
                docs,
                transactions,
                new BiometricData(new byte[0], new byte[0], new byte[0], LocalDate.now()),
                false,
                LocalDateTime.now().minusYears(1)
        );
    }
}