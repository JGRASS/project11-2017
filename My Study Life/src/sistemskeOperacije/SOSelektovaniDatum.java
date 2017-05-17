package sistemskeOperacije;

import java.util.GregorianCalendar;

import gui.GUIKontroler;
import gui.modeli.MojaTabela;
/**
* Klasa koja predstavlja sistemsku opraciju koja vraca datumu
* u tabeli MojaTabela
* @author Miro Maric
* @version 1.0
*/
public class SOSelektovaniDatum {
	/**
	 * Metoda koja vraca selektovani datum u tabeli MojaTabela
	 * @param table koja predstavlja MojaTabela
	 * @return datum u obliku int
	 */
	public static GregorianCalendar izvrsi(MojaTabela table) {
		GregorianCalendar g = new GregorianCalendar();
		int datum = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		g.set(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR),
				GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH), datum);
		return g;
	}
}
