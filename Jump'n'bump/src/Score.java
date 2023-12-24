import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Score implements Drawable {
	public void draw(Graphics2D g2d) {
		Font font = new Font("Plain", Font.PLAIN, 50);
		g2d.setFont(font);
		g2d.setColor(Color.BLUE);
		int distance = Main.coefficientofScore;
		for (int i = 0; i < Main.l.rabbits.size(); i++) {
			g2d.drawString(i+1 +". " + Main.l.rabbits.get(i).score, distance/4, (i+1)*distance);
		}
	}
}
