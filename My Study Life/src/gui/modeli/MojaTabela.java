package gui.modeli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import aktivnosti.Planer;
import gui.GUIKontroler;
/**
 * Klasa koja predstvalja jTable sa odredjenim modifikacijama
 * @author Miro Maric
 * @version 1.0
 *
 */
public class MojaTabela extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 252108936505330030L;

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component comp = super.prepareRenderer(renderer, row, column);
        try {
			GregorianCalendar trenutni = new GregorianCalendar();
        	String value = (String) getModel().getValueAt(row, column);
			if (value.equals(trenutni.get(GregorianCalendar.DATE)+"") && 
					(trenutni.get(GregorianCalendar.MONTH)==GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH))
					&& (trenutni.get(GregorianCalendar.YEAR)==GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR))) {
			    comp.setFont(new Font("Tahoma", Font.BOLD, 15));
			    
			}
			comp.setBackground(Color.WHITE);
		    comp.setForeground(Color.BLACK);
			for(int i=0;i<GUIKontroler.vratiSveAktivnosti().size();i++){
				if((GUIKontroler.vratiSveAktivnosti().get(i).getVremePolaganja().get(GregorianCalendar.DATE)+"").equals(value) &&
						(GUIKontroler.vratiSveAktivnosti().get(i).getVremePolaganja().get(GregorianCalendar.MONTH))==
						(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH)) && (GUIKontroler.vratiSveAktivnosti().get(i).getVremePolaganja().
						get(GregorianCalendar.YEAR)==GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR))){
					if(GUIKontroler.vratiSveAktivnosti().get(i) instanceof Kolokvijum){
						comp.setBackground(GUIKontroler.plavaS);
						comp.setForeground(Color.white);
					}
					else if(GUIKontroler.vratiSveAktivnosti().get(i) instanceof Ispit){
						comp.setBackground(GUIKontroler.plavaT);
						comp.setForeground(Color.white);
					}
						
				}
			}
		} catch (Exception e) {
		}
        return comp;

	}
}
