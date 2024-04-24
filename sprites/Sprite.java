package com.mjcareers.gaming.sprites;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Sprite { // this class is for refactoring of code to use common code by inheritance , abstract as it is a generic class with no object
	  public int speed;
	  public int x;
	  public int y;  // use public or make setter getter
	  public int w;
	  public int h;
	  ImageIcon image;
	  
	  public void draw(Graphics pen)
	  {
		  pen.drawImage(image.getImage(),x,y,w,h,null); // image upcasted to parent Image , also converting it from imageicon to image
	  }
}
