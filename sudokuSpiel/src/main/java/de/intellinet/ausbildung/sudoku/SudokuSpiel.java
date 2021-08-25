/*
 * Intellinet Beratung und Technologie GmbH
 */

package de.intellinet.ausbildung.sudoku;

import java.util.Scanner;

/**
 * [TODO Insert description here.]
 * 
 * @author ahmalk
 *
 * @since 16.10.2019
 */
public class SudokuSpiel {

    /**
     * 
     * TODO Comment
     * 
     * @param args
     */

    public static void main(String[] args) {
        new SudokuSpiel().spiele();
    }

    /**
     * 
     * TODO Comment
     */
    public void spiele() {
        System.out.println("Hinweise: um das Programm zu schließen,geben sie 'exit' ein.\n");
        Scanner eingabe1 = new Scanner(System.in);
        // int[][] ursprungsMatrix = [9][9];
        String sp = eingabe1.nextLine().trim();
        SudokuApp sudokuApp;
        if (sp.equals("spiel")) {
            SpielNiveau level1 = level(eingabe1);
            sudokuApp = new SudokuApp(createMatrix(level1));
        } else {
            sudokuApp = new SudokuApp(new int[9][9]);
        }

        System.out.println(sudokuApp.print());

        while (!sudokuApp.pruefeFeldVoll()) {
            Scanner eingabe = new Scanner(System.in);

            String pos = getKoordinate(eingabe);
            if (pos.equals("exit")) {
                System.out.println("spiel Enden(y) oder Lösen(Enter)");
                String ss = eingabe1.nextLine().trim();
                if (ss.equals("y")) {
                    break;
                } else {
                    System.out.println("lösung");
                    // hier sollte ein Methed aufgerufen, um zu lösen
                    int[][] loesen = sudokuApp.loesen();
                    sudokuApp = new SudokuApp(loesen);

                    System.out.println(sudokuApp.print());

                    break;

                }

            }
            if (sudokuApp.pruefePos(pos) == false) {

            } else {

                int zahl = getZahl(eingabe);

                if (sudokuApp.setze(zahl, pos) == true) {

                    System.out.println(sudokuApp.print());

                } else {
                    System.out.println("²²Bitte prüfen Sie die Zahl²²");
                }
            }
        }
        System.out.println("Das Spiel ist beendet");

    }

    /**
     * 
     * TODO Comment
     * 
     * 
     * @param eingabe
     * @return
     */
    public int getZahl(Scanner eingabe) {

        try {

            System.out.print("Bitte geben Sie die Zahl ein: ");
            int zahl = eingabe.nextInt();
            return zahl;
        } catch (Exception a) {
            eingabe.next();
            return this.getZahl(eingabe);
        }
    }

    /**
     * 
     * TODO Comment
     * 
     * @param eingabe
     * @return
     */
    public String getKoordinate(Scanner eingabe) {

        System.out.print("Bitte geben Sie die Feldkoordinaten ein: ");
        String pos = eingabe.nextLine().trim();

        return pos;
    }

    public SpielNiveau level(Scanner eingabe1) {

        System.out.print("Bitte geben Sie den Level ein: LEICHT,MITTEL,SCHWER oder EXPERTE ");
        String level = eingabe1.nextLine().trim();

        SpielNiveau schwierigkeit = SpielNiveau.LEICHT;
        level = level.toUpperCase();
        // SpielNiveau.valueOf(level);

        switch (level) {
            case "LEICHT":
                schwierigkeit = SpielNiveau.LEICHT;
                break;
            case "MITTEL":

                schwierigkeit = SpielNiveau.MITTEL;
                break;
            case "SCHWER":

                schwierigkeit = SpielNiveau.SCHWER;
                break;
            case "EXPERTE":
                schwierigkeit = SpielNiveau.EXPERTE;
                break;

            default:
                return this.level(eingabe1);
        }

        return schwierigkeit;
    }

    private int[][] createMatrix(SpielNiveau niveau) {
        FeldErstellung feldErstellung = new FeldErstellung();

        int[][] ursprungsMatrix = feldErstellung.feldErstellen(niveau);

        // = {//
        // {5, 0, 0, 0, 0, 0, 0, 0, 0}, //
        // {0, 3, 0, 0, 7, 0, 0, 0, 0}, //
        // {0, 0, 0, 0, 0, 0, 0, 0, 3}, //
        // {0, 0, 0, 0, 0, 0, 0, 0, 0}, //
        // {0, 0, 6, 8, 0, 0, 0, 0, 0}, //
        // {0, 0, 0, 0, 0, 9, 0, 0, 0}, //
        // {0, 0, 0, 0, 0, 0, 0, 0, 0}, //
        // {0, 0, 0, 7, 0, 0, 0, 0, 5}, //
        // {1, 0, 0, 0, 0, 0, 0, 0, 0}};

        return ursprungsMatrix;
    }
}
