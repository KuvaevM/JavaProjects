
//Куваев Максим(2020а)
//9а класс(мандельброт)
//180218
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Zuma {
	static int last = 0;
//	static int LastyB;
	
	static int counter;

	static int xb = 810;
	static int yb = 60;

	static Image goal;
	static Image frog;

	static int T = 0;

	static int x;
	static int y;

	static int x2;
	static int y2;

	// static int xBall;
	// static int yBall;

	static int r = 50;
	static int zx;
	static int zy;

	static int vb = 5;
	static int S;
	static int dt;

	static int dx;
	static int dy;
	
	static int arrsize;

	static boolean MoveBall = false;

	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static ArrayList<Integer> brr = new ArrayList<Integer>();
	static ArrayList<BallCanon> drr = new ArrayList<BallCanon>();
	static ArrayList<Ball> array = new ArrayList<Ball>();
	// static Ball array[] = new Ball[20];
	static ArrayList<Number> crr = new ArrayList<Number>();

	static class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			y2 = getHeight();
			x2 = getWidth();
			g2d.drawImage(goal, 0, 0, this);
			g2d.drawImage(frog, 145, 300, this);

			Random r = new Random();
			// for (int i = 0; i < drr.size();i++) {
			// drr.get(i).color = r.nextInt(4) + 1;
			// }
			for (int i = 0; i < drr.size(); i++) {
//				if (drr.get(i).color == 1) {
//					g2d.setColor(Color.GREEN);
//				} else if (drr.get(i).color == 2) {
//					g2d.setColor(Color.RED);
//				} else if (drr.get(i).color == 3) {
//					g2d.setColor(Color.BLUE);
//				} else if (drr.get(i).color == 4) {
//					g2d.setColor(Color.BLACK);
//				}
				g2d.setColor(Color.BLUE);
				g2d.fillOval(drr.get(i).xB, drr.get(i).yB, 20, 20);
			}
			for (int i = 0; i < array.size(); i++) {
				if (array.get(i).color == 1) {
					g2d.setColor(Color.GREEN);
				} else if (array.get(i).color == 2) {
					g2d.setColor(Color.RED);
				} else if (array.get(i).color == 3) {
					g2d.setColor(Color.BLUE);
				} else if (array.get(i).color == 4) {
					g2d.setColor(Color.BLACK);
				}
				g2d.fillOval(array.get(i).xB, array.get(i).yB, 20, 20);
			}
			// setSize(x, y);
			// g2d.drawLine(x2 / 2, y2, x2 / 2 + (int) ((x - x2 / 2) * r / k), y - (int) ((y
			// - y2) * r / k));

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		JFrame window = new JFrame("Окно");
		window.setSize(410, 435);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		MyPanel p = new MyPanel();
		window.add(p);

		// goal = ImageIO.read(new File("zum.jpg")).getSubimage(40, 50, 390, 390);
		frog = ImageIO.read(new File("Frog.bmp")).getSubimage(10, 10, 97, 100);

		Random r = new Random();
		// for (int i = 0; i < 20; i++) {
		// array. = new Ball();
		// }

		for (int i = 0; i < 20; i++) {
			array.add(new Ball());
			// array.add(i).color = r.nextInt(4) + 1;
		}
		for (int i = 0; i < 20; i++) {
			array.get(i).color = r.nextInt(4) + 1;
		}

		for (int i = 0; i < 20; i++) {
			crr.add(new Number());
			// array.add(i).color = r.nextInt(4) + 1;
		}
		
		while (true) {
			if ((yb == 60) && (xb > 40)) {
				arr.add(xb);
				brr.add(yb);
				xb--;
			} else if ((xb <= 41) && (yb < 100)) {
				arr.add(xb);
				brr.add(yb);
				yb++;
			} else if ((yb == 100) && (xb < 320)) {
				arr.add(xb);
				brr.add(yb);
				xb++;
			} else if ((xb == 320) && (yb < 250)) {
				arr.add(xb);
				brr.add(yb);
				yb++;
//				System.out.println(xb);
//				System.out.println(yb);
			} else if ((yb == 250) && (xb > 40)) {
				arr.add(xb);
				brr.add(yb);
				xb = xb - 1;
//				System.out.println(xb);
			} else if ((yb > 200) && (xb == 40)) {
				arr.add(xb);
				brr.add(yb);
				yb = yb - 1;
//				System.out.println(xb);
			} else {
				break;
			}
		}

		p.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				x = arg0.getX();
				y = arg0.getY();
				S = (int) Math.sqrt((x - x2 / 2) * (x - x2 / 2) + (y - y2) * (y - y2));
				dt = S / vb;
				dx = x - x2 / 2;
				dy = y - y2;

				drr.add(new BallCanon(x2 / 2 - 20, y2 - 20, dx / dt, dy / dt));
				MoveBall = true;

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Timer t = new Timer(10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(array.size());
//				System.out.println(last);
				for (int i = 0; i < array.size(); i++) {
					if (T == 0) {
						array.get(i).xB = arr.get(T + (20 - i) * 20);
						array.get(i).yB = brr.get(T + (20 - i) * 20);
						crr.get(i).N = T + (20 - i) * 20;
					} else {
						array.get(i).xB = arr.get(crr.get(i).N);
						array.get(i).yB = brr.get(crr.get(i).N);
						
						crr.get(i).N ++;
					}
					
					if (i == 19) {
//						array.get(i).xB = arr.get(crr.get(i).N);
//						array.get(i).yB = brr.get(crr.get(i).N);
						last = crr.get(i).N;
						System.out.println(last+" a");
					}

				}
				Random h = new Random();
				arrsize = array.size();
				
				
				for (int i = 0; i < drr.size(); i++) {
					for (int j = 0; j < array.size(); j++) {
						if (Math.sqrt((drr.get(i).xB - array.get(j).xB) * (drr.get(i).xB - array.get(j).xB)
								+ (drr.get(i).yB - array.get(j).yB) * (drr.get(i).yB - array.get(j).yB)) <= 10) {
							System.out.println(last);
							array.add(new Ball());
							drr.remove(i);
							
							crr.add(new Number());
							crr.get(i).N = last - 20;
							
							array.get(arrsize).xB = 1;
							array.get(arrsize).yB = 1;
							
							counter++;
							break;
						}
					}
					if (counter == 0) {
						drr.get(i).color = r.nextInt(4) + 1;
						drr.get(i).xB = drr.get(i).xB + drr.get(i).vBallx;
						drr.get(i).yB = drr.get(i).yB + drr.get(i).vBally;
					}
					counter = 0;

				}

				T += 1;
				window.repaint();
			}

		});
		t.start();
	}
}

class Ball {
	int color;
	int xB;
	int yB;
	// Ball(int a, int b){
	// xB = a;
	// yB = b;
	//
	//
	// }

}

class BallCanon {
	int vBallx;
	int vBally;
	int color;
	int xB;
	int yB;

	BallCanon(int a, int b, int c, int d) {
		xB = a;
		yB = b;

		vBallx = c;
		vBally = d;

	}

}
class Number{
	int N;
}
