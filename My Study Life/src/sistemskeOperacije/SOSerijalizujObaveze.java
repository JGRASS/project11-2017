package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import sismeskiKontroler.SistemskiKontroler;

public class SOSerijalizujObaveze {
	public static void izvrsi(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obaveze.s")));
			out.writeObject(SistemskiKontroler.obaveze);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
