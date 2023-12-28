package com.sarp.lambda.chapter;
import java.util.Optional;

class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Book {
    private String title;
    private Optional<Author> author;

    public Book(String title, Optional<Author> author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Optional<Author> getAuthor() {
        return author;
    }
}

class Library {
    private Optional<Book> book;

    public Library(Optional<Book> book) {
        this.book = book;
    }

    public Optional<Book> getBook() {
        return book;
    }
}

public class OptionalFun {

        public static void main(String[] args) {
            // Create an Author with a name
            Author author = new Author("John Doe");

            // Create a Book with a title and an Author
            Book book = new Book("Java Programming", Optional.of(author));
            Book book1 = new Book("Java Programming with Optional", Optional.ofNullable(null));

            // Create a Library with a Book
            Library library = new Library(Optional.of(book));
            Library library1 = new Library(Optional.of(book1));

            // Use flatMap to safely access the author's name in a nested structure
            String authorName = library1.getBook()
                    .flatMap(Book::getAuthor)
                    .map(Author::getName)
                    .orElse("Unknown Author");

            System.out.println("Author's Name: " + authorName);
        }
}
