/**
 * Created by PJWS on 14/03/2016.
 */

import java.util.Random;

public class Raffle {
    //Array size equals the approximate size of Free Company / Guild
    String[] raffleArray = new String[35];
    int count = 0;

    //Enter participant's name into the array and increment count
    public void enter(String name){
        raffleArray[count] = name;
        count += 1;
    }

    //Reset the array to initial empty state
    public void reset(){
        raffleArray = new String[35];
        count = 0;
    }

    //Generate a random number between 0 and count-1
    //Use the random number to return the name of the winner
    public String drawWinner(){
        String errMsg = "There are no entrants to draw from!";

        //If the array is empty, warn the user
        if (count == 0){
            return errMsg;
        }

        //Generate random number
        Random rn = new Random();
        int winNum = rn.nextInt(count);
        String winMsg = "The Winner is " + raffleArray[winNum] + "!";

        return winMsg;
    }

    //List current entrants
    public String listEntrants(){
        String entrantList = "";

        //Iterate through array and add participants' name and a new line
        for (int i = 0; i < count; i++){
            entrantList = entrantList + raffleArray[i] + System.lineSeparator();
        }

        //Additionally report how many users have been entered into the raffle
        entrantList = entrantList + System.lineSeparator() + "This raffle has " + count + " entrant(s).";
        return entrantList;
    }
}

