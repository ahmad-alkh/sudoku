/**
 * 
 */
package de.intellinet.ausbildung.sudoku.loeser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.intellinet.ausbildung.sudoku.loeser.models.Loesung;

/**
 * @author aakh1
 *
 */

public class LoesungInDatei {
	private static Logger logger = LoggerFactory.getLogger(LoesungInDatei.class);
	Sudokuloeser1 sodukuloeser1 = new Sudokuloeser1();

	public void speichereDatei(String fileName, List<Loesung> loesungen) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName);
			for (Loesung loesung : loesungen) {

				writer.write(loesung.toString());
				writer.append(System.getProperty("line.separator")); // e.g. "\n"

			}

		} catch (IOException e) {
			logger.error("Konnte Datei nicht erstellen");
			throw new RuntimeException("Konnte Datei nicht erstellen", e);
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					logger.error("Fehler beim Schliessen des Writers ");
					throw new RuntimeException("Fehler beim Schliessen des Writers ", e);
				}
		}

	}

}
