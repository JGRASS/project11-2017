package aktivnosti;

import java.io.Serializable;

public class Obaveza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6241531167998558832L;
	private String naziv;
	private String dan;
	private String sat;
	private String minut;
	private String mesto;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if (naziv != null && naziv != "") {
			this.naziv = naziv;
		}else 
			throw new RuntimeException("Naziv obaveze ne moze biti null");
	}
	public String getDan() {
		return dan;
	}
	public void setDan(String dan) {
		if (dan != null && dan != "") {
			this.dan = dan;
		}else 
			throw new RuntimeException("Dan obaveze ne moze biti null");
	}
	public String getSat() {
		return sat;
	}
	public void setSat(String sat) {
		if (sat != null && sat != "") {
			this.sat = sat;
		}else 
			throw new RuntimeException("Sat obaveze ne moze biti null");
	}
	public String getMinut() {
		return minut;
	}
	public void setMinut(String minut) {
		if (minut != null && minut != "") {
			this.minut = minut;
		}else 
			throw new RuntimeException("Minut obaveze ne moze biti null");
	}
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		if (mesto != null && mesto != "") {
			this.mesto = mesto;
		}else 
			throw new RuntimeException("Mesto obaveze ne moze biti null");
	}
	
}
