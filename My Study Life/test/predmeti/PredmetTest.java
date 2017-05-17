package predmeti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PredmetTest {
	
	Predmet predmet = new Predmet("Ekonomija", 6, "2015/2016", true, 1, true, 6, "napomena", "","" );
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetForumNull() {
		predmet.setForum(null);
	}
	
	@Test
	public void testSetForum() {
		predmet.setForum("Link");
		assertEquals("Link", predmet.getForum());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPuskiceNull() {
		predmet.setPuskice(null);
	}
	
	@Test
	public void testSetPuskice() {
		predmet.setPuskice("Link");
		assertEquals("Link", predmet.getPuskice());
	}

	@Test	(expected = java.lang.RuntimeException.class)
	public void testSetNazivNull() {
		predmet.setNaziv(null);
	}
	@Test	(expected = java.lang.RuntimeException.class)
	public void testSetNazivManjeOd2() {
		predmet.setNaziv("M");
	}
	@Test
	public void testSetNaziv() {
		predmet.setNaziv("Ekonomija");
		assertEquals("Ekonomija", predmet.getNaziv());
	}

	@Test
	public void testSetESBP() {
		predmet.setESBP(15);
		assertEquals(15, predmet.getESBP());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetESBPManjiOd1() {
		predmet.setESBP(-15);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetESBPVeciOd30() {
		predmet.setESBP(115);
	}

	@Test
	public void testSetSkolskaGodina() {
		predmet.setSkolskaGodina("2015/2016");
		assertEquals("2015/2016", predmet.getSkolskaGodina());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSkolskaGodinaNull() {
		predmet.setSkolskaGodina(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSkolskaGodinaNijeDuzine9() {
		predmet.setSkolskaGodina("2015/016");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSkolskaGodinaNeSadrziKosuCrtu() {
		predmet.setSkolskaGodina("201552016");
	}

	@Test
	public void testSetSemestar() {
		predmet.setSemestar(6);
		assertEquals(6, predmet.getSemestar());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSemestarManjiOd1() {
		predmet.setSemestar(0);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetSemestarVeciOd12() {
		predmet.setSemestar(13);
	}


	@Test
	public void testSetOcena() {
		predmet.setOcena(8);
		assertEquals(8, predmet.getOcena());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetOcenaManjaOd5() {
		predmet.setOcena(4);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetOcenaVecaOd10() {
		predmet.setOcena(11);
	}
	


}
