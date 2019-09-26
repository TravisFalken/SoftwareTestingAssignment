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


        while(end == false){

           //rolls dice for player and added to hand value
           MainGame.addValues(true);
            //rolls dice for dealer and added to hand value
            MainGame.addValues(false);
           System.out.println("Your dice rolled: " + MainGame.getPlayer().handValue + "\n" +"Computer rolled: " +  MainGame.getDealer().getHandValue());






        }





    }
}
