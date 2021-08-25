package de.intellinet.ausbildung.sudoku.loeser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.intellinet.ausbildung.sudoku.loeser.models.Koordinate;
import de.intellinet.ausbildung.sudoku.loeser.models.Loesungen;

public class Sudokuloser1MethodeTest {
	Sudokuloeser1 sudokuloeser = new Sudokuloeser1();
	private int[][] matrix = { //
			{ 5, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 3, 0, 0, 7, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 6, 8, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 9, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0 } };

	@Test
	public void cloneMatrixTest() {

		int[][] cloneMatrix = sudokuloeser.cloneMatrix(matrix);
		assertEquals(5, cloneMatrix[0][0]);
		assertEquals(6, cloneMatrix[4][2]);
		assertEquals(0, cloneMatrix[0][1]);
		assertEquals(7, cloneMatrix[1][4]);
		assertEquals(0, cloneMatrix[7][4]);
		assertEquals(0, cloneMatrix[8][8]);
		assertEquals(1, cloneMatrix[8][0]);
	}

	@Test
	public void naechstePos() {
		Koordinate startPositionErgibnis = sudokuloeser.naechstefeld2(matrix, new Koordinate(0, 0));
		assertEquals(1, startPositionErgibnis.getX());

		Koordinate startPositionErgibnis2 = sudokuloeser.naechstefeld2(matrix, new Koordinate(2, 1));
		assertEquals(3, startPositionErgibnis2.getX());

		Koordinate startPositionErgibnis3 = sudokuloeser.naechstefeld2(matrix, new Koordinate(8, 1));
		assertEquals(0, startPositionErgibnis3.getX());
		assertEquals(2, startPositionErgibnis3.getY());

	}

	@Test
	public void istPosLeer() {

		assertEquals(sudokuloeser.istPositionLeer(matrix, new Koordinate(0, 0)), false);
		assertEquals(sudokuloeser.istPositionLeer(matrix, new Koordinate(1, 0)), true);
		assertEquals(sudokuloeser.istPositionLeer(matrix, new Koordinate(8, 8)), true);
		assertEquals(sudokuloeser.istPositionLeer(matrix, new Koordinate(8, 2)), false);
	}

	@Test
	public void setzMedothe() {
		int[][] matrix1 = { { 2, 1, 4, 3, 5, 6, 7, 8, 9 }, { 5, 3, 8, 9, 7, 1, 2, 4, 6 }, //
				{ 6, 7, 9, 2, 4, 8, 1, 5, 3 }, //
				{ 3, 2, 1, 4, 6, 5, 8, 9, 7 }, //
				{ 4, 9, 6, 8, 2, 7, 3, 1, 5 }, //
				{ 7, 8, 5, 1, 3, 9, 4, 6, 2 }, //
				{ 8, 4, 2, 5, 9, 3, 6, 7, 1 }, //
				{ 9, 6, 3, 7, 1, 4, 5, 2, 8 }, //
				{ 1, 5, 7, 6, 8, 2, 9, 3, 4 } };//
		assertEquals(sudokuloeser.setzeZahl(matrix, new Koordinate(0, 0), new Loesungen()), matrix1);

	}

	@Test
	public void rekursion2Test() {
		int[][] matrix1 = { { 5, 1, 2, 3, 4, 6, 7, 8, 9 }, //
				{ 4, 3, 8, 9, 7, 1, 2, 5, 6 }, //
				{ 6, 7, 9, 2, 5, 8, 1, 4, 3 }, //
				{ 2, 4, 1, 5, 3, 7, 6, 9, 8 }, //
				{ 3, 9, 6, 8, 1, 2, 4, 7, 5 }, //
				{ 7, 8, 5, 4, 6, 9, 3, 1, 2 }, //
				{ 8, 2, 3, 1, 9, 4, 5, 6, 7 }, //
				{ 9, 6, 4, 7, 2, 5, 8, 3, 1 }, //
				{ 1, 5, 7, 6, 8, 3, 9, 2, 4 } };
		assertEquals(sudokuloeser.rekursion2(matrix, new Koordinate(0, 0), new Loesungen()), matrix1);

	}

	@Test
	public void rekursion3Test() {
		int[][] matrix1 = { { 5, 1, 2, 3, 4, 6, 7, 8, 9 }, //
				{ 4, 3, 8, 9, 7, 1, 2, 5, 6 }, //
				{ 6, 7, 9, 2, 5, 8, 1, 4, 3 }, //
				{ 2, 4, 1, 5, 3, 7, 6, 9, 8 }, //
				{ 3, 9, 6, 8, 1, 2, 4, 7, 5 }, //
				{ 7, 8, 5, 4, 6, 9, 3, 1, 2 }, //
				{ 8, 2, 3, 1, 9, 4, 5, 6, 7 }, //
				{ 9, 6, 4, 7, 2, 5, 8, 3, 1 }, //
				{ 1, 5, 7, 6, 8, 3, 9, 2, 4 } };
		assertEquals(matrixVergleich(sudokuloeser.rekursion(matrix, new Koordinate(0, 0), new Loesungen()), matrix1),
				true);
		// neu Methed

	}

	private boolean matrixVergleich(int[][] matrixErgebnis, int[][] matrixErwartung) {
		if (matrixErwartung.length != matrixErgebnis.length) {
			return false;
		}
		for (int i = 0; i < matrixErwartung.length; i++) {
			for (int j = 0; j < matrixErwartung[i].length; j++) {
				if (matrixErgebnis[i][j] != matrixErwartung[i][j]) {
					return false;

				}

			}
		}
		return true;

	}

}
