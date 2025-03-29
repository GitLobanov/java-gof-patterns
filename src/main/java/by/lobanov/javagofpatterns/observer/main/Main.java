package by.lobanov.javagofpatterns.observer.main;

public class Main {

    public static void main(String[] args) {
        // Создаем ConcreteSubject
        ConcreteSubject subject = new ConcreteSubject();

        // Создаем несколько ConcreteObserver
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        // Добавляем наблюдателей в субъект
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);

        // Изменяем состояние субъекта и уведомляем наблюдателей
        System.out.println("Changing state to 'State 1'");
        subject.setState("State 1");  // Все наблюдатели получат уведомление

        // Удаляем одного наблюдателя
        subject.removeObserver(observer2);

        // Изменяем состояние снова
        System.out.println("\nChanging state to 'State 2'");
        subject.setState("State 2");  // Только Observer 1 и Observer 3 получат уведомление
    }
}