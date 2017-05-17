package predmeti;

import java.io.Serializable;
/**
 * Klasa predmet, sadrz atribute predmeta
 * @author Ivan Stanimirovic
 * @author Milos Mirkovic
 * @author Miro Maric
 * @version 1.0.0
 *
 */
public class Predmet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1413778110949335752L;
	private String naziv;
	private int ESBP;
	private String skolskaGodina;
	private boolean jednosemestralan;
	private int semestar;
	private boolean polozen;
	private int ocena;
	private String napomena;
	private String forum;
	private String puskice;
	/**
	 * Konstruktor koji pravi predmet automatski
	 * @param naziv prosledjuje se naziv predmeta
	 * @param ESBP prosledjuje se broj ESBP poena
	 * @param skolskaGodina prosledjuje se skolska godina u obliku xxxx/xxxx
	 * @param jednosemestralan prosledjuje se boolean vrednost da li je jednosemestralan ili nije
	 * @param semestar prosledjuje se broj semestra
	 * @param polozen prosledjuje se boolean vrednost da li je polozen ili ne
	 * @param ocena prosledjuje se ocena
	 * @param napomena napomena za neki predmet u slucaju da je ima
	 * @param forum prosledjuje se string koji predstavlja link za FONForum
	 * @param puskice prosledjuje se string koji predstavlja link za sajt puskice
	 */
	public Predmet(String naziv, int ESBP, String skolskaGodina, boolean jednosemestralan, int semestar, boolean polozen, int ocena,String napomena, String forum, String puskice) {
		setESBP(ESBP);
		setForum(forum);
		setJednosemestralan(jednosemestralan);
		setNapomena(napomena);
		setNaziv(naziv);
		setOcena(ocena);
		setPolozen(polozen);
		setPuskice(puskice);
		setSemestar(semestar);
		setSkolskaGodina(skolskaGodina);
	}
	/**
	 * Vraca link za sajt FONForum
	 * @return
	 */
	public String getForum() {
		return forum;
	}
	/**
	 * Postavlja novi link za sajt FONForum
	 * @param Link koji zelimo da postavimo
	 */
	public void setForum(String forum) {
		if(forum==null) throw new RuntimeException("Link za forum mora biti pravilno unet"); 
		this.forum = forum;
	}
	/**
	 * Vraca link za sajt Puskice
	 * @return
	 */
	public String getPuskice() {
		return puskice;
	}
	/**
	 * Postavlja novi link za sajt Puskice
	 * @param Link koji zelimo da postavimo
	 */
	public void setPuskice(String puskice) {
		if(puskice==null) throw new RuntimeException("Link za puskice mora biti ispravno unet");
		this.puskice = puskice;
	}

	/**
	 * Vraca naziv predmeta
	 * @return
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * Postavlja novi naziv za predmet
	 * @param Naziv koji zelimo da postavimo
	 */
	public void setNaziv(String naziv) {
		if(naziv==null || naziv.length()<2)
			throw new RuntimeException("Naziv predeta mora biti ispravno unet");
		this.naziv = naziv;
	}
	/**
	 * Vraca broj ESBP poena koji ovaj predmet nosi
	 * @return
	 */
	public int getESBP() {
		return ESBP;
	}
	/**
	 * Postavlja novu vrednost ESBP poena za ovaj predmet
	 * @param Vrednost ESBP poena
	 */
	public void setESBP(int ESBP) {
		if(ESBP<1 || ESBP>30)
			throw new RuntimeException("Pogresno uneti ESBP bodovi");
		this.ESBP = ESBP;
	}
	/**
	 * Vraca u kojoj skolskoj godini se pohadja predmet
	 * @return
	 */
	public String getSkolskaGodina() {
		return skolskaGodina;
	}
	/**
	 * Postavlja novu vrednost za skolsku godinu u kojoj se polaze predmet
	 * @param Vrednost za godinu koju zelimo da postavimo
	 */
	public void setSkolskaGodina(String skolskaGodina) {
		if(skolskaGodina==null || skolskaGodina.length()!=9 || !skolskaGodina.contains("/"))	
			throw new RuntimeException("Skolska goidna mora biti uneta ispravno");
		this.skolskaGodina = skolskaGodina;
	}
	/**
	 * Vraca u kom semestru se pohadja predmet
	 * @return
	 */
	public int getSemestar() {
		return semestar;
	}
	/**
	 * Postavlja semestar u kom se predmet pohadja 
	 * @param Broj semestra koji zelimo da postavimo
	 */
	public void setSemestar(int semestar) {
		if(semestar<1 || semestar>12)
			throw new RuntimeException("Pogresno unet semestar");
		this.semestar = semestar;
	}
	/**
	 * Proverava da li je ovaj predmet polozen
	 * @return 
	 */
	public boolean isPolozen() {
		return polozen;
	}
	
	/**
	 * Postavlja vrednost atributa koji odredjuje da li je predmet polozen ili ne.
	 * @param True ili false u zavisnosti da li je predmet polozen ili ne.
	 */
	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}
	
	/**
	 * Vraca vrednost ocene ako je predmet polozen
	 * @return
	 */
	public int getOcena() {
		return ocena;
	}
	
	/**
	 * Postavlja vrednost ocene.
	 * @param Zeljena ocena
	 */
	public void setOcena(int ocena) {
		if(ocena<5 || ocena>10)
			throw new RuntimeException("Pogresno uneta ocena");
		this.ocena = ocena;
	}
	
	/**
	 * Vraca napomenu o ovom predmetu
	 * @return
	 */
	public String getNapomena() {
		return napomena;
	}
	
	/**
	 * Zapisuje novu napomenu za predmetu
	 * @param Napomena u string formatu
	 */
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	/**
	 * Proverava da li je predmet jednosemestralan.
	 * @return
	 */
	public boolean getJednosemestralan() {
		return jednosemestralan;
	}
	
	/**
	 * Postavlja da li je predmet jednosemestralan ili dvosemestralan.
	 * @param Postavljanjem ovog parametra na true, predmet se smatra jednosemestralnim, ako je false onda je dvosemestralan
	 */
	public void setJednosemestralan(boolean jednosemestralan) {
		this.jednosemestralan = jednosemestralan;
	}
	
	/**
	 * Preradjena equals metoda, proverava da li su naziv, ESBP poeni i skolska godina jednaki, ako jesu vraca true.
	 * u suprotnom false.
	 * @param Predmet sa kojim poredimo ovaj predmet.
	 */
	@Override
	public boolean equals(Object obj) {
		Predmet p = (Predmet)obj;
		if(p.getNaziv().equals(naziv) && p.getESBP()==getESBP() && p.getSkolskaGodina().equals(getSkolskaGodina())){
			return true;
		}
		return false;
	}
}

