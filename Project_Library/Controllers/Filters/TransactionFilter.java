package Unidad_2.Project_Library.Controllers.Filters;

import Unidad_2.Project_Library.Entities.Transaction;
import static Unidad_2.Project_Library.Repositories.TransactionRepository.transactions;

public class TransactionFilter {

    public static void printAllTransactions(){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-'`.");
            System.out.printf("§ %2s|%5s%-5s|%20s%-20s|%26s%-26s|%9s%-9s|%5s%-5s§\n", "ID", "Ty", "pe", "Cli", "ent", "Bo", "ok", "Da", "te", "  Tran", "s. ID ");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Transaction transaction : transactions) {
                transaction.printTransaction(ID);
                ID++;
                System.out.println();
            }System.out.println("`--------------------------------------------------------------------------------------------------------------------------------------------'");

        }
    }

    public static void printDateRangedTransactions(int monthS,int year,int monthF){
        
        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-'`.");
            System.out.printf("§ %2s|%5s%-5s|%20s%-20s|%26s%-26s|%9s%-9s|%5s%-5s§\n", "ID", "Ty", "pe", "Cli", "ent", "Bo", "ok", "Da", "te", "  Tran", "s. ID ");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Transaction transaction : transactions) {
                if(transaction.getDate().getYear()==year&&(transaction.getDate().getMonthValue()>=monthS
                &&transaction.getDate().getMonthValue()<=monthF)){
                    transaction.printTransaction(ID);
                    ID++;
                    System.out.println();
                }
            }
            System.out.println("`--------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    
    }

    public static void printClientTransactions(String name){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-'`.");
            System.out.printf("§ %2s|%5s%-5s|%20s%-20s|%26s%-26s|%9s%-9s|%5s%-5s§\n", "ID", "Ty", "pe", "Cli", "ent", "Bo", "ok", "Da", "te", "  Tran", "s. ID ");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Transaction transaction : transactions) {
                if(transaction.getClient().getProfile().getName().equals(name)) {
                    transaction.printTransaction(ID);
                    ID++;
                    System.out.println();
                }
            }
            System.out.println("`--------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public static void printBookTransactions(String title){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-'`.");
            System.out.printf("§ %2s|%5s%-5s|%20s%-20s|%26s%-26s|%9s%-9s|%5s%-5s§\n", "ID", "Ty", "pe", "Cli", "ent", "Bo", "ok", "Da", "te", "  Tran", "s. ID ");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Transaction transaction : transactions) {
                if(transaction.getBook().getTitle().equals(title)) {
                    transaction.printTransaction(ID);
                    System.out.println();
                }
            }
            System.out.println("`--------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }
}
