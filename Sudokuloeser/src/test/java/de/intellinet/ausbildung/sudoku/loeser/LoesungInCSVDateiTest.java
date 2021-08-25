/**
 * 
 */
package de.intellinet.ausbildung.sudoku.loeser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import de.intellinet.ausbildung.sudoku.loeser.models.Loesung;
import junit.framework.TestCase;

/**
 * @author aakh1
 *
 */
public class LoesungInCSVDateiTest extends TestCase {

	public void testToStringStringArray() throws Exception {
		LoesungInCSVDateiExportiern loesungInCSVDatei = new LoesungInCSVDateiExportiern();
		List<Loesung> erstelleLoesungen = erstelleLoesungen();

		loesungInCSVDatei.exportCsv(erstelleLoesungen, "SudokuErgebnis.csv");
		BufferedReader bufferreader = new BufferedReader(new FileReader("SudokuErgebnis.csv"));
		String speicher = "";
		String line = null;
		while ((line = bufferreader.readLine()) != null) {

			speicher += line;
//			speicher += "\r\n";

		}
		String str = //
				"5,0,0,0,0,0,0,0,0" + //
						"0,3,0,0,7,0,0,0,0" + //
						"0,0,0,0,0,0,0,0,3" + //
						"0,0,0,0,0,0,0,0,0" + //
						"0,0,6,8,0,0,0,0,0" + //
						"0,0,0,0,0,9,0,0,0" + //
						"0,0,0,0,0,0,0,0,0" + //
						"0,0,0,0,0,0,0,0,0" + //
						"1,0,0,0,0,0,0,0,0" + //
						"5,1,2,3,4,6,7,8,9" + //
						"4,3,8,9,7,1,2,5,6" + //
						"6,7,9,2,5,8,1,4,3" + //
						"2,4,1,5,3,7,6,9,8" + //
						"3,9,6,8,1,2,4,7,5" + //
						"7,8,5,4,6,9,3,1,2" + //
						"8,2,3,1,9,4,5,6,7" + //
						"9,6,4,7,2,5,8,3,1" + //
						"1,5,7,6,8,3,9,2,4"//
		;
//		System.out.println(speicher);
		assertEquals(str, speicher);
	}

	private List<Loesung> erstelleLoesungen() {

		List<Loesung> saml = new ArrayList<>();

		int[][] matrix1 = { //
				{ 5, 1, 2, 3, 4, 6, 7, 8, 9 }, //
				{ 4, 3, 8, 9, 7, 1, 2, 5, 6 }, //
				{ 6, 7, 9, 2, 5, 8, 1, 4, 3 }, //
				{ 2, 4, 1, 5, 3, 7, 6, 9, 8 }, //
				{ 3, 9, 6, 8, 1, 2, 4, 7, 5 }, //
				{ 7, 8, 5, 4, 6, 9, 3, 1, 2 }, //
				{ 8, 2, 3, 1, 9, 4, 5, 6, 7 }, //
				{ 9, 6, 4, 7, 2, 5, 8, 3, 1 }, //
				{ 1, 5, 7, 6, 8, 3, 9, 2, 4 } };
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

		saml.add(new Loesung(matrix, 0));
		saml.add(new Loesung(matrix1, 0));

		return saml;

	}

}
