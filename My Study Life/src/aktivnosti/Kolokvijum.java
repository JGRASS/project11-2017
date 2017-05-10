package aktivnosti;

import java.io.Serializable;
import java.util.GregorianCalendar;

import predmeti.Predmet;

public class Kolokvijum extends Aktivnost{
	private double brojPoena;
	
	public double getBrojPoena() {
		return brojPoena;
	}
	public void setBrojPoena(double brojPoena) {
		if(brojPoena<0 || brojPoena>100)
			throw new RuntimeException("Osvojeni poeni moraju biti pravilno uneti");
		this.brojPoena = brojPoena;
	}
	
	
}
