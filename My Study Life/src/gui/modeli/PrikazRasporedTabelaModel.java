package gui.modeli;

import javax.swing.table.AbstractTableModel;

public class PrikazRasporedTabelaModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] dani = { "Ponedeljak", "Utorak", "Sreda", "Cetvratk", "Petak", "Subota", "Nedelja" };
	private String[][] raspored = new String[7][7];
	
	public PrikazRasporedTabelaModel(String[][] raspored) {
		if(raspored!=null){
			this.raspored=raspored;
		}
	}
	@Override
	public int getColumnCount() {
		return raspored[0].length;
		
	}

	@Override
	public int getRowCount() {
		return raspored.length;
	}

	@Override
	public Object getValueAt(int vrsta, int kolona) {
		return raspored[vrsta][kolona];
	}
	@Override
	public String getColumnName(int column) {
		return dani[column];
	}
	public String getRowName(int row){
		return (row+7)+"";
	}
	public void azurirajTabelu(String[][] raspored){
		this.raspored = raspored;
		fireTableDataChanged();
	}
}
