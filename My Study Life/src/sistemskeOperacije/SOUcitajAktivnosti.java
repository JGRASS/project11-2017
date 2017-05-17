package sistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;

import aktivnosti.Aktivnost;
/**
 * Klasa koja predstavlja sistemsku opraciju koja deserijalizuje listu aktivnosti
 * @author Miro Maric
 * @version 1.0
 */
public class SOUcitajAktivnosti {
	/**
	 * Metoda koja deserijalizuje listu aktivnosti
	 * @return listu aktivnosti
	 */
	public static List<Aktivnost> izvrsi(){
		try {
			ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(new FileInputStream("aktivnosti.s")));
			List<Aktivnost> aktivosti =  (LinkedList<Aktivnost>) is.readObject();
			is.close();
			return aktivosti;
		} catch (ClassNotFoundException | IOException e) {
			return new LinkedList<>();
		}
	}
}
