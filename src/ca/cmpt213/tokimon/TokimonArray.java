package ca.cmpt213.tokimon;
import java.util.*;
import static java.lang.System.exit;

/**
 * TokimonArray class stores an array of existing tokimons.
 * Tokimon class performs functions accordingly to user's selection.
 * Users can list all tokimons; add, remove or modify strength of a tokimon; dump object and exit program.
 * Helper funstions check validity of user's input.
 */

public class TokimonArray {
    private static List<Tokimon> tokimonList = new ArrayList<>();

    // Collect input from user
    public String keyboardInput(String command) {
        System.out.print(command);
        Scanner scanInput = new Scanner(System.in);
        String userInput = scanInput.nextLine();
        return userInput;
    }

    // Helper functions
    public int checkInputIndex(int index, int firstEnterFunction) {
        // First time enter function
        if (firstEnterFunction == -1)
            return -1;
        // Cancel option
        if (index == 0)
            return 0;
        // Index out of range
        if ((index > tokimonList.size()) || (index < 0)) {
            System.out.print("Input error. Please re-type your selection." + "\n\n");
            return -1;
        }
        // Correct input
        else
            return 1;
    }

    public int checkInputStrength(int strength, int firstEnterFunction) {
        if (firstEnterFunction == -1)
            return -1;

        if (strength < 0) {
            System.out.print("Input error. Please re-type strength." + "\n\n");
            return -1;
        }
        else
            return 1;
    }


    // List tokimons
    public static void listTokimon() {
        if (tokimonList.size() == 0)
            System.out.println("Empty list");
        for (int i = 0; i < tokimonList.size(); i++) {
            System.out.print(i + 1 + ". ");
            Tokimon eachTokimon = tokimonList.get(i);
            if (eachTokimon != null)
                eachTokimon.print();
        }
    }

    // Add a new Tokimon
    public void addTokimon() {
        String tokimonName = keyboardInput("Enter tokimon's name: ");
        double tokimonSize = Double.parseDouble(keyboardInput("Enter tokimon's size: "));
        String tokimonAbility = keyboardInput("Enter tokimon's ability: ");

        tokimonList.add(new Tokimon(tokimonName, tokimonSize, tokimonAbility));
    }

    // Remove a Tokimon
    public void removeTokimon() {
        this.listTokimon();
        System.out.println("(Enter 0 to cancel)" + "\n");
        int removedNumber = -1;
        int firstEnterFunction = -1;

        while (checkInputIndex(removedNumber, firstEnterFunction) == -1) {
            firstEnterFunction = 0;
            removedNumber = Integer.parseInt(keyboardInput("Which tokimon?: "));
        }

        if (checkInputIndex(removedNumber, firstEnterFunction) == 0) {
            System.out.println("Deletion cancelled");
            return;
        }

        tokimonList.remove(tokimonList.get(removedNumber - 1));
        System.out.println("Deletion complete");
    }

    // Modify Tokimon's strength
    public void modifyTokimonStrength() {
        this.listTokimon();
        System.out.println("(Enter 0 to cancel)" + "\n");
        int modifiedIndex = -1;
        int firstEnterIndex = -1;
        int modifiedStrength = -1;
        int firstEnterStrength = -1;

        while (checkInputIndex(modifiedIndex, firstEnterIndex) == -1) {
            firstEnterIndex = 0;
            modifiedIndex = Integer.parseInt(keyboardInput("Which tokimon?: "));
        }

        if (checkInputIndex(modifiedIndex, firstEnterIndex) == 0) {
            System.out.println("Strength's modification cancelled");
            return;
        }

        while (checkInputStrength(modifiedStrength, firstEnterStrength) == -1) {
            firstEnterStrength = 0;
            modifiedStrength = Integer.parseInt(keyboardInput("By how much?: "));
        }


        Tokimon modifiedTokimon = tokimonList.get(modifiedIndex - 1);
        modifiedTokimon.setTokimonStrength(modifiedStrength);
        tokimonList.set(modifiedIndex - 1, new Tokimon(modifiedTokimon));
        System.out.println("Tokimon " + modifiedTokimon.getTokimonName() + " now has strength " + modifiedTokimon.getTokimonStrength() + "!");
    }

    // Dump Object
    public void dumpObject() {
        for (Tokimon each:tokimonList)
            System.out.println(each.toString());
    }

    // Exit program
    public void Exit() {
        System.out.println("Bye!!! See ya next time");
        exit(0);
    }

}

