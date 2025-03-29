package by.lobanov.javagofpatterns.strategy.sealedclasses.service;

import by.lobanov.javagofpatterns.strategy.sealedclasses.strategy.TaxStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TaxService {
    private final Map<String, TaxStrategy> taxStrategies;

    @Autowired
    public TaxService(Map<String, TaxStrategy> taxStrategies) {
        this.taxStrategies = taxStrategies;
    }

    public double calculateTax(String country, double amount) {
        TaxStrategy strategy = taxStrategies.get(country);
        if (strategy == null) {
            throw new IllegalArgumentException("No tax strategy found for country: " + country);
        }
        return strategy.calculateTax(amount);
    }
}