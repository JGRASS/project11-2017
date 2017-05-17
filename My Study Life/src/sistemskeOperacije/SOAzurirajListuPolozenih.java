package sistemskeOperacije;

import sismeskiKontroler.SistemskiKontroler;

public class SOAzurirajListuPolozenih {
	public static void izvrsi(){
		for (int i = 0; i < SistemskiKontroler.predmeti.size(); i++) {
			if(SistemskiKontroler.predmeti.get(i).isPolozen() && !SistemskiKontroler.polozeni.contains(SistemskiKontroler.predmeti.get(i))){
				SistemskiKontroler.polozeni.add(SistemskiKontroler.predmeti.get(i));
			}
		}
		for (int i = 0; i < SistemskiKontroler.polozeni.size(); i++) {
			if(!SistemskiKontroler.predmeti.contains(SistemskiKontroler.polozeni.get(i))){
				SistemskiKontroler.polozeni.remove(i);
			}
		}
	}
}
