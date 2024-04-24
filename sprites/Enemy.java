package com.mjcareers.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

    public class Enemy extends Sprite 
    {	
	  public Enemy(int x,int speed) 
	  {                 // public as it is available outside package
	  w=50;
	  h=200;
	  this.x=x;  // this.x which comes from parent
	  this.speed = speed;
	  y=30;
	  image = new ImageIcon(Enemy.class.getResource("spider.gif"));
     }
	  public void move() 
	  {
		  if(y>900)
		  {
			y=0;  
		  }
		  y=y+speed;
	  }
}	  