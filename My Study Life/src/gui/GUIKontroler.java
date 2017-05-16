package gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import aktivnosti.*;
import gui.modeli.MojaTabela;
import gui.modeli.PrikazPolozenihTabelaModel;
import gui.modeli.PrikazPredmetaTabelaModel;
import gui.predmetFunkcije.DodajPredmetGUI;
import gui.predmetFunkcije.IzmeniPredmetGUI;
import gui.predmetFunkcije.PregledPredmeta;
import predmeti.Predmet;
import sistemskeOperacije.SOAzurirajListuPolozenih;
import sistemskeOperacije.SOAzurirajTabeluPolozenih;
import sistemskeOperacije.SOAzurirajTabeluPredmeta;
import sistemskeOperacije.SOOtvoriDodajPredmet;
import sistemskeOperacije.SOOtvoriIzmeniPredmet;
import sistemskeOperacije.SOOtvoriPregledPredmeta;
import sistemskeOperacije.SOSerijalizujPolozene;
import sistemskeOperacije.SOSerijalizujPredmete;
import sistemskeOperacije.SOUcitajPolozene;
import sistemskeOperacije.SOUcitajPredmete;
import sistemskeOperacije.SOVratiNazivSlike;
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
	public static String vratiDatumString(GregorianCalendar g){
		String vreme = "";
		vreme+=g.get(GregorianCalendar.YEAR)+"/";
		vreme+=g.get(GregorianCalendar.MONTH)+"/";
		vreme+=g.get(GregorianCalendar.DATE)+" ";
		return vreme;
	}
	
	public static String vratiVremeString(GregorianCalendar g){
		String vreme = "";
		vreme+=g.get(GregorianCalendar.HOUR)+":";
		vreme+=g.get(GregorianCalendar.MINUTE);
		return vreme;
	}
	
	public static String vratiNazivSlike() {
		return SOVratiNazivSlike.izvrsi();
	}
	
	public static void ucitajPredmete(){
		SOUcitajPredmete.izvrsi();
	}
	public static void serijalizujPredmete(){
		SOSerijalizujPredmete.izvrsi();
		
	}
	public static void ucitajPolozene(){
		SOUcitajPolozene.izvrsi();
	}
	public static void serijalizujPolozene(){
		SOSerijalizujPolozene.izvrsi();
	}

	public static void azurirajTabeluPredmet(){
		SOAzurirajTabeluPredmeta.izvrsi();
		
	}
	
	public static void azurirajTabeluPolozeni(){
		SOAzurirajTabeluPolozenih.izvrsi();
	}
	public static void azurirajListuPolozeni(){
		SOAzurirajListuPolozenih.izvrsi();
	}
	public static void otvoriDodajPredmetGUI(){
		SOOtvoriDodajPredmet.izvrsi();
	}
	public static void otvoriIzmeniPredmetGUI(){
		SOOtvoriIzmeniPredmet.izvrsi();
	}
	public static void otvoriPregledPredmeta(){
		SOOtvoriPregledPredmeta.izvrsi();
		
	}
}
