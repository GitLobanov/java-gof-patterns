package by.lobanov.javagofpatterns.publisher.webflux;

import reactor.core.publisher.Flux;

public class TemperatureObserver {

    private String observerName;

    public TemperatureObserver(String observerName) {
        this.observerName = observerName;
    }

    // Метод для обработки обновлений температуры
    public void subscribeToTemperatureUpdates(Flux<String> temperatureFlux) {
        temperatureFlux.subscribe(temp -> {
            // Каждый раз, когда обновляется температура, этот метод будет вызываться
            System.out.println(observerName + " received update: " + temp);
        });
    }
}