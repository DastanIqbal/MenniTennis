import java.util.Random;

public class Ball {

	private final int SPEEDX = 15;
	private final int SPEEDY = 10;
	private final int RANDOMX = 15;
	private final int RANDOMY = 10;

	private int x, y, dx, dy, speedX = SPEEDX, speedY = SPEEDY;
	boolean iscollideX = false;
	boolean iscollideY = false;
	Random r;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		r = new Random();
	}

	public void move() {
		if (x + dx < 0) {
			speedX = SPEEDX;
		}

		if (x + dx > 368) {
			speedX = -SPEEDX;
		}

		if (y + dy < 0) {
			speedY = SPEEDY;
		}
		if (y + dy > 368) {
			speedY = -SPEEDY;
		}

		detectCollision();

		x += speedX + dx;
		y += speedY + dy;
	}

	private void detectCollision() {

		// Right Side
		if (x >= 368) {
			dx = -r.nextInt(RANDOMX);
		}

		// Bottom Side
		if (y >= 368) {
			dy = -r.nextInt(RANDOMY);
		}

		// Left Side
		if (x <= 0) {
			dx = r.nextInt(RANDOMX);
		}

		// Top Side
		if (y <= 0) {
			dy = r.nextInt(RANDOMY);
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
