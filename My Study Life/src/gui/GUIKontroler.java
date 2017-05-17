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
import predmeti.Predmet;
import sismeskiKontroler.SistemskiKontroler;
import sistemskeOperacije.SOAzurirajListuPolozenih;
import sistemskeOperacije.SOAzurirajProsek;
import sistemskeOperacije.SOAzurirajTabeluPolozenih;
import sistemskeOperacije.SOAzurirajTabeluPredmeta;
import sistemskeOperacije.SOOtvoriDodajPredmet;
import sistemskeOperacije.SOOtvoriIzmeniPredmet;
import sistemskeOperacije.SOOtvoriPregledPredmeta;
import sistemskeOperacije.SOSerijalizujObaveze;
import sistemskeOperacije.SOSerijalizujPolozene;
import sistemskeOperacije.SOSerijalizujPredmete;
import sistemskeOperacije.SOUcitajObaveze;
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
	
	private static Planer planer  = SistemskiKontroler.planer;
	private static GlavniProzorGUI glavniProzor ;
	private static DodajKolokvijumGUI dodajKolokvijum;
	private static DodajIspitGUI dodajIspit;
	private static OpisAktivnostiGUI opisAktivnosti;
	private static DodajObavezu dodajObavezu;
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
	
	public static void otvoriDodajObavezu() {
		dodajObavezu = new DodajObavezu();
		dodajObavezu.setVisible(true);
	
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
