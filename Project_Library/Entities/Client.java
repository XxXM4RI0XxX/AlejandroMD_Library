package Unidad_2.Project_Library.Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Client {

    private final Profile profile;
    private final ArrayList<Book> borrowedBooks=new ArrayList<>(); //Books the client has borrowed

    public Client(Profile profile){this.profile=profile;}
    public Profile getProfile(){
        return profile;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void printProfile(int ID){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(profile.getBirthdate());

        System.out.printf("§ %2s |%-40s| %-10s |",ID, profile.getName()+" "+profile.getLastName(),date);
    }

    public void printBorrowedBooks(){
        if(borrowedBooks.isEmpty())
            System.out.println(">>>No borrowed books :(");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-_-._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-`.");
            System.out.printf("§ %2s|%25s%-25s|%20s%-20s|%6s%-6s|%10s%-9s|%5s%-5s§\n", "ID", "Tit", "le ", "Aut", "hor", "Pub. ", "date", "IS", "BN ", "Sta", "tus");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Book book : borrowedBooks) {
                book.printBook(ID);
                ID++;
                System.out.println();
            }
            System.out.println("`-------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public void printClientBooks(){
        for(Book book:borrowedBooks){
            String pBook=book.getTitle();
            if(pBook.length()>25)
                pBook = pBook.substring(0,25)+"...";

            System.out.print(pBook+", ");
        }
    }

    public void borrowBook(Book borrowedBook){

        borrowedBooks.add(borrowedBook);

    }
    public void returnBook(Book borrowedBook){
        borrowedBooks.remove(borrowedBook);
    }


}
