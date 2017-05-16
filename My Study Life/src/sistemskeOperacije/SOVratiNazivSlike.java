package sistemskeOperacije;

import java.util.Random;

public class SOVratiNazivSlike {
	public static String izvrsi() {
		int broj;
		Random r = new Random();
		broj=r.nextInt(9)+1;
		
		return "/"+broj+".jpg";
	}}
