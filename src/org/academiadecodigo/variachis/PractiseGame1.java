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
                if (x <= 5) //this stops the dot from going out of boundaries.
                    x = 5;
                else
                    x -= 5; //gotta go fast? just increase the right numerical value.
            }

            if (keyCode == evt.VK_UP) {
                if (y <= 25)
                    y = 25;
                else
                    y -= 5;
            }

            if (keyCode == evt.VK_RIGHT) {
                if (x >= 280)
                    x = 280;
                else
                    x += 5;
            }

            if (keyCode == evt.VK_DOWN) {
                if (y >= 280)
                    y = 280;
                else
                    y += 5;
            }
        }

        public void keyReleased (KeyEvent evt){


        }
    }

        //////////////

        public PractiseGame1() {

            addKeyListener(new KeyListener()); //addKeyListener is a build-in method that is part of the JFrame.
            //our keyListener will be an instance of the class ActionListener,
            //we created above.
            setTitle("Practise Game 1");
            setSize(300, 300); //size of the window
            setResizable(false); //do we want the window to be resizeable?
            setVisible(true); //set the window to visible
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //without this method we would close the window but the process would continue to run

            x = 150;
            y = 150;
        }

        public void paint(Graphics g) { //double buffering is one of the keys to game making.

            dbImage = createImage(getWidth(), getHeight()); //1st - here we've taken our dbImage and we've created an image of the current screen.
            dbg = dbImage.getGraphics(); //2nd - we've then taken the graphics of that image and stored it in the DoubleBufferGraphics (dbg).
            paintComponent(dbg); //3rd - we paint the graphics to the paintComponent and then we draw the image to the screen
            g.drawImage(dbImage, 0, 0, this);
        }

        public void paintComponent(Graphics g) {

            //g.drawString("Hello World!", 75, 75);
            //g.fillOval(x, y, 15, 15); //arguments are: x position, y position, height, width.
            //when a PractiseGame1 instance is created, the fillOval() method automatically gets
            //the position of x and y, which we just set in the constructor.
            //the reason we used variables is that when we enter key presses,
            //we want the x and y to update, so we can move it, and we can actually start building
            //something that's like a game.
            g.fillOval(x, y, 15, 15);
            repaint();
        }


        ////////////

        public static void main(String[] args) {

            new PractiseGame1();
        }
}

//want to draw lines instead of just moving a dot? easy, just comment out the method "paint" and rename the
//the method "paintComponent" to "paint".