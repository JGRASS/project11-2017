package sistemskeOperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import aktivnosti.Aktivnost;

public class SOSerijalizujAktivnosti {
	public static void izvrsi(List<Aktivnost> aktivnosti){
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
