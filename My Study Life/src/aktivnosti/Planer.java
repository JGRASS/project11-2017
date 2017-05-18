package aktivnosti;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
/**
 * Klasa koja predstavlja planer aktivnosti
 * @author Miro Maric
 * @version 1.0
 */
public class Planer {
	/**
	 * Lista studentovih aktivnosti
	 */
	public  List<Aktivnost> aktivnosti = new LinkedList<>();
	/**
	 * Matrica mesecnih datuma
	 */
	private  String[][] datumi = new String[6][7];
	/**
	 * Trenutno vreme
	 */
	private  GregorianCalendar gc = new GregorianCalendar();
	/**
	 * Metoda vraca matricu mesecnih datuma
	 * @return Datumi mesecni datumi kao String[][]
	 */
	public String[][] vratiDatume() {
		return datumi;
	}
	/**
	 * Postavlja matricu mesecnih datuma
	 * @param Datumi mesecni datumi kao String[][]
	 * @throws java.lang.RuntimeException ako je matrica datuma jednaka null
	 */
	public void postaviDatume(String[][] datumi) {
		if(datumi!=null)
			this.datumi = datumi;
		else
			throw new RuntimeException("Matrica datuma mora biti razlicita od null");
	}
	/**
	 * Vraca trenutno vreme
	 * @return Trenutno vreme kao GregorianCalendar
	 */
	public GregorianCalendar vratiGc() {
		return gc;
	}
	/**
	 * Postavlja trenutno vreme
	 * @param gc Trenutno vreme kao GregorianCalendar
	 * @throws java.lang.RuntimeException ako je uneto vreme jednako null
	 */
	public void postaviGc(GregorianCalendar gc) {
		if(gc!=null)
			this.gc = gc;
		else
			throw new RuntimeException("Datum mora biti razlicit od null");
	}
	/**
	 * Vraca sve studentove aktivnosti
	 * @return Aktivnosti kao listu Aktivnosti
	 */
	public  List<Aktivnost> vratiSveAktivnosti() {
		return aktivnosti;
	}
	/**
	 * Postavlja sve studenske aktivnosti
	 * @param Aktivnosti kao listu Aktivnosti
	 * @throws java.lang.RuntimeException ako su unete aktivnosti null
	 */
	public void postaviAktivnosti(List<Aktivnost> aktivnosti) {
		if(aktivnosti!=null)
			this.aktivnosti = aktivnosti;
		else
			throw new RuntimeException("Aktivnosti moraju biti razlicite od null");
	}
	/**
	 * Dodaje aktivnost u listu studenskih aktivnosti
	 * @param a Studenska aktivnost kao Aktivnost
	 * @throws ako je uneta aktivnost null
	 */
	public void dodajAktivnost(Aktivnost a){
		if(a!=null)
			aktivnosti.add(a);
		else
			throw new RuntimeException("Aktivnost mora biti razlicita od null");
	}
	/**
	 * Brise aktivnost iz liste studenskih aktivnosti
	 * @param a Studenska aktivnost kao Aktivnost
	 * @throws ako je uneta aktivnost null
	 */
	public void obrisiAktivnost(Aktivnost a){
		if(a!=null)
			aktivnosti.remove(a);
		else
			throw new RuntimeException("Aktivnost mora biti razlicita od null");
	}
//	/**
//	 * Proverava da su dva datuma istog dana
//	 * @param g1 Datum kao GregorianCalendar
//	 * @param g2 Datum kao GregorianCalendar
//	 * @return Boolean vrednost u zavisnosti od poklapanja unetih datuma
//	 */
//	public boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
//		return SOIstiDan.izvrsi(g1, g2);
//	}
//	/**
//	 * Pronalazi aktivnost u listi studenskih aktivnosti na osnuvu datuma odrzavanja
//	 * @param g Datum odrzavanja aktivnosti kao GregorianCalendar
//	 * @return Aktivnost ili null ako aktivnost nije pronadjena
//	 */
//	public  Aktivnost pronadjiAktivnost(GregorianCalendar g){
//		return SOPronadjiAktivnost.izvrsi(aktivnosti, g);
//	}
//	/**
//	 * Popunjava matricu mesecnih datuma
//	 */
//	public void popuniMatricuDatuma(){
//		SOPopuniMatricuDatuma.izvrsi(gc, datumi);
//	}
//	/**
//	 * Deserijalizuje listu studenskih aktivnosti
//	 */
//	public  void ucitajAktivnosti(){
//		postaviAktivnosti(SOUcitajAktivnosti.izvrsi());
//	}
//	/**
//	 * Serijalizuje listu studenskih aktivnosti
//	 */
//	public void serijalizujAktivnosti(){
//		SOSerijalizujAktivnosti.izvrsi(aktivnosti);
//	}
}
