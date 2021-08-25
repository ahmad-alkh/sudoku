/**
 * 
 */
package de.intellinet.ausbildung.sudoku.loeser.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aakh1
 *
 */
public class Loesungen {

	private int iterationen = 0;

	private List<Loesung> loesungen;

	public Loesungen() {
		this.iterationen = 0;
		this.loesungen = new ArrayList<Loesung>();
	}

	public int getIterationen() {
		return iterationen;
	}

	public void setIterationen(int iterationen) {
		this.iterationen = iterationen;
	}

	public int getAnzahloesung() {
		return loesungen.size();
	}

	public List<Loesung> getLoesungen() {
		return loesungen;
	}

	public void setLoesungen(List<Loesung> loesungen) {
		this.loesungen = loesungen;
	}

	public Loesungen next() {
		iterationen++;
		return this;
	}

}
