import java.awt.Color;

import javax.swing.JFrame;

public class Board extends Blocks {
	static int length = 500;
	static int width = 1000;
	JFrame f1;
<<<<<<< HEAD
	Panel p1;
=======
	Panel panel1;
>>>>>>> 46e1a7151b1a022c8bc3eac8f923b7c8f7247941

	public static void main(String[] args) {
		Board b = new Board();
		b.setup();

	}

	public Board() {
		f1 = new JFrame();
<<<<<<< HEAD
		p1 = new Panel();
=======
		panel1 = new Panel();
>>>>>>> 46e1a7151b1a022c8bc3eac8f923b7c8f7247941
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
