package gui;

import java.awt.EventQueue;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import aktivnosti.*;
import gui.modeli.MojaTabela;
import gui.modeli.PlanerTabelaModel;
import predmeti.Predmet;
import sistemskeOperacije.SOAzurirajListuPolozenih;
import sistemskeOperacije.SOAzurirajProsek;
import sistemskeOperacije.SOAzurirajTabeluPolozenih;
import sistemskeOperacije.SOAzurirajTabeluPredmeta;
import sistemskeOperacije.SOOtvoriDodajPredmet;
import sistemskeOperacije.SOOtvoriIzmeniPredmet;
import sistemskeOperacije.SOOtvoriPregledPredmeta;
import sistemskeOperacije.SOSerijalizujPolozene;
import sistemskeOperacije.SOSerijalizujPredmete;
import sistemskeOperacije.SOUcitajPolozene;
import sistemskeOperacije.SOUcitajPredmete;
import sistemskeOperacije.SOVratiESPB;
import sistemskeOperacije.SOVratiNazivSlike;
import sistemskeOperacije.SOVratiProsek;
/**
 * 
 * @author Ivan Stanimirovic
 * @author Milos Mirkovic
 * @author Miro Maric
 * @version 1.0.0
 *
 */
public class GUIKontroler {
	
	private static Planer planer;
	private static GlavniProzorGUI glavniProzor ; //Ovde pravite staticke promeljive. Njima posle pristupamo pomocu GuiKontroler.xxx iz bilo koje druge klase.
	private static DodajKolokvijumGUI dodajKolokvijum;
	private static DodajIspitGUI dodajIspit;
	private static OpisAktivnostiGUI opisAktivnosti;
	public static List<Predmet> predmeti = new LinkedList<>();
	public static List<Predmet> polozeni = new LinkedList<>();
	//Ovu listu moramo da serijalizujemo/deserijalizujemo prilikom zatvaranja/otvaranja programa.
	//Osim ove, moramo imati jos i liste predmeti,polozeniIspiti...
	public static void main(String[] args) {
		ucitajPredmete();
		ucitajPolozene();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planer = new Planer();
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
					
					planer.postaviGc(new GregorianCalendar());
					planer.popuniMatricuDatuma();
					planer.ucitajAktivnosti();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void otvoriDodajKolokvujumGUI() {
		dodajKolokvijum = new DodajKolokvijumGUI();
		dodajKolokvijum.setVisible(true);
	}
	
	public static void otvoriDodajIspitGUI() {
		dodajIspit = new DodajIspitGUI();
		dodajIspit.setVisible(true);
	}
	
	public static void otvoriOpisAktivnosti() {
		opisAktivnosti = new OpisAktivnostiGUI();
		opisAktivnosti.setVisible(true);
	
	}
	
	public static List<Aktivnost> vratiSveAktivnosti(){
		return planer.vratiSveAktivnosti();
	}
	
	public static GregorianCalendar vratiTrenutnoVreme(){
		return planer.vratiGc();
	}
	
	public static String[][] vratiDatume(){
		return planer.vratiDatume();
	}
	
	public static boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
		return planer.istiDan(g1, g2);
	}
	
	public static void popuniMatricuDatuma(){
		planer.popuniMatricuDatuma();
	}
	
	public static Aktivnost pronadjiAktivnost(GregorianCalendar g){
		return planer.pronadjiAktivnost(g);
	}
	public static void serijalizujAktivnosti(){
		planer.serijalizujAktivnosti();
	}
	
	/**
	 * Metoda azurira jTable
	 * @param teble prestvlja tabelu koja se azurira
	 */
	public static void azurirajTabelu(MojaTabela table) {
		PlanerTabelaModel model = (PlanerTabelaModel) table.getModel();
		model.azurirajTabelu(vratiDatume());
	}
	
