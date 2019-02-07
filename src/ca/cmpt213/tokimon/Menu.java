package ca.cmpt213.tokimon;
import java.util.*;

/**
 * Menu class presents an option prompt for users.
 * Menu consists of an array of options for user to choose: List Tokimon, Add a new tokimon, Change Tokimon strength, Dump objects and Exit.
 * Menu direct program to the right function based on user's selection
 */


public class Menu {
    private String title;
    private String options[];
    static int printOnce = 1;

    // Constructor
    public Menu() {
        options = new String[]{"List Tokimon", "Add a new Tokimon", "Remove a Tokimon", "Change Tokimon strength", "Dump objects", "Exit"};
    }

    // Print only the option's title with stars wrapped around
    public void printTitle(String title) {
        int countChar = title.length();
        for (int i = 0; i < (countChar + 4); i++)
            System.out.print('*');
        System.out.println();
        System.out.print("* ");
        System.out.print(title);
        System.out.print(" *");
        System.out.println();
        for (int i = 0; i < (countChar + 4); i++)
            System.out.print('*');
        System.out.println();
    }

    // Print main menu with all options
    public void menuPrintingAll() {
        printTitle("Main menu");
        for (int i = 0; i < 6; i++) {
            System.out.print(i+1 + ". ");
            System.out.println(options[i]);
        }
        System.out.println();
    }

    // Ask to re-type option if input is out of range
    public int checkInput(int input) {
        if (input > 6 || input < 1) {
            System.out.print("Input error. Please re-type your option." + "\n");
            return 0;
        }
        else
            return 1;
    }


    // User's selection
    // Welcome line is printed only once
    public void menuSelection() {
        if (printOnce == 1) {
            printTitle("Welcome to Chi's Tokimon tracking system <3");
            System.out.println();
        }
        printOnce = 0;

        menuPrintingAll();
        Scanner userOption = new Scanner(System.in);
        System.out.print("Enter your option: ");
        String userInput = userOption.nextLine();
        System.out.println();

        int input = Integer.parseInt(userInput);
        if ((checkInput(input)) == 0)
            menuSelection();

        TokimonArray tokimonList  = new TokimonArray();

        printTitle(options[input-1]);
        if (input == 1)
            tokimonList.listTokimon();

        else if (input == 2)
            tokimonList.addTokimon();

        else if (input == 3)
            tokimonList.removeTokimon();

        else if (input == 4)
            tokimonList.modifyTokimonStrength();

        else if (input == 5)
            tokimonList.dumpObject();

        else
            tokimonList.Exit();

        System.out.println();
        menuSelection();
    }






}
