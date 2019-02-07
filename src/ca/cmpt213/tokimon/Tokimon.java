package ca.cmpt213.tokimon;

/**
 * Tokimon class stores information of each individual tokimon.
 * Each Tokimon has four attributes: name, size, ability and strength.
 * Tokimon class allows users to create and print Tokimon object, set and retrieve values.
 */

public class Tokimon {
    private String tokimonName;
    private double tokimonSize;
    private String tokimonAbility;
    private int tokimonStrength;


    // Constructors
    public Tokimon(String name, double size, String ability){
        tokimonName = name;
        tokimonSize = size;
        tokimonAbility = ability;
    }

    public Tokimon(Tokimon copyTokimon){
        tokimonName = copyTokimon.getTokimonName();
        tokimonSize = copyTokimon.getTokimonSize();
        tokimonAbility = copyTokimon.getTokimonAbility();
        tokimonStrength = copyTokimon.getTokimonStrength();
    }


    // Setters
    public void setTokimonStrength(int strength) {
        tokimonStrength = strength;
    }


    // Getters
    public String getTokimonName() {
        return tokimonName;
    }

    public double getTokimonSize() {
        return tokimonSize;
    }

    public String getTokimonAbility() {
        return tokimonAbility;
    }

    public int getTokimonStrength() {
        return tokimonStrength;
    }


    // Print attributes of each Tokimon
    public void print() {
        System.out.print(getTokimonName() + ", " + getTokimonSize() + "m, " + getTokimonStrength() + ", " + getTokimonAbility());
        System.out.println();
    }


    // Override default toString function to print more useful information
    @Override
    public String toString() {
        String str = this.getClass().getName() + "[Name: " + this.getTokimonName() + ", Size: " + this.getTokimonSize()
                    + ", Ability: " + this.getTokimonAbility() + ", Strength: " + this.getTokimonStrength() + "]";
        return str;
    }

}
