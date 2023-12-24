import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
public class Combain {
	static double bx;
	static double cx = 1;
	static double x01;
	static double y01;
	static double size = 2;
	static double ac = 1000;
	
	static class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			int y = getHeight();
			int x = getWidth();
			setSize(x, y);
			double k = size;
			double xn = 0;
			double yn = 0;
			double oldy = 0;
			double p = 0;
			double q = 0;
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					for (int s = 0; s < ac; s++) {
						if (s == 0) {
							xn = (double) (x01 - k + 2 * k / x * i);
							yn = (double) (y01 + k - 2 * k / y * j);
							p = xn;
							q = yn;
							// System.out.println((double)(-k + 2 * k / x * i));
						} else {
							oldy = yn;
							yn = 2 * xn * yn + q;
							xn = xn * xn - oldy * oldy + p;

						}
						if (xn * xn + yn * yn >= 4) {
							g2d.setColor(new Color(s % 256, 45 * s % 256, 57));
							g2d.drawLine(i, j, i, j);
							break;
						} else if (s == 999) {
							g2d.setColor(Color.RED);
							g2d.drawLine(i, j, i, j);
						}
					}
				}
			}
		}
	}

	static class MyPanel2 extends JPanel {
		@Override
		protected void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D g2d = (Graphics2D) arg0;
			Scanner sc = new Scanner(System.in);
			int y = getHeight();
			int x = getWidth();
//			double b = sc.nextDouble();
//			double c = sc.nextDouble();
			setSize(x, y);
			double k = size;
			System.out.println(bx);
			Complex z = new Complex();
			Complex z1 = new Complex();
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					for (int s = 0; s < ac; s++) {
						if (s == 0) {
							z.Re = (double) (x01 - k + 2 * k / x * i);
							z.Im = (double) (y01 + k - 2 * k / y * j);
							z1.Re = bx;
							z1.Im = cx;

						} else {
							z = Complex.sum(Complex.mult(z, z), z1);

						}
						if (z.abs(z) >= 2) {
							g2d.setColor(new Color(s % 256, 45 * s % 256, 57));
							g2d.drawLine(i, j, i, j);
							break;
						} else if (s == 999) {
							g2d.setColor(Color.WHITE);
							g2d.drawLine(i, j, i, j);
						}
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JFrame window = new JFrame("Окно");
		window.setSize(410, 435);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setVisible(true);
		JTabbedPane jp = new JTabbedPane();
		JTabbedPane jp2 = new JTabbedPane();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel julia;
		julia = new MyPanel2();
		MyPanel mandelbrot = new MyPanel();
		JRadioButton b1 = new JRadioButton("Мандельброт");
		JRadioButton b2 = new JRadioButton("Жулиа");
		ButtonGroup bg = new ButtonGroup();
		JTextField tf1 = new JTextField("  0   ");
		JTextField tf2 = new JTextField("  1   ");
		JTextField x0 = new JTextField("  0   ");
		JTextField y0 = new JTextField("  0   ");
		JTextField distanse = new JTextField("  2   ");
		JTextField accuracy = new JTextField("  1000   ");
		JLabel l1 = new JLabel("По оси x");
		JLabel l2 = new JLabel("По оси y");
		JLabel l3 = new JLabel("Размер");
		JLabel l4 = new JLabel("Точность");
		JLabel l5 = new JLabel("Таб1 1");
		
		

		JButton repaint = new JButton("Repaint");
		
		bg.add(b2);
		bg.add(b1);
		
		p3.add(l1);
		p3.add(x0);
		p3.add(l2);
		p3.add(y0);
		p3.add(l3);
		p3.add(distanse);
		p3.add(l4);
		p3.add(accuracy);
		
		p4.add(b1);
		p4.add(b2);
		p5.add(tf1);
		p5.add(tf2);
		
		p1.add(p4);
		p1.add(p5);
		p1.add(repaint);
		
		p2.add(mandelbrot);
		p2.add(julia);
		
//		jp.add(l5);
		jp.addTab("Множества", p1);
		
		jp2.add(p3);
		
//		window.add(jp,);
		window.add(jp, BorderLayout.NORTH);
		window.add(jp2, BorderLayout.SOUTH);
		
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p1.setLayout(new BoxLayout(p1, 2));
		p3.setLayout(new FlowLayout());
		p4.setLayout(new GridLayout(2,1));
		p5.setLayout(new GridLayout(2,1));
		
		
		mandelbrot.setVisible(false);
		julia.setVisible(false);
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				julia.setVisible(false);
				tf1.setVisible(false);
				tf2.setVisible(false);
				mandelbrot.setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mandelbrot.setVisible(false);
				tf1.setVisible(true);
				tf2.setVisible(true);
				julia.setVisible(true);

			}
		});
		repaint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str1 = tf1.getText();
				String b = str1.replace(" ", "");
				bx = Double.parseDouble(b);
				
				String str2 = tf2.getText();
				String c = str2.replace(" ", "");
				cx = Double.parseDouble(c);
				
				String x = x0.getText();
				String xx0 = x.replace(" ", "");
				x01 = Double.parseDouble(xx0);
				
				String y = y0.getText();
				String yy0 = y.replace(" ", "");
				y01 = Double.parseDouble(yy0);
				
				String s = distanse.getText();
				String s0 = s.replace(" ", "");
				size = Double.parseDouble(s0);
				
				String a = accuracy.getText();
				String a0 = a.replace(" ", "");
				ac = Double.parseDouble(a0);
				
				window.repaint();
				System.out.println(size);

			}
		});
		window.add(p2, BorderLayout.CENTER);

	}

}

class Complex {
	double Re;
	double Im;

	public static double abs(Complex z1) {
		return Math.sqrt(z1.Re * z1.Re + z1.Im * z1.Im);
	}

	public static Complex mult(Complex z1, Complex z2) {
		Complex complex = new Complex();
		complex.Re = z1.Re * z2.Re - z1.Im * z2.Im;
		complex.Im = z2.Im * z1.Re + z1.Im * z2.Re;
		return complex;
	}

	public static Complex sum(Complex z1, Complex z2) {
		Complex complex = new Complex();
		complex.Re = z1.Re + z2.Re;
		complex.Im = z1.Im + z2.Im;
		return complex;
	}
}
