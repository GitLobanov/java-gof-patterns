package by.lobanov.javagofpatterns.strategy.classic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    public enum TransactionType {
        CARD_PAYMENT,
        TRANSFER,
        DEPOSIT,
        WITHDRAWAL,
        FEE
    }

    private String id;
    private BigDecimal amount;
    private Currency currency;
    private TransactionType type;
    private LocalDateTime timestamp;
    private String counterparty;
    private String description;
    private boolean suspicious;

    public boolean isLarge() {
        return amount.compareTo(new BigDecimal("1000000")) >= 0;
    }
}
