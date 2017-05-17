package sistemskeOperacije;

import gui.GUIKontroler;
import gui.GlavniProzorGUI;

public class SOAzurirajListuPolozenih {
	public static void izvrsi(){
		for (int i = 0; i < GUIKontroler.predmeti.size(); i++) {
			if(GUIKontroler.predmeti.get(i).isPolozen() && !GUIKontroler.polozeni.contains(GUIKontroler.predmeti.get(i))){
				GUIKontroler.polozeni.add(GUIKontroler.predmeti.get(i));
			}
		}
		for (int i = 0; i < GUIKontroler.polozeni.size(); i++) {
			if(!GUIKontroler.predmeti.contains(GUIKontroler.polozeni.get(i))){
				GUIKontroler.polozeni.remove(i);
			}
		}
	}
}
