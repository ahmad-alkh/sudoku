package de.intellinet.ausbildung.sudoku.loeser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.sudoku.loeser.models.Loesung;

public class LoesungInCSVDateiExportiern {
	private static Logger logger = LoggerFactory.getLogger(LoesungInCSVDateiExportiern.class);
	Sudokuloeser1 sodukuloeser1 = new Sudokuloeser1();

	private String delimiter = ";";

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/**
	 * //Hier wird die CSV exportiert
	 * 
	 * @param loesungen
	 * @param filename
	 */
	public void exportCsv(List<Loesung> loesungen, String filename) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);

//			printer.printRecord(loesungen);
			for (Loesung loesung : loesungen) {
//				schreibeLoesung(writer, loesung);
				schreibeLoesung(printer, loesung);
			}

//			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("Fehler beim Schliessen des Writers ");
			throw new RuntimeException("Fehler beim Schliessen des Writers ", e);
		}
	}

	private void schreibeLoesung(CSVPrinter printer, Loesung loesung) throws IOException {
		if (loesung == null) {
			return;
		}

		for (int i = 0; i < loesung.getMatrix().length; i++) {
			int[] zeile = loesung.getMatrix()[i];
			printer.printRecord(objektUmwandlung(zeile));
		}

	}

	/**
	 * @param zeile
	 * @return
	 */
	public List<Integer> objektUmwandlung(int[] zeile) {
		List<Integer> lisrte = new ArrayList<>();
		for (int j : zeile) {
			lisrte.add(new Integer(j));
		}
		return lisrte;
	}

//hier wird die Datei geschreben 
	private void schreibeLoesung(Appendable writer, Loesung loesung) throws IOException {
		if (loesung == null) {
			return;
		}

		for (int i = 0; i < loesung.getMatrix().length; i++) {
			for (int j = 0; j < loesung.getMatrix()[i].length; j++) {
				int j2 = loesung.getMatrix()[i][j];
				appendCsv(writer, j2);
			}
			fugeeineNeuZeilzu(writer);
		}

	}

// hier wird dursch Iteriert 
	private void schreibeLoesung2(Loesung loesung) throws IOException {
		if (loesung == null) {
			return;
		}

		for (int i = 0; i < loesung.getMatrix().length; i++) {

			int[] x = loesung.getMatrix()[i];

		}

	}

//hier wird neu Zeil hinzugefuegt
	private void fugeeineNeuZeilzu(Appendable writer) throws IOException {
		writer.append(System.getProperty("line.separator"));

	}

//hier wird die Csv datei geschriben 
	private void appendCsv(Appendable writer, int j2) throws IOException {

		writer.append(String.valueOf(j2));
		writer.append(';');

	}

}
