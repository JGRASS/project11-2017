package sistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import gui.GUIKontroler;
import predmeti.Predmet;

public class SOUcitajPolozene {
	public static void izvrsi(){
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("polozeni.s")));
			GUIKontroler.polozeni = (LinkedList<Predmet>) in.readObject();
			in.close();
			
		} catch (ClassNotFoundException | IOException e) {
			GUIKontroler.polozeni = new LinkedList<>();
		}
	}
}