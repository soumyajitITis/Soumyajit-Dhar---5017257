package Q6;

import java.util.Arrays;

class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
                new Book("B003", "1984", "George Orwell"),
                new Book("B004", "Pride and Prejudice", "Jane Austen"),
                new Book("B005", "The Catcher in the Rye", "J.D. Salinger")
        };

        // Linear search
        System.out.println("Linear Search Result:");
        Book foundBook = Book.linearSearch(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");

        // Sort the books array for binary search
        Arrays.sort(books);

        // Binary search
        System.out.println("\nBinary Search Result:");
        foundBook = Book.binarySearch(books, "1984");
        System.out.println(foundBook != null ? foundBook : "Book not found");
    }
}
