package by.lobanov.javagofpatterns.strategy.sealedclasses.strategy;

import org.springframework.stereotype.Component;

@Component("Germany")
public final class GermanyTaxStrategy extends TaxStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.2; // Налог 20% в Германии
    }
}
