package gui;


import javax.swing.BorderFactory;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;
import javax.swing.JButton;

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

	
	private Aktivnost aktivnost = GUIKontroler.pronadjiAktivnost(new GregorianCalendar(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR),
			GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH),Integer.parseInt((String) GlavniProzorGUI.table.getValueAt(GlavniProzorGUI.table.getSelectedRow()
					,GlavniProzorGUI.table.getSelectedColumn()))));
	private JLabel lblMeseto;
	private JLabel lblIspisMesta;
	
	public OpisAktivnostiGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
			lblOpisAktivnosti.setText(GUIKontroler.vratiDatumString(aktivnost.getVremePolaganja()));
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
			btnUkloniAktivnost.setBounds(261, 254, 150, 35);
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
								int odgovor = JOptionPane.showConfirmDialog(OpisAktivnostiGUI.this, "Da li zaista zelite da uklonite odabranu aktivnost?",
										"Ukloni", JOptionPane.YES_NO_OPTION);
								if(odgovor==JOptionPane.YES_OPTION){
									GUIKontroler.vratiSveAktivnosti().remove(i);
									GlavniProzorGUI.azurirajTabelu();
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
			btnIzlaz.setBounds(50, 254, 150, 35);
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
}
