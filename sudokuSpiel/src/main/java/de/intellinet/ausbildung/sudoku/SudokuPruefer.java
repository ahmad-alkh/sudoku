/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.sudoku;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 23.10.2019
 */
public class SudokuPruefer { // Hier wird Senkrecht geprüft

    boolean pruefenSenkrecht(int[][] matrix, int zahl, int x) {

        for (int yi = 0; yi < 9; yi++) {

            int prüfZahl = matrix[yi][x];
            if (prüfZahl == zahl) {
                return false;
            }
        }

        return true;
    }

    // Hier wird Waagerecht geprüft
    boolean pruefenWaagerecht(int[][] matrix, int zahl, int y) {

        for (int xi = 0; xi < 9; xi++) {
            int prüfZahl = matrix[y][xi];
            if (prüfZahl == zahl) {

                return false;
            }
        }

        return true;
    }

    // Hier wird Quadrat geprüft
    boolean pruefenQuadrat(int[][] matrix, int zahl, int y, int x) {

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
     * @param spielMatrix
     * @return
     */
    public boolean pruefe(int[][] matrix, int zahl, int x, int y) {

        if (this.pruefenQuadrat(matrix, zahl, y, x) //
                && this.pruefenWaagerecht(matrix, zahl, y) //
                && this.pruefenSenkrecht(matrix, zahl, x) //
        ) {

            return true;
        }

        return false;
    }

}
