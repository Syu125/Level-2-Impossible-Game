import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Player extends Component {
	int X;
	int Y;

	public Player(int x, int y, int width, int length) {
		X = x;
		Y = y;
	}

	void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(X, Y, 30, 30);
		System.out.println(X+" "+Y);
	}

}
