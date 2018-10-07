import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball implements Runnable {
	
	private int posX;
	private int posY;
	private int diameter = 25;
	private Color color = Color.RED;
	private int xVelocity = 5;
	private int yVelocity = 5;
	private JComponent comp;

	Ball(int posX, int posY, JComponent comp){
		this.posX = posX;
		this.posY = posY;
		this.comp = comp;
	}
	
	public void move(){
		if (this.posX >= (this.comp.getWidth() - this.diameter) || this.posX <= 0) {
			xVelocity *= -1;
		}
		if (this.posY >= (this.comp.getHeight() - this.diameter) || this.posY <= 0) {
			yVelocity *= -1;
		}
		
		this.posX += xVelocity;
		this.posY += yVelocity;
	}
	
	public void draw(Graphics2D g2){
		g2.setColor(this.color);
		Ellipse2D.Double ball = new Ellipse2D.Double(this.posX, this.posY, 
				this.diameter, this.diameter);
		g2.fill(ball);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{  
			   while(!Thread.interrupted()){  
				   move();
				   comp.repaint();
//				   System.out.println(String.format("%s is running",
//	                        Thread.currentThread().getName()));
			       Thread.sleep(60);
//			       System.out.println(String.format("%s is sleep",
//	                        Thread.currentThread().getName()));

			   }  
			}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();
				System.out.println(String.format("execute thread: %s",
                        Thread.currentThread().getName()));
			}
	}
}
