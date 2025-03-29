package by.lobanov.javagofpatterns.observer.webflux;

import lombok.extern.slf4j.Slf4j;

import static by.lobanov.util.MyUtil.sleep;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TemperatureSubject temperatureSubject = new TemperatureSubject();

        TemperatureObserver observer1 = new TemperatureObserver("Observer 1");
        TemperatureObserver observer2 = new TemperatureObserver("Observer 2");
        TemperatureObserver observer3 = new TemperatureObserver("Observer 3");

        observer1.subscribeToTemperatureUpdates(temperatureSubject.getTemperatureUpdates());
        observer2.subscribeToTemperatureUpdates(temperatureSubject.getTemperatureUpdates());
        observer3.subscribeToTemperatureUpdates(temperatureSubject.getTemperatureUpdates());

        // Добавляем блокировку потока, чтобы не завершить программу сразу
        sleep(10L);
        log.info("Main method has finished execution");
    }
}