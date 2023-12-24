import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

public class Background implements Drawable {
	public void draw(Graphics2D g2d) {
		g2d.drawImage(Main.ImageofBackground, 0, 0, Main.GlobalWidth, Main.GlobalHeight, null);
	}
}
