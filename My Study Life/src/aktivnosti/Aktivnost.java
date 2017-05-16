package aktivnosti;

import java.io.Serializable;
import java.util.GregorianCalendar;
import predmeti.Predmet;
/**
 * Klasa koja predstavlja studensku aktivnost
 * @author Miro Maric
 * @version 1.0
 *	
 */
public abstract class Aktivnost implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1052336165491682692L;
	/**
	 * Naziv predmeta
	 */
	public Predmet predmet;
	/**
	 * Vreme odrzavanja aktivnosti
	 */
	private GregorianCalendar vremePolaganja;
	/**
	 * Mesto odrzavanja aktivnosti
	 */
	private String mesto;
	/**
	 * Evedencija rezultata aktivnosti
	 */
	private boolean evidentirana = false;

	/**
	 * Vraca naziv predmeta
	 * @return Naziv predmeta kao String
	 */
	public Predmet getPredmet() {
		return predmet;
	}
	/**
	 * Postavlja predmet iz koga se realizuje data aktivnost
	 * @param Predmet naziv predmeta kao String
	 * @throws java.lang.RuntimeException ako je uneti predmet null
	 */
	public void setPredmet(Predmet predmet) {
		if (predmet != null)
			this.predmet = predmet;
		else
			throw new RuntimeException("Predmet ne moze biti null");
	}
	/**
	 * Vraca vreme odrzavanja aktivnosti
	 * @return VremePolaganja kao GregorianCalendar
	 */
	public GregorianCalendar getVremePolaganja() {
		return vremePolaganja;
	}
	/**
	 * Postavlja vreme odrzavanja aktivnosti
	 * @param vremePolaganja kao GregorianCalendar
	 */
	public void setVremePolaganja(GregorianCalendar vremePolaganja) {
		if (vremePolaganja != null)
			this.vremePolaganja = vremePolaganja;
	}
	/**
	 * Vraca mesto odrzavanja aktivnosti
	 * @return Mesto odrzavanja aktivnosti kao String
	 */
	public String getMesto() {
		return mesto;
	}
	/**
	 * Postavlja mesto odrzavanja aktivnosti
	 * @param Mesto odrzavanja aktivnosti kao String
	 */
	public void setMesto(String mesto) {
		if (mesto != null && mesto.length() >= 2)
			this.mesto = mesto;
	}
	/**
	 * Vraca informaciju o tome da li su rezultati aktivnosti evidentirani
	 * @return Informaciju o tome da li je evidentiran rezultat aktivnosti
	 */
	public boolean isEvidentirana() {
		return evidentirana;
	}

	/**
	 * Postavlja onformaciju o evidentiranosti rezultata aktivnosti
	 * @param evidentirana -Inforacija o evidentiranosti rezultata kao boolean vrednost
	 */
	public void setEvidentirana(boolean evidentirana) {
		this.evidentirana = evidentirana;
	}
	
}
