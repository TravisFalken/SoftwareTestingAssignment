package nz.ac.eit;



import java.util.Scanner;

/**
 * Hello world!
 * hi
 * hi
 */
public class App 
{
    public static void main( String[] args )
    {
        //Declare objects needed
        //New Game
        Game MainGame = new Game();
        //New scanner for user input
        Scanner sc = new Scanner(System.in);
        String userinput = "";
        //Checking for game end
        boolean end = false;

        //Welcomes and creates player
        System.out.println("Welcome to BlackJack! Please enter a username: ");
        //Gets user input
        userinput = sc.nextLine();
        //Create player in game using user input
        if(MainGame.createPlayer(userinput)) {
            //Set players username based on input
            MainGame.getPlayer().setUserName(userinput);
            //Welcome message
            System.out.println("Player created! Welcome " + MainGame.getPlayer().getUserName());
        }else{
            System.out.println("Error player not created.");
        }

        //Rolls dice for player and added to hand value
        MainGame.addValues(true);
        //Rolls dice for dealer and added to hand value
        MainGame.addValues(false);

        //While end bool is false, keep game going
        while(end == false){

            //Display roll values and current scores of both player and dealer
            System.out.println("You rolled: " + MainGame.getPlayerRollValue() + ". Your hand value: " + MainGame.getPlayer().getHandValue() +
                    "\n" + "Computer rolled: " +  MainGame.getDealerRollValue() + ". Computers hand value: " + MainGame.getDealer().getHandValue());

            //Hit or hold output string
            System.out.println("Would you like to hit or hold? Please enter 'hit' or 'hold'");
            //Get user input
            userinput = sc.nextLine();
            //If userinput is hit
            if (userinput.equalsIgnoreCase("hit")) {
                //Add dice values to current hand value (true = player)
                MainGame.addValues(true);
                //Checks if dealers hand value is under 16
                if(MainGame.getDealer().canBet()){
                    //Add dice values to current hand value (false = dealer)
                    MainGame.addValues(false);
                }
                //If player's handvalue is more than 21
                if(MainGame.checkPlayerBust()){
                    //Display roll values and current scores of both player and dealer
                    System.out.println("You rolled: " + MainGame.getPlayerRollValue() + ". Your hand value: " + MainGame.getPlayer().getHandValue() +
                            "\n" + "Computer rolled: " +  MainGame.getDealerRollValue() + ". Computers hand value: " + MainGame.getDealer().getHandValue());
                    //Display loss string to user
                    System.out.println(MainGame.DealerWin());
                    //End game
                    end = true;
                //Checks dealer handvalue is more than 21
                } else if(MainGame.checkDealerBust()) {
                    //Display roll values and current scores of both player and dealer
                    System.out.println("You rolled: " + MainGame.getPlayerRollValue() + ". Your hand value: " + MainGame.getPlayer().getHandValue() +
                            "\n" + "Computer rolled: " +  MainGame.getDealerRollValue() + ". Computers hand value: " + MainGame.getDealer().getHandValue());
                    //Display win string to user
                    System.out.println(MainGame.PlayerWin());
                    //End game
                    end = true;
                }
               //Checking if player's handvalue equals 21
               if(MainGame.Hit21() == 1){
                   //Display roll values and current scores of both player and dealer
                   System.out.println("You rolled: " + MainGame.getPlayerRollValue() + ". Your hand value: " + MainGame.getPlayer().getHandValue() +
                           "\n" + "Computer rolled: " +  MainGame.getDealerRollValue() + ". Computers hand value: " + MainGame.getDealer().getHandValue());
                   //Display win string to user
                   System.out.println(MainGame.PlayerWin());
                   //End game
                   end = true;
               }
               //Checking if dealer's handvalue equals 21
                if(MainGame.Hit21() == 0){
                    //Display roll values and current scores of both player and dealer
                    System.out.println("You rolled: " + MainGame.getPlayerRollValue() + ". Your hand value: " + MainGame.getPlayer().getHandValue() +
                            "\n" + "Computer rolled: " +  MainGame.getDealerRollValue() + ". Computers hand value: " + MainGame.getDealer().getHandValue());
                    //Display loss string to user
                    System.out.println(MainGame.DealerWin());
                    //End game
                    end = true;
                }
            //If userinput is hold
            } else if (userinput.equalsIgnoreCase("hold")) {
                //Checks if dealers hand value is under 16
                if(MainGame.getDealer().canBet()){
                    //Add dice values to current hand value (false = dealer)
                    MainGame.addValues(false);
                }
                //If player and dealers score is under 21 while both are holding
                if(!MainGame.checkPlayerBust() && !MainGame.checkDealerBust()) {
                    //If player's score is more than dealer's score
                    if (MainGame.determineWin() == 1) {
                        //Display current scores of both player and dealer
                        System.out.println("Your hand value: " + MainGame.getPlayer().getHandValue() +
                                "\n" + "Computers hand value: " + MainGame.getDealer().getHandValue());
                        //Display win string to user
                        System.out.println(MainGame.PlayerWin());
                        //End game
                        end = true;
                    //If dealer's score is more than player's score
                    } else if (MainGame.determineWin() == 0) {
                        //Display current scores of both player and dealer
                        System.out.println("Your hand value: " + MainGame.getPlayer().getHandValue() +
                                "\n" + "Computers hand value: " + MainGame.getDealer().getHandValue());
                        //Display loss string to user
                        System.out.println(MainGame.DealerWin());
                        //End game
                        end = true;
                    }
                } else {
                    //Checks if dealers score is over 21
                    if(MainGame.checkDealerBust()){
                        //Display win string to user
                        System.out.println(MainGame.PlayerWin());
                        //End game
                        end = true;
                    //Checks if players score is over 21
                    } else if(MainGame.checkPlayerBust()){
                        //Display loss string to user
                        System.out.println(MainGame.DealerWin());
                        //End game
                        end = true;
                    }
                }
            } else {
                //Display to user if something other than hit or hold is entered
                System.out.println("Please only enter 'hit' or 'hold'");
            }
        }
    }
}
