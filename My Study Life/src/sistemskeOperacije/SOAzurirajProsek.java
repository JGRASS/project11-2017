package sistemskeOperacije;

import gui.GUIKontroler;
import gui.GlavniProzorGUI;

public class SOAzurirajProsek {
	public static void izvrsi() {
		GlavniProzorGUI.textFieldProsek.setText("" + GUIKontroler.vratiProsek());
	}
}
