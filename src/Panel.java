import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	final int level3 = 3;
	final int level4 = 4;
	final int level5 = 5;
	int level = level1;
	int bx; // block x
	int by; // block y

	Boolean command = true;
	Boolean start = true;
	Boolean dead = false;
	Boolean finish = false;
	Boolean restart = false;

	public static BufferedImage grid;

	
	  public void paintComponent1(Graphics g) {
		 g.setColor(Color.BLUE);
	  g.fillRect(0, 0, 30, 30); }
	 

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

		b1 = new Blocks(150, 100, 5);
		b2 = new Blocks(300, 460, 5);
		b3 = new Blocks(450, 100, 5);
		b4 = new Blocks(700, 460, 5);
		b5 = new Blocks(850, 100, 5);
	}

	void level2() {
		b1 = new Blocks(150, 120, 5);
		b2 = new Blocks(300, 460, 5);
		b3 = new Blocks(450, 370, 5);
		b4 = new Blocks(700, 220, 5);
		b5 = new Blocks(850, 100, 5);
	}

	void level3() {
		b1 = new Blocks(150, 200, 10);
		b2 = new Blocks(300, 460, 10);
		b3 = new Blocks(450, 370, 10);
		b4 = new Blocks(700, 220, 10);
		b5 = new Blocks(850, 100, 10);
	}

	void level4() {
		b1 = new Blocks(150, 110, 15);
		b2 = new Blocks(300, 460, 15);
		b3 = new Blocks(450, 370, 15);
		b4 = new Blocks(700, 220, 15);
		b5 = new Blocks(850, 170, 15);
	}

	void level5() {
		b1 = new Blocks(150, 210, 15);
		b2 = new Blocks(300, 360, 15);
		b3 = new Blocks(450, 460, 15);
		b4 = new Blocks(700, 320, 15);
		b5 = new Blocks(850, 170, 15);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		System.out.println(start);
		if(p2.Y == 0) {
			p2.Y = by;
		}
		if(p2.Y == 420) {
			p2.Y = by;
		}
		if (start) {
			g.drawImage(grid, 0, 0, 1000, 700, null);
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
		if (dead.FALSE) {
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
		if(command) {
		board.drawStart(g);
		board.currentState = board.GAME_STATE;
		}
		if (finish) {
			board.drawFinish(g);
			board.currentState = board.FINISH_STATE;
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
			dead = true;
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

		if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
			command = false;
			start = true;
			level1();
			}
		
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (level == level1) {
				level2();
				start = true;
				finish = false;
				level = level2;
				p2.X = 10;
				p2.Y = 100;
			} else if (level == level2) {
				level3();
				start = true;
				finish = false;
				level = level3;
				p2.X = 10;
				p2.Y = 100;
			} else if (level == level3) {
				level4();
				start = true;
				finish = false;
				level = level4;
				p2.X = 10;
				p2.Y = 100;
			} else if (level == level4) {
				level5();
				start = true;
				finish = false;
				level = level5;
				p2.X = 10;
				p2.Y = 100;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			level1();
			t1.stop();
			board.setup();
			dead = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("ke");
	}

}
