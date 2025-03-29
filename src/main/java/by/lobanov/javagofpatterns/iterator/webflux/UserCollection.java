package by.lobanov.javagofpatterns.iterator.webflux;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class UserCollection {

    private List<String> users;

    public UserCollection() {
        // Создаем список пользователей
        this.users = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva");
    }

    // Метод, который возвращает Flux для использования как итератор
    public Flux<String> getUsers() {
        return Flux.fromIterable(users); // Преобразуем коллекцию в Flux
    }
}
