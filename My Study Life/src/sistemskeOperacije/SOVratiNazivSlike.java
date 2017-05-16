package sistemskeOperacije;

import java.util.Random;

public class SOVratiNazivSlike {
	public static String izvrsi() {
		Random r = new Random();
		int broj = r.nextInt(5)+1;
		return "/"+broj+".jpg";
	}}
