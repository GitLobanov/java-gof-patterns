package by.lobanov.javagofpatterns.observer.main;

public class ConcreteObserver implements Observer {

    private String observerName;

    public ConcreteObserver(String name) {
        this.observerName = name;
    }

    @Override
    public void update(String message) {
        System.out.println(observerName + " received update: " + message);
    }
}
