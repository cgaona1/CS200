/*****************************************************************************
  * Author: David Fridovich-Keil
  * Course: ELE 583
  *
  * This file implements an abstraction for the SKETCHPAD canvas. It uses
  * the StdDraw library for all graphics and mouse monitoring, but it also
  * is designed to interact with Button objects and create drop-down menus 
  * (for composite selection).
  ****************************************************************************/
import java.util.*;

public class Canvas {
    
    // store buttons and shapes
    private ArrayList<Button> buttons;
    
    // set up canvas
    public Canvas() {
        this.buttons = new ArrayList<Button>();
        
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0.0, 2.0);
        StdDraw.setYscale(0.0, 1.0);
        
        StdDraw.setPenRadius(0.005);
        this.show();
    }
    
    // add a button
    public Button addButton(double center_x, double center_y, 
                            double half_width, double half_height, String name) {
        Button b = new Button(center_x, center_y, 
                              half_width, half_height, name);
        this.buttons.add(b);
        return b;
    }
    
    // return whichever button is being pressed, or null if
    // no button is currently being pressed
    public Button whichButton() {
        for (Button b : this.buttons) {
            if (b.isPressed())
                return b;
        }
        return null;
    }
    
    // draw current state
    public void show() {
        StdDraw.clear();
        for (Button b : this.buttons)
            b.draw();
        StdDraw.show(5);
    }
}