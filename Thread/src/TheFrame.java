import javax.swing.JFrame;

public class TheFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Buttons");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new BouncingBallPanel());
		frame.pack();
		frame.setVisible(true);

	}

}
