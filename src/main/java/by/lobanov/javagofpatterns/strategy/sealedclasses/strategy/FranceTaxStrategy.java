package by.lobanov.javagofpatterns.strategy.sealedclasses.strategy;

import org.springframework.stereotype.Component;

@Component("France")
public final class FranceTaxStrategy extends TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.15; // Налог 15% во Франции
    }
}