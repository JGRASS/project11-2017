package sistemskeOperacije;

import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import gui.modeli.PrikazPolozenihTabelaModel;
import sismeskiKontroler.SistemskiKontroler;

public class SOAzurirajTabeluPolozenih {
	public static void izvrsi(){
		PrikazPolozenihTabelaModel model = (PrikazPolozenihTabelaModel) GlavniProzorGUI.tablePolozeni.getModel();
		GUIKontroler.azurirajListuPolozeni();
		model.azurirajTabeluPolozeni(SistemskiKontroler.polozeni);
	}
}
