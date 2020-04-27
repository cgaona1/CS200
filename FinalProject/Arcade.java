/*#########################################################################
#                      Retrograde Arcade Program                          #
#                                                                         #
#   Programmed by Jessie Herold & Christopher Gaona (12-07-2019)          #
#   Class:  CS160                                                         #
#   Semester: Fall 2019                                                   #
#   Instructor:  Dean Zeller                                              #
#   Submission Date:  Saturday, December 7th, 2019                        #
#                                                                         #
#   Description:  This program simulates a retro game playlist            #
#   where a user can choose a game to play from a list of 6 games.        #
#   Single player and multiplayer games are included with 80's music      #
#   Playing in the background.                                            #
#   COPYRIGHT:                                                            #            
#   This program is copyright (c) 2019 Jessie Herold, Christopher Gaona   # 
#   and Dean Zeller                                                       #  
#   This is original work, without the use of outside sources.            #
#                                                                         #
#########################################################################*/

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class Arcade{
    public static int userChoice;
    
    public static void main (String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        int userPlayAgain;
        
        //#### Print out an Introduction to the program ####//
        printWithDelay("\tWelcome To The Arcade Program!\n\n", TimeUnit.MILLISECONDS, 50);
        printWithDelay("-----------------------LOADING PROGRAM---------------------------\n\n", TimeUnit.MILLISECONDS, 20);
        printWithDelay("You will be able to choose from a list of games to play\n\n", TimeUnit.MILLISECONDS, 50);
        
        //#### Print the list of games ####//
        gameListAndUserInput();
        
        while(true){
            //#### Play the game that the user picked ####//
            if(userChoice == 1){
                TicTacToe.main();
                gameSongPlayer(userChoice);
            }
            
            if(userChoice == 2){
                gameSongPlayer(userChoice);
                ConnectFour.main();
            }
            if(userChoice == 3){
                Snake.main();
                gameSongPlayer(userChoice);
            }
            
            if(userChoice == 4){
                Tetris.main();
                gameSongPlayer(userChoice);
            }
            
            if(userChoice == 5){
                Puzzle.main();
                gameSongPlayer(userChoice);
            }
            
            if(userChoice == 6){
                Pong.main();
                gameSongPlayer(userChoice);
            }
            
            //#### Check if the user wants to play again ####//
            printWithDelay("To play again or to play a different game please enter 1, if not enter 2: ", TimeUnit.MILLISECONDS, 50);
            userPlayAgain = sc.nextInt();
            if(userPlayAgain == 2){
                break;
            }
            
            //#### Stop the music once user chooses to play again or exit the program ####//
            musicStuff.stopMusic();
            
            //#### Ask for user input again and print the game list by calling the gameListAndUserInput method####//
            printWithDelay("-----------------------LOADING GAME LIST---------------------------\n\n", TimeUnit.MILLISECONDS, 20);
            gameListAndUserInput();
        }
        
        //#### Print goodbye message once the while is over ####//
        printWithDelay("Thank you for playing!!! Bye.\n", TimeUnit.MILLISECONDS, 50);
        printWithDelay("-----------------------SHUTTING DOWN---------------------------\n\n", TimeUnit.MILLISECONDS, 20);
        System.exit(0);
    }
    
    
    //#### Method for printing out list of games and getting user input ####//
    public static void gameListAndUserInput()throws Exception{
        Scanner sc = new Scanner(System.in);
        
        printWithDelay("Enter 1 if you want to play Tic Tac Toe\n", TimeUnit.MILLISECONDS, 25); 
        printWithDelay("Enter 2 if you want to play Connect Four\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Enter 3 if you want to play Java Snake\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Enter 4 if you want to play Tetris\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Enter 5 if you want to play Puzzle\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("Enter 6 if you want to play Pong\n", TimeUnit.MILLISECONDS, 25);
        printWithDelay("\nEnter your choice here: ", TimeUnit.MILLISECONDS, 50);
        userChoice = sc.nextInt();
        printWithDelay("Have fun and enjoy!\n", TimeUnit.MILLISECONDS, 50);
    }
    
    //#### Method for printing with a delay ####//
    public static void printWithDelay(String data, TimeUnit unit, long delay)throws InterruptedException{
        for(char ch : data.toCharArray()){
            System.out.print(ch);
            unit.sleep(delay);
        }
    }
    
    //#### Method to check which song to play ####//
    public static void gameSongPlayer(int userChoice_)
    {
        int userChoice = userChoice_;
        String filepath = "";
        
        if(userChoice == 1){
            filepath = "/Users/Chris/Downloads/music/Whitney.wav";
        }
        if(userChoice == 2){
            filepath = "/Users/Chris/Downloads/music/Drive.wav";
        }
        if(userChoice == 3){
            filepath = "/Users/Chris/Downloads/music/Prince.wav";
        }
        if(userChoice == 4){
            filepath = "/Users/Chris/Downloads/music/TaintedLove.wav";
        }
        if(userChoice == 5){
            filepath = "/Users/Chris/Downloads/music/UnderPressure.wav";
        }
        if(userChoice == 6){
            filepath = "/Users/Chris/Downloads/music/StayOrGo.wav";
        }
        
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);
    }
}