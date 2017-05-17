package sistemskeOperacije;

import java.util.GregorianCalendar;
/**
 * Klasa koja predstavlja sistemsku opraciju vraca datum
 * oblika GregorianCalendar u vidu Stringa format hh:mm
 * @author Miro Maric
 * @version 1.0
 */
public class SOVratiVremeString {
	/**
	 * Metoda koja vraca odredjeni GregorianCalendar(sat,minut) u String obliku
	 * @param g Datum koji se zeli prikazati u vidu Stringa
	 * @return Vreme u String formatu
	 */
	public static String izvrsi(GregorianCalendar g){
		String vreme = "";
		vreme+=g.get(GregorianCalendar.HOUR)+":";
		vreme+=g.get(GregorianCalendar.MINUTE);
		return vreme;
	}
}
