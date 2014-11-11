package minitennies;
import java.awt.Rectangle;

import IqbalUtils.Logging;

public class Brick {

	private int x, y, speed;
	private Rectangle rect;
	Main main;

	public Brick(int x, int y, Main main) {
		this.x = x;
		this.y = y;
		speed = 10;
		rect = new Rectangle();
		this.main = main;
	}

	public void moveLeft() {
		if (x <= 0) {
			x = 0;
		} else {
			x += -speed;
		}

		rect.setBounds(x, y, 50, 10);
	}

	public void moveRight() {
		if (x >= 350) {
			x = 350;
		} else {
			x += speed;
		}

		rect.setBounds(x, y, 50, 10);
	}

	public void stop() {
		speed = 0;
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
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
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

	/**
	 * @param speed
	 *            the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
