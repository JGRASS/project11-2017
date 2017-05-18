package sistemskeOperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import predmeti.Predmet;
import sismeskiKontroler.SistemskiKontroler;

public class SOUcitajPredmete {
	public static void izvrsi(){
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.s")));
			SistemskiKontroler.predmeti = (LinkedList<Predmet>) in.readObject();
			in.close();
			
		} catch (ClassNotFoundException | IOException e) {
			SistemskiKontroler.predmeti = new LinkedList<>();
		}
		
	}
}
