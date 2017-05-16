package sistemskeOperacije;

import gui.GlavniProzorGUI;
import gui.predmetFunkcije.DodajPredmetGUI;
import gui.predmetFunkcije.IzmeniPredmetGUI;

public class SOOtvoriDodajPredmet {
	public static void izvrsi(){
		DodajPredmetGUI d = new DodajPredmetGUI();
		d.setVisible(true);
		d.setLocationRelativeTo(GlavniProzorGUI.GlavniProzorGUI);
	}
}
