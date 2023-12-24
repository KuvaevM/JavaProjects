import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
	ArrayList<Wall> walls = new ArrayList<>();
	ArrayList<Rabbit> rabbits = new ArrayList<>();
	ArrayList<Drawable> images = new ArrayList<>();
	ArrayList<Hittable> hitobjects = new ArrayList<>();

	Level(String filename) throws IOException {
		Scanner sc = new Scanner(new File(filename));
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = 0; i < a; i++) {
			walls.add(new Wall(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		for (int i = 0; i < b; i++) {
			rabbits.add(new Rabbit(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next()));
		}
		images.addAll(walls);
		images.addAll(rabbits);
		hitobjects.addAll(walls);
		hitobjects.addAll(rabbits);

	}

	public void draw(Graphics2D g2d) {
		for (int i = 0; i < images.size(); i++) {
			images.get(i).draw(g2d);
		}
	}

	public void update() {
		for (int i = 0; i < rabbits.size(); i++) {
			rabbits.get(i).update();
		}
	}

	public void keyReleased(int a) {
		for (int i = 0; i < rabbits.size(); i++) {
			rabbits.get(i).keyReleased(a);
		}
	}

	public void keyPressed(int a) {
		for (int i = 0; i < rabbits.size(); i++) {
			rabbits.get(i).keyPressed(a);
		}
	}

}
