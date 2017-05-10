package gui;

import java.awt.EventQueue;

public class GUIKontroler {
	
	public static GlavniProzorGUI glavniProzor ;
	
	public static void main(String[] args) {
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
	
	public String vratiNazivSlike(){
		int broj = (int)(Math.random()*10);
		return broj + ".png";
	}
}
