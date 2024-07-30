import java.util.*;

class Book {
    public int bookId;
    public String title;
    public String author;

    Book() {}
    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

class LibrarySystem {
    public List<Book> library;
    LibrarySystem() {
        library = new ArrayList<>();
    }

    //1. Add Books
    public void addBooks(int bookId, String title, String author) {
        library.add(new Book(bookId, title, author));
        System.out.println("Book Successfully Added");
    }

    //2. Linear Search
    public void linearSearch(String title) {
        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            if (book.title.equals(title)) {
                System.out.println("Book found!");
                System.out.println("Book id : " + book.bookId);
                System.out.println("Book Title : " + book.title);
                System.out.println("Book Author : " + book.author);
                System.out.println();
                return;
            }
        }
        System.out.println("BOOK NOT FOUND");
    }

    //3. Binary Search 
    public void binarySearch(String title) {
        List<Book> tempList = new ArrayList<>(library);
        Collections.sort(tempList, (a, b) -> a.title.compareTo(b.title));
        int i = 0;
        int j = tempList.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (tempList.get(mid).title.equals(title)) {
                System.out.println("Book found");
                Book book = tempList.get(mid);
                System.out.println("Book id : " + book.bookId);
                System.out.println("Book Title : " + book.title);
                System.out.println("Book Author : " + book.author);
                System.out.println();
                return;
            } else if (tempList.get(mid).title.compareTo(title) > 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        System.out.println("Book Not found");
    }

    public void display() {
        for (Book book : library) {
            System.out.println("Book id : " + book.bookId);
            System.out.println("Book Title : " + book.title);
            System.out.println("Book Author : " + book.author);
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add ");
            System.out.println("2. Linear Search ");
            System.out.println("3. Binary Search ");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.println("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter Book Id: ");
                    int bookId = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    System.out.println("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter Book Author: ");
                    String author = sc.nextLine();

                    librarySystem.addBooks(bookId, title, author);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("Enter Title: ");
                    title = sc.nextLine();
                    librarySystem.linearSearch(title);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Enter Title: ");
                    title = sc.nextLine();
                    librarySystem.binarySearch(title);
                    break;

                case 4:
                    librarySystem.display();
                    break;

                case 5:
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("OOPS! WRONG CHOICE!");
            }
        }
    }
}
