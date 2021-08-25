/**
 * 
 */
package de.intellinet.ausbildung.sudoku.loeser.models;

/**
 * @author aakh1
 *
 */
public class Koordinate {
	private int y;
	private int x;

	public Koordinate(int x, int y) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
