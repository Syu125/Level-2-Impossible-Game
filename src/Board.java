import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Board {
	static int length = 500;
	static int width = 1000;
	JFrame f1;
	Panel p1;
	Font start = new Font("Impact", Font.PLAIN, 80);
	Font end = new Font("Impact", Font.PLAIN, 50);
	Font finish = new Font("Impact", Font.PLAIN, 30);
	Font restart = new Font("Impact", Font.PLAIN, 20);

	final int START_STATE = -1;
	final int GAME_STATE = 0;
	final int FINISH_STATE = 1;
	final int END_STATE = 2;
	int currentState = START_STATE;

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
	
	void drawStart(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, length);
		g.setColor(Color.WHITE);
		g.setFont(start);
		g.drawString("THE IMPOSSIBLE", 220, 200);
		g.setFont(restart);
		g.drawString("Press SHIFT to continue on to the next phase!", 295, 400);
		g.drawString("RULES: Use the arrow keys to control your player", 280, 240);
	}

	void drawFinish(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, width, length);
		g.setColor(Color.BLACK);
		g.setFont(finish);
		g.drawString("CONGRATULATIONS! YOU COMPLETED THIS LEVEL!", 220, 250);
		g.drawString("Press ENTER to continue one to the next phase!", 220, 300);
	}

	void drawDie(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, width, length);
		g.setColor(Color.BLACK);
		g.setFont(end);
		g.drawString("GAME OVER", 360, 200);
		g.setFont(restart);
		g.drawString("press R to restart", 400, 250);
	}
}
