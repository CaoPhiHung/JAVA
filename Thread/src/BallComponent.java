import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BallComponent extends JPanel {
	private ArrayList<Ball> 
	balls = new ArrayList<Ball>();
	private BallComponent comp;
	
	
	public BallComponent(){
		setBackground(Color.black);
		setPreferredSize(new Dimension(500, 500));
		addMouseListener(new MouseListener());
//		this.setFocusable(true);
		comp = this;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for (Ball ball : balls) {
			ball.draw(g2);
		}
	}
	
	private class MouseListener extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			Ball ball = new Ball(e.getX(), e.getY(), comp);
			balls.add(ball);
			Thread t = new Thread(ball);
			t.start();
			
		}	
	}
}
