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
public class GUIKontroler {

	public static GlavniProzorGUI glavniProzor ; //Ovde pravite staticke promeljive. Njima posle pristupamo pomocu GuiKontroler.xxx iz bilo koje druge klase.
	public static DodajKolokvijumGUI dodajKolokvijum;
	public static DodajIspitGUI dodajIspit;
	public static GregorianCalendar gc;
	public static String[][] datumi = new String[6][7];
	public static List<Kolokvijum> kolokvijumi;
	//Ovu listu moramo da serijalizujemo/deserijalizujemo prilikom zatvaranja/otvaranja programa.
	//Osim ove, moramo imati jos i liste predmeti,polozeniIspiti...
	public static void main(String[] args) {
		ucitajKolokvijume();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gc = new GregorianCalendar();
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
					glavniProzor.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							GUIKontroler.serijalizujKolokvijume();
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
	public static void serijalizujKolokvijume(){
		try {
			ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("kolokvijumi.s")));
			os.writeObject(kolokvijumi);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ucitajKolokvijume(){
		try {
			ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream("kolokvijumi.s")));
			kolokvijumi = (LinkedList<Kolokvijum>) is.readObject();
			is.close();
		} catch (ClassNotFoundException | IOException e) {
			kolokvijumi = new LinkedList<>();
		}
	}
	
}
