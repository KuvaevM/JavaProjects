//Куваев Максим(2020а)
//9а класс(Jump-n-Bump)
//180218
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Main {
	static Level l;
	static Score score;
	static Background background;
	public static final double G = 0.3;
	public static final int GlobalWidth = 410;
	public static final int GlobalHeight = 435;
	public static final int periodofTimer = 30;
	public static final int Floor = 368;
	public static final int coefficientofScore = 40;
	public static final int MotionV = 5;
//	public static final int StandingV = 0;
	public static final int leftHit = 1;
	public static final int upHit = 2;
	public static final int rightHit = 3;
	public static final int downHit = 4;
	public static final int R = 20;
	public static Image ImageofWall;
	public static Image ImageofBackground;
	public static final int PlaceofRevival = 300;
	
	static class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			background.draw(g2d);
			l.draw(g2d);
			score.draw(g2d);
//			background.draw(g2d);
			
		}
	}

	public static void main(String[] args) throws IOException {
		l =  new Level("level1.txt");
		score = new Score();
		background = new Background();
		ImageofWall = ImageIO.read(new File("MegaWall.jpg"));
		ImageofBackground = ImageIO.read(new File("Background.jpg"));
//		ImageIO.read(new File("Background.jpg"));
		Scanner sc = new Scanner(new File("Level1.txt"));
		JFrame window = new JFrame("Окно");
		window.setSize(GlobalWidth, GlobalHeight);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		MyPanel p = new MyPanel();
		window.add(p);
		p.setFocusable(true);
		p.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				for (int i = 0;i < l.rabbits.size();i++) {
					l.keyReleased(e.getKeyCode());
					
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0;i < l.rabbits.size();i++) {
					l.keyPressed(e.getKeyCode());
					
				}
			}
		});
		Timer t = new Timer(periodofTimer, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0;i < l.rabbits.size();i++) {
					l.update();
				}
//				score.draw(g2d);
				p.repaint();
//				l.draw(g2d);
			}
		});
		t.start();

	}

}
