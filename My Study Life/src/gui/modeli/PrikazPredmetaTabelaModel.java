package gui.modeli;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import predmeti.Predmet;

public class PrikazPredmetaTabelaModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5262200438539935598L;
	/*
	 * private String naziv; private int ESBP; private String skolskaGodina;
	 * private boolean jednosemestralan; private int semestar; private boolean
	 * polozen; private int ocena; private String napomena;
	 */
	private String[] kolone = { "Naziv", "ESPB", "Skolska godina", "Semestar" };
	private List<Predmet> predmeti;

	public PrikazPredmetaTabelaModel(List<Predmet> predmeti) {
		if (predmeti == null) {
			this.predmeti = new LinkedList<>();
			
		} else {
			this.predmeti = predmeti;
		}
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return predmeti.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p;
		try {
			p = predmeti.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return p.getNaziv();
			case 1:
				return p.getESBP();
			case 2:
				return p.getSkolskaGodina();
			case 3:
				return p.getSemestar();

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

	public void azurirajTabelu(List<Predmet> predmeti){
		this.predmeti = predmeti;
		fireTableDataChanged();
	}
	public Predmet vratiPredmet(int rowIndex){
		return predmeti.get(rowIndex);
	}
	
}
