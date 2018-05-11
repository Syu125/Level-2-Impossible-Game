import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Board {
	static int length = 500;
	static int width = 1000;
	JFrame f1;
	Panel p1;

	final int GAME_STATE = 0;
	final int FINISH_STATE = 1;
	final int END_STATE = 2;
	int currentState = GAME_STATE;

	public static void main(String[] args) {
		Board b = new Board();
		b.setup();
	}

	public Board() {
	}

	void setup() {
		f1 = new JFrame();
		p1 = new Panel(this);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		f1.setSize(width, length);
		f1.add(p1);
		p1.setVisible(true);
		f1.addKeyListener(p1);
		p1.startGame();

	}

	void drawFinish(Graphics g) {
		p1.setVisible(false);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, length);
		g.drawString("CONGRATULATIONS! YOU COMPLETED THIS LEVEL!", 200, 250);
	}

	void drawDie(Graphics g) {
		g.setColor(Color.RED);
		g.drawString("GAME OVER", 400, 200);
	}
}
