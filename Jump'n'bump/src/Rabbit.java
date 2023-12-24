import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Rabbit extends Hittable implements Drawable {

	int r = Main.R;
	int left;
	int right;
	int up;
	// double g;
	boolean isPushedUp = false;
	boolean isPushedLeft = false;
	boolean isPushedRight = false;
	boolean isPushedDown = false;
	double vx;
	double vy;
	int score;
	Image image;

	Rabbit(int x1, int y1, int Left1, int Right1, int Up1, String filename) throws IOException {
		width = r;
		height = r;
		x = x1;
		y = y1;
		left = Left1;
		right = Right1;
		up = Up1;
		image = ImageIO.read(new File(filename));

	}

	void update() {
		isPushedUp = false;
		isPushedLeft = false;
		isPushedRight = false;
		isPushedDown = false;
		for (int i = 0; i < Main.l.hitobjects.size(); i++) {
			if (Main.l.hitobjects.get(i) != this) {
				int s = Main.l.hitobjects.get(i).Hittest(y, x, r);
				if (s == Main.leftHit) {
					isPushedRight = true;
				} else if (s == Main.upHit) {
					if (Main.l.hitobjects.get(i).getClass() == Rabbit.class) {
						Main.l.hitobjects.get(i).x = Main.PlaceofRevival;
						Main.l.hitobjects.get(i).y = 0;
						score++;
					} else {
						isPushedDown = true;
					}
				} else if (s == Main.rightHit) {
					isPushedLeft = true;
				} else if (s == Main.downHit) {
					isPushedUp = true;
				}
			}
		}
		vy = vy + Main.G;
		if ((isPushedRight == true) && (vx > 0)) {
			vx = 0;
		} else if ((isPushedLeft == true) && (vx < 0)) {
			vx = 0;
		} else if ((isPushedUp == true) && (vy < 0)) {
			vy = 0;
		} else if ((isPushedDown == true) && (vy > 0)) {
			vy = 0;
		}
		if ((y >= Main.Floor) && (vy > 0)) {
			vy = 0;
		}

		x = (int) (x + vx);
		y = (int) (y + vy);
		if (y > Main.Floor) {
			y = Main.Floor;
		}

	}

	void keyReleased(int a) {
		if (left == a) {
			vx = 0;
		}
		if (right == a) {
			vx = 0;
		}
		if (up == a) {
			vx = 0;
		}
	}

	void keyPressed(int a) {
		if (left == a) {
			vx = -Main.MotionV;
		}
		if (right == a) {
			vx = Main.MotionV;
		}
		if (isPushedDown == true) {
			if (up == a) {
				vy = -Main.MotionV;
			}
		}
	}

	public void draw(Graphics2D g2d) {
		// if (color == 1) {
		// g2d.setColor(Color.RED);
		// }
		// if (color == 2) {
		// g2d.setColor(Color.BLUE);
		// }
		g2d.drawImage(image, x, y, height, width, null);
	}
}
