package sistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import aktivnosti.Obaveza;
import gui.GUIKontroler;
import sismeskiKontroler.SistemskiKontroler;

public class SOUcitajObaveze {
	public static void izvrsi(){
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obaveze.s")));
			SistemskiKontroler.obaveze = (LinkedList<Obaveza>) in.readObject();
			in.close();
			
		} catch (ClassNotFoundException | IOException e) {
			SistemskiKontroler.obaveze = new LinkedList<>();
		}
		
	}
}
