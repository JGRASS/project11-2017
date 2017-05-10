package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GUIKontroler {

	public static GlavniProzorGUI glavniProzor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					glavniProzor = new GlavniProzorGUI();
					glavniProzor.setVisible(true);
					glavniProzor.addWindowListener(new WindowAdapter() {
						private Component frame;

						@Override
						public void windowClosing(WindowEvent e) {
							int odgovor = JOptionPane.showConfirmDialog(frame, "Da li zelite da zatvorite aplikaciju?",
									"Exit", JOptionPane.YES_NO_CANCEL_OPTION);
							if (odgovor == JOptionPane.YES_OPTION)
								System.exit(0);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String vratiNazivSlike() {
		int broj = (int) (Math.random() * 10);
		return broj + ".png";
	}

	public static void dodajPredmet(String naziv, int ESBP, String skolskaGodina, boolean jednosemestralan,
			int semsetar, boolean polozen, int ocena, String napomena, String forum, String puskice) {
	}
	public static void izmeniPredmet(String naziv, int ESBP, String skolskaGodina, boolean jednosemestralan,
			int semsetar, boolean polozen, int ocena, String napomena, String forum, String puskice) {
	}
}
