/*******************************************************************************
*                     Assignment 7B -- YahtzeeSoloGame Class                   *
*                                                                              *
* PROGRAMMER:        Christopher Gaona (gaonachris930@gmail.com)               *
* CLASS:             CS200 -- Object Oriented Programming                      *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   04.17.2020                                                *
*                                                                              *
* DESCRIPTION:                                                                 *
* This is an object class YahtzeeSoloGame will represent a UI for a solo game  *
* of Yahtzee                                                                   *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2020 your-name and Dean Zeller.                *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
import java.util.*;
import java.io.*;
import sun.audio.*;

public class YahtzeeSoloGame{
    /**************************************************************
    * ATTRIBUTES                                                  *
    **************************************************************/
    private ArrayList<String> acceptableChoices;
    private String choice;
    private Scanner input;
    private YahtzeeScoreCard card;
    
    /**************************************************************
    * CONSTRUCTORS                                                *
    **************************************************************/
    /*******************************************************************************
    * Constructor:                                                                 *
    * Purpose: initialize a YahtzeeScoreCard and Scanner. Then create an arraylist *
    * that contains acceptableChoices                                              *
    *                                                                              * 
    *******************************************************************************/
    public YahtzeeSoloGame(){
        this.card = new YahtzeeScoreCard();
        this.input = new Scanner(System.in);
        this.acceptableChoices = new ArrayList<String>();
        List<String> die = Arrays.asList("1", "2", "3", "4", "5");
        this.acceptableChoices.addAll(die);
        this.choice = "0";
    }
    
    /**************************************************************
    * METHODS                                                     *
    **************************************************************/
    /*******************************************************************************
    * Method: playerThrows                                                         *
    * Purpose: check what die the player wants to reroll and execute that choice   *
    *                                                                              * 
    *******************************************************************************/
    public void playerThrows(){
        int maxThrows = 0;
        boolean d1 = false, d2 = false, d3 = false, d4 = false, d5 = false;
        
        //ask for user input until they press enter or enter the max amount of die throws
        this.choice = input.nextLine();
        if(!this.choice.isEmpty()){
            String[] choice_ = this.choice.split(" ");
            for(String a : choice_){
                if(maxThrows == 5){
                    break;
                }
                if(this.acceptableChoices.contains(a)){
                    if(a.equals("1")){
                        d1 = true;
                    }
                    if(a.equals("2")){
                        d2 = true;
                    }
                    if(a.equals("3")){
                        d3 = true;
                    }
                    if(a.equals("4")){
                        d4 = true;
                    }
                    if(a.equals("5")){
                        d5 = true;
                    }
                }
                maxThrows++;
            }
        }
        //execute the user input
        if(d1 == true || d2 == true || d3 == true || d4 == true || d5 == true){
            this.card.rollDice(d1,d2,d3,d4,d5);
        }
    }
    
    /*******************************************************************************
    * Method: rowChoice                                                            *
    * Purpose: get user input for which row they want to use and execute the choice*
    *                                                                              * 
    *******************************************************************************/
    public void rowChoice(){
        this.choice = input.nextLine();
        if(this.choice.equals("1")){
            this.card.scoreOnes();
            System.out.println("Score of "+this.card.scores.get(0)+" saved in row "+this.choice+" (Ones)");
        }
        if(this.choice.equals("2")){
            this.card.scoreTwos();
            System.out.println("Score of "+this.card.scores.get(1)+" saved in row "+this.choice+" (Twos)");
        }
        if(this.choice.equals("3")){
            this.card.scoreThrees();
            System.out.println("Score of "+this.card.scores.get(2)+" saved in row "+this.choice+" (Threes)");
        }
        if(this.choice.equals("4")){
            this.card.scoreFours();
            System.out.println("Score of "+this.card.scores.get(3)+" saved in row "+this.choice+" (Fours)");
        }
        if(this.choice.equals("5")){
            this.card.scoreFives();
            System.out.println("Score of "+this.card.scores.get(4)+" saved in row "+this.choice+" (Fives)");
        }
        if(this.choice.equals("6")){
            this.card.scoreSixes();
            System.out.println("Score of "+this.card.scores.get(5)+" saved in row "+this.choice+" (Sixes)");
        }
        if(this.choice.equals("7")){
            this.card.scoreThreeKind();
            System.out.println("Score of "+this.card.scores.get(7)+" saved in row "+this.choice+" (3-Kind)");
        }
        if(this.choice.equals("8")){
            this.card.scoreFourKind();
            System.out.println("Score of "+this.card.scores.get(8)+" saved in row "+this.choice+" (4-Kind)");
        }
        if(this.choice.equals("9")){
            this.card.scoreFullHouse();
            System.out.println("Score of "+this.card.scores.get(9)+" saved in row "+this.choice+" (Full House)");
        }
        if(this.choice.equals("10")){
            this.card.scoreSmallStraight();
            System.out.println("Score of "+this.card.scores.get(10)+" saved in row "+this.choice+" (Small Straight)");
        }
        if(this.choice.equals("11")){
            this.card.scoreLargeStraight();
            System.out.println("Score of "+this.card.scores.get(11)+" saved in row "+this.choice+" (Large Straight)");
        }
        if(this.choice.equals("12")){
            this.card.scoreYahtzee();
            System.out.println("Score of "+this.card.scores.get(12)+" saved in row "+this.choice+" (Yahtzee)");
        }
        if(this.choice.equals("13")){
            this.card.scoreChance();
            System.out.println("Score of "+this.card.scores.get(13)+" saved in row "+this.choice+" (Chance)");
        }
    }
    
    /*******************************************************************************
    * Method: throwSheet                                                           *
    * Purpose: print out a sheet that shows the die values and ask the player for  *
    * which die they want to reroll and for what row they want to pick. As well    *
    * play noises when die are rerolled                                            *
    *                                                                              * 
    *******************************************************************************/
    public void throwSheet()throws Exception{
        System.out.println("Dice Throw #1:  "+this.card.hand.toString());
        System.out.print("Dice to throw:  ");
        playerThrows();
        diceNoise();
        System.out.println();
        
        System.out.println("Dice Throw #2:  "+this.card.hand.toString());
        System.out.print("Dice to throw: ");
        playerThrows();
        diceNoise();
        System.out.println();
        
        System.out.println("Dice Throw #3:  "+this.card.hand.toString());
        System.out.println();
        
        System.out.print("Use in row: ");
        rowChoice();
    }
    
    /*******************************************************************************
    * Method: repeatUntilOver                                                      *
    * Purpose: Run the game until player reaches 13 turns and print the final      *
    * scoresheet                                                                   *
    *                                                                              * 
    *******************************************************************************/
    public void repeatUntilOver()throws Exception{
        int turn = 1;
        while(turn != 14){
            diceNoise();
            System.out.println("Turn #"+turn+" of 13\n");
            this.card.displayScoresheet();
            System.out.println();
            throwSheet();
            System.out.println();
            this.card.rollDice();
            turn++;
        }
        
        System.out.println("Final Scoresheet:\n");
        this.card.displayScoresheet();
    }
    
    
    /*******************************************************************************
    * Method: diceNoise                                                            *
    * Purpose: play audio when dice are being rolled                               *
    *                                                                              * 
    *******************************************************************************/
    /**
     * A simple Java sound file example (i.e., Java code to play a sound file).
     * AudioStream and AudioPlayer code comes from a javaworld.com example.
     * @author alvin alexander, devdaily.com.
     */
    public void diceNoise()throws Exception{
        // open the sound file as a Java input stream
        String gongFile = "/Users/Chris/Downloads/drum_roll2.wav";
        InputStream in = new FileInputStream(gongFile);
        
        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);
        
        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
    
//"C:\Users\hero7354\Downloads\Ms_Pacman_Death.wav"
//"C:\Users\jessica.herold\Downloads\Techno.wav"
}