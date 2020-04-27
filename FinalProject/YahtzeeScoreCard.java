/*******************************************************************************
*                     Assignment 7B -- YahtzeeScoreCard Class                  *
*                                                                              *
* PROGRAMMER:        Christopher Gaona (gaonachris930@gmail.com)               *
* CLASS:             CS200 -- Object Oriented Programming                      *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   04.17.2020                                                *
*                                                                              *
* DESCRIPTION:                                                                 *
* This is an object class YahtzeeScoreCard that will keep track of the score   *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2020 your-name and Dean Zeller.                *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
import java.util.*;

public class YahtzeeScoreCard{
    /**************************************************************
    * ATTRIBUTES                                                  *
    **************************************************************/
    public ArrayList<Integer> scores;
    public Integer bonus = 0;
    public YahtzeeHand hand;
    /**************************************************************
    * CONSTRUCTORS                                                *
    **************************************************************/
    /*******************************************************************************
    * Constructor                                                                  *
    * Purpose: store the necessary score attributes into an array and create a     *
    *          YahtzeeHand object                                                  * 
    *******************************************************************************/
    public YahtzeeScoreCard(){
        //store score attributes into an arraylist
        List<Integer> initScoreValues = Arrays.asList(null,    //onesScore
                                                      null,    //twosScore
                                                      null,    //threesScore
                                                      null,    //foursScore
                                                      null,    //fivesScore
                                                      null,    //sixesScore
                                                      0,       //bonusScore
                                                      null,    //threeKindScore
                                                      null,    //fourKindScore
                                                      null,    //fullHouseScore
                                                      null,    //smallStraightScore
                                                      null,    //largeStraightScore
                                                      null,    //yahtzeeScore
                                                      null,    //chanceScore
                                                      0);      //totalScore
        this.scores = new ArrayList<Integer>();
        this.scores.addAll(initScoreValues);
        
        //create a YahtzeeHand
        this.hand = new YahtzeeHand();
    }

    /**************************************************************
    * METHODS                                                     *
    **************************************************************/
    /*******************************************************************************
    * Method: rollDice                                                             *
    * Purpose: roll all the die in the YahtzeeHand object                          *
    *                                                                              * 
    *******************************************************************************/
    public void rollDice(){
        this.hand.rollDice();
    }
    
    /*******************************************************************************
    * Method: rollDice - with 5 boolean parameters                                 *
    * Purpose: roll specific die that the user wants                               *
    *                                                                              * 
    *******************************************************************************/
    public void rollDice(boolean d1, boolean d2, boolean d3, boolean d4, boolean d5){
        if(d1 == true){
            this.hand.dice.get(0).roll();
        }
        if(d2 == true){
            this.hand.dice.get(1).roll();
        }
        if(d3 == true){
            this.hand.dice.get(2).roll();
        }
        if(d4 == true){
            this.hand.dice.get(3).roll();
        }
        if(d5 == true){
            this.hand.dice.get(4).roll();
        }
    }
    
    /*******************************************************************************
    * Methods: scoreOnes - scoreSixes                                              *
    * Purpose: update the appropriate score attributes from the arraylist by       *
    * calling the appropriate methods from the YahtzeeHand class. Then recalculate *
    * the bonus and total score attributes                                         *                                     
    *                                                                              * 
    *******************************************************************************/
    public void scoreOnes(){
        this.scores.set(0,this.hand.faceValue(1));
        this.bonus += this.hand.faceValue(1);
        this.scores.set(14,(this.scores.get(14)+this.hand.faceValue(1)));
    }
    
    public void scoreTwos(){
        this.scores.set(1,this.hand.faceValue(2));
        this.bonus += this.hand.faceValue(2);
        this.scores.set(14,(this.scores.get(14)+this.hand.faceValue(2)));
    }
    
    public void scoreThrees(){
        this.scores.set(2,this.hand.faceValue(3));
        this.bonus += this.hand.faceValue(3);
        this.scores.set(14,(this.scores.get(14)+this.hand.faceValue(3)));
    }
    
    public void scoreFours(){
        this.scores.set(3,this.hand.faceValue(4));
        this.bonus += this.hand.faceValue(4);
        this.scores.set(14,(this.scores.get(14)+this.hand.faceValue(4)));
    }
    
    public void scoreFives(){
        this.scores.set(4,this.hand.faceValue(5));
        this.bonus += this.hand.faceValue(5);
        this.scores.set(14,(this.scores.get(14)+this.hand.faceValue(5)));
    }
    
    public void scoreSixes(){
        this.scores.set(5,this.hand.faceValue(6));
        this.bonus += this.hand.faceValue(6);
        this.scores.set(14,(this.scores.get(14)+this.hand.faceValue(6)));
    }
    
    /*******************************************************************************
    * Methods: scoreThreeKind - scoreChance                                        *
    * Purpose: update the appropriate score attributes from the arraylist by       *
    * calling the appropriate methods from the YahtzeeHand class. Then recalculate *
    * the total score attribute                                                    *
    *                                                                              * 
    *******************************************************************************/
    public void scoreThreeKind(){
        this.scores.set(7,this.hand.threeKindValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.threeKindValue()));
    }
    
    public void scoreFourKind(){
        this.scores.set(8,this.hand.fourKindValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.fourKindValue()));
    }
    
    public void scoreFullHouse(){
        this.scores.set(9,this.hand.fullHouseValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.fullHouseValue()));
    }
    
    public void scoreSmallStraight(){
        this.scores.set(10,this.hand.smallStraightValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.smallStraightValue()));
    }
    
    public void scoreLargeStraight(){
        this.scores.set(11,this.hand.largeStraightValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.largeStraightValue()));
    }
    
    public void scoreYahtzee(){
        this.scores.set(12,this.hand.yahtzeeValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.yahtzeeValue()));
    }
    
    public void scoreChance(){
        this.scores.set(13,this.hand.chanceValue());
        this.scores.set(14,(this.scores.get(14)+this.hand.chanceValue()));
    }
    
    /*******************************************************************************
    * Method: displayScoresheet                                                    *
    * Purpose: neatly printout the scoresheet and check for a bonus                *
    *                                                                              * 
    *******************************************************************************/
    public void displayScoresheet(){
        System.out.println("Current Scoresheet:");
        System.out.printf(" 1. Ones:%16s %n",this.scores.get(0) == null ? "" : this.scores.get(0));
        System.out.printf(" 2. Twos:%16s %n",this.scores.get(1) == null ? "" : this.scores.get(1));
        System.out.printf(" 3. Threes:%14s %n",this.scores.get(2) == null ? "" : this.scores.get(2));
        System.out.printf(" 4. Fours:%15s %n",this.scores.get(3) == null ? "" : this.scores.get(3));
        System.out.printf(" 5. Fives:%15s %n",this.scores.get(4) == null ? "" : this.scores.get(4));
        System.out.printf(" 6. Sixes:%15s %n",this.scores.get(5) == null ? "" : this.scores.get(5));
        System.out.printf("BONUS:%19s %n",this.scores.get(6) == null ? "" : this.scores.get(6));
        System.out.printf(" 7. 3-Kind:%14s %n",this.scores.get(7) == null ? "" : this.scores.get(7));
        System.out.printf(" 8. 4-Kind:%14s %n",this.scores.get(8) == null ? "" : this.scores.get(8));
        System.out.printf(" 9. Full House:%10s %n",this.scores.get(9) == null ? "" : this.scores.get(9));
        System.out.printf("10. Small Straight:%6s %n",this.scores.get(10) == null ? "" : this.scores.get(10));
        System.out.printf("11. Large Straight:%6s %n",this.scores.get(11) == null ? "" : this.scores.get(11));
        System.out.printf("12. Yahtzee:%13s %n",this.scores.get(12) == null ? "" : this.scores.get(12));
        System.out.printf("13. Chance:%14s %n",this.scores.get(13) == null ? "" : this.scores.get(13));
        System.out.printf("TOTAL:%19s %n",this.scores.get(14) == null ? "" : this.scores.get(14));
        
        //check for bonus score
        if(this.bonus >= 63){
            this.scores.set(6, 35);
        }
    }
    
}