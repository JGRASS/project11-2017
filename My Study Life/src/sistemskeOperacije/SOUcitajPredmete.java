package sistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import gui.GUIKontroler;
import predmeti.Predmet;

public class SOUcitajPredmete {
	public static void izvrsi(){
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.s")));
			GUIKontroler.predmeti = (LinkedList<Predmet>) in.readObject();
			in.close();
			
		} catch (ClassNotFoundException | IOException e) {
			GUIKontroler.predmeti = new LinkedList<>();
		}
		
	}
}
