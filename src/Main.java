import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Main extends Applet implements Runnable {

	private Image image;
	private Graphics second;
	private Ball ball;

	@Override
	public void init() {

		setSize(400, 400);
		setBackground(Color.WHITE);
		setFocusable(true);

	}

	@Override
	public void start() {
		ball = new Ball(0, 0);
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void paint(Graphics g) {
		g.fillOval(ball.getX(),ball.getY(), 30, 30);
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

}
