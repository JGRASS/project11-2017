package sistemskeOperacije;

import java.util.GregorianCalendar;

public class SOIstiDan {
	
	public static boolean izvrsi(GregorianCalendar g1, GregorianCalendar g2){
		if(g1==null || g2==null)
			throw new RuntimeException("Datumi moraju biti razliciti od null");
		if(g1.get(GregorianCalendar.DATE)==g2.get(GregorianCalendar.DATE) &&
				g1.get(GregorianCalendar.MONTH)==g2.get(GregorianCalendar.MONTH) &&
				g1.get(GregorianCalendar.YEAR)==g2.get(GregorianCalendar.YEAR))
			return true;
		return false;
	}
}
