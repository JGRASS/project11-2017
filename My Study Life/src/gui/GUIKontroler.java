package gui;

import java.awt.Color;
import java.awt.EventQueue;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import aktivnosti.*;
import gui.modeli.MojaTabela;
import gui.predmetFunkcije.DodajPredmetGUI;
import gui.predmetFunkcije.IzmeniPredmetGUI;
import gui.predmetFunkcije.PregledPredmeta;
import gui.raspored.DodajObavezu;
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

 // Ovde pravite staticke
													// promeljive. Njima posle
													// pristupamo pomocu
													// GuiKontroler.xxx iz bilo
													// koje druge klase.

public class GUIKontroler {
	
	private static Planer planer  = SistemskiKontroler.planer;
	private static GlavniProzorGUI glavniProzor ;
	private static DodajKolokvijumGUI dodajKolokvijum;
	private static DodajIspitGUI dodajIspit;
	private static OpisAktivnostiGUI opisAktivnosti;
	private static PregledKolokvijumaGUI pregledKolokvijuma;
	private static PregledIspitaGUI pregledIspita;
	private static DodajObavezu dodajObavezu;
	//public static SistemskiKontroler SK = new SistemskiKontroler();
	public static List<Obaveza> obaveze = new LinkedList<>();


	public static Color plavaT = new Color(0, 155, 179);


	// Ovu listu moramo da serijalizujemo/deserijalizujemo prilikom
	// zatvaranja/otvaranja programa.
	// Osim ove, moramo imati jos i liste predmeti,polozeniIspiti...

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


					planer.postaviGc(new GregorianCalendar());
					

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
	public static void otvoriPregledKolokvijuma(){
		pregledKolokvijuma = new PregledKolokvijumaGUI();
		pregledKolokvijuma.setVisible(true);
	}
	/**
	 * Metoda otvara prozr PregledIspitaGUI
	 */
	public static void otvoriPregledIspita() {
		pregledIspita = new PregledIspitaGUI();
		pregledIspita.setVisible(true);
	}
	public static void otvoriDodajObavezu() {
		dodajObavezu = new DodajObavezu();
		dodajObavezu.setVisible(true);

	}
	
	public static List<Predmet> vratiPredmete(){
		return SistemskiKontroler.vratiPredmete();
	}
	
	public static List<Predmet> vratiPolozene(){
		return SistemskiKontroler.vratiPolozene();
	}
	
	public static List<Obaveza> vratiObaveze(){
		return SistemskiKontroler.vratiObaveze();
	}
	
	public static void dodajObavezu(Obaveza o){

		SistemskiKontroler.dodajObavezu(o);
	}


	
	public static void izbrisiObavezu(Obaveza o){
		SistemskiKontroler.izbrisiObavezu(o);
	}
	/**
	 * Metoda vraca sve studenske aktivnosti
	 * 
	 * @return Listu aktivnosti tipa Aktivnost
	 */
	public static List<Aktivnost> vratiSveAktivnosti(){
		return SistemskiKontroler.vratiSveAktivnosti();

	}


	/**
	 * Metoda vraca trenutno vreme
	 * 
	 * @return Trenutno vreme u vidu GregorianCalendar-a
	 */
	public static GregorianCalendar vratiTrenutnoVreme(){
		return SistemskiKontroler.vratiTrenutnoVreme();

	}


	/**
	 * Metoda vraca matricu mesecnih datuma
	 * 
	 * @return Matricu mesecnih datuma u obliku String[][]
	 */
	public static String[][] vratiDatume(){
		return SistemskiKontroler.vratiDatume();

	}


