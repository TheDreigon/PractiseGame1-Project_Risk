package org.academiadecodigo.variachis;

import javax.swing.*;
import java.awt.*; ////

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PractiseGame1 extends JFrame {

    private int x;
    private int y; //in this case, we don't initialize x and y here, but in the constructor PractiseGame1.

     public class KeyListener extends KeyAdapter { //

        public void keyPressed(KeyEvent evt) {

            int keyCode = evt.getKeyCode();

            if (keyCode == evt.VK_LEFT) {
                x -= 10;
            }

            if (keyCode == evt.VK_UP) {
                y -= 10;
            }

            if (keyCode == evt.VK_RIGHT) {
                x += 10;
            }

            if (keyCode == evt.VK_DOWN) {
                y += 10;
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
        setSize(300, 300); //size of the window
        setResizable(false); //do we want the window to be resizeable?
        setVisible(true); //set the window to visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //without this method we would close the window but the process would continue to run

        x = 150;
        y = 150;
    }

    public void paint(Graphics g) {

        //g.drawString("Hello World!", 75, 75);
        //g.fillOval(x, y, 15, 15); //arguments are: x position, y position, height, width.
                                    //when a PractiseGame1 instance is created, the fillOval() method automatically gets
                                    //the position of x and y, which we just set in the constructor.
                                    //the reason we used variables is that when we enter key presses,
                                    //we want the x and y to update, so we can move it, and we can actually start building
                                    //something that's like a game.
        g.fillRect(x, y, 15, 15);
        repaint();
    }

    ////////////

    public static void main(String[] args) {

        new PractiseGame1();

    }
}