
package de.intellinet.ausbildung.sudoku.loeser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.sudoku.loeser.models.Koordinate;
import de.intellinet.ausbildung.sudoku.loeser.models.Loesung;
import de.intellinet.ausbildung.sudoku.loeser.models.Loesungen;

public class Sudokuloeser1 {

	private static Logger logger = LoggerFactory.getLogger(Sudokuloeser1.class);

	SudokuPruefer sudokuPruefer = new SudokuPruefer(); // Hier wird Prüfung methed aufgeruft

	public Loesungen loeser(int[][] matrix) {

		Loesungen iterationen = new Loesungen();
		Koordinate startPosition = new Koordinate(0, 0);
		int[][] rekursion = rekursion(matrix, startPosition, iterationen); // Hier wird die REKURSION deklariert und
//		System.out.println(getErgebnis(rekursion)); // mit Methed
		// REKURSION
		// installiert

		// Hier wird "PRINT ERGEBNIS" aufgeruft, um die Rerkusion auszugeben

//	0	logger.info(printErgebnis(rekursion));
		logger.info("Anzahl Iterationen: {}", iterationen.getIterationen());
		logger.info("Anzahl Loesungen: {}", iterationen.getAnzahloesung());
		return iterationen;

	}

	/**
	 * 
	 * TODO Konstruktor rekursion
	 * 
	 * @param matrix
	 * @param x
	 * @param y
	 * @return
	 */
	@Deprecated
	public int[][] rekursion(int[][] matrix, int x, int y) {
		logger.debug("insert rekursion ...");
		Koordinate koordinate = new Koordinate(x, y);
		System.out.println(getErgebnis(matrix, koordinate));

		if (!istPositionLeer(matrix, koordinate)) {

			return naechstefeld(matrix, x, y);

		} else {

			int[][] cloneMatrix = this.cloneMatrix(matrix);
			int[] arrayZahl = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // hier wird die Eingegebene Zahl gespeichiert
			for (int zahl : arrayZahl) { // Hier wird geprüft,welcher Zahl in der Matrix einsetzen kann
//				iterationen++;
//				System.out.println("X: " + x + "\tY: " + y + "\tZahl: " + zahl +"\titerationen:"+iterationen);
				logger.debug("X: {} Y: {} Zahl: {}", x, y, zahl);
				if (sudokuPruefer.pruefe(matrix, zahl, x, y)) { // Hier wird geprüft,ob die Zahl in der Matrix einsetzen
																// kann
					cloneMatrix[y][x] = zahl;

					int[][] naechstefeldMitRuck = naechstefeld(cloneMatrix, x, y);

					if (naechstefeldMitRuck != null) {
						return naechstefeldMitRuck;
					}

				}
			}
		}
		System.out.println("Gehe nun zurueck");
		// falls keine Zahl passt in dieser Posietion, dann wird die kopierte Matrix
		// aufgeruft
//		printErgebnis(matrix,y , x);
		return null;

	}

