package gui.raspored;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import aktivnosti.Ispit;
import aktivnosti.Obaveza;
import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import gui.modeli.FrameDragListener;
import sismeskiKontroler.SistemskiKontroler;

import javax.swing.DefaultComboBoxModel;

public class DodajObavezu extends JFrame {
	private JPanel contentPane;
	private JLabel lblObaveza;
	private JLabel lblVreme;
	private JLabel lblMesto;
	private JTextField txtMesto;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JLabel lblDodajIspit;
	private JLabel lblX;
	private JPanel panel;
	private JLabel lblDvotacka;
	private JTextField txtObaveza;
	private JTextField txtDan;
	private JLabel lblDan;
	private JLabel lblSat;
	private JLabel lblMinut;
	private JComboBox comboBoxSat;
	private JComboBox comboBoxMinut;
	
	public DodajObavezu() {
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
		contentPane.add(getLblObaveza());
		contentPane.add(getLblVreme());
		contentPane.add(getLblMesto());
		contentPane.add(getTxtMesto());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		contentPane.add(getLblDvotacka());
		contentPane.add(getTxtObaveza());
		contentPane.add(getTxtDan());
		contentPane.add(getLblDan());
		contentPane.add(getLblSat());
		contentPane.add(getLblMinut());
		contentPane.add(getComboBoxSat());
		contentPane.add(getComboBox_1());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}
	private JLabel getLblObaveza() {
		if (lblObaveza == null) {
			lblObaveza = new JLabel("Unesite obavezu");
			lblObaveza.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblObaveza.setHorizontalAlignment(SwingConstants.CENTER);
			lblObaveza.setBounds(86, 45, 250, 27);
		}
		return lblObaveza;
	}
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme:");
			lblVreme.setHorizontalAlignment(SwingConstants.CENTER);
			lblVreme.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblVreme.setBounds(86, 109, 250, 27);
		}
		return lblVreme;
	}
	private JLabel getLblMesto() {
		if (lblMesto == null) {
			lblMesto = new JLabel("Mesto");
			lblMesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblMesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMesto.setBounds(86, 171, 250, 27);
		}
		return lblMesto;
	}
	private JTextField getTxtMesto() {
		if (txtMesto == null) {
			txtMesto = new JTextField();
			txtMesto.setHorizontalAlignment(SwingConstants.CENTER);
			txtMesto.setFont(new Font("Courier New", Font.PLAIN, 15));
			txtMesto.setColumns(10);
			txtMesto.setBounds(133, 194, 153, 35);
		}
		return txtMesto;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ((txtObaveza.getText() != "") && (txtMesto.getText() != "") &&
						((txtDan.getText() == "NED") || (txtDan.getText() == "PON")|| (txtDan.getText() == "UTO") || (txtDan.getText() == "SRE") || (txtDan.getText() == "CET") || (txtDan.getText() == "PET") || (txtDan.getText() == "SUB"))
						 ) {
						Obaveza o = new Obaveza();
						o.setNaziv(txtObaveza.getText());
						o.setDan(txtDan.getText());
						o.setSat((String)comboBoxSat.getSelectedItem());
						o.setMinut((String)comboBoxMinut.getSelectedItem());
						o.setMesto(txtMesto.getText());
						GUIKontroler.dodajObavezu(o);
						GUIKontroler.azurirajTabeluObaveza(o);
					}else{
						System.out.println("Morate popuniti sva polja, i dan ukucati u formatu: PON, UTO, SRE ...");
					}
				}
			});
			btnDodaj.setForeground(Color.WHITE);
			btnDodaj.setBackground(Color.GRAY);
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
			btnOdustani.setBounds(217, 240, 140, 35);
			btnOdustani.setFocusPainted(false);
		}
		return btnOdustani;
	}

	private JLabel getLblDodajIspit() {
		if (lblDodajIspit == null) {
			lblDodajIspit = new JLabel("Dodaj obavezu");
			lblDodajIspit.setBounds(5, 0, 405, 25);
			lblDodajIspit.setBackground(Color.GRAY);
			lblDodajIspit.setForeground(Color.WHITE);
			lblDodajIspit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblDodajIspit;
	}
	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("x");
			lblX.setBounds(420, 0, 30, 20);
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				}
			});
			lblX.setBackground(Color.GRAY);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Tahoma", Font.BOLD, 19));
		}
		return lblX;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 450, 25);
			panel.setLayout(null);
			panel.add(getLblDodajIspit());
			panel.add(getLblX());
		}
		return panel;
	}
	private JLabel getLblDvotacka() {
		if (lblDvotacka == null) {
			lblDvotacka = new JLabel(":");
			lblDvotacka.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblDvotacka.setBounds(268, 145, 10, 27);
		}
		return lblDvotacka;
	}
	private JTextField getTxtObaveza() {
		if (txtObaveza == null) {
			txtObaveza = new JTextField();
			txtObaveza.setBounds(86, 78, 243, 25);
			txtObaveza.setColumns(10);
		}
		return txtObaveza;
	}
	private JTextField getTxtDan() {
		if (txtDan == null) {
			txtDan = new JTextField();
			txtDan.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDan.setHorizontalAlignment(SwingConstants.CENTER);
			txtDan.setBounds(118, 147, 86, 25);
			txtDan.setColumns(10);
		}
		return txtDan;
	}
	private JLabel getLblDan() {
		if (lblDan == null) {
			lblDan = new JLabel("Dan");
			lblDan.setHorizontalAlignment(SwingConstants.CENTER);
			lblDan.setBounds(133, 134, 46, 14);
		}
		return lblDan;
	}
	private JLabel getLblSat() {
		if (lblSat == null) {
			lblSat = new JLabel("Sat");
			lblSat.setHorizontalAlignment(SwingConstants.CENTER);
			lblSat.setBounds(218, 134, 46, 14);
		}
		return lblSat;
	}
	private JLabel getLblMinut() {
		if (lblMinut == null) {
			lblMinut = new JLabel("Minut");
			lblMinut.setHorizontalAlignment(SwingConstants.CENTER);
			lblMinut.setBounds(283, 134, 46, 14);
		}
		return lblMinut;
	}
	private JComboBox getComboBoxSat() {
		if (comboBoxSat == null) {
			comboBoxSat = new JComboBox();
			comboBoxSat.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
			comboBoxSat.setMaximumRowCount(12);
			comboBoxSat.setBounds(217, 151, 46, 20);
		}
		return comboBoxSat;
	}
	private JComboBox getComboBox_1() {
		if (comboBoxMinut == null) {
			comboBoxMinut = new JComboBox();
			comboBoxMinut.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "56", "57", "58", "59", "60"}));
			comboBoxMinut.setBounds(282, 152, 39, 20);
		}
		return comboBoxMinut;
	}
}
