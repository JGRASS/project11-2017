package sistemskeOperacije;

import gui.GUIKontroler;
import sismeskiKontroler.SistemskiKontroler;

public class SOVratiProsek {
	public static double izvrsi(){
		int broj=0;
		if(SistemskiKontroler.polozeni.size()==0){
			return 0;
		}
		for (int i = 0; i < SistemskiKontroler.polozeni.size(); i++) {
			broj += SistemskiKontroler.polozeni.get(i).getOcena();
		}
		return ((double)broj) / (SistemskiKontroler.polozeni.size());
	}
}
