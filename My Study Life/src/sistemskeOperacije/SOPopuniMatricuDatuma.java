package sistemskeOperacije;

import java.util.GregorianCalendar;

public class SOPopuniMatricuDatuma {
	public static void izvrsi(GregorianCalendar gc,String datumi[][]){
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
	}
}
