package by.lobanov.javagofpatterns.iterator.webflux;

import reactor.core.publisher.Flux;

public class Main {

    public static void main(String[] args) {
        UserCollection userCollection = new UserCollection();
        Flux<String> userFlux = userCollection.getUsers();

        // Подписываемся на Flux и перебираем пользователей
        userFlux.subscribe(user -> {
            System.out.println("Processing user: " + user);
        });
    }
}
