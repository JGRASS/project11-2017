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
	private  List<Aktivnost> aktivnosti = new LinkedList<>();
	private  String[][] datumi = new String[6][7];
	private  GregorianCalendar gc = new GregorianCalendar();
	
	public String[][] vratiDatume() {
		return datumi;
	}

	public void postaviDatume(String[][] datumi) {
		this.datumi = datumi;
	}

	public GregorianCalendar vratiGc() {
		return gc;
	}

	public void postaviGc(GregorianCalendar gc) {
		this.gc = gc;
	}

	public  List<Aktivnost> vratiSveAktivnosti() {
		return aktivnosti;
	}

	public void postaviAktivnosti(List<Aktivnost> aktivnosti) {
		this.aktivnosti = aktivnosti;
	}
	
	public void dodajAktivnost(Aktivnost a){
		aktivnosti.add(a);
	}
	
	public void obrisiAktivnost(Aktivnost a){
		aktivnosti.remove(a);
	}
	
	public boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
		return SOIstiDan.izvrsi(g1, g2);
	}
	
	public  Aktivnost pronadjiAktivnost(GregorianCalendar g){
		return SOPronadjiAktivnost.izvrsi(aktivnosti, g);
	}
	
	
	public  void ucitajAktivnosti(){
		postaviAktivnosti(SOUcitajAktivnosti.izvrsi());
	}
	
	public void serijalizujAktivnosti(){
		SOSerijalizujAktivnosti.izvrsi(aktivnosti);
	}
	
	public void popuniMatricuDatuma(){
		SOPopuniMatricuDatuma.izvrsi(gc, datumi);
	}
}
