package by.lobanov.javagofpatterns.strategy.classic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientProfile {
    private String clientId;
    private String fullName;
    private LocalDate birthDate;
    private String taxNumber;
    private String phoneNumber;
    private String email;
    private Address address;
    private ClientStatus status;
    private List<Document> documents = new ArrayList<>();
    private List<Transaction> lastTransactions = new ArrayList<>();
    private BiometricData biometricData;
    private boolean isPep;
    private LocalDateTime registrationDate;

    public enum ClientStatus {
        NEW,
        ACTIVE,
        BLOCKED,
        CLOSED
    }
}

