package org.academiadecodigo.variachis;

import javax.swing.*;
import java.awt.*; ////

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PractiseGame1 extends JFrame {

    private int x;
    private int y; //in this case, we don't initialize x and y here, but in the constructor PractiseGame1.
    private Image dbImage; //db stand for "double buffer".
    private Graphics dbg; //the g here stands for graphics.

    public class KeyListener extends KeyAdapter { //

        public void keyPressed(KeyEvent evt) {

            int keyCode = evt.getKeyCode();

            if (keyCode == evt.VK_LEFT) {
                if (x <= 0) //this stops the dot from going out of boundaries.
                    x = 0;
                else
                    x -= 100; //gotta go fast? just increase the right numerical value.
            }

            /* if (keyCode == evt.VK_UP) { //for now, it works if uncommented.
                if (y <= 0)
                    y = 0;
                else
                    y -= 0;
            } */

            if (keyCode == evt.VK_RIGHT) {
                if (x >=200)
                    x = 200;
                else
                    x += 100;
            }

            /* if (keyCode == evt.VK_DOWN) { //for now, it works if uncommented.
                if (y >= 50)
                    y = 50;
                else
                    y += 0;
            } */

            if (keyCode == evt.VK_SPACE) { //
                //
            }
        }

        public void keyReleased(KeyEvent evt) {


        }
    }

    //////////////

    public PractiseGame1() {

        addKeyListener(new KeyListener()); //addKeyListener is a build-in method that is part of the JFrame.
        //our keyListener will be an instance of the class ActionListener,
        //we created above.
        setTitle("Practise Game 1");
        setSize(301, 123); //size of the window. in this case it really depends on the size we gave our "selection rectangle"
        setResizable(true); //do we want the window to be resizeable?
        setVisible(true); //set the window to visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //without this method we would close the window but the process would continue to run

        x = 0; //here we are initializing x and y in the constructor.
        y = 22; //their value is their default initial location.
        //how to initialize them in the previously selected territory??
    }

    public void paint(Graphics g1) { //double buffering is one of the keys to game making.

        dbImage = createImage(getWidth(), getHeight()); //1st - here we've taken our dbImage and we've created an image of the current screen.
        //getWidth() and getHeight() refer to the width and height of the window.
        dbg = dbImage.getGraphics(); //2nd - we've then taken the graphics of that image and stored it in the DoubleBufferGraphics (dbg).
        paintComponent(dbg); //3rd - we paint the graphics to the paintComponent and then we draw the image to the screen.
        g1.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g1) {

        //g.drawString("Hello World!", 75, 75);
        //g.fillOval(x, y, 15, 15); //arguments are: x position, y position, height, width.
        //when a PractiseGame1 instance is created, the fillOval() method automatically gets
        //the position of x and y, which we just set in the constructor.
        //the reason we used variables is that when we enter key presses,
        //we want the x and y to update, so we can move it, and we can actually start building
        //something that's like a game.
        g1.setColor(Color.RED); //to have the ability of setting a different color we have to first import the SimpleGfx library and build.xml
        g1.drawRect(x, y, 100, 100); //drawRect() draws borders; fillRect() draws borders and paints the inside.
        //note to self: to make the border thicker draw a square inside the bigger square.

        //g2.setColor(Color.BLUE); //
        //g2.drawRect(x, y, 100, 100); //

        repaint();
    }

    ////////////

    public static void main(String[] args) {

        new PractiseGame1();
    }
}

//want to draw lines instead of just moving a dot? easy, just comment out the method "paint" and rename the
//the method "paintComponent" to "paint". this will disable double buffering.