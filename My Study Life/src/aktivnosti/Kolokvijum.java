package aktivnosti;

import java.io.Serializable;
import java.util.GregorianCalendar;

import predmeti.Predmet;

public class Kolokvijum extends Aktivnost{
	
	private double brojPoena = -1;
	
	public double vratiBrojPoena() {
		return brojPoena;
	}
	public void postaviBrojPoena(double brojPoena) {
		if(brojPoena<0 || brojPoena>100)
			throw new RuntimeException("Osvojeni poeni moraju biti pravilno uneti");
		this.brojPoena = brojPoena;
	}
	
	
}
