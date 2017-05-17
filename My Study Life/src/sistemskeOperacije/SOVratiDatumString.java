package sistemskeOperacije;

import java.util.GregorianCalendar;
/**
 * Klasa koja predstavlja sistemsku opraciju koja vraca datum oblika
 * GregorianCalendar u vidu Stringa format: yyyy/mm/dd
 * @author Miro Maric
 * @version 1.0
 */
public class SOVratiDatumString {
	/**
	 * Metoda koja vraca odredjeni GregorianCalendar(godina,mesec,dan) u String obliku
	 * @param g Datum koji se zeli prikazati u vidu Stringa
	 * @return Datum u String formatu
	 */
	public static String izvrsi(GregorianCalendar g){
		String vreme = "";
		vreme+=g.get(GregorianCalendar.YEAR)+"/";
		vreme+=g.get(GregorianCalendar.MONTH)+"/";
		vreme+=g.get(GregorianCalendar.DATE)+" ";
		return vreme;
	}
}
