package nz.ac.eit;

public class Dealer extends Player {
    private static final int houseLimit = 16; //The dealer can not bet passed this limit
    public Dealer() {
        super("Dealer"); //Always sets the user name to dealer
    }

    //check if limit is reached return true if it has not been reached
    public boolean canBet(){
        return handValue < houseLimit; //returns true if hand value is less than
    }
}
