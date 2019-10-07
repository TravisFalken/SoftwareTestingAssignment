package nz.ac.eit;

public class Player {
    protected String userName;
    //protected int gameScore = 0;
    protected int handValue = 0; //What is in the players hand each round

    public Player(String userName){
        setUserName(userName);
    }

    //Sets the user name
    public void setUserName(String userName){
        if(userName != ""){
            this.userName = userName;
        } else {
            this.userName = "player1";//Default user name
        }
    }

    public String getUserName() {
        return userName;
    }

//    public int getGameScore() {
//        return gameScore;
//    }
//
//    public void setGameScore(int gameScore) {
//        this.gameScore = gameScore;
//    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

//    public void increaseHandValue(int roundScore) {
//        this.handValue = roundScore;
//    }

//    //Increase the game score each time the user wins a round
//    public void increaseGameScore(int gameScore) {
//        this.gameScore++;
//    }

//    //resets the handValue at the beginning of every round
//    public void resetHandValue(){
//        this.handValue = 0;
//    }
}
