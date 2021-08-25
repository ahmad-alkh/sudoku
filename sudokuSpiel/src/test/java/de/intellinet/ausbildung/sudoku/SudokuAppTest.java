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

    // @Test
    // public void prüfenSenkrechtTest1() {
    //
    // sudokuApp = new SudokuApp(matrix);
    // boolean ergebnis = sudokuApp.pruefenSenkrecht(8, 0);
    // assertEquals(true, ergebnis);
    // assertFalse(sudokuApp.pruefenSenkrecht(1, 0));
    // assertTrue(sudokuApp.pruefenSenkrecht(2, 0));
    // assertFalse(sudokuApp.pruefenSenkrecht(3, 1));
    // assertTrue(sudokuApp.pruefenSenkrecht(4, 0));
    // assertFalse(sudokuApp.pruefenSenkrecht(5, 0));
    // assertFalse(sudokuApp.pruefenSenkrecht(3, 8));
    // assertTrue(sudokuApp.pruefenSenkrecht(6, 0));
    // assertFalse(sudokuApp.pruefenSenkrecht(6, 2));
    // }
    //
    // @Test
    // public void prüfenSenkrechtTest2() {
    //
    // sudokuApp = new SudokuApp(matrix);
    // boolean ergebnis = sudokuApp.pruefenSenkrecht(7, 4);
    // assertEquals(false, ergebnis);
    // assertFalse(sudokuApp.pruefenSenkrecht(5, 0));
    // assertTrue(sudokuApp.pruefenSenkrecht(6, 0));
    // }
    //
    // @Test
    // public void prüfenWaagerechtTest1() {
    //
    // sudokuApp = new SudokuApp(matrix);
    // boolean ergebnis = sudokuApp.pruefenWaagerecht(3, 4);
    // assertEquals(true, ergebnis);
    // assertFalse(sudokuApp.pruefenWaagerecht(5, 0));
    // assertFalse(sudokuApp.pruefenWaagerecht(8, 4));
    // }
    //
    // @Test
    // public void pruefenQuadrad1() {
    //
    // sudokuApp = new SudokuApp(matrix);
    // boolean ergebnis = sudokuApp.pruefenQuadrat(7, 4, 3);
    // assertEquals(true, ergebnis);
    // assertTrue(sudokuApp.pruefenQuadrat(8, 5, 6));
    // assertFalse(sudokuApp.pruefenQuadrat(9, 4, 4));
    // assertTrue(sudokuApp.pruefenQuadrat(8, 5, 6));
    // assertTrue(sudokuApp.pruefenQuadrat(7, 6, 4));
    // assertTrue(sudokuApp.pruefenQuadrat(8, 6, 0));
    // assertTrue(sudokuApp.pruefenQuadrat(1, 3, 5));
    // assertTrue(sudokuApp.pruefenQuadrat(6, 4, 6));
    // assertTrue(sudokuApp.pruefenQuadrat(3, 6, 7));
    // assertFalse(sudokuApp.pruefenQuadrat(5, 0, 1));
    // assertFalse(sudokuApp.pruefenQuadrat(7, 4, 7));
    // assertFalse(sudokuApp.pruefenQuadrat(1, 2, 7));
    // assertFalse(sudokuApp.pruefenQuadrat(9, 5, 5));
    // assertFalse(sudokuApp.pruefenQuadrat(7, 4, 6));
    // assertFalse(sudokuApp.pruefenQuadrat(5, 7, 6));
    // assertFalse(sudokuApp.pruefenQuadrat(5, 7, 6));
    // }
    //
    // @Test
    // public void pruefe() {
    //
    // sudokuApp = new SudokuApp(matrix);
    // boolean ergebnis = sudokuApp.pruefe(8, 4, 3);
    // assertEquals(false, ergebnis);
    // assertFalse(sudokuApp.pruefe(1, 2, 7));
    // assertFalse(sudokuApp.pruefe(9, 5, 5));
    // assertFalse(sudokuApp.pruefe(7, 4, 6));
    // assertFalse(sudokuApp.pruefe(5, 7, 6));
    // assertTrue(sudokuApp.pruefe(8, 0, 8));
    // assertTrue(sudokuApp.pruefe(4, 0, 6));
    // assertFalse(sudokuApp.pruefe(5, 0, 2));
    // assertFalse(sudokuApp.pruefe(3, 0, 2));
    // assertFalse(sudokuApp.pruefe(5, 7, 6));
    // assertFalse(sudokuApp.pruefe(1, 0, 5));
    // assertTrue(sudokuApp.pruefe(9, 4, 6));
    // assertFalse(sudokuApp.pruefe(5, 0, 3));
    // assertTrue(sudokuApp.pruefe(8, 4, 0));
    // assertTrue(sudokuApp.pruefe(5, 1, 3));
    //
    // }

    @Test
    public void print() {

        sudokuApp = new SudokuApp(matrix);
        System.out.println(sudokuApp.print());

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
        assertEquals(asserted, sudokuApp.print());

    }

    @Test
    public void setze() {
        sudokuApp = new SudokuApp(matrix);

        System.out.println("Start: \n" + sudokuApp.print());
        assertTrue(sudokuApp.setze(9, 3, 2));
        System.out.println("\n-----------------------------------------\n 01: \n" + sudokuApp.print());
        assertTrue(sudokuApp.setze(9, 8, 3));
        System.out.println("\n-----------------------------------------\n 02: \n" + sudokuApp.print());
        assertTrue(sudokuApp.setze(9, 2, 7));
        System.out.println("\n-----------------------------------------\n 03: \n" + sudokuApp.print());
        assertTrue(sudokuApp.setze(9, 7, 6));
        System.out.println("\n-----------------------------------------\n 04: \n" + sudokuApp.print());
        assertFalse(sudokuApp.setze(2, 5, 5));
        System.out.println("\n-----------------------------------------\n 05: \n" + sudokuApp.print());
        assertTrue(sudokuApp.setze(8, 7, 3));
        System.out.println("\n-----------------------------------------\n 06: \n" + sudokuApp.print());

        // System.out.println(sudokuApp.setze(zahl, x, y, matrix));

    }

    public void setze2() {

        sudokuApp = new SudokuApp(matrix);
        boolean ergebnis = sudokuApp.setze(2, "e2");
        assertEquals(false, ergebnis);
        assertFalse(sudokuApp.setze(2, "i3"));
        assertFalse(sudokuApp.setze(2, "a1"));
        assertTrue(sudokuApp.setze(6, "i7"));
        assertFalse(sudokuApp.setze(7, "d8"));
        assertFalse(sudokuApp.setze(2, "f6"));
        assertTrue(sudokuApp.setze(2, "e3"));
        assertFalse(sudokuApp.setze(6, "e3"));
        assertTrue(sudokuApp.setze(8, "i9"));
        assertFalse(sudokuApp.setze(2, "i8"));
        assertTrue(sudokuApp.setze(9, 3, 2));
        assertTrue(sudokuApp.setze(9, 8, 3));
        assertTrue(sudokuApp.setze(9, 2, 7));
        assertTrue(sudokuApp.setze(9, 7, 6));
        assertFalse(sudokuApp.setze(3, "i7"));

    }

}
