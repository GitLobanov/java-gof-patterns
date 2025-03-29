package by.lobanov.javagofpatterns.publisher.webflux;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class TemperatureHotPublisher {

    private Flux<String> temperatureFlux;

    public TemperatureHotPublisher() {
        // Симуляция обновления температуры каждую секунду
        this.temperatureFlux = Flux.interval(Duration.ofSeconds(1))
                .map(seq -> "Temperature: " + (20 + (seq % 5)) + "°C")
                .share();
    }

    // Метод для подписки наблюдателей
    public Flux<String> getTemperatureUpdates() {
        return temperatureFlux;
    }
}
