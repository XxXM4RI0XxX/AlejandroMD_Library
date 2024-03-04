package Unidad_2.Project_Library.Controllers;

import Unidad_2.Project_Library.ConsoleReader;
import Unidad_2.Project_Library.Controllers.Filters.BookFilter;
import Unidad_2.Project_Library.Entities.Book;
import Unidad_2.Project_Library.Repositories.*;

public class OptionMenu {

    public static void adminBookMenu(){

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Book admin>>>");
            System.out.println("1) Create book\n2) See books\n3) Modify book\n4) Delete a book\n0) Return");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt){
                case 1:
                    EntitiesConstructors.bookConstructor();
                    break;
                case 2:
                    BookFilter.seeBooks();
                    break;
                case 3:
                    System.out.println("Choose the book you want to modify...");
                    BookRepository.selectBook();
                    int bookID = ConsoleReader.q.nextInt();
                    if(bookID!=0 && bookID <= BookRepository.books.size()){
                        EntitiesModifier.modifyBooks(bookID);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 4:
                    System.out.println("Choose the book you want to delete...");
                    BookRepository.printBooks();
                    System.out.println("0) Cancel");
                    int BookID = ConsoleReader.q.nextInt();
                    if(BookID>0 && BookID<=BookRepository.books.size()) {
                        Book delBook = BookRepository.getBook(BookID-1);
                        if(delBook.getIsAvailable())
                            BookRepository.deleteBook(delBook);
                        else{
                            System.out.println(">>> Someone has borrowed the book... wait until the book is returned ._.");
                        }
                    }
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);
    }

    public static void adminClientMenu(){

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Clients admin>>>");
            System.out.println("1) Add new client\n2) See clients\n3) Modify client\n4) Delete client\n0) Return");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt) {
                case 1:
                    EntitiesConstructors.clientConstructor();
                    break;
                case 2:
                    ClientRepository.printClients();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Choose the client you want to modify...");
                    ClientRepository.selectClient();
                    int cliID=ConsoleReader.q.nextInt();
                    if(cliID>0 && cliID<=ClientRepository.clients.size()){
                        EntitiesModifier.modifyClients(cliID);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 4:
                    System.out.println("Choose the client you want to delete...");
                    ClientRepository.printClients();
                    System.out.println("0) Cancel");
                    int CliID=ConsoleReader.q.nextInt();
                    if(CliID>0 && CliID<=ClientRepository.clients.size()){
                        ClientRepository.deleteClients(CliID-1);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);

    }

    public static void adminAuthorMenu(){

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Authors admin>>>");
            System.out.println("1) Add new author\n2) See authors\n3) Modify authors\n4) Delete author\n0) Return");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt) {
                case 1:
                    EntitiesConstructors.authorConstructor();
                    break;
                case 2:
                    AuthorRepository.printAuthors();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Choose the author you want to modify...");
                    AuthorRepository.selectAuthor();
                    int AutID=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();
                    if(AutID>0 && AutID<=AuthorRepository.getAuthors().size()){
                        EntitiesModifier.modifyAuthors(AutID);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 4:
                    System.out.println("Choose the Author you want to delete...");
                    AuthorRepository.printAuthors();
                    System.out.println("0) Cancel");
                    int  autID=ConsoleReader.q.nextInt();
                    if(autID>0 && autID<=AuthorRepository.getAuthors().size()){
                        AuthorRepository.deleteAuthors(autID-1);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);

    }

}
