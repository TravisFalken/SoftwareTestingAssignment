package nz.ac.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {
    private Die die;

    @Before
    public void setup(){
        die = new Die();
    }

    @Test
    public void dieTest_RollDie_Does_Not_Return_less_than_1() {
        int value = die.rollDie();
        boolean result = value < 1;
        assertEquals("Die Rolled less than 1 and it should roll between 1 and 6", false,result);
    }

    @Test
    public void dieTest_RollDie_Does_Not_Return_Greater_Than_6(){
        int value = die.rollDie();
        boolean result = value > 6;
        assertEquals("Die rolled more than 6 and it should not", false, result);
    }
}
