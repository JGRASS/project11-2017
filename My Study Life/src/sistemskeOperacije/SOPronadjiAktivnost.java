package sistemskeOperacije;

import java.util.GregorianCalendar;
import java.util.List;

import aktivnosti.Aktivnost;
/**
 * Klasa koja predstavlja sistemsku opraciju koja pronalazi aktivnost 
 * u listi aktivnosti na osnovu datuma odrazvanja
 * @author Miro Maric
 * @version 1.0
 */
public class SOPronadjiAktivnost {
	/**
	 * Metoda koja pronalazi aktivnost u listi aktivnosti na osnovu datuma odrazvanja
	 * @param aktivnosti Predstavlja listu aktivnosti
	 * @param g Predstavlja vreme odrzavanja aktivnosti kao GregorianCalendar
	 * @return Trazenu aktivnost ili null u suprotnom
	 */
	public static Aktivnost izvrsi(List<Aktivnost> aktivnosti, GregorianCalendar g){
		if(aktivnosti==null || g==null)
			throw new RuntimeException("Aktivnosti i datum moraju biti razliciti od null");
		for(int i=0;i<aktivnosti.size();i++){
			if(SOIstiDan.izvrsi(aktivnosti.get(i).getVremePolaganja(), g))
				return aktivnosti.get(i);
		}
		return null;
	}
}
