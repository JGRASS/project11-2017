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
import gui.model.PrikazPredmetaTabelaModel;
import predmeti.Predmet;
public class GUIKontroler {
	
	public static GlavniProzorGUI glavniProzor ; //Ovde pravite staticke promeljive. Njima posle pristupamo pomocu GuiKontroler.xxx iz bilo koje druge klase.
	public static DodajKolokvijumGUI dodajKolokvijum;
	public static DodajIspitGUI dodajIspit;
	public static GregorianCalendar gc = new GregorianCalendar();
	public static String[][] datumi = new String[6][7];
	public static List<Aktivnost> aktivnosti;
	public static List<Kolokvijum> kolokvijumi;
	public static List<Predmet> predmeti = new LinkedList<>();
	//Ovu listu moramo da serijalizujemo/deserijalizujemo prilikom zatvaranja/otvaranja programa.
	//Osim ove, moramo imati jos i liste predmeti,polozeniIspiti...
	public static void main(String[] args) {
		ucitajAktivnosti();
		gc = new GregorianCalendar();
		popuniMatricuDatuma(datumi, gc);
		ucitajPredmete();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
					glavniProzor.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							serijalizujAktivnosti();
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
		dodajKolokvijum.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dodajKolokvijum.dispose();
			}
		});
	}
	
	public static void otvoriDodajIspitGUI() {
		dodajIspit = new DodajIspitGUI();
		dodajIspit.setVisible(true);
		dodajIspit.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dodajIspit.dispose();
			}
		});
	}
	public static void popuniMatricuDatuma(String[][] datumi,GregorianCalendar gc){
		gc.set(GregorianCalendar.DATE, 1);
		int prviDanUMesecu = gc.get(GregorianCalendar.DAY_OF_WEEK);
		int dan = 1;
		int brojac = 1;
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(brojac>=prviDanUMesecu && dan<=gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)){
					datumi[i][j] = dan+"";
					dan++;
				}
				else	
					datumi[i][j] = "";
				brojac++;
			}
		}
	}
	
	public static boolean istiDan(GregorianCalendar g1, GregorianCalendar g2){
		if(g1.get(GregorianCalendar.DATE)==g2.get(GregorianCalendar.DATE) &&
				g1.get(GregorianCalendar.MONTH)==g2.get(GregorianCalendar.MONTH) &&
				g1.get(GregorianCalendar.YEAR)==g2.get(GregorianCalendar.YEAR))
			return true;
		return false;
	}
	public static void serijalizujAktivnosti(){
		try {
			ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("aktivnosti.s")));
			os.writeObject(aktivnosti);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ucitajAktivnosti(){
		try {
			ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream("aktivnosti.s")));
			aktivnosti = (LinkedList<Aktivnost>) is.readObject();
			is.close();
		} catch (ClassNotFoundException | IOException e) {
			aktivnosti = new LinkedList<>();
		}
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
	public String vratiNazivSlike() {
		int broj = (int) (Math.random() * 10);
		return broj + ".png";
	}

	public static void izmeniPredmet(String naziv, int ESBP, String skolskaGodina, boolean jednosemestralan,
			int semsetar, boolean polozen, int ocena, String napomena, String forum, String puskice) {
		
	}
	public static void azurirajTabeluPredmet(){
		PrikazPredmetaTabelaModel model = (PrikazPredmetaTabelaModel) GlavniProzorGUI.tablePredmeti.getModel();
		model.azurirajTabelu(predmeti);
	}
}
