import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

//import Zhulia.MyPanel;

public class Ball {
	static class MyPanel extends JPanel {
		int a = 90;
		int b = 40;
		int d1 = 5;
		int d2 = 3;
		int k1 = d1;
		int k2 = d2;
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			g2d.drawOval(a, b, 20, 20);

		}
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Окно");
		window.setSize(410, 435);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);

		MyPanel p = new MyPanel();
		window.add(p);

		Timer t = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int y = window.getHeight();
				int x = window.getWidth();
				if (p.a <= 0) {
					p.k1 = Math.abs(p.d1);
				}
				if (p.b <= 0) {
					p.k2 = Math.abs(p.d2);
				}
				if (p.a + 40 >= x) {
					p.k1 = - Math.abs(p.d1);
				}
				if (p.b + 40 >= y - 28) {
					p.k2 = - Math.abs(p.d2);
				}		
				p.a += p.k1;
				p.b += p.k2;
				window.repaint();

			}
		});
		t.start();

	}

}
