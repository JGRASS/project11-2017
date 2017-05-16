package sistemskeOperacije;

import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import gui.modeli.PrikazPolozenihTabelaModel;

public class SOAzurirajTabeluPolozenih {
	public static void izvrsi(){
		PrikazPolozenihTabelaModel model = (PrikazPolozenihTabelaModel) GlavniProzorGUI.tablePolozeni.getModel();
		GUIKontroler.azurirajListuPolozeni();
		model.azurirajTabeluPolozeni(GUIKontroler.polozeni);
	}
}
