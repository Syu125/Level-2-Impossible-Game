import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends Blocks {
	static int length = 500;
	static int width = 1000;
	JFrame f1;
	Panel p1;

	public static void main(String[] args) {
		Board b = new Board();
		b.setup();

	}

	public Board() {
		f1 = new JFrame();
		p1 = new Panel();
	}

	void setup() {
		f1.setVisible(true);
		f1.setSize(width, length);
		f1.setBackground(Color.WHITE);
		f1.add(p1);
		p1.startGame();
		f1.addKeyListener(p1);
	}

}
