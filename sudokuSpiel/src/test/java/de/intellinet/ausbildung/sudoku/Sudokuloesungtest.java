
package de.intellinet.ausbildung.sudoku;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Sudokuloesungtest {

    SudokuLoesung sudokuLoesung = new SudokuLoesung();

    @Test
    public void frelderstellen() {

        sudokuLoesung.createMatrix();
    }
}
