/**
 * 
 */
package de.intellinet.ausbildung.sudoku.loeser;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.intellinet.ausbildung.sudoku.loeser.models.Loesung;

/**
 * @author aakh1
 *
 */
public class LoesungInDateiTest {

	@Test
	public void test() throws IOException {
		String fileName = "SudokuErgebnis.txt";
		LoesungInDatei datei = new LoesungInDatei();
		List<Loesung> erstelleLoesungen = erstelleLoesungen();
		datei.speichereDatei(fileName, erstelleLoesungen);
		BufferedReader bufferreader = new BufferedReader(new FileReader(fileName));
		String speicher = "";
		String line = null;
		while ((line = bufferreader.readLine()) != null) {
			speicher += line;
			speicher += "\r\n";

		}

		String str = "5,0,0,0,0,0 0 0 0,\r\n" //
				+ "0 3 0 0 7 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 3\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "0 0 6 8 0 0 0 0 0\r\n"
				+ "0 0 0 0 0 9 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "0 0 0 0 0 0 0 0 0\r\n" + "1 0 0 0 0 0 0 0 0\r\n" //
				+ "\r\n" //
				+ "5 1 2 3 4 6 7 8 9\r\n" + "4 3 8 9 7 1 2 5 6\r\n" + "6 7 9 2 5 8 1 4 3\r\n" + "2 4 1 5 3 7 6 9 8\r\n"
				+ "3 9 6 8 1 2 4 7 5\r\n" + "7 8 5 4 6 9 3 1 2\r\n" + "8 2 3 1 9 4 5 6 7\r\n" + "9 6 4 7 2 5 8 3 1\r\n"
				+ "1 5 7 6 8 3 9 2 4\r\n" + "\r\n";
//		System.out.println(speicher);
		assertEquals(str, speicher);
//		System.out.println(fileReader);

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
//	private String getErgebnis(List<Loesung> feld) {
//		String ergebnis = ""; // Hier wird das ergebnis deklariert
//	
//
//		
//
//				
//					ergebnis += feld[row][column] + "  ";
//
//			}
//			ergebnis += "\n";
//		}
////		System.out.println(ergebnis);
//		return ergebnis;
//	}
}
