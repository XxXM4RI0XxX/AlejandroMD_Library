package Unidad_2.Project_Library.Controllers;

import Unidad_2.Project_Library.ConsoleReader;
import Unidad_2.Project_Library.Entities.*;
import Unidad_2.Project_Library.Repositories.*;
import java.time.LocalDateTime;

import java.util.Date;

public class EntitiesConstructors {

    //////////////////////AUTHORS/////////////////////////////
    public static void authorConstructor() {
        //////////////////////
        // NAME
        System.out.println(">>>Author data<<<");
        System.out.print("Author name: ");
        String name = ConsoleReader.q.nextLine();
        System.out.print("Author last name: ");
        String lastname = ConsoleReader.q.nextLine();
        if(name.isEmpty()||lastname.isEmpty()){
            System.out.println(">>> Invalid author name, try again...");
        }
        else{
        System.out.println("Author birth day(DD/MM/YYYY):");
        /////////////////////
        // BIRTHDAY
        int day = DateConstructor.dayConstructor();
        int month = DateConstructor.monthConstructor();
        int type=1;//Author
        int year = DateConstructor.yearConstructor(type);
        //Creating author profile
        Profile profile = new Profile(name.trim(), lastname.trim(), new Date(year, month, day));
        //Object author
        Author author = new Author(profile);
        //Add new author to Data_Repository
        AuthorRepository.addAuthor(author);
            System.out.println("Author successfully added :D");
        }
    }
    //////////////////////////////////////////////////////

    /////////////////////////BOOKS//////////////////////////////
    public static void bookConstructor() {

        System.out.println(">>>Book data<<<");
        System.out.print("Book title: ");
        String title = ConsoleReader.q.nextLine();
        if(title.isEmpty()){
            System.out.println(">>> Book title is esencial, try again...");
        }
        else{
        AuthorRepository.selectAuthor();
        int autID = ConsoleReader.q.nextInt();

        if (autID > 0 && autID<=AuthorRepository.getAuthors().size()) {
            Author bookAuthor = AuthorRepository.getAuthor(autID-1);
            System.out.println("Publish date(DD/MM/YYYY): ");
            int day = DateConstructor.dayConstructor();
            int month = DateConstructor.monthConstructor();
            int type=1;//Author
            int year = DateConstructor.yearConstructor(type);
            ConsoleReader.q.nextLine();

            String isbn = IsbnConstructor.verifyISBN(1);
            Book book = new Book(title.trim(), bookAuthor, new Date(year, month, day), isbn);

            bookAuthor.addBook(book);

            System.out.println(">>> Book successfully created :D");
        }
        else {
            System.out.println("Invalid input...");
        }
        }
    }

    //////////////////////AUTHORS/////////////////////////////
    public static void clientConstructor() {
        //////////////////////
        // NAME
        System.out.println(">>>Client data<<<");
        System.out.print("Client name: ");
        String name = ConsoleReader.q.nextLine();
        System.out.print("Client last name: ");
        String lastname = ConsoleReader.q.nextLine();
        if(name.isEmpty()||lastname.isEmpty()){
            System.out.println(">>> Invalid client name, try again...");
        }
        else{
        System.out.println("Client birth day(DD/MM/YYYY):");
        /////////////////////
        // BIRTHDAY
        int day = DateConstructor.dayConstructor();
        int month = DateConstructor.monthConstructor();
        int year = DateConstructor.yearConstructor(2);
        //Creating author profile
        Profile profile = new Profile(name.trim(), lastname.trim(), new Date(year, month, day));
        //Object author
        Client client = new Client(profile);
        //Add new author to Data_Repository
        ClientRepository.addClient(client);
            System.out.println(">>> Client successfully added :D");
        }
    }
    //////////////////////////////////////////////////////

    //////////////////////TRANSACTIONS/////////////////////////////
    public static void transactionConstructor(int transType) {
        String transactionType="";
        switch (transType) {
            case 1:
                transactionType = "BORROW";
                break;
            case 2:
                transactionType = "RETURN";
                break;
        }

        System.out.println("Who's " + transactionType.toLowerCase() + "ing the book?");
        if(transType==1)
            ClientRepository.selectClient();
        else{
        ClientRepository.selectReturnClient();}

        int selClient = ConsoleReader.q.nextInt(),selBook;

        //If wanted to cancel
        if (selClient > 0 && selClient <= ClientRepository.clients.size()) {
            Client client = ClientRepository.getClient(selClient - 1);

                switch (transType) {
                    case 1:
                        if(client.getBorrowedBooks().size()<3) {
                            System.out.println("Choose the book to " + transactionType.toLowerCase());
                            BookRepository.selectBook();
                            selBook = ConsoleReader.q.nextInt();

                            //If wanted to cancel
                            if (selBook > 0 && selBook <= BookRepository.books.size()) {
                                Book book = BookRepository.getBook(selBook - 1);

                                if (book.getIsAvailable()) {
                                    book.modifyIsAvailable(false);

                                    Transaction transaction = new Transaction(transactionType, client, book, LocalDateTime.now());

                                    TransactionRepository.addTransaction(transaction);

                                    client.borrowBook(book);

                                    System.out.println(">>> Book successfully borrowed :D");
                                } else {
                                    System.out.println(">>> Book already borrowed, try selecting another one :]");
                                }
                            }
                            else {
                                System.out.println("Invalid book...");
                            }
                        }
                        else {
                            System.out.println("Client "+client.getProfile().getName() +" has reached the book borrow limit [3], return any to borrow a new one :]");
                        }
                        break;
                    case 2:
                        System.out.println("Choose the book to " + transactionType.toLowerCase());
                        ClientRepository.selectClientBook(client);
                        selBook = ConsoleReader.q.nextInt();

                        //If there's no book to return
                        if (selBook > 0 && selBook < BookRepository.books.size()) {
                            Book book = client.getBorrowedBooks().get(selBook-1);
                            book.modifyIsAvailable(true);

                            Transaction transaction = new Transaction(transactionType, client, book, LocalDateTime.now());
                            TransactionRepository.addTransaction(transaction);

                            client.returnBook(book);

                            System.out.println(">>> Book successfully returned :D ");
                        }
                        else {
                            System.out.println("Invalid book...");
                        }
                }

        }
        else {
            System.out.println("Invalid client...");
        }
    }
}
