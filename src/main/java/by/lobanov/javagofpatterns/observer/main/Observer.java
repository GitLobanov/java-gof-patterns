package by.lobanov.javagofpatterns.observer.main;

/**
 * Наблюдатели должны реализовать этот интерфейс, чтобы получать обновления.
 */
public interface Observer {
    void update(String message);
}
