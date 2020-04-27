public class ArcadeMk2{
    //attributes
    private static final int delayMillis = 100;
    
    //draw the canvas and run the Arcade
    public static void main(String[] args) throws Exception{
        
        //set up canvas with buttons
        Canvas canvas = new Canvas();
        
        Button btnTicTacToe = canvas.addButton(0.6,0.7,0.15,0.03,"Tic Tac Toe");
        
        Button btnConnectFour = canvas.addButton(1.3,0.7,0.15,0.03,"Connect Four");
        
        Button btnSnake = canvas.addButton(0.6,0.6,0.15,0.03,"Java Snake");
        
        Button btnTetris = canvas.addButton(1.3,0.6,0.15,0.03,"Tetris");
        
        Button btnPuzzle = canvas.addButton(0.6,0.5,0.15,0.03,"Puzzle");
        
        Button btnPong = canvas.addButton(1.3,0.5,0.15,0.03,"Pong");
        
        Button btnFrogger = canvas.addButton(0.6,0.4,0.15,0.03,"Frogger");
        
        Button btnYahtzee = canvas.addButton(1.3,0.4,0.15,0.03,"Yahtzee");
        
        canvas.show();
        while(true){
            waitForMouse();
            
            //if the mouse is pressed determine which game to play
            Button state = canvas.whichButton();
            
            //hightlight button
            state.highlight();
            canvas.show();
            
            if(state == btnTicTacToe){
                TicTacToe.main();
                song("/Users/Chris/Downloads/music/Whitney.wav");
            }
            if(state == btnConnectFour){
                song("/Users/Chris/Downloads/music/Drive.wav");
                ConnectFour.main();
            }
            if(state == btnSnake){
                Snake.main();
                song("/Users/Chris/Downloads/music/Prince.wav");
            }
            if(state == btnTetris){
                Tetris.main();
                song("/Users/Chris/Downloads/music/TaintedLove.wav");
            }
            if(state == btnPuzzle){
                Puzzle.main();
                song("/Users/Chris/Downloads/music/UnderPressure.wav");
            }
            if(state == btnPong){
                Pong.main();
                song("/Users/Chris/Downloads/music/StayOrGo.wav");
            } 
            if(state == btnFrogger){
                Frogger.main();
            }
            if(state == btnYahtzee){
                YahtzeeSoloGame game = new YahtzeeSoloGame();
                game.repeatUntilOver();
            }
            
            //update the canvas
            state.unhighlight();
            canvas.show();
            musicStuff.stopMusic();
        }
    }
    
    //helper method: wait for mouse click
    private static void waitForMouse(){
        try {
            while (true) {
                Thread.sleep(delayMillis);
                if (StdDraw.mousePressed()) {
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred while waiting for mouse: " + 
                               e.getMessage());
        }
    }
    
    //method to play song
    private static void song(String filepath_){
        musicStuff music = new musicStuff();
        music.playMusic(filepath_);
    }
}