class Book {

    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagement {
    static void linearSearch(Book[] books, String title) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].title.equalsIgnoreCase(title)) {

                System.out.println("Book Found (Linear Search)");
                System.out.println("Book ID : " + books[i].bookId);
                System.out.println("Title   : " + books[i].title);
                System.out.println("Author  : " + books[i].author);
                return;
            }
        }

        System.out.println("Book Not Found");
    }
    static void sortBooks(Book[] books) {

        for (int i = 0; i < books.length - 1; i++) {

            for (int j = 0; j < books.length - i - 1; j++) {

                if (books[j].title.compareToIgnoreCase(books[j + 1].title) > 0) {

                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }
    static void binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {

                System.out.println("\nBook Found (Binary Search)");
                System.out.println("Book ID : " + books[mid].bookId);
                System.out.println("Title   : " + books[mid].title);
                System.out.println("Author  : " + books[mid].author);
                return;

            } else if (result < 0) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }
        }

        System.out.println("Book Not Found");
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "Java", "James"),
                new Book(102, "Python", "Guido"),
                new Book(103, "C Programming", "Dennis"),
                new Book(104, "Operating System", "Galvin"),
                new Book(105, "Database", "Korth")
        };
        linearSearch(books, "Operating System");
        sortBooks(books);
        binarySearch(books, "Operating System");
    }
}