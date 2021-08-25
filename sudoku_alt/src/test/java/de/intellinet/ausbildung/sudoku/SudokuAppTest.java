/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 26.09.2019
 */
public class SudokuAppTest {

    private static int[][] matrix;

    @Before
    public void setUp() {
        int[][] matrix = {//
                {5, 0, 0, 0, 0, 0, 0, 0, 0}, //
                {0, 3, 0, 0, 7, 0, 0, 0, 0}, //
                {0, 0, 0, 0, 0, 0, 0, 0, 3}, //
                {0, 0, 0, 0, 0, 0, 0, 0, 0}, //
                {0, 0, 6, 8, 0, 0, 0, 0, 0}, //
                {0, 0, 0, 0, 0, 9, 0, 0, 0}, //
                {0, 0, 0, 0, 0, 0, 0, 0, 0}, //
                {0, 0, 0, 7, 0, 0, 0, 0, 5}, //
                {1, 0, 0, 0, 0, 0, 0, 0, 0}};
        SudokuAppTest.matrix = matrix;
    }

    private SudokuApp sudokuApp;

    @Test
    public void prüfenSenkrechtTest1() {

        sudokuApp = new SudokuApp();
        boolean ergebnis = sudokuApp.pruefenSenkrecht(8, 0, matrix);
        assertEquals(true, ergebnis);
        assertFalse(sudokuApp.pruefenSenkrecht(1, 0, matrix));
        assertTrue(sudokuApp.pruefenSenkrecht(2, 0, matrix));
        assertFalse(sudokuApp.pruefenSenkrecht(3, 1, matrix));
        assertTrue(sudokuApp.pruefenSenkrecht(4, 0, matrix));
        assertFalse(sudokuApp.pruefenSenkrecht(5, 0, matrix));
        assertFalse(sudokuApp.pruefenSenkrecht(3, 8, matrix));
        assertTrue(sudokuApp.pruefenSenkrecht(6, 0, matrix));
        assertFalse(sudokuApp.pruefenSenkrecht(6, 2, matrix));
    }

    @Test
    public void prüfenSenkrechtTest2() {

        sudokuApp = new SudokuApp();
        boolean ergebnis = sudokuApp.pruefenSenkrecht(7, 4, matrix);
        assertEquals(false, ergebnis);
        assertFalse(sudokuApp.pruefenSenkrecht(5, 0, matrix));
        assertTrue(sudokuApp.pruefenSenkrecht(6, 0, matrix));
    }

    @Test
    public void prüfenWaagerechtTest1() {

        sudokuApp = new SudokuApp();
        boolean ergebnis = sudokuApp.pruefenWaagerecht(3, 4, matrix);
        assertEquals(true, ergebnis);
        assertFalse(sudokuApp.pruefenWaagerecht(5, 0, matrix));
        assertFalse(sudokuApp.pruefenWaagerecht(8, 4, matrix));
    }

    @Test
    public void pruefenQuadrad1() {

        sudokuApp = new SudokuApp();
        boolean ergebnis = sudokuApp.pruefenQuadrat(7, 4, 3, matrix);
        assertEquals(true, ergebnis);
        assertTrue(sudokuApp.pruefenQuadrat(8, 5, 6, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(9, 4, 4, matrix));
        assertTrue(sudokuApp.pruefenQuadrat(8, 5, 6, matrix));
        assertTrue(sudokuApp.pruefenQuadrat(7, 6, 4, matrix));
        assertTrue(sudokuApp.pruefenQuadrat(8, 6, 0, matrix));
        assertTrue(sudokuApp.pruefenQuadrat(1, 3, 5, matrix));
        assertTrue(sudokuApp.pruefenQuadrat(6, 4, 6, matrix));
        assertTrue(sudokuApp.pruefenQuadrat(3, 6, 7, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(5, 0, 1, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(7, 4, 7, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(1, 2, 7, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(9, 5, 5, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(7, 4, 6, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(5, 7, 6, matrix));
        assertFalse(sudokuApp.pruefenQuadrat(5, 7, 6, matrix));
    }

    @Test
    public void pruefe() {

        sudokuApp = new SudokuApp();
        boolean ergebnis = sudokuApp.pruefe(8, 4, 3, matrix);
        assertEquals(false, ergebnis);
        assertFalse(sudokuApp.pruefe(1, 2, 7, matrix));
        assertFalse(sudokuApp.pruefe(9, 5, 5, matrix));
        assertFalse(sudokuApp.pruefe(7, 4, 6, matrix));
        assertFalse(sudokuApp.pruefe(5, 7, 6, matrix));
        assertTrue(sudokuApp.pruefe(8, 0, 8, matrix));
        assertTrue(sudokuApp.pruefe(4, 0, 6, matrix));
        assertFalse(sudokuApp.pruefe(5, 0, 2, matrix));
        assertFalse(sudokuApp.pruefe(3, 0, 2, matrix));
        assertFalse(sudokuApp.pruefe(5, 7, 6, matrix));
        assertTrue(sudokuApp.pruefe(1, 0, 5, matrix));
        assertTrue(sudokuApp.pruefe(9, 4, 6, matrix));
        assertFalse(sudokuApp.pruefe(5, 0, 3, matrix));
        assertFalse(sudokuApp.pruefe(8, 4, 0, matrix));
        assertTrue(sudokuApp.pruefe(5, 1, 3, matrix));

    }

    @Test
    public void print() {

        sudokuApp = new SudokuApp();
        System.out.println(sudokuApp.print(matrix));

        String asserted = "" //
                + "  |a b c|d e f|g h i|\n" //
                + "- |- - -|- - -|- - -|\n" //
                + "1 |5    |     |     |\n" //
                + "2 |  3  |  7  |     |\n" //
                + "3 |     |     |    3|\n" //
                + "- |- - -|- - -|- - -|\n" //
                + "4 |     |     |     |\n" //
                + "5 |    6|8    |     |\n" //
                + "6 |     |    9|     |\n" //
                + "- |- - -|- - -|- - -|\n" //
                + "7 |     |     |     |\n" //
                + "8 |     |7    |    5|\n" //
                + "9 |1    |     |     |\n" //
                + "- |- - -|- - -|- - -|\n";
        assertEquals(asserted, sudokuApp.print(matrix));

    }

    @Test
    public void setze() throws Exception {

        sudokuApp = new SudokuApp();
        sudokuApp.setze(9, 3, 2, matrix);
        sudokuApp.setze(9, 8, 3, matrix);
        sudokuApp.setze(9, 2, 7, matrix);
        sudokuApp.setze(9, 7, 6, matrix);

        // System.out.println(sudokuApp.setze(zahl, x, y, matrix));

    }

    @Test
    public void setze1() throws Exception {

        sudokuApp = new SudokuApp();
        sudokuApp.setze(2, "f5", matrix);
        sudokuApp.setze(2, "b5", matrix);
        sudokuApp.setze(2, "c7", matrix);
        sudokuApp.setze(2, "d1", matrix);
        sudokuApp.setze(2, "h6", matrix);
        sudokuApp.setze(2, "e3", matrix);
        sudokuApp.setze(2, "i9", matrix);
        sudokuApp.setze(2, "f8", matrix);

    }

    @Test(expected = Exception.class)
    public void setze2() throws Exception {

        sudokuApp = new SudokuApp();
        sudokuApp.setze(2, "e2", matrix);
        sudokuApp.setze(2, "i3", matrix);
        sudokuApp.setze(2, "a1", matrix);
        sudokuApp.setze(2, "i7", matrix);
        sudokuApp.setze(2, "f5", matrix);
    }

}
