package nz.ac.eit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DieTest {
    private Die die;

    @Before
    public void setup(){
        die = new Die();
    }

    @Test
    public void dieTest_RollDie_ReturnsNumBetween1And6() {
        boolean result = die.rollDie() >= 1 && die.rollDie() <= 6;
        assertEquals("rollDie result is not between 1-6", true, result);
    }
}
