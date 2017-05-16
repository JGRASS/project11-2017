package sistemskeOperacije;

import gui.GlavniProzorGUI;
import gui.predmetFunkcije.PregledPredmeta;

public class SOOtvoriPregledPredmeta {
	public static void izvrsi(){
		PregledPredmeta p = new PregledPredmeta();
		
		p.setVisible(true);
		p.setLocationRelativeTo(GlavniProzorGUI.GlavniProzorGUI);
		p.popuniPolja();
		
	}

}
