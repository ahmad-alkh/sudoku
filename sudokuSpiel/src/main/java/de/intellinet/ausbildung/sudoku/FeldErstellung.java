
package de.intellinet.ausbildung.sudoku;

import java.util.concurrent.ThreadLocalRandom;

public class FeldErstellung {

    SudokuPruefer sudokuPruefer = new SudokuPruefer(); // Hier wird Prüfung methed aufgeruft

    int iterationen = 0; // Hier wird die Iteration deklariert und installiert

    public int[][] feldErstellen(SpielNiveau niveau) {// Hier wird die Konstruktor "Feld erstellen" erstellt

        long start = System.nanoTime();// Hier wird START erstellt, um die verstrichen Zeit zu breschnen

        int[][] feld = new int[9][9];// Hier wird ARRAY FELD deklariert und installiert

        int[][] rekursion = rekursion(feld, 0, 0); // Hier wird die REKURSION deklariert und mit Methed REKURSION
                                                   // installiert

        // Hier wird "PRINT ERGEBNIS" aufgeruft, um die Rerkusion auszugeben
        // 33 printErgebnis(rekursion);
        // Hier wird FINISH erstellt, um die verstrichen Zeit zu breschnen
        long finish = System.nanoTime();
        // Hier wird die verstrichen Zeit breschnen, indem beendete Zeit minusbeginnen Zeit berchnen
        long timeElapsed = finish - start;
        niveauSpielfeld(rekursion, niveau);
        System.out.println("Iterationen: " + iterationen + "\t" + "timeElapsed: " + timeElapsed / 1000000 + " ms");
        // Hier wird die verstrichen Zeit und wie viel Iterationen haben
        return rekursion;

    }

    /**
     * 
     * 
     * Hier wird die Konstruktor "print Ergebnis" erstellt
     * 
     * @param feld
     */
    private void printErgebnis(int[][] feld) {
        String ergebnis; // Hier wird das ergebnis deklariert
        System.out.println("++++++++++++++++++++++++++++");
        // mit dem zwei for schleife,um MATRIX auszugeben
        for (int cy = 0; cy < feld.length; cy++) {
            for (int vx = 0; vx < feld.length; vx++) {

                int e = (vx / 3) * 3 + 2;
                if (vx == e) {
                    ergebnis = feld[cy][vx] + " | ";
                } else {
                    ergebnis = feld[cy][vx] + " ";
                }
                System.out.print(ergebnis);
            }
            int r = (cy / 3) * 3 + 2;
            if (cy == r) {
                System.out.println("\n" + "-----------------------");
            } else {
                System.out.println();
            }
        }
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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                cloneMatrix[i][j] = matrix[i][j];
            }
        }
        return cloneMatrix;

    }

    /**
     * 
     * hier wird Zufaellige Array erstellt
     * 
     * @return
     */
    public int[] zufaelligeArray() {
        int[] line = new int[9];
        ThreadLocalRandom randomGenrato = ThreadLocalRandom.current();

        for (int i = 0; i < 9; i++) {
            int randomNum;
            do {
                randomNum = randomGenrato.nextInt(1, 9 + 1);
            } while (prufeArray(line, randomNum));
            line[i] = randomNum;
        }
        return line;

    }

    public static boolean prufeArray(int[] line, int zahl) {
        for (int i : line) {
            if (i == zahl) {
                return true;
            }
        }
        return false;
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
    public int[][] rekursion(int[][] matrix, int x, int y) {

        // printErgebnis(matrix);
        int[][] cloneMatrix = this.cloneMatrix(matrix);
        int[] array = this.zufaelligeArray(); // hier wird die Eingegebene Zahl gespeichiert
        for (int i : array) { // Hier wird geprüft,welcher Zahl in der Matrix einsetzen kann
            iterationen++;
            // 33 System.out.println("X: " + x + "\tY: " + y + "\tZahl: " + i);

            if (sudokuPruefer.pruefe(matrix, i, x, y)) { // Hier wird geprüft,ob die Zahl in der Matrix einsetzen kann
                cloneMatrix[y][x] = i;

                int xn = x + 1;
                int yn = y;
                if (xn >= cloneMatrix[y].length) { // ob die nächste spalte >9
                    xn = 0; // denn x=0
                    yn += 1; // und y+1 (zu ein neue Zeile)
                }
                if (yn >= cloneMatrix.length) { // y=9 dann brech ab,da gibt es keine line heißt 9
                    return cloneMatrix;
                }

                int[][] result = rekursion(cloneMatrix, xn, yn);
                if (result != null)
                    return result;
            }
        }
        // System.out.println("Gehen nun zurueck");
        // falls keine Zahl passt in dieser Posietion, dann wird die kopierte Matrix aufgeruft
        // printErgebnis(cloneMatrix);
        return null;

    }

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int[][] niveauSpielfeld(int[][] matrix, SpielNiveau niveau) {
        // printErgebnis(matrix);

        for (int ike = 0; ike < 9; ike++) {
            int[] v = this.zufaelligeArray();
            for (int ikee = 0; ikee < niveau.val; ikee++) {

                matrix[ike][v[ikee] - 1] = 0;

            }
        }

        // 33 printErgebnis(matrix);
        return matrix;

    }

}
