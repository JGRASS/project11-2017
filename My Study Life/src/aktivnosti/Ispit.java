package aktivnosti;
/**
 * Klasa koja predstavlja ispit kao studensku aktvnost
 * @author Miro Maric
 * @version 1.0
 *
 */
public class Ispit extends Aktivnost{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7048815963110303140L;
	/**
	 * Ocena ispita, po defaultu je -1
	 */
	private int ocena = -1;
	
	/**
	 * Vraca ocenu predmeta
	 * @return Ocena kao int vrednost
	 */
	public int vratiOcenu() {
		return ocena;
	}
	/**
	 * Postvalja ocenu predmeta
	 * @param Ocena kao int vrednost
	 * @throws java.lang.RuntimeException ako je ocena manja od 5 ili veca od 10
	 */
	public void postaviOcenu(int ocena) {
		if(ocena<5 || ocena>10)
			throw new RuntimeException("Ocena mora biti pravilno uneta");
		this.ocena = ocena;
	}
}
