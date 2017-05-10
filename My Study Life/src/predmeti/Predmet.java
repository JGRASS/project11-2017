package predmeti;

import com.sun.org.apache.xerces.internal.util.URI;

public class Predmet {
	private String naziv;
	private int ESBP;
	private String skolskaGodina;
	private boolean jednosemestralan;
	private int semestar;
	private boolean polozen;
	private int ocena;
	private String napomena;
	private URI forum;
	public URI getForum() {
		return forum;
	}

	public void setForum(URI forum) {
		if(forum==null) throw new RuntimeException("Link za forum mora biti pravilno unet"); 
		this.forum = forum;
	}

	public URI getPuskice() {
		return puskice;
	}

	public void setPuskice(URI puskice) {
		if(puskice==null) throw new RuntimeException("Link za puskice mora biti ispravno unet");
		this.puskice = puskice;
	}

	private URI puskice;
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv==null || naziv.length()<2)
			throw new RuntimeException("Naziv predeta mora biti ispravno unet");
		this.naziv = naziv;
	}

	public int getESBP() {
		return ESBP;
	}

	public void setESBP(int ESBP) {
		if(ESBP<1 || ESBP>30)
			throw new RuntimeException("Pogresno uneti ESBP bodovi");
		this.ESBP = ESBP;
	}

	public String getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(String skolskaGodina) {
		if(skolskaGodina==null || skolskaGodina.length()!=9 || !skolskaGodina.contains("/"))	
			throw new RuntimeException("Skolska goidna mora biti uneta ispravno");
		this.skolskaGodina = skolskaGodina;
	}
	
	public int getSemestar() {
		return semestar;
	}
	
	public void setSemestar(int semestar) {
		if(semestar<1 || semestar>12)
			throw new RuntimeException("Pogresno unet semestar");
		this.semestar = semestar;
	}
	
	public boolean isPolozen() {
		return polozen;
	}

	public void setPolozen(boolean polozen) {
		this.polozen = polozen;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		if(ocena<5 || ocena>10)
			throw new RuntimeException("Pogresno uneta ocena");
		this.ocena = ocena;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	
	public boolean getJednosemestralan() {
		return jednosemestralan;
	}

	public void setJednosemestralan(boolean jednosemestralan) {
		this.jednosemestralan = jednosemestralan;
	}
	
}

