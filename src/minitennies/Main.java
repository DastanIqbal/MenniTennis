package minitennies;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main extends Applet implements Runnable, KeyListener {

	private Image image;
	private Graphics second;
	public Ball ball;
	private Brick brick;
	private URL base;
	ArrayList<Bricks> alist = new ArrayList<Bricks>();
	boolean iswinbn = false;

	@Override
	public void init() {

		setSize(400, 400);
		setBackground(Color.WHITE);
		setFocusable(true);

		addKeyListener(this);

	}

	@Override
	public void start() {
		brick = new Brick(0, 370, this);
		ball = new Ball(0, 0, this, brick);
		Thread t = new Thread(this);
		t.start();

		loadStage("res/maps.txt");
	}

	private void loadStage(String path) {
		ArrayList lines = new ArrayList();
		int width = 0;
		int height = 0;

		try {
			BufferedReader breader = new BufferedReader(new FileReader(path));
			while (true) {
				String line = breader.readLine();
				if (line == null) {
					breader.close();
					break;
				}

				if (!line.startsWith("!")) {
					lines.add(line);
					width = Math.max(width, line.length());
				}
			}

			height = lines.size();
			for (int i = 0; i < height; i++) {
				String line = (String) lines.get(i);
				for (int j = 0; j < width; j++) {
					if (j < line.length()) {
						char ch = line.charAt(j);
						if (Character.getNumericValue(ch) == 8) {
							alist.add(new Bricks(j, i));
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void paintBricks(Graphics g) {
		for (int i = 0; i < alist.size(); i++) {
			Bricks brick = alist.get(i);
			g.setColor(Color.BLACK);
			g.fillRect(brick.getX(), brick.getY(), 22, 10);
		}
	}

	void updateBricks() {
		for (int i = 0; i < alist.size(); i++) {
			Bricks brick = alist.get(i);
			brick.update(ball);
		}
	}

	@Override
	public void paint(Graphics g) {
		if (iswinbn) {
			setBackground(Color.WHITE);
			g.setColor(Color.BLACK);
			g.drawString("You Won", (getWidth() - 30) / 2, getHeight() / 2);
		} else if (!ball.isgameover) {
			g.setColor(Color.RED);
			g.fillOval(ball.getX(), ball.getY(), 15, 15);
			g.setColor(Color.BLUE);
			g.fillRect(brick.getX(), brick.getY(), 100, 10);

			paintBricks(g);

		} else if (ball.isgameover = true) {
			setBackground(Color.BLACK);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", (getWidth() - 30) / 2, getHeight() / 2);
		}
	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, this.getWidth(), this.getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void run() {

		while (true) {
			ball.move();

			for (int i = 0; i < alist.size(); i++) {
				Bricks brick = alist.get(i);
				if (brick.isvisible) {
					brick.update(ball);
				} else {
					alist.remove(i);
					if (alist.size() == 0) {
						iswinbn = true;
					}
				}
			}

			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			brick.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			brick.moveRight();
			break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
