import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Wall extends Hittable implements Drawable {
	Wall(int x1, int y1, int w, int h) {
		x = x1;
		y = y1;
		width = w;
		height = h;
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(Main.ImageofWall, x, y, x + width, y + height, 0, 0, width, height, null);
	}

}
