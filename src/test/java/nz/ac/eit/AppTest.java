package nz.ac.eit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private Game game;
    private Player player;
    /**
     * Rigorous Test :-)
     */

    @Before
    public void setup(){
        game = new Game();
        player = new Player("Harry Potter");
        game.setPlayer(player);
    }


    @Test
    public void gameTest__CreatePlayer_True(){
        boolean result = game.createPlayer("Harry Potter");
        assertEquals("Given string is not returning true",true,result);
    }

    @Test
    public void gameTest__CreatePlayer_False(){
        boolean result = game.createPlayer("");
        assertEquals("Empty string is not returning false",false,result);
    }

    @Test
    public void gameTest_CheckPlayerBust_True(){
        game.getPlayer().setHandValue(22);
        boolean result = game.checkPlayerBust();
        assertEquals("PlayerHand is at 22 and is not returning true",true,result);
    }

    @Test
    public void gameTest_CheckPlayerBust_False(){
        game.getPlayer().setHandValue(15);
        boolean result = game.checkPlayerBust();
        assertEquals("PlayerHand is at 15 and is not returning false",false,result);
    }

    @Test
    public void gameTest_CheckDealerBust_True(){
        game.getDealer().setHandValue(22);
        boolean result = game.checkDealerBust();
        assertEquals("DealerHand is at 22 and is not returning true",true,result);
    }

    @Test
    public void gameTest_CheckDealerBust_False(){
        game.getDealer().setHandValue(15);
        boolean result = game.checkDealerBust();
        assertEquals("DealerHand is at 15 and is not returning false",false,result);
    }

    @Test
    public void gameTest_AddValues_Player_HandValueNot0(){
        game.getPlayer().setHandValue(0);
        game.addValues(true);
        int value = game.getPlayer().getHandValue();
        boolean result = false;
        if(value != 0){
            result = true;
        }
        assertTrue("DealerHand has been dealt to but is still 0", result);

    }

    @Test
    public void gameTest_AddValues_Dealer_HandValueNot0(){
        game.getDealer().setHandValue(0);
        game.addValues(false);
        int value = game.getDealer().getHandValue();
        boolean result = false;
        if(value != 0){
            result = true;
        }
        assertTrue("DealerHand has been dealt to but is still 0", result);

    }

    @Test
    public void gameTest_determineWin_PlayerWin_1(){
        game.getPlayer().setHandValue(20);
        game.getDealer().setHandValue(10);
        int result = game.determineWin();
        assertEquals("Player should have won but didnt",1,result);
    }

    @Test
    public void gameTest_determineWin_DealerWin_0(){
        game.getPlayer().setHandValue(10);
        game.getDealer().setHandValue(20);
        int result = game.determineWin();
        assertEquals("Dealer should have won but didnt",0,result);
    }

    @Test
    public void gameTest_determineWin_Tie_0(){
        game.getPlayer().setHandValue(20);
        game.getDealer().setHandValue(20);
        int result = game.determineWin();
        assertEquals("Dealer should have won but didnt",0,result);
    }

    @Test
    public void gameTest_PlayerWin_String(){

        String result = game.PlayerWin();
        assertEquals("Should have returned 'You Win' but didnt","You Win",result);
    }

    @Test
    public void gameTest_DealerWin_String(){

        String result = game.DealerWin();
        assertEquals("Should have returned 'You lose' but didnt","You lose",result);
    }

    @Test
    public void gameTest_Hit21_Player21_1(){
        game.getPlayer().setHandValue(21);
        game.getDealer().setHandValue(10);
        int result = game.Hit21();
        assertEquals("Player has 21 but didnt return 1",1,result);
    }

    @Test
    public void gameTest_Hit21_Dealer21_0(){
        game.getPlayer().setHandValue(10);
        game.getDealer().setHandValue(21);
        int result = game.Hit21();
        assertEquals("Dealer has 21 but didnt return 0",0,result);
    }

    @Test
    public void gameTest_Hit21_Neither21_Negitive1(){
        game.getPlayer().setHandValue(10);
        game.getDealer().setHandValue(10);
        int result = game.Hit21();
        assertEquals("Neither Player or dealer has 21 but didnt return -1",-1,result);
    }
}
