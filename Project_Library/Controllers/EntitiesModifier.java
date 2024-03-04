package Unidad_2.Project_Library.Controllers;

import Unidad_2.Project_Library.ConsoleReader;
import Unidad_2.Project_Library.Entities.*;
import Unidad_2.Project_Library.Repositories.*;

public class EntitiesModifier {


    public static void modifyAuthors(int auID){
        Author modAut = AuthorRepository.getAuthor(auID-1);
        Profile modProf = modAut.getProfile();
        System.out.print("New Name: ");
        String NewName = ConsoleReader.q.nextLine();
        System.out.print("New Last Name: ");
        String NewLastName= ConsoleReader.q.nextLine();
        System.out.println("Want to change Birthday?(Y/N)");
        char bOpt=ConsoleReader.q.next().charAt(0);ConsoleReader.q.nextLine();

        if(bOpt=='y'||bOpt=='Y') {
            System.out.println("New Birthday(DD/MM/YYYY)");
            int day = DateConstructor.dayConstructor();
            int month = DateConstructor.monthConstructor();
            int type=1;
            int year = DateConstructor.yearConstructor(type);

            modProf.modifyBirthday(day, month, year);
        }
        //CHECK NEW INFO ISN'T BLANK
        if(!NewName.isEmpty())
            modProf.modifyName(NewName);

        if(!NewLastName.isEmpty())
            modProf.modifyLastName(NewLastName);

        System.out.println("Author successfully modified :D");
    }

    public static void modifyBooks(int bookID){
        Book modBook = BookRepository.getBook(bookID-1);

        if(modBook.getIsAvailable()) {
            System.out.print("New title: ");
            ConsoleReader.q.nextLine();
            String newTitle = ConsoleReader.q.nextLine();

            System.out.println(">> Assign new author");
            AuthorRepository.selectAuthor();
            int newAutID = ConsoleReader.q.nextInt();

            if (newAutID == 0)
                System.out.println(">> Previous author assigned");
            if (newAutID < 0 || newAutID>AuthorRepository.getAuthors().size()) {

                System.out.println("Invalid author input, previous assigned");
            }

            System.out.println("Want to change publish day?(Y/N)");
            char bOpt = ConsoleReader.q.next().charAt(0);

            if (bOpt == 'y' || bOpt == 'Y') {
                System.out.println("New date(DD/MM/YYYY)");
                int day = DateConstructor.dayConstructor();
                int month = DateConstructor.monthConstructor();
                int type = 1;
                int year = DateConstructor.yearConstructor(type);
                modBook.modifyPublishDate(day, month, year);
            } ConsoleReader.q.nextLine();
            String newIsbn = IsbnConstructor.verifyISBN(2);

            //CHECK NEW INFO ISN'T BLANK
            if (!newTitle.isEmpty())
                modBook.modifyTitle(newTitle);

            if (newAutID > 0  && newAutID<AuthorRepository.getAuthors().size()) {
                Author newAuthor = AuthorRepository.getAuthor(newAutID-1);
                modBook.modifyAuthor(newAuthor);
            }

            if (!newIsbn.isEmpty())
                modBook.modifyIsbn(newIsbn);

            System.out.println(">>> Books successfully modified :D");
        }
        else {
            System.out.println("Book <"+modBook.getTitle()+"> is borrowed, wait until it's returned to modify it");
        }

    }

    public static void modifyClients(int cliID){
        Client modCli = ClientRepository.getClient(cliID-1);ConsoleReader.q.nextLine();
        Profile modProf = modCli.getProfile();
        System.out.print("New Name: ");
        String NewName = ConsoleReader.q.nextLine();
        System.out.print("New Last Name: ");
        String NewLastName= ConsoleReader.q.nextLine();
        System.out.println("Want to change Birthday?(Y/N)");
        char bOpt=ConsoleReader.q.next().charAt(0);ConsoleReader.q.nextLine();

        if(bOpt=='y'||bOpt=='Y') {
            System.out.println("New Birthday(DD/MM/YYYY)");
            int day = DateConstructor.dayConstructor();
            int month = DateConstructor.monthConstructor();
            int type=2;
            int year = DateConstructor.yearConstructor(type);

            modProf.modifyBirthday(day, month, year);
        }
        //CHECK NEW INFO ISN'T BLANK
        if(!NewName.isEmpty())
            modProf.modifyName(NewName);

        if(!NewLastName.isEmpty())
            modProf.modifyLastName(NewLastName);

        System.out.println("Client successfully modified :D");

    }


}
