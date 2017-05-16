package sistemskeOperacije;

import gui.GlavniProzorGUI;
import gui.predmetFunkcije.IzmeniPredmetGUI;

public class SOOtvoriIzmeniPredmet {
	public static void izvrsi(){
		IzmeniPredmetGUI i = new IzmeniPredmetGUI();
		
		i.setVisible(true);
		i.setLocationRelativeTo(GlavniProzorGUI.GlavniProzorGUI);
		i.popuniPolja();
	}
}
