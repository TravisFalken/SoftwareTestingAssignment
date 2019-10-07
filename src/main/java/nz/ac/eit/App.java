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
        Game MainGame = new Game();
        Dealer Computer = new Dealer();
        Die Dice = new Die();
        Scanner sc = new Scanner(System.in);
        String userinput = "";
        boolean end = false;
        //welcomes and creates player
        System.out.println("Welcome to BlackJack! Please enter a username: ");
        userinput = sc.nextLine();
        if(MainGame.createPlayer(userinput)) {
            System.out.println("Player created!");
        }else{
            System.out.println("Error player not created");

        }

        //rolls dice for player and added to hand value
        MainGame.addValues(true);
        //rolls dice for dealer and added to hand value
        MainGame.addValues(false);

        while(end == false){


            System.out.println("Your dice rolled:" + MainGame.getPlayer().getHandValue() + "\n" + "Computer rolled: " +  MainGame.getDealer().getHandValue());



            System.out.println("Would you like to hit or hold? Please enter 'hit' or 'hold'");
            userinput = sc.nextLine();
            if (userinput.equalsIgnoreCase("hit")) {
                MainGame.addValues(true);
                if(MainGame.getDealer().canBet()){
                    MainGame.addValues(false);
                }
                if(MainGame.checkPlayerBust()){
                    System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" +"Computer rolled: " +  MainGame.getDealer().getHandValue());
                    System.out.println(MainGame.DealerWin());
                    end = true;
                } else if(MainGame.checkDealerBust()) {
                    System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" +"Computer rolled: " +  MainGame.getDealer().getHandValue());
                    System.out.println(MainGame.PlayerWin());
                    end = true;
                }
               if(MainGame.Hit21() == 1){
                   System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" +"Computer rolled: " +  MainGame.getDealer().getHandValue());
                   System.out.println(MainGame.PlayerWin());
                   end = true;
               }
                if(MainGame.Hit21() == 0){
                    System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" +"Computer rolled: " +  MainGame.getDealer().getHandValue());
                    System.out.println(MainGame.DealerWin());
                    end = true;
                }


            } else if (userinput.equalsIgnoreCase("hold")) {
                if(MainGame.getDealer().canBet()){
                    MainGame.addValues(false);
                }
                if(!MainGame.checkPlayerBust() && !MainGame.checkDealerBust()) {
                    if (MainGame.determineWin() == 1) {
                        System.out.println(MainGame.PlayerWin());
                        System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" + "Computer rolled: " + MainGame.getDealer().getHandValue());

                        end = true;

                    } else if (MainGame.determineWin() == 0) {
                        System.out.println(MainGame.DealerWin());
                        System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" + "Computer rolled: " + MainGame.getDealer().getHandValue());

                        end = true;
                    }
                } else {
                    if(MainGame.checkDealerBust()){
                        System.out.println(MainGame.PlayerWin());
                        end = true;
                    } else if(MainGame.checkPlayerBust()){
                        System.out.println(MainGame.DealerWin());
                        end = true;
                    }
                }
            } else {
                System.out.println("Please only enter 'hit' or 'hold'");
                end = true;
            }
        }
    }
}
