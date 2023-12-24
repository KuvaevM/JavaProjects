import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class UI extends JFrame {
	private final static int WINDOWS_WIDTH = 900;
	private final static int WINDOWS_HEIGHT = 600;
	private final static int FIELD_WIDTH = 600;

	private final static int BARS = 40;
	private final static int GOAL_WIDTH = FIELD_WIDTH - 10;
	private final static int GOAL_HEIGHT = 100;
	private final static int KEEPER_HEIGHT = GOAL_HEIGHT - 20;

	private double KOEFF = GOAL_WIDTH / Application.instance.Y;

	private final static double BAR_WIDTH = 1.0 * GOAL_WIDTH / BARS;

	private final static int BARS_START = (FIELD_WIDTH - GOAL_WIDTH) / 2;
	private final static int BARS_START_Y = GOAL_HEIGHT + 10;

	private final static int BALL_START_X = FIELD_WIDTH / 2;
	private int BALL_START_Y;

	private Image goal;
	private Image keeper;
	private Image keeperStay;
	private Image forward;

	private int width = FIELD_WIDTH;

	private int ballTime = -1;
	
	private int convert(double x) {
		return BARS_START + (int) (KOEFF * x);
	}
	
	private int getY(double x, double angle) {
		int dx = convert(x) - convert(Application.instance.Y/2);
		int dx2 = convert(Application.instance.Y / 2
				+ Application.instance.X * Math.sin((angle) / 180.0 * Math.PI)) - convert(Application.instance.Y/2);
		return (int)(1.0 * (BARS_START_Y-BALL_START_Y) * (1.0*dx / dx2));
	}

	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			BALL_START_Y = this.getHeight() - 10;

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

			g.drawImage(goal, 1, 1, this);
			g.drawImage(forward, width / 2 - 33, this.getHeight() - 150, this);

			drawKeeper(g);
			drawForward(g);

			for (int i = 0; i < BARS; i++) {
				g.drawRect((int) (BARS_START + i * BAR_WIDTH), BARS_START_Y, (int) BAR_WIDTH, (int) BAR_WIDTH);
			}
			
			if (ballTime >= 0) {
				int w = (int) BAR_WIDTH;
				int x = convert(Application.instance.Y / 2
						+ Application.instance.U * ballTime * Math.sin((Application.instance.forwardB - Application.instance.alpha / 2.0 + Application.instance.forwardHit) / 180.0 * Math.PI));
				int y = BALL_START_Y + UI.this.getY(Application.instance.Y / 2
						+ Application.instance.U * ballTime * Math.sin((Application.instance.forwardB - Application.instance.alpha / 2.0 + Application.instance.forwardHit) / 180.0 * Math.PI), Application.instance.forwardB - Application.instance.alpha / 2.0 + Application.instance.forwardHit);
				g.drawOval(x-w/2, y-w/2, w, w);
			}
		}

		private void drawForward(Graphics g) {
			if ((Application.instance.state == 1) || (Application.instance.state > 3)) {
				int x = convert(Application.instance.Y / 2
						+ Application.instance.X * Math.sin((Application.instance.forwardB - Application.instance.alpha / 2.0 + Application.instance.forwardHit) / 180.0 * Math.PI));
				int y = BARS_START_Y;
				g.drawLine(BALL_START_X, BALL_START_Y, x, y);
			} else {
				int x = convert(Application.instance.Y / 2
						+ Application.instance.X * Math.sin(Application.instance.forwardB / 180.0 * Math.PI));
				int y = BARS_START_Y;

				int x1 = convert(Application.instance.Y / 2 + Application.instance.X
						* Math.sin((Application.instance.forwardB + Application.instance.alpha / 2.0) / 180 * Math.PI));

				int x2 = convert(Application.instance.Y / 2 + Application.instance.X
						* Math.sin((Application.instance.forwardB - Application.instance.alpha / 2.0) / 180 * Math.PI));

				g.drawLine(BALL_START_X, BALL_START_Y, x, y);
				g.drawLine(BALL_START_X, BALL_START_Y, x1, y);
				g.drawLine(BALL_START_X, BALL_START_Y, x2, y);
			}
		}

		private void drawKeeper(Graphics g) {
			switch (Application.instance.state) {
			case 2:
			case 12:
				g.drawImage(keeper, convert(Application.instance.keeperX), BARS_START_Y - KEEPER_HEIGHT - 2,
						-convert(Application.instance.L), KEEPER_HEIGHT, this);
				break;
			case 3:
			case 13:
				g.drawImage(keeper, convert(Application.instance.keeperX), BARS_START_Y - KEEPER_HEIGHT - 2, this);
				break;
			default:
				g.drawImage(keeperStay, convert(Application.instance.keeperX - Application.instance.l / 2),
						BARS_START_Y - KEEPER_HEIGHT - 2, this);
			}

			int left;
			int right;
			switch (Application.instance.state) {
			case 2:
			case 12:
				left = convert(Application.instance.keeperX - Application.instance.L);
				right = convert(Application.instance.keeperX);
				break;
			case 3:
			case 13:
				left = convert(Application.instance.keeperX);
				right = convert(Application.instance.keeperX + Application.instance.L);
				break;
			default:
				left = convert(Application.instance.keeperX - Application.instance.l / 2);
				right = convert(Application.instance.keeperX + Application.instance.l / 2);
			}

			g.setColor(Color.BLUE);
			g.fillRect(left, BARS_START_Y, right - left, (int) BAR_WIDTH);
			g.setColor(Color.BLACK);
		}

	}

	MyPanel panel = new MyPanel();

	public UI() throws IOException {
		goal = ImageIO.read(new File("goal.bmp")).getSubimage(47, 50, 210, 140);
		goal = goal.getScaledInstance(FIELD_WIDTH - 2, GOAL_HEIGHT, Image.SCALE_DEFAULT);

		keeper = ImageIO.read(new File("keeper.bmp")).getSubimage(0, 0, 170, 91);
		keeper = keeper.getScaledInstance(convert(Application.instance.L), KEEPER_HEIGHT, Image.SCALE_DEFAULT);

		keeperStay = ImageIO.read(new File("keeper_stay.bmp"));
		keeperStay = keeperStay.getScaledInstance(convert(Application.instance.l), KEEPER_HEIGHT, Image.SCALE_DEFAULT);

		forward = ImageIO.read(new File("forward.bmp")).getSubimage(5, 0, 77, 140);

		setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));

		panel.setPreferredSize(new Dimension(width, getHeight() - 50));
		add(panel);

		JLabel text = new JLabel();

		Timer t = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean fTurn = true;
				boolean kTurn = true;

				if ((Application.instance.state == 1) || (Application.instance.state > 3)) {
					fTurn = false;
				}
				if (Application.instance.state > 1) {
					kTurn = false;
				}
				int mf = 0;
				int mk = 0;
				if (fTurn) {
					mf = Application.f.moveForward();
				}
				if (kTurn) {
					mk = Application.k.moveKeeper();
				}

				if (fTurn) {
					if (mf == 1) {
						Application.instance.forwardB += Application.instance.delta;
					}
					if (mf == -1) {
						Application.instance.forwardB -= Application.instance.delta;
					}
					if (mf > 1) {
						int hit = mf - 2;
						hit = Math.max(0, hit);
						hit = Math.min(Application.instance.alpha, hit);
						Application.instance.forwardHit = hit;
						if (Application.instance.state < 2) {
							Application.instance.state = 1;
						} else {
							Application.instance.state += 10;
						}
						ballTime = 0;
					}
				} else {
					ballTime++;
				}
				
				if (kTurn) {
					if (mk == 1) {
						Application.instance.keeperX += Application.instance.v;
						Application.instance.keeperX = Math.min(Application.instance.keeperX, Application.instance.Y);
					}
					if (mk == -1) {
						Application.instance.keeperX -= Application.instance.v;
						Application.instance.keeperX = Math.max(Application.instance.keeperX, 0);
					}
					if (mk == 2) {
						Application.instance.state = 3;
					}
					if (mk == -2) {
						Application.instance.state = 2;
					}
				} else {
					if (Application.instance.state % 10 == 3) {
						if (Application.instance.keeperX + Application.instance.L
								+ Application.instance.V <= Application.instance.Y) {
							Application.instance.keeperX += Application.instance.V;
						}
					}
					if (Application.instance.state % 10 == 2) {
						if (Application.instance.keeperX - Application.instance.L - Application.instance.V >= 0) {
							Application.instance.keeperX -= Application.instance.V;
						}
					}
				}
				
				
				text.setText("<html>Keeper: " + mk + "<br>Forward: " + mf + "</html>");
				
				UI.this.repaint();
			}
		});

		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.start();
			}
		});
		
		
		JPanel tmpPanel = new JPanel();
		tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.Y_AXIS));
		tmpPanel.add(start);
		tmpPanel.add(text);
		
		add(tmpPanel);

		setVisible(true);
	}
}
