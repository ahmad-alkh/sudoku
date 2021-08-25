/**
 * 
 */
package de.intellinet.ausbildung.sudoku.loeser.models;

/**
 * @author aakh1
 *
 */
public class Loesung {

	public Loesung(int[][] matrix, int anzahlIteration) {

		this.matrix = matrix;
		this.anzahlIteration = anzahlIteration;
	}

	private int[][] matrix;

	private int anzahlIteration;

	public int getAnzahlIteration() {
		return anzahlIteration;
	}

	public void setAnzahlIteration(int anzahlIteration) {
		this.anzahlIteration = anzahlIteration;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

//	@Override
//	public String toString() {
//		StringBuffer strB = new StringBuffer(); // Hier wird das ergebnis deklariert
//
//		for (int row = 0; row < matrix.length; row++) {
//			StringBuffer zeile = new StringBuffer();
//			for (int column = 0; column < matrix.length; column++) {
//
//				zeile.append(matrix[row][column] + " ");
//
//			}
//
//			strB.append(zeile.toString().trim()).append("\n");
//		}
//		String ergebnis = strB.toString();
//		// System.out.println(ergebnis);
//		return ergebnis;
//	}

}
