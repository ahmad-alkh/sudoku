/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.sudoku.loeser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.intellinet.ausbildung.sudoku.loeser.models.Loesungen;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 26.09.2019
 */
public class SudokuLoser1Test {

	Sudokuloeser1 sodukuloeser = new Sudokuloeser1();

	private static int[][] matrix;

//	@Test
	public void setUp() {
		int[][] matrix = { //
				{ 5, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 3, 0, 0, 7, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 6, 8, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 9, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0 } };

		System.out.println(sodukuloeser.loeser(matrix));

	}

//	@Test
	public void setUp1() {
		int[][] matrix = { //
				{ 8, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 5, 0, 0, 7, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 6, 8, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 5, 0, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 4, 0, 0 }, //
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 2, 0, 0, 0, 0, 0, 0, 3, 0 } };

		Loesungen loeser = sodukuloeser.loeser(matrix);

		assertEquals(1, loeser.getLoesungen().size());
		assertEquals(80, loeser.getIterationen());

	}

//	@Test
	public void eineLoesung() {
		int[][] matrix = { //
				{ 2, 4, 1, 9, 3, 6, 7, 5, 8 }, //
				{ 6, 8, 7, 1, 2, 5, 3, 9, 4 }, //
				{ 9, 5, 3, 4, 7, 8, 6, 2, 1 }, //
				{ 7, 3, 8, 5, 9, 1, 2, 4, 6 }, //
				{ 4, 2, 6, 7, 8, 3, 5, 1, 9 }, //
				{ 5, 1, 9, 2, 6, 4, 8, 7, 3 }, //
				{ 1, 6, 4, 8, 5, 2, 9, 3, 7 }, //
				{ 3, 9, 5, 6, 4, 7, 1, 8, 2 }, //
				{ 8, 7, 2, 3, 1, 9, 4, 6, 0 } };

		Loesungen loeser = sodukuloeser.loeser(matrix);

//		assertThat(loeser.getLoesungen().size(), is(1));
//		assertThat(loeser.getIterationen(), is(80));
		assertEquals(loeser.getLoesungen().size(), 1);
		assertEquals(loeser.getIterationen(), 80);
	}

	@Test
	public void zweiLoesungen() {
		int[][] matrix = { //
				{ 2, 4, 1, 9, 3, 6, 7, 5, 8 }, //
				{ 6, 8, 7, 1, 2, 5, 3, 9, 4 }, //
				{ 9, 5, 3, 4, 7, 8, 6, 2, 1 }, //
				{ 7, 3, 8, 5, 9, 1, 2, 4, 6 }, //
				{ 4, 2, 6, 7, 8, 3, 5, 1, 9 }, //
				{ 5, 1, 9, 2, 6, 4, 8, 7, 3 }, //
				{ 1, 6, 4, 8, 5, 2, 9, 3, 7 }, //
				{ 3, 9, 5, 6, 4, 7, 1, 8, 2 }, //
				{ 8, 7, 2, 3, 1, 9, 4, 0, 0 } };

		Loesungen loeser = sodukuloeser.loeser(matrix);

//		assertThat(loeser.getLoesungen().size(), is(1));
//		assertThat(loeser.getIterationen(), is(80));
		assertEquals(loeser.getLoesungen().size(), 1);
		assertEquals(loeser.getIterationen(), 80);
	}

	@Test
	public void driteLoesungen() {
		int[][] matrix = { //
				{ 0, 4, 1, 9, 0, 0, 0, 5, 8 }, //
				{ 0, 8, 0, 0, 2, 0, 3, 0, 0 }, //
				{ 9, 0, 3, 4, 0, 0, 6, 2, 1 }, //
				{ 0, 3, 8, 5, 9, 0, 0, 4, 6 }, //
				{ 4, 2, 0, 0, 8, 3, 5, 0, 9 }, //
				{ 0, 1, 0, 2, 0, 4, 8, 0, 3 }, //
				{ 0, 6, 0, 8, 5, 2, 0, 0, 0 }, //
				{ 0, 9, 0, 6, 4, 0, 1, 0, 2 }, //
				{ 0, 0, 2, 3, 0, 0, 4, 0, 0 } };

		Loesungen loeser = sodukuloeser.loeser(matrix);

//		assertThat(loeser.getLoesungen().size(), is(1));
//		assertThat(loeser.getIterationen(), is(80));
		assertEquals(1, loeser.getLoesungen().size());
		assertEquals(181, loeser.getIterationen());
	}

	@Test
	public void vierteLoesungen() {
		int[][] matrix = { //
				{ 0, 4, 1, 9, 0, 0, 0, 5, 8 }, //
				{ 0, 8, 0, 0, 2, 0, 3, 0, 0 }, //
				{ 9, 0, 3, 4, 0, 0, 0, 0, 1 }, //
				{ 0, 3, 8, 5, 0, 0, 0, 4, 0 }, //
				{ 0, 2, 0, 0, 0, 0, 0, 0, 0 }, //
				{ 0, 0, 0, 2, 0, 4, 8, 0, 0 }, //
				{ 0, 6, 0, 0, 0, 2, 0, 0, 0 }, //
				{ 0, 0, 0, 6, 0, 0, 1, 0, 2 }, //
				{ 0, 0, 0, 3, 0, 0, 4, 0, 0 } };

		Loesungen loeser = sodukuloeser.loeser(matrix);
		System.out.println(loeser);
//		assertThat(loeser.getLoesungen().size(), is(1));
//		assertThat(loeser.getIterationen(), is(80));
//
////		for (int x = 0; x < 9; x++) {
////			System.out.println(sodukuloeser.getErgebnis(loeser.getLoesungen().get(x).getMatrix()));
////
////		}
//		for (int zahl : Loesung)
//		sodukuloeser.printErgebnis()
//	0	assertEquals(2185, loeser.getLoesungen().size());
//	0	assertEquals(304818, loeser.getIterationen());
	}

}