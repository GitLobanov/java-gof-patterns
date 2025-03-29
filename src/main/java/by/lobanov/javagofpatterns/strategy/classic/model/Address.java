package by.lobanov.javagofpatterns.strategy.classic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String postalCode;
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private String apartment;
}
