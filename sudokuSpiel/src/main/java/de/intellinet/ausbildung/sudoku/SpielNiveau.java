
package de.intellinet.ausbildung.sudoku;

public enum SpielNiveau {
    LEICHT(5),
    MITTEL(6),
    SCHWER(7),
    EXPERTE(8);

    public int val;

    SpielNiveau(int x) {
        this.val = x;

    }
}
