/*******************************************************************************
*                     Assignment 3 -- YahtzeeHand Class                        *
*                                                                              *
* PROGRAMMER:        Christopher Gaona (gaonachris930@gmail.com)               *
* CLASS:             CS200 -- Object Oriented Programming                      *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   02.14.2020                                                *
*                                                                              *
* DESCRIPTION:                                                                 *
* This is an object class for a solo game of Yahtzee                           *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2020 Christopher Gaona and Dean Zeller.        *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/
import java.util.*;

public class YahtzeeHand{
    //class attributes
    public ArrayList<Die> dice = new ArrayList<Die>();
    public int numSides;
    public int numDice;
    
    //constructors
    public YahtzeeHand(int numDice, int numSides){
        this.numSides = numSides;
        this.numDice = numDice;
        
        for(int i = 0;i < this.numDice; i++){
            Die d = new Die(this.numSides);
            dice.add(d);
        }
    }
    public YahtzeeHand(int numDice){
        this(numDice, 6);
    }
    public YahtzeeHand(){
        this(5, 6);
    }
    
    //methods
    
    /*******************************************************************************
    * Method: rollDice                                                             *
    * Purpose: roll all dice to generate new values                                *
    * Parameters: None                                                             *
    * Return Vaue: None                                                            *
    *******************************************************************************/
    public void rollDice(){
        for(Die i : dice){
            i.roll();
        }
    }
    
    /*******************************************************************************
    * Method: toString                                                             *
    * Purpose: return a string of the values of all the dice                       *
    * Parameters: None                                                             *
    * Return Vaue: string values of all die                                        *
    *******************************************************************************/
    public String toString(){
        String dieValues = "";
        for(Die i : dice){
            dieValues += (i.getCurrentValue()+" ");
        }
        return dieValues;
    }
    
    /*******************************************************************************
    * Method: countDice                                                            *
    * Purpose: return the number of dice matching the parameter                    *
    * Parameters: numDice                                                          *
    * Return Vaue: number of dice matching parameter                               *
    *******************************************************************************/
    public int countDice(int num){
        int numMatch = 0;
        for(Die i : dice){
            if(i.getCurrentValue() == num){
                numMatch++;
            }
        }
        return numMatch;
    }
    
    /*******************************************************************************
    * Method: setDice                                                              *
    * Purpose: Accept an ArrayList of integers as a parameter, setting all dice    *
    * Parameters: ArrayList of integers                                            *
    * Return Vaue: None                                                            *
    *******************************************************************************/
    public void setDice(ArrayList<Integer> nums){
        for(int i = 0; i < dice.size(); i++){
            dice.get(i).setCurrentValue(nums.get(i));
        }
    }
    
    /*******************************************************************************
    * Method: faceValue                                                            *
    * Purpose: return the number of n's in the hand and multiply by n              *
    * Parameters: int n                                                            *
    * Return Vaue: numN                                                            *
    *******************************************************************************/
    public int faceValue(int n){
        int numN = countDice(n) * n;
        return numN;
    }
    
    /*******************************************************************************
    * Method: threeKindValue                                                       *
    * Purpose: check for a three of a kind and return the sum of all die, if no    *
    *          three of a kind then return 0                                       *
    * Parameters: None                                                             *
    * Return Vaue: sum of all die or 0                                             *
    *******************************************************************************/
    public int threeKindValue(){
        int sum = 0;
        int threeKindCheck = 0;
        
        //check for 3 of a kind
        for(Die i : dice){
            if(countDice(i.getCurrentValue()) == 3 && threeKindCheck != i.getCurrentValue()){
                for(Die j : dice){
                    sum += j.getCurrentValue();
                }
                threeKindCheck = i.getCurrentValue();
            }
        }
        return sum;
    }
    
    /*******************************************************************************
    * Method: fourKindValue                                                        *
    * Purpose: check for a four of a kind and return the sum of all die, if no     *
    *          four of a kind then return 0                                        *
    * Parameters: None                                                             *
    * Return Vaue: sum of all die or 0                                             *
    *******************************************************************************/
    public int fourKindValue(){
        int sum = 0;
        int fourKindCheck = 0;
        
        //check for 4 of a kind
        for(Die i : dice){
            if(countDice(i.getCurrentValue()) == 4 && fourKindCheck != i.getCurrentValue()){
                for(Die j : dice){
                    sum += j.getCurrentValue();
                }
                fourKindCheck = i.getCurrentValue();
            }
        }
        return sum;
    }
    
    /*******************************************************************************
    * Method: fullHouseValue                                                       *
    * Purpose: check for a full house and return 25, if no full house then return 0*
    * Parameters: None                                                             *
    * Return Vaue: fullHouse or 0                                                  *
    *******************************************************************************/
    public int fullHouseValue(){
        int flagOfTwo = 0;
        int flagOfThree = 0;
        int fullHouse = 0;
        
        //create dummy array list that is the same as the dice array list
        ArrayList<Die> dummyDice = new ArrayList<Die>(dice);
        
        //check for full house
        for(Die i : dummyDice){
            if(countDice(i.getCurrentValue()) == 3){
                flagOfThree = 1;
                dummyDice.removeAll(Collections.singleton(i.getCurrentValue()));
            }
            if(countDice(i.getCurrentValue()) == 2){
                flagOfTwo = 1;
                dummyDice.removeAll(Collections.singleton(i.getCurrentValue()));
            }
            if(flagOfTwo == 1 && flagOfThree == 1){
                fullHouse = 25;
            }
            
        }
        return fullHouse;
    }

    /*******************************************************************************
    * Method: smallStraightValue                                                   *
    * Purpose: check for a small straight and return 30, otherwise return 0        *
    * Parameters: None                                                             *
    * Return Vaue: 30 or 0                                                         *
    *******************************************************************************/
    public int smallStraightValue(){
        ArrayList<Integer> diceInts = new ArrayList<Integer>();
        int duplicate = 0;
        int flag = 0;
        
        for(Die i : dice){
            if(countDice(i.getCurrentValue()) == 2){
                duplicate = i.getCurrentValue();
            }
            diceInts.add(i.getCurrentValue());
        }
        diceInts.remove(Integer.valueOf(duplicate));
        Collections.sort(diceInts);
        
        if(diceInts.get(0) == (diceInts.get(1)-1)
           && diceInts.get(1) == (diceInts.get(2)-1)
           && diceInts.get(2) == (diceInts.get(3)-1)){
            flag++;
        }
        if(flag == 1){
            return 30;
        }
        else{
            return 0;
        }
    }
    
    /*******************************************************************************
    * Method: largeStraightValue                                                   *
    * Purpose: check for a large straight and return 40, otherwise return 0        *
    * Parameters: None                                                             *
    * Return Vaue: 40 or 0                                                         *
    *******************************************************************************/
    public int largeStraightValue(){
        ArrayList<Integer> diceInts = new ArrayList<Integer>();
        int flag = 0;
        
        for(Die i : dice){
            diceInts.add(i.getCurrentValue());
        }
        Collections.sort(diceInts);
        
        for(int i = 0; i < diceInts.size(); i++){
            if(i < 4 && diceInts.get(i) == (diceInts.get(i+1)-1) ){
                flag++;
            }
            if(i == 4 && (diceInts.get(i)-1) == diceInts.get(i-1)){
                flag++;
            }
        }
        
        if(flag == 5){
            return 40;
        }
        else{
            return 0;
        }
    }

    /*******************************************************************************
    * Method: chanceValue                                                          *
    * Purpose: sum the dice and return the sum                                     *
    * Parameters: None                                                             *
    * Return Vaue: sum of all dice                                                 *
    *******************************************************************************/
    public int chanceValue(){
        int sum = 0;
        
        for(Die i : dice){
            sum += i.getCurrentValue();
        }
        
        return sum;
    }
    
    /*******************************************************************************
    * Method: yahtzeeValue                                                         *
    * Purpose: check for a yahtzee and return 50, otherwise return 0               *
    * Parameters: None                                                             *
    * Return Vaue: 50 or 0                                                         *
    *******************************************************************************/
    public int yahtzeeValue()  
    {
        int sum = 0;
        int fiveKindCheck = 0;
        
        //check for 5 of a kind
        for(Die i : dice){
            if(countDice(i.getCurrentValue()) == 5 && fiveKindCheck != i.getCurrentValue()){
                sum = 50;
                fiveKindCheck = i.getCurrentValue();
            }
        }
        return sum;
    }
    
    /*******************************************************************************
    * Method: reportLine                                                           *
    * Purpose: prints a report for each roll of the dice                           *
    * Parameters: None                                                             *
    * Return Vaue: None                                                            *
    *******************************************************************************/
    public void reportLine(int lineNum){
        System.out.printf("%-3s %s %4d %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d %5d %n%n", (lineNum)+".", toString(), countDice(1), countDice(2)*2,
        countDice(3)*3, countDice(4)*4, countDice(5)*5, countDice(6)*6, threeKindValue(), fourKindValue(),
        fullHouseValue(), smallStraightValue(), largeStraightValue(), yahtzeeValue(), chanceValue());
    }
    
    /*******************************************************************************
    * Method: reportHeader                                                         *
    * Purpose: print the header                                                    *
    * Parameters: None                                                             *
    * Return Vaue: None                                                            *
    *******************************************************************************/
    public void reportHeader(){
        System.out.println("YahtzeeHand Report\n\nCreating 10 manual YahtzeeHand examples\n");
        System.out.printf("%8s %s %n%n", "Dice","        1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch");
        
    }
}