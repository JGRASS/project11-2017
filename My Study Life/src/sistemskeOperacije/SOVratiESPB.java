package sistemskeOperacije;

import gui.GUIKontroler;

public class SOVratiESPB {
	public static int izvrsi() {
		int broj = 0;
		if (GUIKontroler.polozeni.size() == 0) {
			return 0;
		}
		for (int i = 0; i < GUIKontroler.polozeni.size(); i++) {
			broj += GUIKontroler.polozeni.get(i).getESBP();
		}
		return broj;
	}
}