	/**
	 * Metoda koja proverava da li su dva datuma istog dana
	 * 
	 * @param g1
	 *            prvi datum GregorianCalendar
	 * @param g2
	 *            drugi datim GregorianCalendar
	 * @return boolean vrednost u zavisnosti od podudaranja datuma
	 */
	public static boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
		return SistemskiKontroler.istiDan(g1, g2);

	}
	
	/**
	 * Metoda popunjava tabelu obaveza
	 */
	public static void popuniTabeluObaveza(){
		for (int i = 0; i < SistemskiKontroler.obaveze.size(); i++) {
			azurirajTabeluObaveza(SistemskiKontroler.obaveze.get(i));
		}
	}
	

	/**
	 * Metoda popunjava matricu mesecnih datuma
	 */

	public static void popuniMatricuDatuma(){
		SistemskiKontroler.popuniMatricuDatuma();

	}


	/**
	 * Metoda pronalazi datu aktivnost na osnuvu vremena njenog odrzavanja
	 * 
	 * @param g
	 *            datum odrzavanja aktivnosti GregorianCalendar
	 * @return Aktivnost
	 */
	public static Aktivnost pronadjiAktivnost(GregorianCalendar g){
		return SistemskiKontroler.pronadjiAktivnost(g);

	}


	
	
	public static void postaviGc (){
		SistemskiKontroler.postaviGc();
	}
	/**
	 * Metoda koja serijalizuje aktivnosti
	 */

	public static void serijalizujAktivnosti(){
		SistemskiKontroler.serijalizujAktivnosti();

	}


	
	
	public static void ucitajAktivnosti(){
		SistemskiKontroler.ucitajAktivnosti();
	}
	
	/**
	 * Metoda azurira jTable
	 * 
	 * @param teble
	 *            prestvlja tabelu koja se azurira
	 */

	public static void azurirajTabelu(MojaTabela table) {
		SistemskiKontroler.azurirajTabelu(table);
	}


	/**
	 * Metoda koja vraca selektovani datum u tabeli MojaTabela
	 * 
	 * @return datum u obliku int
	 */
	public static GregorianCalendar selektovanDatum(MojaTabela table) {
		return SistemskiKontroler.selektovanDatum(table);
	}


	/**
	 * Metoda koja vraca odredjeni GregorianCalendar(godina,mesec,dan) u String
	 * obliku
	 * 
	 * @param g
	 *            Datum koji se zeli prikazati u vidu Stringa
	 * @return Datum u String formatu
	 */
	public static String vratiDatumString(GregorianCalendar g){
		return SistemskiKontroler.vratiDatumString(g);
	}


	/**
	 * Metoda koja vraca odredjeni GregorianCalendar(sat,minut) u String obliku
	 * 
	 * @param g
	 *            Datum koji se zeli prikazati u vidu Stringa
	 * @return Vreme u String formatu
	 */

	public static String vratiVremeString(GregorianCalendar g){
		return SistemskiKontroler.vratiVremeString(g);

	}


	/**
	 * Metoda koja nalazi index predmeta(pozicija u listi) na osnovu njegovog
	 * naziva
	 * 
	 * @param naziv
	 *            Naziv predmeta
	 * @return index predmeta u listi predmeta
	 */

	public static int vratiIndexPredmeta(String naziv){
		return SistemskiKontroler.vratiIndexPredmeta(naziv);
	}

	/**
	 * Metoda sluzi za vracanje random imena slike koja se koristi kao pozadina
	 * glavnog prozora
	 * 
	 * @return String vrednost koja predstavlja naziv slike
	 */
	public static String vratiNazivSlike() {
		return SistemskiKontroler.vratiNazivSlike();
	}

	/**
	 * Metoda se koristi za ucitavanje predmeta iz fajla
	 */
	public static void ucitajPredmete() {
		SistemskiKontroler.ucitajPredmete();
	}

	/**
	 * Metoda se korsiti za serializaciju predmeta u file
	 */
	public static void serijalizujPredmete() {
		SistemskiKontroler.serijalizujPredmete();

	}

	/**
	 * Metoda se koristi za ucitavanje polozenih predmeta iz fajla
	 */
	public static void ucitajPolozene() {
		SistemskiKontroler.ucitajPolozene();
	}

	/**
	 * Metoda se koristi za serializaciju polozenih predmeta u file
	 */
	public static void serijalizujPolozene() {
		SistemskiKontroler.serijalizujPolozene();
	}

	/**
	 * Metoda se koristi za ucitavanje obaveza iz fajla
	 */
	public static void ucitajObaveze() {
		SistemskiKontroler.ucitajObaveze();
	}

	/**
	 * Metoda se koristi za serijalizaciju obaveza u file
	 */
	public static void serijalizujObaveze(){
		SistemskiKontroler.serijalizujObaveze();
		}

	/**
	 * Sluzi za azuriranje tabele pri unosu nove obaveze
	 * @param Nova obaveza
	 */
	public static void azurirajTabeluObaveza(Obaveza o){
		int sat = Integer.parseInt(o.getSat());
		sat -= 8;
		switch (o.getDan()) {
		case "NED":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 0);
			break;
		case "PON":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 1);
			break;
		case "UTO":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 2);
			break;
		case "SRE":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 3);
			break;
		case "CET":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 4);
			break;
		case "PET":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 5);
			break;
		case "SUB":
			GlavniProzorGUI.tableraspored.setValueAt(o.getNaziv() + "-" + o.getMesto(), sat, 6);
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
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("NED") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;
		case 1:
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("PON") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;
		case 2:
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("UTO") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;	
		case 3:
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("SRE") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;
		case 4:
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("CET") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;
		case 5:
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("PET") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;
		case 6:
			for (int i = 0; i < SistemskiKontroler.vratiObaveze().size(); i++) {
				if(SistemskiKontroler.vratiObaveze().get(i).getDan().equals("SUB") && SistemskiKontroler.vratiObaveze().get(i).getSat().equals(s)){
					SistemskiKontroler.vratiObaveze().remove(i);
				}
			}
			break;

		case -1:
		//	GUIKontroler.otvoriIzbrisiObavezu();
			break;
		}
	}
	/**
	 *Metoda se koristi za azuriranje tabele predmeta iz liste predmet
	 */
	public static void azurirajTabeluPredmet() {
		SistemskiKontroler.azurirajTabeluPredmet();

	}

	/**
	 * Metoda se koristi za azuriranje tebele polozenih ispita iz liste polozeni
	 * ispiti
	 */
	public static void azurirajTabeluPolozeni() {
		SistemskiKontroler.azurirajTabeluPolozeni();
	}

	/**
	 * Metoda se koristi za azuriranje liste polozenih predmeta iz liste
	 * predmeta
	 */
	public static void azurirajListuPolozeni() {
		SistemskiKontroler.azurirajListuPolozeni();
	}

	/**
	 * Metoda otvara novi GUI za dodavanje predmeta
	 */
	public static void otvoriDodajPredmetGUI() {
		DodajPredmetGUI d = new DodajPredmetGUI();
		d.setVisible(true);
		d.setLocationRelativeTo(GlavniProzorGUI.GlavniProzorGUI);
	}

	/**
	 * Metoda otvara novi Gui za izmenu predmeta
	 */
	public static void otvoriIzmeniPredmetGUI() {
		IzmeniPredmetGUI i = new IzmeniPredmetGUI();

		i.setVisible(true);
		i.setLocationRelativeTo(GlavniProzorGUI.GlavniProzorGUI);
		i.popuniPolja();
	}

	/**
	 * Metoda otvara novi GUI za pregled predmeta
	 */
	public static void otvoriPregledPredmeta() {
		PregledPredmeta p = new PregledPredmeta();

		p.setVisible(true);
		p.setLocationRelativeTo(GlavniProzorGUI.GlavniProzorGUI);
		p.popuniPolja();
	}

	/**
	 * Metoda sluzi za vracanje prosecne ocene
	 * 
	 * @return double vrednost koje predstavlja prosecnu ocenu
	 */
	public static double vratiProsek() {
		return SistemskiKontroler.vratiProsek();
	}

	/**
	 * Metoda sluzi za azuriranje proseka i upisivanje u tektualni editor
	 */
	public static void azurirajProsek() {
		SistemskiKontroler.azurirajProsek();
	}

	/**
	 * Metoda sluzi za pronalazenje i vracanje zbira ESPB poena
	 * 
	 * @return int vrednost kao zbir svih poena
	 */
	public static int vratiESPB() {
		return SistemskiKontroler.vratiESPB();
	}
	/**
	 * Metoda koja sluzi za dodavanje predmeta u listu
	 * @param naziv predstavlja naziv predmeta
	 * @param ESBP predstavlja boroj ESBP poena koje taj predmet nosi
	 * @param skolskaGodina	predstavlja String u obliku yyyy/yyyy 
	 * @param jednosemestralan boolean vrednost 
	 * @param semestar  vrednost koja predstavlja broj semestra
	 * @param polozen boolean vrednost 
	 * @param ocena  vrednost koja predstavlja ocenu na ispitu
	 * @param napomena String sa napomenom o predmetu
	 * @param forum String koji predstavlja link za forum
	 * @param puskice String koji predstavlja link za puskice
	 * @return int vrednost 1- ako je sve uspesno izvrseno ili 0 ako nije
	 */
	public static int dodajPredmet(String naziv, String ESBP, String skolskaGodina, boolean jednosemestralan,
			String semestar, boolean polozen, String ocena, String napomena, String forum, String puskice) {
		try {

			Predmet p = new Predmet(naziv, Integer.parseInt(ESBP), skolskaGodina, jednosemestralan,
					Integer.parseInt(semestar), polozen, Integer.parseInt(ocena), napomena, forum, puskice);
			SistemskiKontroler.vratiPredmete().add(p);
			return 1;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom unosa brojevnih vrednosti", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		} catch (RuntimeException e2) {
			JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom unosa skolske godine", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
	/**
	 * 
	 * Metoda koja sluzi za dodavanje predmeta u listu
	 * @param naziv predstavlja naziv predmeta
	 * @param ESBP predstavlja boroj ESBP poena koje taj predmet nosi
	 * @param skolskaGodina	predstavlja String u obliku yyyy/yyyy 
	 * @param jednosemestralan boolean vrednost 
	 * @param semestar  vrednost koja predstavlja broj semestra
	 * @param polozen boolean vrednost 
	 * @param ocena  vrednost koja predstavlja ocenu na ispitu
	 * @param napomena String sa napomenom o predmetu
	 * @param forum String koji predstavlja link za forum
	 * @param puskice String koji predstavlja link za puskice
	 * @param predmet predstavlja predmet koji se trenutno posmatra u prozoru
	 * @return int vrednost 1- ako je sve uspesno izvrseno ili 0 ako nije
	 */
	public static int izmeniPredmet(String naziv, String ESBP, String skolskaGodina, boolean jednosemestralan,
			String semestar, boolean polozen, String ocena, String napomena, String forum, String puskice,
			Predmet predmet) {
		try {
			Predmet p = new Predmet(naziv, Integer.parseInt(ESBP), skolskaGodina, jednosemestralan,
					Integer.parseInt(semestar), polozen, Integer.parseInt(ocena), napomena, forum, puskice);
			for (int i = 0; i < SistemskiKontroler.vratiPredmete().size(); i++) {
				if (SistemskiKontroler.vratiPredmete().get(i).equals(predmet)) {
					SistemskiKontroler.vratiPredmete().remove(i);
					break;
				}
			}
			SistemskiKontroler.vratiPredmete().add(p);
			return 1;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom unosa brojevnih vrednosti", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		} catch (RuntimeException e2) {
			JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom unosa skolske godine", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}

}
