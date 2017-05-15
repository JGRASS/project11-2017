package sistemskeOperacije;

import java.util.GregorianCalendar;
import java.util.List;

import aktivnosti.Aktivnost;

public class SOPronadjiAktivnost {
	
	public static Aktivnost izvrsi(List<Aktivnost> aktivnosti, GregorianCalendar g){
		if(aktivnosti==null || g==null)
			throw new RuntimeException("Aktivnosti i datum moraju biti razliciti od null");
		for(int i=0;i<aktivnosti.size();i++){
			if(SOIstiDan.izvrsi(aktivnosti.get(i).getVremePolaganja(), g))
				return aktivnosti.get(i);
		}
		return null;
	}
}
