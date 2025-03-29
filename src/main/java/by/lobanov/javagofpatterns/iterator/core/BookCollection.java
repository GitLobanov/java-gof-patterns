package by.lobanov.javagofpatterns.iterator.core;

import by.lobanov.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCollection implements Aggregate<Book> {

    private List<Book> books;  // Коллекция книг

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);  // Добавление книги в коллекцию
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator();  // Создание итератора
    }

    // Класс итератора для коллекции книг
    private class BookIterator implements Iterator<Book> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < books.size();
        }

        @Override
        public Book next() {
            if (hasNext()) {
                return books.get(currentIndex++);
            }
            return null;
        }
    }
}
