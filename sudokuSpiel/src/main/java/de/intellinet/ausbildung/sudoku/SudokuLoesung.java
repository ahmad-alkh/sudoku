/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.sudoku;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 06.11.2019
 */
public class SudokuLoesung {

    int[][] feld = new int[9][9];
    SudokuApp sudokuApp = new SudokuApp(feld);
    SudokuSpiel sudokuSpiel = new SudokuSpiel();

    public int[][] createMatrix() {
        sudokuSpiel.spiele();

        return feld;
    }

}
