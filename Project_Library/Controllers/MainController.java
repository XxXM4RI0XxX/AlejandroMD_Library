package Unidad_2.Project_Library.Controllers;

import Unidad_2.Project_Library.ConsoleReader;

public class MainController {

    public static void mainMenu(){
        boolean flag = true;
        do {
            System.out.println("\n\t<<<MENU>>>");
            System.out.println("-------------------------------");
            System.out.println("\t>>>Operation options<<<\n1)Borrow book\n2)Return book\n3)See transactions");
            System.out.println("\t>>>Admin options<<<\n4) Admin books\n5) Admin clients\n6) Admin authors\n0) Exit system");
            int opt1 = ConsoleReader.q.nextInt();
            switch (opt1) {
                case 1:
                    OperationControllers.borrowBook();
                    break;
                case 2:
                    OperationControllers.returnBook();
                    break;
                case 3:
                    OperationControllers.seeTransactions();
                    break;
                case 4:
                    OptionMenu.adminBookMenu();
                    break;
                case 5:
                    OptionMenu.adminClientMenu();
                    break;
                case 6:
                    OptionMenu.adminAuthorMenu();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option :o");
            }
        }
        while (flag);

    }
}
