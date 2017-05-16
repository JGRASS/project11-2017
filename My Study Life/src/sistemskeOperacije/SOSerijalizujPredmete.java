package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import gui.GUIKontroler;

public class SOSerijalizujPredmete {
	public static void izvrsi(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.s")));
			out.writeObject(GUIKontroler.predmeti);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
