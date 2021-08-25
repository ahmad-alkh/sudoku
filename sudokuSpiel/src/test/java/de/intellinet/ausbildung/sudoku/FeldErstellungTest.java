/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.sudoku;

import org.junit.Test;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 23.10.2019
 */
public class FeldErstellungTest {

    private SpielNiveau niveau;

    @Test
    public void test() {
        new FeldErstellung().feldErstellen(null);
    }

    @Test
    public void testMatrix() {
        int[][] matrix = new int[4][8];

        // assertEquals(4, matrix.length);
        // assertEquals(8, matrix[0].length);

    }

}
