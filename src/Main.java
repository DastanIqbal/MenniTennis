import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends Applet implements Runnable, KeyListener {

	private Image image;
	private Graphics second;
	public Ball ball;
	private Brick brick;

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
	}

	@Override
	public void paint(Graphics g) {
		if (!ball.isgameover) {
			g.setColor(Color.RED);
			g.fillOval(ball.getX(), ball.getY(), 20, 20);
			g.setColor(Color.BLUE);
			g.fillRect(brick.getX(), brick.getY(), 100, 10);
		} else {
			setBackground(Color.BLACK);
			g.setColor(Color.WHITE);
			g.drawString("Game Over", (getWidth()-30) / 2, getHeight() / 2);
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
