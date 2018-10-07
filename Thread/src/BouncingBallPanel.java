import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.*;

import javax.swing.JPanel;

public class BouncingBallPanel extends JPanel {
	private Point location;
	private Timer t;
	private int xDirection = 10, yDirection = 5;

	public BouncingBallPanel() {
		Random gen = new Random();
		location = new Point(gen.nextInt(380), gen.nextInt(380));
		t = new Timer(50, new TimerListener());
		t.start();
		setBackground(Color.black);
		setPreferredSize(new Dimension(400, 400));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.magenta);
		Ellipse2D.Double ball = new Ellipse2D.Double(location.x, location.y, 20, 20);
		g2.fill(ball);
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (location.getX() >= 380 || location.getX() <= 0) {
				xDirection *= -1;
			}
			if (location.getY() >= 380 || location.getY() <= 0) {
				yDirection *= -1;
			}
			location.x+= xDirection;
			location.y+= yDirection;
			repaint();
		}
	}
}
