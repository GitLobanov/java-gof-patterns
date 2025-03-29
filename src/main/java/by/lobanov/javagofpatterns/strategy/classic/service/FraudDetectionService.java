package by.lobanov.javagofpatterns.strategy.classic.service;

import by.lobanov.javagofpatterns.strategy.classic.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudDetectionService {
    public boolean isSuspicious(Transaction transaction) {
        // Реальная реализация могла бы использовать:
        // - ML модели
        // - Списки подозрительных контрагентов
        // - Анализ паттернов
        return transaction.getCounterparty().contains("офшор") ||
                transaction.getAmount().compareTo(new BigDecimal("500000")) > 0;
    }
}
