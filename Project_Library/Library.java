package Unidad_2.Project_Library;

import Unidad_2.Project_Library.Controllers.MainController;

public class Library {

    public static void main(String[] args) {

        Seeder.initialize();
        System.out.println("\nWelcome to the library! Glad to see you here :].\n");
        MainController.mainMenu();
        System.out.println("See ya :D");
    }

}
