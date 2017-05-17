package gui;

import java.awt.Color;
import java.awt.EventQueue;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import aktivnosti.*;
import gui.modeli.MojaTabela;
import gui.modeli.PlanerTabelaModel;
import gui.raspored.DodajObavezu;
import gui.raspored.IzbrisiObavezu;
import predmeti.Predmet;
import sismeskiKontroler.SistemskiKontroler;
/**
 * 
 * @author Ivan Stanimirovic
 * @author Milos Mirkovic
 * @author Miro Maric
 * @version 1.0.0
 *
 */
public class GUIKontroler {
	
	private static Planer planer  = SistemskiKontroler.planer;
	private static GlavniProzorGUI glavniProzor ;
	private static DodajKolokvijumGUI dodajKolokvijum;
	private static DodajIspitGUI dodajIspit;
	private static OpisAktivnostiGUI opisAktivnosti;
	private static PregledKolokvijumaGUI pregledKolokvijuma;
	private static DodajObavezu dodajObavezu;
	private static IzbrisiObavezu izbrisiObavezu;
	public static List<Predmet> predmeti = new LinkedList<>();
	public static List<Obaveza> obaveze = new LinkedList<>();
	public static List<Predmet> polozeni = new LinkedList<>();
	public static SistemskiKontroler SK = new SistemskiKontroler();
	public static Color plavaT = new Color(0, 155, 179);
	public static Color plavaS = new Color(112, 155, 179);
	public static void main(String[] args) {
		postaviGc();
		ucitajPredmete();
		ucitajPolozene();
		ucitajAktivnosti();
		ucitajObaveze();
		popuniMatricuDatuma();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Metoda otvara prozor DodajKolokvijumGUI
	 */
	public static void otvoriDodajKolokvujumGUI() {
		dodajKolokvijum = new DodajKolokvijumGUI();
		dodajKolokvijum.setVisible(true);
	}
	/**
	 * Metoda otvara prozor DodajIspitGUI
	 */
	public static void otvoriDodajIspitGUI() {
		dodajIspit = new DodajIspitGUI();
		dodajIspit.setVisible(true);
	}
	/**
	 * Metoda otvara prozor OpisAktivnosti
	 */
	public static void otvoriOpisAktivnosti() {
		opisAktivnosti = new OpisAktivnostiGUI();
		opisAktivnosti.setVisible(true);
	
	}
	/**
	 * Metoda otvara prozor PregledAktivnostiGUIGUI
	 */
	public static void otvoriPregledAktivnosti(){
		pregledKolokvijuma = new PregledKolokvijumaGUI();
		pregledKolokvijuma.setVisible(true);
	}
	public static void otvoriDodajObavezu() {
		dodajObavezu = new DodajObavezu();
		dodajObavezu.setVisible(true);
	
	}
	
	public static void otvoriIzbrisiObavezu(){
		izbrisiObavezu = new IzbrisiObavezu();
		izbrisiObavezu.setVisible(true);
	}
	
	public static void dodajObavezu(Obaveza o){
		SK.dodajObavezu(o);
	}
	
	public static void izbrisiObavezu(Obaveza o){
		SK.izbrisiObavezu(o);
	}
	
	public static List<Aktivnost> vratiSveAktivnosti(){
		return SistemskiKontroler.vratiSveAktivnosti();
	}
	
	public static GregorianCalendar vratiTrenutnoVreme(){
		return SistemskiKontroler.vratiTrenutnoVreme();
	}
	
	public static String[][] vratiDatume(){
		return SistemskiKontroler.vratiDatume();
	}
	
	public static boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
		return SistemskiKontroler.istiDan(g1, g2);
	}
	
	public static void popuniMatricuDatuma(){
		SistemskiKontroler.popuniMatricuDatuma();
	}
	
	public static Aktivnost pronadjiAktivnost(GregorianCalendar g){
		return SistemskiKontroler.pronadjiAktivnost(g);
	}
	
	public static void postaviGc (){
		SistemskiKontroler.postaviGc();
	}
	
	public static void serijalizujAktivnosti(){
		SistemskiKontroler.serijalizujAktivnosti();
	}
	
	public static void ucitajAktivnosti(){
		SistemskiKontroler.ucitajAktivnosti();
	}
	
	public static void azurirajTabelu(MojaTabela table) {
		SistemskiKontroler.azurirajTabelu(table);
	}
	
	public static GregorianCalendar selektovanDatum(MojaTabela table) {
		return SistemskiKontroler.selektovanDatum(table);
	}
	
	public static String vratiDatumString(GregorianCalendar g){
		return SistemskiKontroler.vratiDatumString(g);
	}
	
	public static String vratiVremeString(GregorianCalendar g){
		return SistemskiKontroler.vratiVremeString(g);
	}
	
