import java.awt.Color;

import javax.swing.JFrame;
/*******************************************************************************************************
* @ original author LazySloth13                                                                        *                                                                     
* https://codereview.stackexchange.com/questions/27197/pong-game-in-java                               *
*                                                                                                      * 
*******************************************************************************************************/
public class Pong extends JFrame {
    private final static int WIDTH = 1400, HEIGHT = 900;
    private PongPanel panel;

    public Pong() {
        setSize(WIDTH, HEIGHT);
        setTitle("Pong");
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panel = new PongPanel(this);
        add(panel);
    }

    public PongPanel getPanel() {
        return panel;
    }

    public static void main() {
        new Pong();
    }
}