package aktivnosti;
/**
 * Klasa koja predstavlja kolokvijum kao studensku aktivnost
 * @author Miro Maric
 * @version 1.0
 *
 */
public class Kolokvijum extends Aktivnost{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3603916327125780436L;
	/**
	 * Broj poena kolokvijuma, po defaultu je -1
	 */
	private double brojPoena = -1;
	/**
	 * Vraca broj poena na kolokvijumu
	 * @return Broj poena kao double vrednost
	 */
	public double vratiBrojPoena() {
		return brojPoena;
	}
	/**
	 * Postvalja broj poena kolokvijuma
	 * @param Broj poena kao double vrednost
	 * @throws java.lang.RuntimeException ako je broj poena manji od 0 ili je veci od 100
	 */
	public void postaviBrojPoena(double brojPoena) {
		if(brojPoena<0 || brojPoena>100)
			throw new RuntimeException("Osvojeni poeni moraju biti pravilno uneti");
		this.brojPoena = brojPoena;
	}
}
