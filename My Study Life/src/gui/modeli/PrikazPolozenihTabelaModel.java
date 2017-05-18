package gui.modeli;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import predmeti.Predmet;

public class PrikazPolozenihTabelaModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6944911736096374736L;
	private String[] kolone = { "Naziv", "ESPB", "Skolska godina", "Semestar", "Ocena" };
	private List<Predmet> polozeni;

	public PrikazPolozenihTabelaModel(List<Predmet> polozeni) {
		if (polozeni == null) {
			this.polozeni = new LinkedList<>();
		} else {
			this.polozeni = polozeni;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return polozeni.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p;
		try {
			p = polozeni.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return p.getNaziv();
			case 1:
				return p.getESBP();
			case 2:
				return p.getSkolskaGodina();
			case 3:
				return p.getSemestar();
			case 4:
				return p.getOcena();
			default:
				return "Nepoznat unos";
			}
		} catch (Exception e) {
			return "Nepoznat unos";
		}

	}
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	/**
	 * Metoda za azuriranje tabele polozenih ispita
	 * @param polozeni lista polozenih ispita
	 */
	public void azurirajTabeluPolozeni(List<Predmet> polozeni) {
		this.polozeni=polozeni;
		fireTableDataChanged();
	}
}
