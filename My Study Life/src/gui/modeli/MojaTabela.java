package gui.modeli;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import gui.GUIKontroler;

public class MojaTabela extends JTable {
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component comp = super.prepareRenderer(renderer, row, column);
        String value = (String) getModel().getValueAt(row, column);
        if (value.equals(new GregorianCalendar().get(GregorianCalendar.DATE)+"") && 
        		(new GregorianCalendar().get(GregorianCalendar.MONTH)==GUIKontroler.gc.get(GregorianCalendar.MONTH))) {
            comp.setFont(new Font("Tahoma", Font.BOLD, 15));
        }
        else{
        	comp.setBackground(Color.white);
        	comp.setForeground(Color.BLACK);
        }
        for(int i=0;i<GUIKontroler.kolokvijumi.size();i++){
        	if((GUIKontroler.kolokvijumi.get(i).getVremePolaganja().get(GregorianCalendar.DATE)+"").equals(value)){
        		comp.setBackground(new Color(112, 155, 179));
        		comp.setForeground(Color.white);
        	}
        }
        return comp;
	}
}
