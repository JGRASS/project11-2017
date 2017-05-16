package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import gui.GUIKontroler;

public class SOSerijalizujPolozene {
	public static void izvrsi(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("polozeni.s")));
			out.writeObject(GUIKontroler.polozeni);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}