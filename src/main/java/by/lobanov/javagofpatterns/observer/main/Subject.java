package by.lobanov.javagofpatterns.observer.main;

/**
 * Субъект (объект, за состоянием которого следят) должен
 * иметь методы для добавления/удаления наблюдателей и для уведомления их о изменениях.
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}