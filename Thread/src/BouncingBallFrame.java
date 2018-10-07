import javax.swing.JFrame;

public class BouncingBallFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Bouncing Ball Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new BallComponent());
		frame.pack();
		frame.setVisible(true);

	}

}
