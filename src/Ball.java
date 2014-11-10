public class Ball {

	private int x, y, speed = 2;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move() {
		if (x >= 0 && x<370) {
			x += speed;
		}
		
		if (y >= 0 && y<370) {
			y += speed;
		}

		// if (x >= 0 && x <= 380) {
		// x -= speed;
		// }
		//
		// if (y >= 0 && y <= 380) {
		// y -= speed;
		// }
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
