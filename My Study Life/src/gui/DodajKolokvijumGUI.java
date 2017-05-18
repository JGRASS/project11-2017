package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import aktivnosti.Planer;
import gui.modeli.FrameDragListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Klasa predstavlja GUI za dodavanje kolokvijuma
 * @author Miro Maric
 * @version 1.0
 */
public class DodajKolokvijumGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBoxPredmeti;
	private JLabel lblIzaberiPredmet;
	private JLabel lblVreme;
	private JLabel lblMesto;
	private JTextField textFieldMesto;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JPanel panel;
	private JLabel lblDodajKolokvijum;
	private JLabel lblX;
	private JTextField textFieldH;
	private JLabel label;
	private JTextField textFieldM;
	public DodajKolokvijumGUI() {
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
		contentPane.add(getComboBoxPredmeti());
		contentPane.add(getLblIzaberiPredmet());
		contentPane.add(getLblVreme());
		contentPane.add(getLblMesto());
		contentPane.add(getTextFieldMesto());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		contentPane.add(getTextFieldH());
		contentPane.add(getLabel());
		contentPane.add(getTextFieldM());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}
	private JComboBox<String> getComboBoxPredmeti() { 
		if (comboBoxPredmeti == null) {
			comboBoxPredmeti = new JComboBox<String>();
			comboBoxPredmeti.setForeground(Color.WHITE);
			comboBoxPredmeti.setBackground(Color.GRAY);
			for(int i=0;i<GUIKontroler.SK.predmeti.size();i++){
				if(GUIKontroler.SK.predmeti.get(i).isPolozen()) continue;
				comboBoxPredmeti.addItem(GUIKontroler.SK.predmeti.get(i).getNaziv());
			}
			comboBoxPredmeti.setAlignmentX(comboBoxPredmeti.CENTER_ALIGNMENT);
			comboBoxPredmeti.setBounds(100, 75, 250, 35);
		}
		return comboBoxPredmeti;
	}
	private JLabel getLblIzaberiPredmet() {
		if (lblIzaberiPredmet == null) {
			lblIzaberiPredmet = new JLabel("Izaberi predmet:*");
			lblIzaberiPredmet.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIzaberiPredmet.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzaberiPredmet.setBounds(101, 46, 250, 27);
		}
		return lblIzaberiPredmet;
	}
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme:");
			lblVreme.setHorizontalAlignment(SwingConstants.CENTER);
			lblVreme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblVreme.setBounds(101, 110, 250, 27);
		}
		return lblVreme;
	}
	private JLabel getLblMesto() {
		if (lblMesto == null) {
			lblMesto = new JLabel("Amfiteatar/ucionica");
			lblMesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblMesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMesto.setBounds(100, 172, 250, 27);
		}
		return lblMesto;
	}
	private JTextField getTextFieldMesto() {
		if (textFieldMesto == null) {
			textFieldMesto = new JTextField();
			textFieldMesto.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldMesto.setFont(new Font("Courier New", Font.PLAIN, 15));
			textFieldMesto.setColumns(10);
			textFieldMesto.setBounds(148, 195, 155, 35);
		}
		return textFieldMesto;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setForeground(Color.WHITE);
			btnDodaj.setBackground(Color.GRAY);
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Kolokvijum k = new Kolokvijum();
					GregorianCalendar g = new GregorianCalendar();
					try {
						String naziv = comboBoxPredmeti.getItemAt(comboBoxPredmeti.getSelectedIndex()); //bug
						int index = GUIKontroler.vratiIndexPredmeta(naziv);
						if(index==-1)
							throw new IndexOutOfBoundsException();
						k.setPredmet(GUIKontroler.SK.predmeti.get(index));
						
						g.set(GregorianCalendar.YEAR, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR));
						g.set(GregorianCalendar.MONTH,GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH));
						g.set(GregorianCalendar.DATE, Integer.parseInt((String) GlavniProzorGUI.table.getValueAt(GlavniProzorGUI.table.getSelectedRow(),
								GlavniProzorGUI.table.getSelectedColumn())));
						k.setVremePolaganja(g);
						String satString = textFieldH.getText();
						String minutString = textFieldM.getText();
						if(!satString.equals("") || !minutString.equals("")){
							int sat = Integer.parseInt(satString);
							int minut = Integer.parseInt(minutString);
							g.set(GregorianCalendar.HOUR, sat);
							g.set(GregorianCalendar.MINUTE, minut);
							k.setVremePolaganja(g);
						}
						k.setMesto(textFieldMesto.getText());
						GUIKontroler.vratiSveAktivnosti().add(k);
						GUIKontroler.azurirajTabelu(GlavniProzorGUI.table);
						dispose();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Greska prilikom unosa vremena", "Greska", JOptionPane.OK_OPTION);
					}catch (IndexOutOfBoundsException e2){
						JOptionPane.showMessageDialog(null, "Nema unetih predmeta", "Greska", JOptionPane.OK_OPTION);
					}catch(Exception e3){
						
					}
				}
			});
			btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodaj.setBounds(57, 240, 140, 35);
			btnDodaj.setFocusPainted(false);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setForeground(Color.WHITE);
			btnOdustani.setBackground(Color.GRAY);
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnOdustani.setBounds(250, 240, 140, 35);
			btnOdustani.setFocusPainted(false);
		}
		return btnOdustani;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 450, 25);
			panel.setLayout(null);
			panel.add(getLblDodajKolokvijum());
			panel.add(getLblX());
		}
		return panel;
	}
	private JLabel getLblDodajKolokvijum() {
		if (lblDodajKolokvijum == null) {
			lblDodajKolokvijum = new JLabel("Dodaj kolokvijum");
			lblDodajKolokvijum.setForeground(Color.WHITE);
			lblDodajKolokvijum.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDodajKolokvijum.setBackground(Color.GRAY);
			lblDodajKolokvijum.setBounds(5, 0, 405, 25);
		}
		return lblDodajKolokvijum;
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
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblX.setBackground(Color.GRAY);
			lblX.setBounds(420, 0, 30, 20);
		}
		return lblX;
	}
	private JTextField getTextFieldH() {
		if (textFieldH == null) {
			textFieldH = new JTextField();
			textFieldH.setText("h");
			textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldH.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldH.setColumns(10);
			textFieldH.setBounds(168, 137, 50, 35);
		}
		return textFieldH;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(":");
			label.setFont(new Font("Tahoma", Font.PLAIN, 19));
			label.setBounds(222, 139, 10, 27);
		}
		return label;
	}
	private JTextField getTextFieldM() {
		if (textFieldM == null) {
			textFieldM = new JTextField();
			textFieldM.setText("m");
			textFieldM.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldM.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldM.setColumns(10);
			textFieldM.setBounds(233, 137, 50, 35);
		}
		return textFieldM;
	}
}

