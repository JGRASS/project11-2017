package sistemskeOperacije;

import gui.GlavniProzorGUI;
import gui.modeli.PrikazPredmetaTabelaModel;
import sismeskiKontroler.SistemskiKontroler;

public class SOAzurirajTabeluPredmeta {
	public static void izvrsi() {
		PrikazPredmetaTabelaModel model = (PrikazPredmetaTabelaModel) GlavniProzorGUI.tablePredmeti.getModel();
		model.azurirajTabelu(SistemskiKontroler.predmeti);

	}
}
