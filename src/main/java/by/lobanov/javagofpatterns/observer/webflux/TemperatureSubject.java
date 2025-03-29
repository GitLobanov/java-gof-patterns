package by.lobanov.javagofpatterns.observer.webflux;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class TemperatureSubject {

    private Flux<String> temperatureFlux;

    public TemperatureSubject() {
        // Симуляция обновления температуры каждую секунду
        this.temperatureFlux = Flux.interval(Duration.ofSeconds(1))
                .map(seq -> "Temperature: " + (20 + (seq % 5)) + "°C");  // Простая логика для симуляции
    }

    // Метод для подписки наблюдателей
    public Flux<String> getTemperatureUpdates() {
        return temperatureFlux;
    }
}
