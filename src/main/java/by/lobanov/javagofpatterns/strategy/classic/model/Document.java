package by.lobanov.javagofpatterns.strategy.classic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    public enum DocumentType {
        PASSPORT,
        DRIVER_LICENSE,
        SNILS,
        INCOME_CERTIFICATE,
        CONTRACT
    }

    private String id;
    private DocumentType type;
    private String number;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String issuingAuthority;
    private boolean verified;

    public boolean isValid() {
        return verified && !isExpired();
    }

    public boolean isExpired() {
        return expiryDate != null && expiryDate.isBefore(LocalDate.now());
    }
}
