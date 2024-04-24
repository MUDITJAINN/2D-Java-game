package com.mjcareers.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite
{
  public Player() { // public as it is available outside package
	  w=200;
	  h=200;
	  x=50;
	  y=300;
	  image = new ImageIcon(Player.class.getResource("Player.gif"));
  }
  public void move() 
  {
	  x=x+speed;
  }
  
  public boolean outOfScreen() {
	  return x>1100; 
  }
}
