import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Board {
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
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		f1.setSize(width, length);
		f1.add(p1);
		p1.setVisible(true);
		f1.addKeyListener(p1);
		p1.startGame();
	}
	void drawFinish(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawString("CONGRATULATIONS! YOU COMPLETED THIS LEVEL!", 200, 250);
	}

}
