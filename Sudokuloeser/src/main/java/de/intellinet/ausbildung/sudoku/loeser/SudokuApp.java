
package de.intellinet.ausbildung.sudoku.loeser;

/**
 * Sudoku App zu prüfen
 * 
 * @author ahmalk
 *
 * @since 26.09.2019
 */

public class SudokuApp {

    Sudokuloeser1 feldErstellung = new Sudokuloeser1();

    private int[][] ursprungsMatrix;

    private int[][] spielMatrix;

    public SudokuApp(int[][] matrix) {
        this.ursprungsMatrix = new int[matrix.length][matrix[0].length];
        this.spielMatrix = matrix;
        /**
         * clone /hier habe ich mein erste Matrix Copert und gespeichrit /for wurde gebaut,um die innere
         * Array zu greifien
         */
        for (int i = 0; i < 9; i++) {
            this.ursprungsMatrix[i] = matrix[i].clone();
        }
    }

    // ---------------------------------------------------------------

    /**
     * Hier wird geprüft,falls kein mehr leer felde gibt
     * TODO Comment
     * 
     * @param sudokuApp
     * @return
     */

    public boolean pruefeFeldVoll() {
        for (int au = 0; au < ursprungsMatrix.length; au++) {
            for (int in = 0; in < ursprungsMatrix[au].length; in++) {
                if (spielMatrix[au][in] == 0) {
                    // this.spiele();
                    // break ;
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] loesen() {

        int[][] rekursion = feldErstellung.rekursion(ursprungsMatrix, 0, 0);
        return rekursion;
    }

    /**
     * 
     ** Hier mit Print methode wird den Matrix mit Trennrn Grenze Ausgegeben
     * 
     * @param spielMatrix
     * @return
     */
    public String print() {
        String ergebnis = "";
        final String NEWLINE = "\n";
        String heada = "  |a b c|d e f|g h i|";
        String trennendGrenze = "- |- - -|- - -|- - -|";

        ergebnis += heada + NEWLINE;
        ergebnis += trennendGrenze + NEWLINE;

        for (int i = 0; i < spielMatrix.length; i++) {
            // i == ZEILEN

            ergebnis += i + 1 + " |";

            for (int j = 0; j < spielMatrix[i].length; j++) {

                // j == SPALTEN
                int jx = (j / 3) * 3 + 2;
                if (spielMatrix[i][j] == 0) {

                    if (j == jx) {
                        ergebnis += " |";
                    } else
                        ergebnis += "  ";

                } else {
                    ergebnis += spielMatrix[i][j];

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
     * @param spielMatrix
     * @return
     */

    public boolean setze(int zahl, String pos) {

        int[] vektor = getKoordinateVektor(pos);

        return this.setze(zahl, vektor[0], vektor[1]);

    }

    private int[] getKoordinateVektor(String pos) {
        char[] charArray = pos.toCharArray();
        try {
            char buchstabeSpalte = charArray[0];
            char reihe = charArray[1];

            int y = Character.getNumericValue(reihe) - 1;
            int x = getKoordinaten(buchstabeSpalte);

            int[] vektor = {x, y};
            return vektor;
        } catch (

        Exception a) {

            return null;
        }
    }

    private int getKoordinaten(char buchstabeSpalte) {
        char[] splteII = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        for (int i = 0; i <= splteII.length - 1; i++) {
            char z = splteII[i];
            if (z == buchstabeSpalte) {
                return i;

            }
        }
        return -1;
    }

    public boolean setze(int zahl, int x, int y) {
        SudokuPruefer sudokuPruefer = new SudokuPruefer();
        if (sudokuPruefer.pruefe(spielMatrix, zahl, x, y) == true) {
            if (ursprungsMatrix[y][x] == 0) {
                spielMatrix[y][x] = zahl;

                return true;
            }
        }

        return false;

    }

    public boolean pruefePos(String pos) {
        int[] vektor = getKoordinateVektor(pos);
        if (vektor == null) {

            return false;
        }
        try {
            if (ursprungsMatrix[vektor[1]][vektor[0]] == 0 && (vektor[0] >= 0 && vektor[1] >= 0)) {
                return true;
            }
        } catch (Exception a) {
            return false;
        }
        return false;
    }
}
