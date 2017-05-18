package sistemskeOperacije;

import java.util.Random;
/**
 * Klasa koja predstavlja sistemsku opraciju koja vraca nasumican naziv slike
 * @author MikoPC
 * @version 1.0
 */
public class SOVratiNazivSlike {
	/**
	 * Metoda koja vraca nasumican naziv slike
	 * @return naziv slike kao String
	 */
	public static String izvrsi() {
		int broj;
		Random r = new Random();
		broj=r.nextInt(5)+1;
		
		return "/"+broj+".jpg";
	}}
