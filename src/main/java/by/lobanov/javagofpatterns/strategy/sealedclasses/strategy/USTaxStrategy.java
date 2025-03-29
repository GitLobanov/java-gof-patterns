package by.lobanov.javagofpatterns.strategy.sealedclasses.strategy;

import org.springframework.stereotype.Component;

@Component("USA")
public final class USTaxStrategy extends TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.1; // Налог 10% в США
    }
}