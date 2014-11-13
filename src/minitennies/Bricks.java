package minitennies;

public class Bricks {

	private int x, y;
	boolean isvisible;
	private Ball ball;

	public Bricks(int x, int y) {
		this.x = x * 15;
		this.y = y * 10;
		isvisible = true;
	}

	public void update(Ball bal) {
		this.ball = bal;
		if (ball.getX() >= x &&  ball.getX()<=x + 10) {
			if (ball.getY() <= y + 10) {
				isvisible = false;
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

	/**
	 * @return the isvisible
	 */
	public boolean isIsvisible() {
		return isvisible;
	}

	/**
	 * @param isvisible
	 *            the isvisible to set
	 */
	public void setIsvisible(boolean isvisible) {
		this.isvisible = isvisible;
	}
}
