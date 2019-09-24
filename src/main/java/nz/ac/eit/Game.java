package nz.ac.eit;

import java.util.ArrayList;

public class Game {
    private static final int numOfDice = 3; //Set the number of dice a game can have
    private static final int maxHandValue = 21; //The max hand value a player or dealer can have before going bust
    private Player player; //The player playing the game
    private Dealer dealer; //The dealer versing the player
    private boolean playerTurn = true; //if true its the players turn to hit or stay
    ArrayList<Die> dice;


    public Game(){
        dice = new ArrayList<Die>();
        createDice();
        dealer = new Dealer();
    }

    //creates the dice
    private void createDice(){
        for(int i = 0; i <= numOfDice; i++){
            Die newDie = new Die();
            dice.add(newDie);
        }
    }

    //Creates a player returns true if player was created
    public boolean createPlayer(String userName){
        if(userName != ""){
            player = new Player(userName);
            return true;
        }
        return false;
    }

    //returns true if player is bust
    public boolean checkPlayerBust(){
        return player.getHandValue() > maxHandValue;
    }

    //returns true if dealer is bust
    public boolean checkDealerBust(){
        return dealer.getHandValue() > maxHandValue;
    }

    //Adds 2 numbers to players handvalue (rolls dice)
    public void addValues(){
        for(int i = 0; i > dice.size();i++){
            player.handValue += dice.get(i).rollDie();
        }
    }

    //Checks for who wins if both players are holding
    public int determineWin() {
        if (!checkPlayerBust() && !checkDealerBust()) {
            if (player.getHandValue() > dealer.getHandValue()) {
                return 1;
            } else if (player.getHandValue() == dealer.getHandValue()) {
                return 0;
            }
            return 0;
        }
        return -1;
    }
}
