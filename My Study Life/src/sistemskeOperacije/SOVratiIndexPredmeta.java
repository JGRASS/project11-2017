package sistemskeOperacije;

import java.util.List;
import predmeti.Predmet;

public class SOVratiIndexPredmeta {
	/**
	 * Metoda koja nalazi index predmeta(pozicija u listi) na osnovu njegovog naziva
	 * @param naziv Naziv predmeta
	 * @return index predmeta u listi predmeta 
	 */
	public static int izvrsi(String naziv,List<Predmet> predmeti){
		for(int i=0;i<predmeti.size();i++){
			if(predmeti.get(i).getNaziv().equals(naziv))
				return i;
		}
		return -1;
	}
}
