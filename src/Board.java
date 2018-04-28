import java.awt.Color;

import javax.swing.JFrame;

public class Board extends Blocks {
	static int length = 500;
	static int width = 1000;
	JFrame f1;
	Panel panel1;

	public static void main(String[] args) {
		Board b = new Board();
		b.setup();

	}

	public Board() {
		f1 = new JFrame();
		panel1 = new Panel();
	}

	void setup() {
		f1.setVisible(true);
		f1.setSize(width, length);
		f1.setBackground(Color.WHITE);
		f1.add(panel1);
		panel1.startGame();
		f1.addKeyListener(panel1);
	}

}
