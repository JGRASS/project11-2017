package sismeskiKontroler;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import aktivnosti.Aktivnost;
import aktivnosti.Planer;
import gui.modeli.MojaTabela;
import gui.modeli.PlanerTabelaModel;
import aktivnosti.Obaveza;
import predmeti.Predmet;
import sistemskeOperacije.SOAzurirajListuPolozenih;
import sistemskeOperacije.SOAzurirajProsek;
import sistemskeOperacije.SOAzurirajTabeluPolozenih;
import sistemskeOperacije.SOAzurirajTabeluPredmeta;

import sistemskeOperacije.SOIstiDan;
import sistemskeOperacije.SOPopuniMatricuDatuma;
import sistemskeOperacije.SOPronadjiAktivnost;
import sistemskeOperacije.SOSelektovaniDatum;
import sistemskeOperacije.SOSerijalizujAktivnosti;

import sistemskeOperacije.SOSerijalizujObaveze;
import sistemskeOperacije.SOSerijalizujPolozene;
import sistemskeOperacije.SOSerijalizujPredmete;
import sistemskeOperacije.SOUcitajAktivnosti;
import sistemskeOperacije.SOUcitajObaveze;
import sistemskeOperacije.SOUcitajPolozene;
import sistemskeOperacije.SOUcitajPredmete;
import sistemskeOperacije.SOVratiDatumString;
import sistemskeOperacije.SOVratiESPB;
import sistemskeOperacije.SOVratiNazivSlike;
import sistemskeOperacije.SOVratiProsek;
import sistemskeOperacije.SOVratiVremeString;

public class SistemskiKontroler {
	public static Planer planer  = new Planer();
	public static List<Predmet> predmeti = new LinkedList<>();
	public static List<Predmet> polozeni = new LinkedList<>();
	public static List<Obaveza> obaveze = new LinkedList<>();
	
	
	public static List<Aktivnost> vratiSveAktivnosti(){
		return planer.vratiSveAktivnosti();
	}
	public static GregorianCalendar vratiTrenutnoVreme(){
		return planer.vratiGc();
	}
	
	public static String[][] vratiDatume(){
		return planer.vratiDatume();
	}
	
	public static void azurirajTabelu(MojaTabela table) {
		PlanerTabelaModel model = (PlanerTabelaModel) table.getModel();
		model.azurirajTabelu(vratiDatume());
	}
	
	public static String vratiNazivSlike() {
		return SOVratiNazivSlike.izvrsi();
	}
	
	public static void serijalizujAktivnosti(){
		SOSerijalizujAktivnosti.izvrsi(planer.aktivnosti);
	}
	
	public static void ucitajAktivnosti(){
		planer.aktivnosti = SOUcitajAktivnosti.izvrsi();
	}
	
	public static void postaviGc (){
		planer.postaviGc(new GregorianCalendar());
		
	}
	
	public static GregorianCalendar selektovanDatum(MojaTabela table) {
		return SOSelektovaniDatum.izvrsi(table);
	}
	
	public static String vratiDatumString(GregorianCalendar g){
		return SOVratiDatumString.izvrsi(g);
	}
	
	public static String vratiVremeString(GregorianCalendar g){
		return SOVratiVremeString.izvrsi(g);
	}
	
	public static int vratiIndexPredmeta(String naziv){
		for(int i=0;i<predmeti.size();i++){
			if(predmeti.get(i).getNaziv().equals(naziv))
				return i;
		}
		return -1;
	}
	
	public static boolean istiDan(GregorianCalendar g1,GregorianCalendar g2){
		return SOIstiDan.izvrsi(g1, g2);
	}
	
	public static void popuniMatricuDatuma(){
		SOPopuniMatricuDatuma.izvrsi(planer.vratiGc(), planer.vratiDatume());
	}
	
	public static Aktivnost pronadjiAktivnost(GregorianCalendar g){
		return SOPronadjiAktivnost.izvrsi(planer.aktivnosti, g);
	}
	
	public static void ucitajPredmete(){
		SOUcitajPredmete.izvrsi();
	}
	
	public static void serijalizujPredmete(){
		SOSerijalizujPredmete.izvrsi();
		
	}
	
	public static void ucitajPolozene(){
		SOUcitajPolozene.izvrsi();
	}

	public static  void serijalizujPolozene(){
		SOSerijalizujPolozene.izvrsi();
	}
	
	public static void ucitajObaveze(){
		SOUcitajObaveze.izvrsi();
	}

	public static void serijalizujObaveze(){
		SOSerijalizujObaveze.izvrsi();
	}
	
	public static void dodajObavezu(Obaveza o){
		obaveze.add(o);
	}
	
	public static void izbrisiObavezu(Obaveza o){
		obaveze.remove(o);
	}
	
	public static void azurirajTabeluPredmet(){
		SOAzurirajTabeluPredmeta.izvrsi();
		
	}
	
	public static void azurirajTabeluPolozeni(){
		SOAzurirajTabeluPolozenih.izvrsi();
	}
	
	public static void azurirajListuPolozeni(){
		SOAzurirajListuPolozenih.izvrsi();
	}
	

	public static double vratiProsek(){
		return SOVratiProsek.izvrsi();
	}
	
	public static void azurirajProsek(){
		SOAzurirajProsek.izvrsi();
	}
	
	public static int vratiESPB(){
		return SOVratiESPB.izvrsi();
	}
	
	public static List<Predmet> vratiPredmete(){
		return predmeti;
	}
	
	public static List<Predmet> vratiPolozene(){
		return polozeni;
	}
	
	public static List<Obaveza> vratiObaveze(){
		return obaveze;
	}

}
