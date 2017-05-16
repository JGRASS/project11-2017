package sistemskeOperacije;

import gui.GUIKontroler;

public class SOVratiProsek {
	public static double izvrsi(){
		int broj=0;
		if(GUIKontroler.polozeni.size()==0){
			return 0;
		}
		for (int i = 0; i < GUIKontroler.polozeni.size(); i++) {
			broj += GUIKontroler.polozeni.get(i).getOcena();
		}
		return ((double)broj) / (GUIKontroler.polozeni.size());
	}
}
