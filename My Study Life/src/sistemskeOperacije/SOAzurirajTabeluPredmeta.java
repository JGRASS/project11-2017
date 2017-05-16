package sistemskeOperacije;

import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import gui.modeli.PrikazPredmetaTabelaModel;

public class SOAzurirajTabeluPredmeta {
	public static void izvrsi() {
		PrikazPredmetaTabelaModel model = (PrikazPredmetaTabelaModel) GlavniProzorGUI.tablePredmeti.getModel();
		model.azurirajTabelu(GUIKontroler.predmeti);

	}
}
