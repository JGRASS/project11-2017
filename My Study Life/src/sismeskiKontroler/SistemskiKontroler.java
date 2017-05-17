package sismeskiKontroler;

import java.util.LinkedList;
import java.util.List;

import aktivnosti.Obaveza;
import predmeti.Predmet;
import sistemskeOperacije.SOAzurirajListuPolozenih;
import sistemskeOperacije.SOAzurirajProsek;
import sistemskeOperacije.SOAzurirajTabeluPolozenih;
import sistemskeOperacije.SOAzurirajTabeluPredmeta;
import sistemskeOperacije.SOSerijalizujObaveze;
import sistemskeOperacije.SOSerijalizujPolozene;
import sistemskeOperacije.SOSerijalizujPredmete;
import sistemskeOperacije.SOUcitajObaveze;
import sistemskeOperacije.SOUcitajPolozene;
import sistemskeOperacije.SOUcitajPredmete;
import sistemskeOperacije.SOVratiESPB;
import sistemskeOperacije.SOVratiNazivSlike;
import sistemskeOperacije.SOVratiProsek;

public class SistemskiKontroler {
	public static List<Predmet> predmeti = new LinkedList<>();
	public static List<Predmet> polozeni = new LinkedList<>();
	public static List<Obaveza> obaveze = new LinkedList<>();
	
	public  String vratiNazivSlike() {
		return SOVratiNazivSlike.izvrsi();
	}
	
	public  void ucitajPredmete(){
		SOUcitajPredmete.izvrsi();
	}
	
	public  void serijalizujPredmete(){
		SOSerijalizujPredmete.izvrsi();
		
	}
	
	public  void ucitajPolozene(){
		SOUcitajPolozene.izvrsi();
	}

	public  void serijalizujPolozene(){
		SOSerijalizujPolozene.izvrsi();
	}
	
	public void ucitajObaveze(){
		SOUcitajObaveze.izvrsi();
	}

	public void serijalizujObaveze(){
		SOSerijalizujObaveze.izvrsi();
	}
	
	public void dodajObavezu(Obaveza o){
		obaveze.add(o);
	}
	
	public  void azurirajTabeluPredmet(){
		SOAzurirajTabeluPredmeta.izvrsi();
		
	}
	
	public  void azurirajTabeluPolozeni(){
		SOAzurirajTabeluPolozenih.izvrsi();
	}
	
	public  void azurirajListuPolozeni(){
		SOAzurirajListuPolozenih.izvrsi();
	}
	

	public  double vratiProsek(){
		return SOVratiProsek.izvrsi();
	}
	
	public  void azurirajProsek(){
		SOAzurirajProsek.izvrsi();
	}
	
	public  int vratiESPB(){
		return SOVratiESPB.izvrsi();
	}


}
