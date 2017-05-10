package gui.modeli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import gui.GUIKontroler;

public class MojaTabela extends JTable {

	private static final long serialVersionUID = 252108936505330030L;

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component comp = super.prepareRenderer(renderer, row, column);
        try {
			GregorianCalendar trenutni = new GregorianCalendar();
        	String value = (String) getModel().getValueAt(row, column);
			if (value.equals(trenutni.get(GregorianCalendar.DATE)+"") && 
					(trenutni.get(GregorianCalendar.MONTH)==GUIKontroler.gc.get(GregorianCalendar.MONTH))
					&& (trenutni.get(GregorianCalendar.YEAR)==GUIKontroler.gc.get(GregorianCalendar.YEAR))) {
			    comp.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			else{
				comp.setBackground(Color.white);
				comp.setForeground(Color.BLACK);
			}
			for(int i=0;i<GUIKontroler.aktivnosti.size();i++){
				if((GUIKontroler.aktivnosti.get(i).getVremePolaganja().get(GregorianCalendar.DATE)+"").equals(value) &&
						(GUIKontroler.aktivnosti.get(i).getVremePolaganja().get(GregorianCalendar.MONTH))==
						(GUIKontroler.gc.get(GregorianCalendar.MONTH)) && (GUIKontroler.aktivnosti.get(i).getVremePolaganja().
						get(GregorianCalendar.YEAR)==GUIKontroler.gc.get(GregorianCalendar.YEAR))){
					if(GUIKontroler.aktivnosti.get(i) instanceof Kolokvijum){
						comp.setBackground(new Color(112, 155, 179));
						comp.setForeground(Color.white);
					}
					else if(GUIKontroler.aktivnosti.get(i) instanceof Ispit){
						comp.setBackground(new Color(0, 155, 179));
						comp.setForeground(Color.white);
					}
						
				}
			}
		} catch (Exception e) {
			//Nista ne treba da se uradi u ovom slucaju?
		}
        return comp;

	}
}
