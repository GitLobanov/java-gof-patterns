package by.lobanov.javagofpatterns.iterator.core;

/**
 * Интерфейс Iterator будет определять методы для перемещения по коллекции и получения элементов.
 */
public interface Iterator<T> {
    boolean hasNext();   // Проверка на наличие следующего элемента
    T next();            // Получение следующего элемента
}