	public int[][] rekursion2(int[][] matrix, Koordinate aktuellePosition, Loesungen iterationen) {
		logger.debug("insert rekursion ...");

//		Koordinate cloneKoordinate =

//		getErgebnis(matrix, startPosition);

		// Hier wird geprueft, ob die Postion leer ist!
		if (!istPositionLeer(matrix, aktuellePosition)) {
			// falls die Postion bsetzt, dann greif die naechste Postion zu.
			Koordinate naechste = naechstefeld2(matrix, aktuellePosition); // die naechaste Feld
																			// zugraeifen
			if (naechste.getY() >= matrix.length) { // y=9 dann brech ab,da gibt es keine line heißt 9
				return matrix;
			}
			int[][] result = rekursion2(matrix, naechste, iterationen.next());

			if (result != null)
				return result;

		} else {
//falls die Postion nicht besetzt, dann versuch eine Zahl zu setzten.
			int[][] cloneMatrix = this.cloneMatrix(matrix);
			int[] arrayZahl = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // hier wird die Eingegebene Zahl gespeichiert
			for (int zahl : arrayZahl) { // Hier wird geprüft,welcher Zahl in der Matrix einsetzen kann
//				iterationen++;
				System.out.println("X: " + aktuellePosition.getX() + "\tY: " + aktuellePosition.getY() + "\tZahl: "
						+ zahl + "\titerationen:" + iterationen);
				logger.debug("X: {} Y: {} Zahl: {}", aktuellePosition.getX(), aktuellePosition.getY(), zahl);

				if (sudokuPruefer.pruefe(matrix, zahl, aktuellePosition.getX(), aktuellePosition.getY())) { // Hier wird
					// die Zahl in
					// kann
					cloneMatrix[aktuellePosition.getY()][aktuellePosition.getX()] = zahl;
					System.out.println(getErgebnis(cloneMatrix, aktuellePosition));
					Koordinate naechste = naechstefeld2(cloneMatrix, aktuellePosition);
					if (naechste.getY() >= matrix.length) { // y=9 dann brech ab,da gibt es keine line heißt 9
//						\\hier ist das End der  Rekursion

////						Loesung loesung = new Loesung(cloneMatrix, iterationen.getIterationen());
////
////						List<Loesung> loesungen = iterationen.getLoesungen();
////						loesungen.add(loesung);
////						logger.info("Loesung gefunden {}", loesungen.size());
////						return null;
						return cloneMatrix;
					}
					iterationen.setIterationen(iterationen.getIterationen() + 1);
					int[][] result = rekursion2(cloneMatrix, naechste, iterationen);

					if (result != null)
						return result;

				}
			}
		}
		logger.debug("Geh nun zurueck" + " Iterationen: {}", iterationen.getIterationen());
		System.out.println("Geh nun zurueck " + iterationen.getIterationen());
		// falls keine Zahl passt in dieser Posietion, dann wird die kopierte Matrix
		// aufgeruft

		return null;

	}

	public int[][] rekursion(int[][] matrix, Koordinate aktuellePosition, Loesungen iterationen) {
		logger.debug("insert rekursion ...");

		// Hier wird geprueft, ob die Postion leer ist!
		if (!istPositionLeer(matrix, aktuellePosition)) {
			// falls die Postion bsetzt, dann greif die naechste Postion zu.
			return nachstePosition(matrix, aktuellePosition, iterationen);

		} else {
			// falls die Postion nicht besetzt, dann versuch eine Zahl zu setzten.
			return setzeZahl(matrix, aktuellePosition, iterationen);
		}

	}

	/**
	 * @param matrix
	 * @param aktuellePosition
	 * @param iterationen
	 * @return
	 */
	public int[][] setzeZahl(int[][] matrix, Koordinate aktuellePosition, Loesungen iterationen) {
		// falls die Postion nicht besetzt, dann versuch eine Zahl zu setzten.
		int[][] cloneMatrix = this.cloneMatrix(matrix);
		int[] arrayZahl = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // hier wird die Eingegebene Zahl gespeichiert
		for (int zahl : arrayZahl) { // Hier wird geprüft,welcher Zahl in der Matrix einsetzen kann
			// iterationen++;
			System.out.println("X: " + aktuellePosition.getX() + "\tY: " + aktuellePosition.getY() + "\tZahl: " + zahl
					+ "\titerationen:" + iterationen);
			logger.debug("X: {} Y: {} Zahl: {}", aktuellePosition.getX(), aktuellePosition.getY(), zahl);

			if (sudokuPruefer.pruefe(matrix, zahl, aktuellePosition.getX(), aktuellePosition.getY())) { // Hier wird
				// die Zahl in
				// kann
				cloneMatrix[aktuellePosition.getY()][aktuellePosition.getX()] = zahl;
				System.out.println(getErgebnis(cloneMatrix, aktuellePosition));
				Koordinate naechste = naechstefeld2(cloneMatrix, aktuellePosition);
				if (naechste.getY() >= matrix.length) { // y=9 dann brech ab,da gibt es keine line heißt 9
					// \\hier ist das End der Rekursion

					loesungSammlung(iterationen, cloneMatrix);

					return null;
//					return cloneMatrix;
				}
				iterationen.setIterationen(iterationen.getIterationen() + 1);
				int[][] result = rekursion(cloneMatrix, naechste, iterationen);

				if (result != null)
					return result;

			}
		}
		logger.debug("Geh nun zurueck" + " Iterationen: {}", iterationen.getIterationen());
		System.out.println("Geh nun zurueck " + iterationen.getIterationen());
		return null;
	}

