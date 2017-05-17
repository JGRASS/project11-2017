package sistemskeOperacijeTest;

import static org.junit.Assert.*;

import org.junit.Test;

import predmeti.Predmet;
import sismeskiKontroler.SistemskiKontroler;
import sistemskeOperacije.SOVratiESPB;

public class SOVratiESPBTest {	
	@Test
	public void testESPB() {
		SistemskiKontroler S= new SistemskiKontroler();
		Predmet p1;
		Predmet p2;
		Predmet p3;
		Predmet p4;
		p1 = new Predmet("Ime", 5, "2017/2016", true, 2, true, 6, "", "", "");
		p2 = new Predmet("Pera", 5, "2017/2016", true, 2, true, 6, "", "", "");
		p3 = new Predmet("Zika", 5, "2017/2016", true, 2, true, 6, "", "", "");
		p4 = new Predmet("Jovanka", 5, "2017/2016", true, 2, true, 6, "", "", "");
		S.polozeni.add(p1);
		S.polozeni.add(p2);
		S.polozeni.add(p3);
		S.polozeni.add(p4);
		int broj = SOVratiESPB.izvrsi();
		assertEquals(20, broj);
	}
	

}