	public static int vratiIndexPredmeta(String naziv){
		return SistemskiKontroler.vratiIndexPredmeta(naziv);
	}
	/**
	 * Metoda sluzi za vracanje random imena slike koja se koristi kao pozadina glavnog prozora
	 * @return String vrednost koja predstavlja naziv slike
	 */
	public static String vratiNazivSlike() {
		return SK.vratiNazivSlike();
	}
	/**
	 * Metoda se koristi za ucitavanje predmeta iz fajla
	 */
	public static void ucitajPredmete(){
		SK.ucitajPredmete();
	}
	/**
	 * Metoda se korsiti za serializaciju predmeta u file
	 */
	public static void serijalizujPredmete(){
		SK.serijalizujPredmete();
		
	}
	/**
	 * Metoda se koristi za ucitavanje polozenih predmeta iz fajla
	 */
	public static void ucitajPolozene(){
		SK.ucitajPolozene();
	}
	/**
	 * Metoda se koristi za serializaciju polozenih predmeta u file
	 */
	public static void serijalizujPolozene(){
		SK.serijalizujPolozene();
	}
	/**
	 * Metoda se koristi za ucitavanje obaveza iz fajla
	 */
	public static void ucitajObaveze(){
		SK.ucitajObaveze();
	}
	/**
	 * Metoda se koristi za serijalizaciju obaveza u file
	 */
	public static void serijalizujObaveze(){
		SK.serijalizujObaveze();
	}
	/**
	 * Sluzi za azuriranje tabele pri unosu nove obaveze
	 * @param Nova obaveza
	 */
	public static void azurirajTabeluObaveza(Obaveza o){
		int sat = Integer.parseInt(o.getSat());
		switch (o.getDan()) {
		case "NED":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 0);
			break;
		case "PON":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 1);
			break;
		case "UTO":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 2);
			break;
		case "SRE":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 3);
			break;
		case "CET":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 4);
			break;
		case "PET":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 5);
			break;
		case "SUB":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat-8, 6);
			break;

		}
	}
		/**
		 * Sluzi za brisanje iz tabele obaveze
		 * @param Obaveza koju zelimo da izbacimo
		 */
	public static void izbrisiIzTabeleObaveza(Obaveza o){
		int sat = Integer.parseInt(o.getSat());
		switch (o.getDan()) {
		case "NED":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 0);
			break;
		case "PON":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 1);
			break;
		case "UTO":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 2);
			break;
		case "SRE":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 3);
			break;
		case "CET":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 4);
			break;
		case "PET":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 5);
			break;
		case "SUB":
			GlavniProzorGUI.tableraspored.setValueAt("", sat-8, 6);
			break;

		}
	}
		/**
		 * Sluzi za brisanje iz tabele ako tako sto selektujemo zeljenu celiju u tabeli
		 */
	public static void izvrsiObrisiObavezu(){
		int sat = GlavniProzorGUI.tableraspored.getSelectedRow();
		int dan = GlavniProzorGUI.tableraspored.getSelectedColumn();
		if (sat != -1 && dan != -1) {
			GlavniProzorGUI.tableraspored.setValueAt("", sat, dan);
		}
		String s = String.valueOf(sat);
		switch (dan) {
		case 0:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("NED") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;
		case 1:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("PON") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;
		case 2:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("UTO") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;	
		case 3:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("SRE") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;
		case 4:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("CET") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;
		case 5:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("PET") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;
		case 6:
			for (int i = 0; i < SK.obaveze.size(); i++) {
				if(SK.obaveze.get(i).getDan().equals("SUB") && SK.obaveze.get(i).getSat().equals(s)){
					SK.obaveze.remove(i);
				}
			}
			break;

		case -1:
			GUIKontroler.otvoriIzbrisiObavezu();
			break;
		}
	}
	/**
	 *Metoda se koristi za azuriranje tabele predmeta iz liste predmet
	 */
	public static void azurirajTabeluPredmet(){
		SK.azurirajTabeluPredmet();
		
	}
	/**
	 * Metoda se koristi za azuriranje tebele polozenih ispita iz liste polozeni ispiti
	 */
	public static void azurirajTabeluPolozeni(){
		SK.azurirajTabeluPolozeni();
	}
	/**
	 * Metoda se koristi za azuriranje liste polozenih predmeta iz liste predmeta
	 */
	public static void azurirajListuPolozeni(){
		SK.azurirajListuPolozeni();
	}
	/**
	 * Metoda otvara novi GUI za dodavanje predmeta
	 */
	public static void otvoriDodajPredmetGUI(){
		SK.otvoriDodajPredmetGUI();
	}
	/**
	 * Metoda otvara novi Gui za izmenu predmeta
	 */
	public static void otvoriIzmeniPredmetGUI(){
		SK.otvoriIzmeniPredmetGUI();
	}
	/**
	 * Metoda otvara novi GUI za pregled predmeta
	 */
	public static void otvoriPregledPredmeta(){
		SK.otvoriPregledPredmeta();
	}
	/**
	 * Metoda sluzi za vracanje prosecne ocene
	 * @return double vrednost koje predstavlja prosecnu ocenu
	 */
	public static double vratiProsek(){
		return SK.vratiProsek();
	}
	/**
	 * Metoda sluzi za azuriranje proseka i upisivanje u tektualni editor
	 */
	public static void azurirajProsek(){
		SK.azurirajProsek();
	}
	/**
	 * Metoda sluzi za pronalazenje i vracanje zbira ESPB poena
	 * @return int vrednost kao zbir svih poena
	 */
	public static int vratiESPB(){
		return SK.vratiESPB();
	}

}
