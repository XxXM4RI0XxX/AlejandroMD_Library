package Unidad_2.Project_Library.Controllers;

import Unidad_2.Project_Library.ConsoleReader;
import Unidad_2.Project_Library.Controllers.Filters.TransactionFilter;
import Unidad_2.Project_Library.Entities.*;
import Unidad_2.Project_Library.Repositories.*;

public class OperationControllers {

    public static void borrowBook(){
        int transType=1;
        EntitiesConstructors.transactionConstructor(transType);
    }

    public static void returnBook(){
        int transType=2;
        EntitiesConstructors.transactionConstructor(transType);
    }

    public static void seeTransactions(){
        System.out.println("\nWant to filter transactions?");
        System.out.println("1) Date range\n2) Client transactions\n3) Book transactions\n0) Don't filter, see all");
        int opt = ConsoleReader.q.nextInt();

        switch (opt){
            case 0:
                TransactionFilter.printAllTransactions();
                break;
            case 1:
                System.out.println("Year of the transactions...");
                int year = DateConstructor.yearConstructor(1);

                System.out.println("Initial month...");
                int monthI = DateConstructor.monthConstructor();
                System.out.println("End month...");
                int monthE = DateConstructor.monthConstructor();

                if(monthE<monthI)
                    System.out.println("The finish date has to be bigger than the start date");
                else{
                TransactionFilter.printDateRangedTransactions(monthI,year+1900,monthE);}
                break;
            case 2:
                System.out.println("Choose the client you want to filter for the search...");
                ClientRepository.selectClient();
                int client = ConsoleReader.q.nextInt();
                if(client>0){
                Client pClient = ClientRepository.getClient(client-1);

                String name = pClient.getProfile().getName();
                TransactionFilter.printClientTransactions(name);}

                break;
            case 3:
                System.out.println("Choose the book you want to filter for the search...");
                BookRepository.selectBook();
                int book = ConsoleReader.q.nextInt();

                if(book>0) {
                    Book pBook = BookRepository.getBook(book - 1);
                    String title = pBook.getTitle();
                    TransactionFilter.printBookTransactions(title);
                }
                break;
        }
    }
}