	/**
	 * Metoda koja vraca selektovani datum u tabeli MojaTabela
	 * @return datum u obliku int
	 */
	public static GregorianCalendar selektovanDatum(MojaTabela table) {
		GregorianCalendar g = new GregorianCalendar();
		int datum = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		g.set(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR),
				GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH), datum);
		return g;
	}
	/**
	 * Metoda koja vraca odredjeni GregorianCalendar(godina,mesec,dan) u String obliku
	 * @param g Datum koji se zeli prikazati u vidu Stringa
	 * @return Datum u String formatu
	 */
	public static String vratiDatumString(GregorianCalendar g){
		String vreme = "";
		vreme+=g.get(GregorianCalendar.YEAR)+"/";
		vreme+=g.get(GregorianCalendar.MONTH)+"/";
		vreme+=g.get(GregorianCalendar.DATE)+" ";
		return vreme;
	}
	/**
	 * Metoda koja vraca odredjeni GregorianCalendar(sat,minut) u String obliku
	 * @param g Datum koji se zeli prikazati u vidu Stringa
	 * @return Vreme u String formatu
	 */
	public static String vratiVremeString(GregorianCalendar g){
		String vreme = "";
		vreme+=g.get(GregorianCalendar.HOUR)+":";
		vreme+=g.get(GregorianCalendar.MINUTE);
		return vreme;
	}
	/**
	 * Metoda koja nalazi index predmeta(pozicija u listi) na osnovu njegovog naziva
	 * @param naziv Naziv predmeta
	 * @return index predmeta u listi predmeta 
	 */
	public static int vratiIndexPredmeta(String naziv){
		for(int i=0;i<GUIKontroler.predmeti.size();i++){
			if(GUIKontroler.predmeti.get(i).getNaziv().equals(naziv))
				return i;
		}
		return -1;
	}
	/**
	 * Metoda sluzi za vracanje random imena slike koja se koristi kao pozadina glavnog prozora
	 * @return String vrednost koja predstavlja naziv slike
	 */
	public static String vratiNazivSlike() {
		return SOVratiNazivSlike.izvrsi();
	}
	/**
	 * Metoda se koristi za ucitavanje predmeta iz fajla
	 */
	public static void ucitajPredmete(){
		SOUcitajPredmete.izvrsi();
	}
	/**
	 * Metoda se korsiti za serializaciju predmeta u file
	 */
	public static void serijalizujPredmete(){
		SOSerijalizujPredmete.izvrsi();
		
	}
	/**
	 * Metoda se koristi za ucitavanje polozenih predmeta iz fajla
	 */
	public static void ucitajPolozene(){
		SOUcitajPolozene.izvrsi();
	}
	/**
	 * Metoda se koristi za serializaciju polozenih predmeta u file
	 */
	public static void serijalizujPolozene(){
		SOSerijalizujPolozene.izvrsi();
	}
	/**
	 *Metoda se koristi za azuriranje tabele predmeta iz liste predmet
	 */
	public static void azurirajTabeluPredmet(){
		SOAzurirajTabeluPredmeta.izvrsi();
		
	}
	/**
	 * Metoda se koristi za azuriranje tebele polozenih ispita iz liste polozeni ispiti
	 */
	public static void azurirajTabeluPolozeni(){
		SOAzurirajTabeluPolozenih.izvrsi();
	}
	/**
	 * Metoda se koristi za azuriranje liste polozenih predmeta iz liste predmeta
	 */
	public static void azurirajListuPolozeni(){
		SOAzurirajListuPolozenih.izvrsi();
	}
	/**
	 * Metoda otvara novi GUI za dodavanje predmeta
	 */
	public static void otvoriDodajPredmetGUI(){
		SOOtvoriDodajPredmet.izvrsi();
	}
	/**
	 * Metoda otvara novi Gui za izmenu predmeta
	 */
	public static void otvoriIzmeniPredmetGUI(){
		SOOtvoriIzmeniPredmet.izvrsi();
	}
	/**
	 * Metoda otvara novi GUI za pregled predmeta
	 */
	public static void otvoriPregledPredmeta(){
		SOOtvoriPregledPredmeta.izvrsi();
	}
	/**
	 * Metoda sluzi za vracanje prosecne ocene
	 * @return double vrednost koje predstavlja prosecnu ocenu
	 */
	public static double vratiProsek(){
		return SOVratiProsek.izvrsi();
	}
	public static void azurirajProsek(){
		SOAzurirajProsek.izvrsi();
	}
	public static int vratiESPB(){
		return SOVratiESPB.izvrsi();
	}
}
