package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import aktivnosti.Aktivnost;
/**
 * Klasa koja predstavlja sistemsku opraciju koja serijalizuje listu aktivnosti
 * @author Miro Maric
 * @version 1.0
 */
public class SOSerijalizujAktivnosti {
	/**
	 * Metoda koja setijalizuje listu aktivnosti u fajl"aktivnosti.s";
	 * @param aktivnosti predstavlja listu aktivnosti koji se serijalizuju
	 */
	public static void izvrsi(List<Aktivnost> aktivnosti){
		if(aktivnosti==null)
			throw new RuntimeException("Aktivnost moraju biti razliciti od null");
		try {
			ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("aktivnosti.s")));
			os.writeObject(aktivnosti);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
