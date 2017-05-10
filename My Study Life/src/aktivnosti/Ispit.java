package aktivnosti;

import java.io.Serializable;
import java.util.GregorianCalendar;

import predmeti.Predmet;

public class Ispit extends Aktivnost{
	private int ocena;
	
	public double getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		if(ocena<0 || ocena>10)
			throw new RuntimeException("Osvojeni poeni moraju biti pravilno uneti");
		this.ocena = ocena;
	}
}
