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
	int bx; // block x
	int by; // block y
	int mm; // mm=movement

	/*
	 * public void paintComponent(Graphics g) { g.setColor(Color.BLUE);
	 * g.fillRect(0, 0, 30, 30); }
	 */

	public Panel() {
		bx = 10;
		by = 100;
		t1 = new Timer(1000 / 100, this);
		p2 = new Player(bx, by, 30, 30);
		mm = 5;
		p2.repaint();
	}

	void startGame() {
		t1.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		p2.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("hi");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			by -= mm;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

		}
		System.out.println("kt");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("kp");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ke");
	}

}
