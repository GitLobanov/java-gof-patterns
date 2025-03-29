package by.lobanov.javagofpatterns.iterator.core;

// Этот интерфейс будет использоваться для создания итератора для коллекции.
public interface Aggregate<T> {
    Iterator<T> createIterator();   // Метод для создания итератора
}
