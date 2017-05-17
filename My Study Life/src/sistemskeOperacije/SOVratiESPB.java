package sistemskeOperacije;

import sismeskiKontroler.SistemskiKontroler;

public class SOVratiESPB {
	public static int izvrsi() {
		int broj = 0;
		if (SistemskiKontroler.polozeni.size() == 0) {
			return 0;
		}
		for (int i = 0; i < SistemskiKontroler.polozeni.size(); i++) {
			broj += SistemskiKontroler.polozeni.get(i).getESBP();
		}
		return broj;
	}
}
