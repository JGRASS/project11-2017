package aktivnosti;

import java.io.Serializable;
import java.util.GregorianCalendar;

import predmeti.Predmet;

public class Ispit extends Aktivnost{
	
	private int ocena = -1;
	
	public double vratiOcenu() {
		return ocena;
	}
	public void postaviOcenu(int ocena) {
		if(ocena<5 || ocena>10)
			throw new RuntimeException("Ocena mora biti pravilno uneta");
		this.ocena = ocena;
	}
}
