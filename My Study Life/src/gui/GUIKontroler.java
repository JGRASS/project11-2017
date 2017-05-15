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

import aktivnosti.*;
import gui.modeli.MojaTabela;
import gui.modeli.PrikazPredmetaTabelaModel;
import predmeti.Predmet;
public class GUIKontroler {
	
	private static Planer planer;
	private static GlavniProzorGUI glavniProzor ; //Ovde pravite staticke promeljive. Njima posle pristupamo pomocu GuiKontroler.xxx iz bilo koje druge klase.
	private static DodajKolokvijumGUI dodajKolokvijum;
	private static DodajIspitGUI dodajIspit;
	private static OpisAktivnostiGUI opisAktivnosti;
	public static List<Predmet> predmeti = new LinkedList<>();
	//Ovu listu moramo da serijalizujemo/deserijalizujemo prilikom zatvaranja/otvaranja programa.
	//Osim ove, moramo imati jos i liste predmeti,polozeniIspiti...
	public static void main(String[] args) {
		ucitajPredmete();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planer = new Planer();
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
					
					planer.postaviGc(new GregorianCalendar());
					planer.popuniMatricuDatuma();
					planer.ucitajAktivnosti();
					
					glavniProzor.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							planer.serijalizujAktivnosti();
							serijalizujPredmete();
							glavniProzor.dispose();
						};
					});
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
	
	public String vratiNazivSlike() {
		int broj = (int) (Math.random() * 10);
		return broj + ".png";
	}
	
	public static void ucitajPredmete(){
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.s")));
			predmeti = (LinkedList<Predmet>) in.readObject();
			in.close();
			
		} catch (ClassNotFoundException | IOException e) {
			predmeti = new LinkedList<>();
		}
		
	}
	public static void serijalizujPredmete(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.s")));
			out.writeObject(predmeti);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void izmeniPredmet(String naziv, int ESBP, String skolskaGodina, boolean jednosemestralan,
			int semsetar, boolean polozen, int ocena, String napomena, String forum, String puskice) {
		
	}
	public static void azurirajTabeluPredmet(){
		PrikazPredmetaTabelaModel model = (PrikazPredmetaTabelaModel) GlavniProzorGUI.tablePredmeti.getModel();
		model.azurirajTabelu(predmeti);
	}
}
