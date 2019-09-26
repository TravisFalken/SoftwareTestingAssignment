package nz.ac.eit;


import java.util.ArrayList;

public class Game {
    private static final int numOfDice = 2; //Set the number of dice a game can have
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

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
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

    public void addGameScore(){
        player.setGameScore(player.getGameScore() + 1);
    }

    public void addComputerGameScore(){
        dealer.setGameScore(dealer.getGameScore() + 1);
    }
    //Adds 2 numbers to players handvalue (rolls dice)
    public void addValues(boolean Isplayer){
        for(int i = 0; i < dice.size();i++){
            if(Isplayer == true){
                player.setHandValue(player.getHandValue() + dice.get(i).rollDie());
            } else{
                dealer.setHandValue(dealer.getHandValue() + dice.get(i).rollDie());
            }

        }
    }
//hi
    //Checks for who wins if both players are holding
    public int determineWin() {

            if (player.getHandValue() > dealer.getHandValue()) {
                return 1;
            } else if (player.getHandValue() == dealer.getHandValue()) {
                return 0;
            }
            return 0;


    }

    public String PlayerWin(){
        addGameScore();
        return "You Win. Your Score: " + player.getGameScore() + " Computer Score: " + dealer.getGameScore();
    }

    public String DealerWin(){
        addComputerGameScore();
        return "You lose. Your Score: " + player.getGameScore() + " Computer Score: " + dealer.getGameScore();
    }

    public int Hit21(){
        if(player.getHandValue() == 21){
            return 1;

        } else if(dealer.getHandValue() == 21){
            return 0;
        } else{
            return -1;
        }
    }
}
