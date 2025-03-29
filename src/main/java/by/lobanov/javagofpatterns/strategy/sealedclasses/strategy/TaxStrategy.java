package by.lobanov.javagofpatterns.strategy.sealedclasses.strategy;

public abstract sealed class TaxStrategy permits
        USTaxStrategy, GermanyTaxStrategy, FranceTaxStrategy {

    public abstract double calculateTax(double amount);
}