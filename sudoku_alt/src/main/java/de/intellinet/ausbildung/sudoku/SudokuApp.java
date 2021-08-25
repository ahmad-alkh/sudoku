
package de.intellinet.ausbildung.sudoku;

/**
 * Sudoku App zu prüfen
 * 
 * @author ahmalk
 *
 * @since 26.09.2019
 */
public class SudokuApp {

    // Hier wird Senkrecht geprüft
    boolean pruefenSenkrecht(int zahl, int y, int[][] matrix) {

        for (int xi = 0; xi < 9; xi++) {
            int prüfZahl = matrix[xi][y];
            if (prüfZahl == zahl) {
                return false;
            }
        }

        return true;
    }
/**
 * 
 * @param zahl
 * @param x
 * @param matrix
 * @return
 */
    // Hier wird Waagerecht geprüft
    boolean pruefenWaagerecht(int zahl, int x, int[][] matrix) {

        for (int yi = 0; yi < 9; yi++) {
            int prüfZahl = matrix[x][yi];
            if (prüfZahl == zahl) {

                return false;
            }
        }

        return true;
    }

    // Hier wird Quadrat geprüft
    boolean pruefenQuadrat(int zahl, int x, int y, int[][] matrix) {

        int xz = (x / 3) * 3;
        int yz = (y / 3) * 3;

        for (int xj = xz; xj < xz + 3; xj++) {
            for (int yj = yz; yj < yz + 3; yj++) {
                int pruefZahl = matrix[yj][xj];
                if (pruefZahl == zahl) {

                    return false;
                }

            }

        }
        return true;

    }

    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    /**
     * mit prüfen methode werden Quadrat,Waagerecht und Senkrecht aufgeruft, um alle prüfungsmethoden in
     * einer Methode zu prüfen
     * 
     * @param zahl
     * @param x koordinaten
     * @param y koordinaten
     * @param matrix
     * @return
     */
    public boolean pruefe(int zahl, int x, int y, int[][] matrix) {

        if (this.pruefenQuadrat(zahl, x, y, matrix) //
                && this.pruefenWaagerecht(zahl, x, matrix) //
                && this.pruefenSenkrecht(zahl, y, matrix) //
        ) {

            return true;
        }

        return false;
    }

    /**
     * 
     * Hier mit Print methode wird den Matrix mit Trennrn Grenze Ausgegeben
     * 
     * @param matrix
     * @return
     */
    public String print(int[][] matrix) {
        String ergebnis = "";
        final String NEWLINE = "\n";
        String heada = "  |a b c|d e f|g h i|";
        String trennendGrenze = "- |- - -|- - -|- - -|";

        ergebnis += heada + NEWLINE;
        ergebnis += trennendGrenze + NEWLINE;

        for (int i = 0; i < matrix.length; i++) {
            // i == ZEILEN

            ergebnis += i + 1 + " |";

            for (int j = 0; j < matrix[i].length; j++) {

                // j == SPALTEN
                int jx = (j / 3) * 3 + 2;
                if (matrix[i][j] == 0) {

                    if (j == jx) {
                        ergebnis += " |";
                    } else
                        ergebnis += "  ";

                } else {
                    ergebnis += matrix[i][j];

                    if (j == jx) {
                        ergebnis += "|";
                    } else
                        ergebnis += " ";

                }
            }

            ergebnis += NEWLINE;
            int jx = (i / 3) * 3 + 2;
            if (i == jx)
                ergebnis += trennendGrenze + NEWLINE;

        }

        return ergebnis;

    }

    /**
     * Hier wird die Zahl in der Position mit name das feld/koordinaten eingesetzt
     * 
     * 
     * @param zahl
     * @param pos
     * @param matrix
     * @return
     */

    public int[][] setze(int zahl, String pos, int[][] matrix) throws Exception {

        char[] charArray = pos.toCharArray();
        char buchstabeSpalte = charArray[0];
        char reihe = charArray[1];
        int x = 0;
        int y = Character.getNumericValue(reihe) - 1;
        char[] splteII = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        for (int i = 0; i <= splteII.length - 1; i++) {
            char z = splteII[i];
            if (z == buchstabeSpalte) {
                x = i;
            }
        }
        if (matrix[y][x] == 0) {
            matrix[y][x] = zahl;
        } else {
            throw new Exception("schon besetzt!");

        }

        System.out.println(zahl + pos);

        System.out.println(this.print(matrix));
        return matrix;

    }

    public int[][] setze(int zahl, int x, int y, int[][] matrix) throws Exception {

        if (this.pruefe(zahl, x, y, matrix) == true) {
            if (matrix[y][x] == 0) {
                matrix[x][y] = zahl;
            } else {
                throw new Exception("schon besetzt");
            }

            System.out.println(this.print(matrix));

        }

        return matrix;

    }

}
