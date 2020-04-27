/*******************************************************************************
*                     Assignment 2 -- Die Class                                *
*                                                                              *
* PROGRAMMER:        Christopher Gaona (gaonachris930@gmail.com)               *
* CLASS:             CS200 -- Object Oriented Programming                      *
* INSTRUCTOR:        Dean Zeller                                               *
* TERM:              Spring 2020                                               *
* SUBMISSION DATE:   01.31.2020                                                *
*                                                                              *
* DESCRIPTION:                                                                 *
* This is an object class called die that will simulate a dice roll.           *
*                                                                              *
* COPYRIGHT:                                                                   *
* This program is copyright (c) 2020 your-name and Dean Zeller.                *
* It is original work without use of outside sources.                          *
*                                                                              *
*******************************************************************************/

import java.lang.Math;

public class Die{
    
    //class attributes
    public int numSides;
    public int currentValue;
    public String dieName;
    
    //primary constructor
    public Die(int initNumSides){
        this.numSides = initNumSides;
        this.dieName = "D"+this.numSides;
    }
    
    //constructor with default value
    public Die(){
        this(6);
    }
    
    /*******************************************************************************
    * Method: getNumSides                                                          *
    * Purpose: Return the number of sides                                          *
    * Parameters: None                                                             *
    * Return Vaue: numSides                                                        *
    *******************************************************************************/
    public int getNumSides(){
        return this.numSides;
    }

    /*******************************************************************************
    * Method: setNumSides                                                          *
    * Purpose: Change the number sides to a parameter given and check that num     *
    *          is greater than or equal to 1                                       *
    * Parameters: numSides_                                                        *
    * Return Vaue: error message                                                   *
    *******************************************************************************/
    public String setNumSides(int numSides_){
        if(numSides_ >= 1){
            this.numSides = numSides_;
            this.dieName = "D"+this.numSides;
            return null;
        }
        else{
            System.out.println("Error: Number must be greater than 0");
            return null;
        }
    }
    
    /*******************************************************************************
    * Method: getCurrentValue                                                      *
    * Purpose: Return the current value of the dies as an integer                  *
    * Parameters: None                                                             *
    * Return Vaue: currentValue                                                    *
    *******************************************************************************/
    public int getCurrentValue(){
        if(this.currentValue > 0){
            return this.currentValue;
        }
        else{
            return this.currentValue = (int)(Math.random()*this.numSides)+1;
        }
    }
    /*******************************************************************************
    * Method: toString                                                             *
    * Purpose: Return the current value of the dies as a string                    *
    * Parameters: None                                                             *
    * Return Vaue: current value                                                   *
    *******************************************************************************/
    public String toString(){
        return String.valueOf(this.currentValue);
    }
    
    /*******************************************************************************
    * Method: generateDieName                                                      *
    * Purpose: Generate and return a single string name for the die                *
    *          (die name created in the primary constructor above)                 *
    * Parameters: None                                                             *
    * Return Vaue: dieName                                                         *
    *******************************************************************************/
    public String generateDieName(){
        return this.dieName;
    }
    
    /*******************************************************************************
    * Method: printSummary                                                         *
    * Purpose: Print summary of die attributes                                     *
    * Parameters: None                                                             *
    * Return Vaue: summary of attributes                                           *
    *******************************************************************************/
    public String printSummary(){
        return("Die Summary:\n"+this.dieName+" ("+this.numSides+"-sided die)\n"+"Range: 1 to "+this.numSides);
    }
    
    /*******************************************************************************
    * Method: roll                                                                 *
    * Purpose: generate a random value between 1 and the number of sides           *
    * Parameters: None                                                             *
    * Return Vaue: None                                                            *
    *******************************************************************************/
    public void roll(){
        this.currentValue = (int)(Math.random()*this.numSides)+1;
    }
    
    /*******************************************************************************
    * Method: setCurrentValue                                                      *
    * Purpose: change the current value to a specific value that is greater        *
    *          than 0 and less than number of sides                                *
    * Parameters: newCurrentValue                                                  *
    * Return Vaue: error message                                                   *
    *******************************************************************************/
    public String setCurrentValue(int newCurrentValue){
        if(newCurrentValue >= 1 && newCurrentValue <= this.numSides){
            this.currentValue = newCurrentValue;
            return null;
        }
        else{
            System.out.println("Error: Number must be greater than 0 and less than "+this.numSides);
            return null;
        }
    }
    
    /*******************************************************************************
    * Method: setCurrentValueOverride                                              *
    * Purpose: change the current value to a specific value that without           *
    *          error checking                                                      *
    * Parameters: newCurrentValue                                                  *
    * Return Vaue: None                                                            *
    *******************************************************************************/
    public void setCurrentValueOverride(int newCurrentValue){
        this.currentValue = newCurrentValue;
    }
}