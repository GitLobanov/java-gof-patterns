package by.lobanov.javagofpatterns.observer.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Это конкретная реализация Subject.
 * Здесь храним список наблюдателей и вызываем их обновление при изменении состояния.
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Устанавливаем новое состояние
    public void setState(String state) {
        this.state = state;
        notifyObservers();  // Когда состояние меняется, уведомляем всех наблюдателей
    }

    public String getState() {
        return state;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
