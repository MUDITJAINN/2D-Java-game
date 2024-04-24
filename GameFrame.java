package com.mjcareers.gaming;

import javax.swing.JFrame; // ctrl + shift + o to import and organise packages

public class GameFrame extends JFrame // using jframe class of java swing
{
	public GameFrame() // it is better to initialize in constructor rather than main
	{
	   Board board = new Board();	// board obj created
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // remove frame from memory after close
 	   setTitle("Game Dev In JAVA");
 	   setSize(1300,700);
 	   setResizable(false); // no need for this key java identifies itself
 	   setLocationRelativeTo(null); // to make frame center
 	   add(board);
 	   setVisible(true);
	}
    public static void main(String args[])
      {
    	   new GameFrame(); // created object default constructor call 
      }
}