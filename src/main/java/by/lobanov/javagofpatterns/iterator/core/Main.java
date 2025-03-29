package by.lobanov.javagofpatterns.iterator.core;

import by.lobanov.model.Book;

public class Main {

    public static void main(String[] args) {
        // Создаем коллекцию книг
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("1984", "George Orwell"));
        bookCollection.addBook(new Book("Brave New World", "Aldous Huxley"));
        bookCollection.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        // Получаем итератор коллекции книг
        Iterator<Book> iterator = bookCollection.createIterator();

        // Перебираем книги с помощью итератора
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}