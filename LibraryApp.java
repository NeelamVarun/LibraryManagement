package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class LibraryApp {
    private static LibraryService libraryService = new LibraryService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Library Management System");

        do {
            System.out.println("Enter a command (add, remove, list, exit): ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    addBook(scanner);
                    break;
                case "remove":
                    removeBook(scanner);
                    break;
                case "list":
                    listBooks();
                    break;
                case "exit":
                    System.out.println("Exiting the Library Management System...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();

        System.out.println("Enter book author: ");
        String author = scanner.nextLine();

        System.out.println("Enter book ISBN: ");
        String isbn = scanner.nextLine();

        libraryService.addBook(new Book(title, author, isbn));
        System.out.println("Book added successfully.");
    }

    private static void removeBook(Scanner scanner) {
        System.out.println("Enter the ISBN of the book to remove: ");
        String isbn = scanner.nextLine();

        if (libraryService.removeBook(isbn)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void listBooks() {
        List<Book> books = libraryService.listBooks();

        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            books.forEach(System.out::println);
        }
    }
}