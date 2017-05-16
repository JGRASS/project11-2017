package aktivnosti;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import sistemskeOperacije.SOIstiDan;
import sistemskeOperacije.SOPopuniMatricuDatuma;
import sistemskeOperacije.SOPronadjiAktivnost;
import sistemskeOperacije.SOSerijalizujAktivnosti;
import sistemskeOperacije.SOUcitajAktivnosti;

public class Planer {
	public  List<Aktivnost> aktivnosti = new LinkedList<>();
	private  String[][] datumi = new String[6][7];
	private  GregorianCalendar gc = new GregorianCalendar();
	
	public String[][] vratiDatume() {
		return datumi;
	}

	public void postaviDatume(String[][] datumi) {
		if(datumi!=null)
			this.datumi = datumi;
		else
			throw new RuntimeException("Matrica datuma mora biti razlicita od null");
	}

	public GregorianCalendar vratiGc() {
		return gc;
	}

	public void postaviGc(GregorianCalendar gc) {
		if(gc!=null)
			this.gc = gc;
		else
			throw new RuntimeException("Datum mora biti razlicit od null");
	}

	public  List<Aktivnost> vratiSveAktivnosti() {
		return aktivnosti;
	}

	public void postaviAktivnosti(List<Aktivnost> aktivnosti) {
		if(aktivnosti!=null)
			this.aktivnosti = aktivnosti;
		else
			throw new RuntimeException("Aktivnosti moraju biti razlicite od null");
	}
	
	public void dodajAktivnost(Aktivnost a){
		if(a!=null)
			aktivnosti.add(a);
		else
			throw new RuntimeException("Aktivnost mora biti razlicita od null");
	}
	
	public void obrisiAktivnost(Aktivnost a){
		if(a!=null)
			aktivnosti.remove(a);
		else
			throw new RuntimeException("Aktivnost mora biti razlicita od null");
	}
	
	public boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
		return SOIstiDan.izvrsi(g1, g2);
	}
	
	public  Aktivnost pronadjiAktivnost(GregorianCalendar g){
		return SOPronadjiAktivnost.izvrsi(aktivnosti, g);
	}
	
	public void popuniMatricuDatuma(){
		SOPopuniMatricuDatuma.izvrsi(gc, datumi);
	}
	
	public  void ucitajAktivnosti(){
		postaviAktivnosti(SOUcitajAktivnosti.izvrsi());
	}
	
	public void serijalizujAktivnosti(){
		SOSerijalizujAktivnosti.izvrsi(aktivnosti);
	}
}