	/**
	 * @param iterationen
	 * @param cloneMatrix
	 */
	public void loesungSammlung(Loesungen iterationen, int[][] cloneMatrix) {
		Loesung loesung = new Loesung(cloneMatrix, iterationen.getIterationen());

		List<Loesung> loesungen = iterationen.getLoesungen();
		if (loesungen.size() >= 1000) {
			logger.error("Es gibt ueber 1000 Kombinationen {}", loesungen.size());
			throw new RuntimeException("Es gibt ueber 1000 Kombinationen ");
		}
		loesungen.add(loesung);
		logger.info("Loesung gefunden {}", loesungen.size());
	}

	/**
	 * @param matrix
	 * @param aktuellePosition
	 * @param iterationen
	 */
	public int[][] nachstePosition(int[][] matrix, Koordinate aktuellePosition, Loesungen iterationen) {
		// falls die Postion bsetzt, dann greif die naechste Postion zu.
		Koordinate naechste = naechstefeld2(matrix, aktuellePosition); // die naechaste Feld
																		// zugraeifen
		if (naechste.getY() >= matrix.length) { // y=9 dann brech ab,da gibt es keine line heißt 9
			return matrix;
		}
		int[][] result = rekursion(matrix, naechste, iterationen.next());

		if (result != null)
			return result;

		return null;
	}

	/**
	 * 
	 * 
	 * Hier wird die Konstruktor "print Ergebnis" erstellt
	 * 
	 * @param feld
	 */
	private String getErgebnis(int[][] feld, Koordinate startPosition) {
		String ergebnis = ""; // Hier wird das ergebnis deklariert
		ergebnis += ("++++++++++++++++++++++++++++\n");
		// mit dem zwei for schleife,um MATRIX auszugeben

		for (int row = 0; row < feld.length; row++) {
			for (int column = 0; column < feld.length; column++) {
				if (startPosition.getY() == row && startPosition.getX() == column) {

					ergebnis += (feld[row][column] + ") ");
				} else {
					ergebnis += feld[row][column] + "  ";

				}
			}
			ergebnis += "\n";
		}
//		System.out.println(ergebnis);
		return ergebnis;
	}

	/**
	 * 
	 * 
	 * Hier wird die Konstruktor "print Ergebnis" erstellt
	 * 
	 * @param feld
	 */
	public String getErgebnis(int[][] feld) {

		return this.getErgebnis(feld, new Koordinate(-1, -1));
	}

	/**
	 * 
	 * TODO Hier wird die matrix Kopiert
	 * 
	 * @param matrix
	 * @return
	 */
	public int[][] cloneMatrix(int[][] matrix) {
		int[][] cloneMatrix = new int[matrix.length][matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				cloneMatrix[row][column] = matrix[row][column];
			}
		}
		return cloneMatrix;

	}

	/**
	 * 
	 * @param matrix
	 * @param row
	 * @param column
	 * @return result rekursion es wird deaktiver, weil die nicht nur maechste feld
	 *         zugreift sonder auch rekursion liefrat
	 */
	@Deprecated
	private int[][] naechstefeld(int[][] matrix, int row, int column) {
		int[][] result = null;
		int xn = row + 1;
		int yn = column;
		if (xn >= matrix[column].length) { // ob die nächste spalte >9
			xn = 0; // denn x=0
			yn += 1; // und y+1 (zu ein neue Zeile)
		}
		if (yn >= matrix.length) { // y=9 dann brech ab,da gibt es keine line heißt 9
			result = matrix;
		}
		if (result != matrix)
			result = rekursion(matrix, xn, yn);

		return result;
	}

	public Koordinate naechstefeld2(int[][] matrix, Koordinate startPosition) {

		int xn = startPosition.getX() + 1;
		int yn = startPosition.getY();
		if (xn >= matrix[startPosition.getY()].length) { // ob die nächste spalte >9
			xn = 0; // denn x=0
			yn += 1; // und y+1 (zu ein neue Zeile)
		}
		// Todo von vektor to koordinate naechtepos
		return new Koordinate(xn, yn);
//		startPosition.setX();
//		startPosition.setY(yn);
//		return startPosition;

	}

	public boolean istPositionLeer(int[][] matrix, Koordinate startPosition) {
		if (matrix[startPosition.getY()][startPosition.getX()] == 0) {
			return true;
		}
		return false;

	}

}
