package Unidad_2.Project_Library.Repositories;

import Unidad_2.Project_Library.Entities.Transaction;
import java.util.ArrayList;

public class TransactionRepository {

    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

}
