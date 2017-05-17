package sistemskeOperacije;

import java.util.GregorianCalendar;
/**
 * Klasa koja predstavlja sistemsku opraciju koja popunjava
 * matricu mesecnih datuma
 * @author Miro Maric
 * @version 1.0
 */
public class SOPopuniMatricuDatuma {
	/**
	 * Metoda popunjava matricu mesecnih datuma
	 * @param gc predstavlja vreme u vidu GregorianCalendar-a
	 * @param datumi predstavlja matricu mesecnih datuma koja se popunjava
	 */
	public static void izvrsi(GregorianCalendar gc,String datumi[][]){
		if(gc==null || datumi==null)
			throw new RuntimeException("Datum i matrica moraju biti razliciti od null");
		gc.set(GregorianCalendar.DATE, 1);
		int prviDanUMesecu = gc.get(GregorianCalendar.DAY_OF_WEEK);
		int dan = 1;
		int brojac = 1;
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(brojac>=prviDanUMesecu && dan<=gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)){
					datumi[i][j] = dan+"";
					dan++;
				}
				else	
					datumi[i][j] = "";
				brojac++;
			}
		}
		gc.set(GregorianCalendar.DATE,new GregorianCalendar().get(GregorianCalendar.DATE));
	}
}
