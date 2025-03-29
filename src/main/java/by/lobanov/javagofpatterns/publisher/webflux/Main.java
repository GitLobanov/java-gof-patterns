package by.lobanov.javagofpatterns.publisher.webflux;

import lombok.extern.slf4j.Slf4j;

import static by.lobanov.util.MyUtil.sleep;

@Slf4j
public class Main {

    public static void main(String[] args) {
//        exampleWithColdPublisher();
        exampleWithHotPublisher();
    }

    private static void exampleWithColdPublisher() {
        TemperatureColdPublisher temperatureColdPublisher = new TemperatureColdPublisher();

        TemperatureObserver observer1 = new TemperatureObserver("Observer 1");
        TemperatureObserver observer2 = new TemperatureObserver("Observer 2");
        TemperatureObserver observer3 = new TemperatureObserver("Observer 3");

        observer1.subscribeToTemperatureUpdates(temperatureColdPublisher.getTemperatureUpdates());
        sleep(3L); // Блокируем выполнение на 1 секунду, чтобы вызвать задержку для подписки на событие 2,3
        observer2.subscribeToTemperatureUpdates(temperatureColdPublisher.getTemperatureUpdates());
        observer3.subscribeToTemperatureUpdates(temperatureColdPublisher.getTemperatureUpdates());

        // Добавляем блокировку потока, чтобы не завершить программу сразу
        sleep(10L);
        log.info("Main method has finished execution");
    }

    private static void exampleWithHotPublisher() {
        TemperatureHotPublisher temperatureHotPublisher = new TemperatureHotPublisher();

        TemperatureObserver observer1 = new TemperatureObserver("Observer 1");
        TemperatureObserver observer2 = new TemperatureObserver("Observer 2");
        TemperatureObserver observer3 = new TemperatureObserver("Observer 3");

        observer1.subscribeToTemperatureUpdates(temperatureHotPublisher.getTemperatureUpdates());
        sleep(3L); // Блокируем выполнение на 1 секунду, чтобы вызвать задержку для подписки на событие 2,3
        observer2.subscribeToTemperatureUpdates(temperatureHotPublisher.getTemperatureUpdates());
        observer3.subscribeToTemperatureUpdates(temperatureHotPublisher.getTemperatureUpdates());

        // Добавляем блокировку потока, чтобы не завершить программу сразу
        sleep(10L);
        log.info("Main method has finished execution");
    }


}