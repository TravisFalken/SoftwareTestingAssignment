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
        while(end == false){
           System.out.println("Welcome to BlackJack! Please enter a username: ");
           userinput = sc.nextLine();
           if(MainGame.createPlayer(userinput)) {
                System.out.println("Player created!");
           }else{
               System.out.println("Error player not created");
               end = true;
           }
           Player User = MainGame.getPlayer();






        }
        System.out.println("Would you like to hit or hold? Please enter 'hit' or 'hold'");
        userinput = sc.nextLine();
        if (userinput.equalsIgnoreCase("hit")) {


        } else if (userinput.equalsIgnoreCase("hold")) {
            //determine winner
        }



    }
}
