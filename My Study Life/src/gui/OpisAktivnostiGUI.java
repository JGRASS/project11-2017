package gui;

import aktivnosti.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aktivnosti.Aktivnost;
import aktivnosti.Planer;
import gui.modeli.FrameDragListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OpisAktivnostiGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblX;
	private JLabel lblOpisAktivnosti;
	private JButton btnUkloniAktivnost;
	private JButton btnIzlaz;
	private JLabel lblNazivPredmeta;
	private JLabel lblIspisNaziva;
	private JLabel lblVreme;
	private JLabel lblIspisVremena;
	private JLabel lblMeseto;
	private JLabel lblIspisMesta;
	private JLabel lblRezultati;
	private Aktivnost aktivnost = GUIKontroler.pronadjiAktivnost(new GregorianCalendar(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR),
			GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH),Integer.parseInt((String) GlavniProzorGUI.table.getValueAt(GlavniProzorGUI.table.getSelectedRow()
					,GlavniProzorGUI.table.getSelectedColumn()))));
	private JTextField textFieldUnos;
	private JButton btnUnesi;
	
	public OpisAktivnostiGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createMatteBorder(
                1, 1, 1, 1, Color.GRAY));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getBtnUkloniAktivnost());
		contentPane.add(getBtnIzlaz());
		contentPane.add(getLblNazivPredmeta());
		contentPane.add(getLblIspisNaziva());
		contentPane.add(getLblVreme());
		contentPane.add(getLblIspisVremena());
		contentPane.add(getLblMeseto());
		contentPane.add(getLblIspisMesta());
		contentPane.add(getLblRezultati());
		contentPane.add(getTextFieldUnos());
		contentPane.add(getBtnUnesi());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 450, 25);
			panel.setBackground(Color.GRAY);
			panel.setPreferredSize(new Dimension(0, 20));
			panel.setLayout(null);
			panel.add(getLblX());
			panel.add(getLblOpisAktivnosti());
		}
		return panel;
	}
	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("x");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			lblX.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblX.setForeground(Color.WHITE);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setBounds(420, 0, 30, 20);
		}
		return lblX;
	}
	private JLabel getLblOpisAktivnosti() {
		if (lblOpisAktivnosti == null) {
			lblOpisAktivnosti = new JLabel("");
			lblOpisAktivnosti.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblOpisAktivnosti.setForeground(Color.WHITE);
			lblOpisAktivnosti.setBounds(5, 0, 405, 25);
			String tekst = "";
			if(aktivnost instanceof Kolokvijum)
				tekst+="Kolokvijum ";
			if(aktivnost instanceof Ispit)
				tekst+="Ispit ";
			tekst+=GUIKontroler.vratiDatumString(aktivnost.getVremePolaganja());
			lblOpisAktivnosti.setText(tekst);
		}
		return lblOpisAktivnosti;
	}
	private JButton getBtnUkloniAktivnost() {
		if (btnUkloniAktivnost == null) {
			btnUkloniAktivnost = new JButton("Ukloni aktivnost");
			btnUkloniAktivnost.setForeground(Color.WHITE);
			btnUkloniAktivnost.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnUkloniAktivnost.setFocusPainted(false);
			btnUkloniAktivnost.setBackground(Color.GRAY);
			btnUkloniAktivnost.setBounds(30, 340, 150, 35);
			btnUkloniAktivnost.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						int datum = Integer.parseInt((String) GlavniProzorGUI.table.getValueAt(GlavniProzorGUI.table.getSelectedRow(),
								GlavniProzorGUI.table.getSelectedColumn()));
						int mesec = GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH);
						int godina = GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR);
						GregorianCalendar g = new GregorianCalendar(godina,mesec,datum);
						for(int i=0;i<GUIKontroler.vratiSveAktivnosti().size();i++){
							if(GUIKontroler.istiDan(GUIKontroler.vratiSveAktivnosti().get(i).getVremePolaganja(),g)){
								int odgovor = JOptionPane.showConfirmDialog(OpisAktivnostiGUI.this,
								" Svaka evidencija o aktivnosti ce biti obrisana.\nDa li zaista zelite da uklonite odabranu aktivnost?",
								"Ukloni", JOptionPane.YES_NO_OPTION);
								if(odgovor==JOptionPane.YES_OPTION){
									GUIKontroler.vratiSveAktivnosti().remove(i);
									GUIKontroler.azurirajTabelu(GlavniProzorGUI.table);
									dispose();
									return;
								}
								break;
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(OpisAktivnostiGUI.this, "Morate prvo izabrati datum", "Greska", JOptionPane.OK_OPTION);
					}
				}
			});
			
		}
		return btnUkloniAktivnost;
	}
	private JButton getBtnIzlaz() {
		if (btnIzlaz == null) {
			btnIzlaz = new JButton("Izlaz");
			btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnIzlaz.setForeground(Color.WHITE);
			btnIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIzlaz.setFocusPainted(false);
			btnIzlaz.setBackground(Color.GRAY);
			btnIzlaz.setBounds(270, 340, 150, 35);
		}
		return btnIzlaz;
	}
	private JLabel getLblNazivPredmeta() {
		if (lblNazivPredmeta == null) {
			lblNazivPredmeta = new JLabel("Naziv predmeta:");
			lblNazivPredmeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNazivPredmeta.setHorizontalAlignment(SwingConstants.CENTER);
			lblNazivPredmeta.setBounds(10, 36, 430, 25);
		}
		return lblNazivPredmeta;
	}
	private JLabel getLblIspisNaziva() {
		if (lblIspisNaziva == null) {
			lblIspisNaziva = new JLabel("");
			lblIspisNaziva.setHorizontalAlignment(SwingConstants.CENTER);
			lblIspisNaziva.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIspisNaziva.setBounds(10, 61, 430, 25);
			lblIspisNaziva.setText(aktivnost.getPredmet().getNaziv());
		}
		return lblIspisNaziva;
	}
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme:");
			lblVreme.setHorizontalAlignment(SwingConstants.CENTER);
			lblVreme.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVreme.setBounds(10, 92, 430, 25);
		}
		return lblVreme;
	}
	private JLabel getLblIspisVremena() {
		if (lblIspisVremena == null) {
			lblIspisVremena = new JLabel((String) null);
			lblIspisVremena.setHorizontalAlignment(SwingConstants.CENTER);
			lblIspisVremena.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIspisVremena.setBounds(10, 117, 430, 25);
			lblIspisVremena.setText(GUIKontroler.vratiVremeString(aktivnost.getVremePolaganja()));
		}
		return lblIspisVremena;
	}
	private JLabel getLblMeseto() {
		if (lblMeseto == null) {
			lblMeseto = new JLabel("Amfiteatar/ucionica:");
			lblMeseto.setHorizontalAlignment(SwingConstants.CENTER);
			lblMeseto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMeseto.setBounds(10, 153, 430, 25);
		}
		return lblMeseto;
	}
	private JLabel getLblIspisMesta() {
		if (lblIspisMesta == null) {
			lblIspisMesta = new JLabel((String) null);
			lblIspisMesta.setHorizontalAlignment(SwingConstants.CENTER);
			lblIspisMesta.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIspisMesta.setBounds(10, 178, 430, 25);
			lblIspisMesta.setText(aktivnost.getMesto());
		}
		return lblIspisMesta;
	}
	private JLabel getLblRezultati() {
		if (lblRezultati == null) {
			lblRezultati = new JLabel("Unesi ocenu/rezultat:");
//			if(GlavniProzorGUI.selektovanDatum().before(new GregorianCalendar())){
//				lblRezultati.setText("Rezultati: ");
//				lblRezultati.setVisible(true);
//			}
			lblRezultati.setHorizontalAlignment(SwingConstants.CENTER);
			lblRezultati.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblRezultati.setBounds(10, 214, 430, 25);
		}
		return lblRezultati;
	}
	private JTextField getTextFieldUnos() {
		if (textFieldUnos == null) {
			textFieldUnos = new JTextField();
			textFieldUnos.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldUnos.setBounds(145, 250, 160, 35);
			textFieldUnos.setColumns(10);
			if(GUIKontroler.selektovanDatum(GlavniProzorGUI.table).after(new GregorianCalendar())){
				textFieldUnos.setEnabled(false);
				String brDana = String.format("%.2f",((float)(aktivnost.getVremePolaganja().getTimeInMillis() - new GregorianCalendar().getTimeInMillis())/(3600000*24)));
				textFieldUnos.setText("Jos "+brDana+" dana");
			}
		}
		if(aktivnost.isEvidentirana()){
			if(aktivnost instanceof Ispit){
				textFieldUnos.setText(("Ocena: "+(int)((Ispit)aktivnost).vratiOcenu()));
			}
			else
				textFieldUnos.setText("Broj poena: "+((Kolokvijum)aktivnost).vratiBrojPoena()+"");
		}
		return textFieldUnos;
	}
	private JButton getBtnUnesi() {
		if (btnUnesi == null) {
			btnUnesi = new JButton("Unesi");
			btnUnesi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						double rezultat =Float.parseFloat(textFieldUnos.getText());
						if(aktivnost instanceof Kolokvijum){
							((Kolokvijum)aktivnost).postaviBrojPoena(rezultat);
							aktivnost.setEvidentirana(true);
						}
						else{
							((Ispit)aktivnost).postaviOcenu((int)rezultat);
							
							aktivnost.setEvidentirana(true);
							
							for(int i=0;i<GUIKontroler.predmeti.size();i++){
								if(aktivnost.getPredmet().getNaziv().equals(GUIKontroler.predmeti.get(i).getNaziv())){
									GUIKontroler.predmeti.get(i).setPolozen(true);
									GUIKontroler.predmeti.get(i).setOcena((int)rezultat);
									GUIKontroler.azurirajTabeluPredmet();
									GUIKontroler.azurirajListuPolozeni();
									GUIKontroler.polozeni.get(GUIKontroler.polozeni.indexOf(GUIKontroler.predmeti.get(i))).setOcena((int)rezultat);
									GUIKontroler.azurirajTabeluPolozeni();
									GUIKontroler.azurirajProsek();
								}
							}
						}
						dispose();
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,"Pogresno uneti rezultati", "Greska", JOptionPane.OK_OPTION);
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null,e.getMessage(), "Greska", JOptionPane.OK_OPTION);
					}
				}
			});
			if(GUIKontroler.selektovanDatum(GlavniProzorGUI.table).after(new GregorianCalendar()))
				btnUnesi.setEnabled(false);
			btnUnesi.setForeground(Color.WHITE);
			btnUnesi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnUnesi.setFocusPainted(false);
			btnUnesi.setBackground(Color.GRAY);
			btnUnesi.setBounds(150, 294, 150, 35);
			
		}
		return btnUnesi;
	}
}
