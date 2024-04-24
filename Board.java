package com.mjcareers.gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics; // awt package class
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.mjcareers.gaming.sprites.Enemy;
import com.mjcareers.gaming.sprites.Player;

public class Board extends JPanel
{
   Timer timer;
   BufferedImage backgroundImage; // to store img
   Player player;
   Enemy enemies[] = new Enemy[3];
   public Board() 
   {
	   setSize(1300, 700);
	   loadBackgroundImage();
	   player = new Player();
	   loadEnemies();
	   gameLoop();
	   setFocusable(true); // to get focus on board
	   bindEvents();
	   
   }
   private void gameOver(Graphics pen) 
   {
	   if(player.outOfScreen()) 
	   {
				   pen.setFont(new Font("times",Font.BOLD,30));
				   pen.setColor(Color.RED);
				   pen.drawString("Game WIN", 1300/2, 700/2);
				   timer.stop();
				   return;
       }
	   for(Enemy enemy : enemies) 
	   {
		   if(isCollide(enemy)) 
		   {
			   pen.setFont(new Font("times",Font.BOLD,30));
			   pen.setColor(Color.RED);
			   pen.drawString("Game over", 1300/2, 700/2);
			   timer.stop();
		   }
	    }
   }
   private boolean isCollide(Enemy enemy) 
   {
	  int xDistance = Math.abs(player.x - enemy.x);
	  int yDistance = Math.abs(player.y - enemy.y);
	  int maxH = Math.max(player.h, enemy.h);
	  int maxW = Math.max(player.w, enemy.w);
	   return xDistance <= maxW-80 && yDistance <= maxH-80;
   }
   private void bindEvents() {
	   addKeyListener(new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) { // on right arrow key press only move
			player.speed = 20;
			// TODO Auto-generated method stub
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
		     player.speed = -20;		
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.speed = 0;
			// TODO Auto-generated method stub
			
		}
		   
	   }
	);
   }
   
   private void loadEnemies()
   {
	   int x = 300;
	   int speed = 5;
	   int gap = 300;
	   for(int i = 0;i<enemies.length;i++)
	   {
		   enemies[i] = new Enemy(x, speed);
		   x = x + gap;
		   speed = speed + 5;
	   }
   }
   
   private void gameLoop()
   {
	   timer = new Timer(50,(e)->repaint()); // timer using the thread concept 
	   timer.start();
	   
   }
   
   private void loadBackgroundImage() {
	   try {
		backgroundImage=ImageIO.read(Board.class.getResource("game-bg.jpeg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("background Image Not Found.....");
		System.exit(1); // to stop the operation   exit 0 means no problem , exit 1 there exist some problem 
		e.printStackTrace();
	}
   }
   
   private void printEnemies(Graphics pen)
   {
	   for(Enemy enemy : enemies) 
	   {
		  enemy.draw(pen); 
		  enemy.move();
	   }
   }
   // paintcomponent overridden
   @Override
   public void paintComponent(Graphics pen) // reference variable pen of graphics , after constructer all this is created
   {
	   // all printing logic will be here
	   super.paintComponent(pen); // clean up canvas
	   pen.drawImage(backgroundImage,0,0,1500, 920,null);// left corner to right corner , image observer null as not needed
	   player.draw(pen);
	   player.move();
	   printEnemies(pen);
	   gameOver(pen);
   }
}