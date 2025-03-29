package by.lobanov.javagofpatterns.publisher.webflux;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class TemperatureColdPublisher {

    private Flux<String> temperatureFlux;

    public TemperatureColdPublisher() {
        // Симуляция обновления температуры каждую секунду
        this.temperatureFlux = Flux.interval(Duration.ofSeconds(1))
                .map(seq -> "Temperature: " + (20 + (seq % 5)) + "°C");  // Простая логика для симуляции
    }

    // Метод для подписки наблюдателей
    public Flux<String> getTemperatureUpdates() {
        return temperatureFlux;
    }
}
