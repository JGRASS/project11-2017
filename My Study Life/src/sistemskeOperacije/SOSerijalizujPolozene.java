package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sismeskiKontroler.SistemskiKontroler;

public class SOSerijalizujPolozene {
	public static void izvrsi(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("polozeni.s")));
			out.writeObject(SistemskiKontroler.polozeni);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
