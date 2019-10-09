package nz.ac.eit;

import java.util.Random;

public class Die {
    private int maxNumber = 6; //The max number the die can roll onto
    private Random randomDieNumber; //The random class for the die

    public Die(){
        randomDieNumber = new Random();
    }

    //Roll the die and return the value of the roll
    public int rollDie(){
        return randomDieNumber.nextInt((maxNumber)) + 1; //Find a random number between (1 - maxNumber)
    }
}


