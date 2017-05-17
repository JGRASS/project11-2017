package gui.modeli;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.omg.PortableServer.ServantRetentionPolicyValue;
/**
 * Klasa koja predstavlja tableModel sa odredjenim podesavanjima
 * @author Miro Maric
 *
 */
public class PlanerTabelaModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7705308216214403383L;
	/**
	 * Niz dana u nedelji tj. kolone u tabeli
	 */
	private String[] dani = {"Ponedeljak","Utorak","Sreda","Cetvratk","Petak","Subota","Nedelja"};
	/**
	 * Matrica mesecnih datuma
	 */
	private String[][] datumi = new String[6][7];
	
	/**
	 * Postavljanje matrice mesecnih datuma
	 * @param datumi kao matrica String[][] koja predstavlja mesecne datume
	 */
	public PlanerTabelaModel(String[][] datumi) {
		if(datumi!=null)
			this.datumi = datumi;
	}
	@Override
	public int getColumnCount() {
		return datumi[0].length;
	}

	
	@Override
	public int getRowCount() {
		return datumi.length;
	}

	@Override
	public Object getValueAt(int vrsta, int kolona) {
		return datumi[vrsta][kolona];
	}
	@Override
	public String getColumnName(int index) {
		return dani[index];
	}
	/**
	 * Metoda koja azurira Planer
	 * @param datumi Matrica mesecnih datuma
	 */
	public void azurirajTabelu(String[][] datumi){
		this.datumi = datumi;
		fireTableDataChanged();
	}
	
}
