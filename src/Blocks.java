import java.awt.Color;
import java.awt.Graphics;

public class Blocks {
	int blockx;
	int blocky;
	int speed;

	public Blocks(int x, int y, int s) {
		blockx = x;
		blocky = y;
		speed = s;
	}

	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(blockx, blocky, 30, 30);

		blocky -= speed;
		if (blocky <= 0) {
			speed = -speed;
		}
		if (blocky >= 460) {
			speed = -speed;
		}

	}

}
