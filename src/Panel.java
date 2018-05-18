import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener {

	Timer t1;
	Player p2;
	Blocks b1;
	Blocks b2;
	Blocks b3;
	Blocks b4;
	Blocks b5;
	Board board;
	final int level1 = 1;
	final int level2 = 2;
	int level = level1;
	int bx; // block x
	int by; // block y
	Boolean start = true;
	Boolean dead = false;
	Boolean finish = false;

	/*
	 * public void paintComponent(Graphics g) { g.setColor(Color.BLUE);
	 * g.fillRect(0, 0, 30, 30); }
	 */

	public Panel(Board b) {
		bx = 50;
		by = 100;
		t1 = new Timer(1000 / 100, this);
		p2 = new Player(bx, by, 30, 30);
		board = b;
		level1();
	}

	void startGame() {
		t1.start();

	}

	void level1() {
		b1 = new Blocks(150, 100);
		b2 = new Blocks(300, 460);
		b3 = new Blocks(450, 100);
		b4 = new Blocks(700, 460);
		b5 = new Blocks(850, 100);
	}

	void level2() {
		b1 = new Blocks(150, 120);
		b2 = new Blocks(300, 460);
		b3 = new Blocks(450, 370);
		b4 = new Blocks(700, 220);
		b5 = new Blocks(850, 100);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if (start) {
			g.setColor(Color.GREEN);
			g.fillRect(100, 0, 20, 500);
			g.setColor(Color.GREEN);
			g.fillRect(910, 0, 20, 500);
			p2.draw(g);
			b1.draw(g);
			b2.draw(g);
			b3.draw(g);
			b4.draw(g);
			b5.draw(g);
		}
		if (p2.X >= 940) {
			board.currentState = board.FINISH_STATE;
			finish = true;
			start = false;
		}
		if (finish) {
			board.drawFinish(g);
			board.currentState = board.GAME_STATE;
		}
		if (p2.X >= b1.blockx - 20 && p2.X <= b1.blockx + 20 && p2.Y >= b1.blocky - 20 && p2.Y <= b1.blocky + 20) {
			board.currentState = board.END_STATE;
			dead = true;
		}
		if (p2.X >= b2.blockx - 20 && p2.X <= b2.blockx + 20 && p2.Y >= b2.blocky - 20 && p2.Y <= b2.blocky + 20) {
			board.currentState = board.END_STATE;
			dead = true;
		}
		if (p2.X >= b3.blockx - 20 && p2.X <= b3.blockx + 20 && p2.Y >= b3.blocky - 20 && p2.Y <= b3.blocky + 20) {
			board.currentState = board.END_STATE;
			dead = true;
		}
		if (p2.X >= b4.blockx - 20 && p2.X <= b4.blockx + 20 && p2.Y >= b4.blocky - 20 && p2.Y <= b4.blocky + 20) {
			board.currentState = board.END_STATE;
			dead = true;
		}
		if (p2.X >= b5.blockx - 20 && p2.X <= b5.blockx + 20 && p2.Y >= b5.blocky - 20 && p2.Y <= b5.blocky + 20) {
			board.currentState = board.END_STATE;
			dead = true;
		}
		if (dead) {
			board.drawDie(g);
			start = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			p2.Y -= 10;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p2.Y += 10;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p2.X -= 10;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p2.X += 10;

		}
		if (e.getKeyCode() == KeyEvent.VK_N) {
			System.out.println("next");
			if (level == level1) {
				level2();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			level1();
			board.currentState = board.GAME_STATE;
			start = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("ke");
	}

}
