package minitennies;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	private int SPEEDX = 3;
	private int SPEEDY = 3;
	private int RANDOMX = 15;
	private int RANDOMY = 10;

	private int x, y, dx, dy, speedX = SPEEDX, speedY = SPEEDY;
	boolean iscollideX = false;
	boolean iscollideY = false;
	private Random r;
	public Rectangle rect;
	Main main;
	Brick brick;
	public boolean isgameover=false;

	public Ball(int x, int y, Main main, Brick brick) {
		this.x = x;
		this.y = y;
		this.main = main;
		rect = new Rectangle();
		r = new Random();
		this.brick = brick;
	}

	/**
	 * @return the sPEEDX
	 */
	public int getSPEEDX() {
		return SPEEDX;
	}

	/**
	 * @return the sPEEDY
	 */
	public int getSPEEDY() {
		return SPEEDY;
	}

	/**
	 * @param sPEEDX
	 *            the sPEEDX to set
	 */
	public void setSPEEDX(int sPEEDX) {
		SPEEDX = sPEEDX;
	}

	/**
	 * @param sPEEDY
	 *            the sPEEDY to set
	 */
	public void setSPEEDY(int sPEEDY) {
		SPEEDY = sPEEDY;
	}

	public void move() {
		
		x += speedX;
		y += speedY;
		
		if (x < 0) {
			speedX = SPEEDX;
		}

		if (x > main.getSize().width) {
			speedX = -SPEEDX;
		}

		if (y < 0) {
			speedY = SPEEDY;
		}
		if (y > main.getSize().height) {
			speedY = -SPEEDY;
			//isgameover=true;
		}

		detectCollision();

		rect.setBounds(x - 10, y - 10, 20, 20);
	}

	private void detectCollision() {

		if (x >= brick.getX() && x <= brick.getX() + 100) {
			if (y >= brick.getY()-10) {
				speedY = -SPEEDY;
			}
		}
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
