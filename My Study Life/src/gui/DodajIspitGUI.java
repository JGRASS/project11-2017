package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import gui.modeli.FrameDragListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DodajIspitGUI extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBoxPredmeti;
	private JLabel lblIzaberiPredmet;
	private JLabel lblVreme;
	private JTextField textFieldVreme;
	private JLabel lblMesto;
	private JTextField textFieldMesto;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JLabel lblDodajIspit;
	private JLabel lblX;
	private JPanel panel;
	
	public DodajIspitGUI() {
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
		contentPane.add(getTextFieldVreme());
		contentPane.add(getLblMesto());
		contentPane.add(getTextFieldMesto());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}
	private JComboBox<String> getComboBoxPredmeti() { 
		if (comboBoxPredmeti == null) {
			comboBoxPredmeti = new JComboBox<String>();
			comboBoxPredmeti.setForeground(Color.WHITE);
			comboBoxPredmeti.setBackground(Color.GRAY);
			for(int i=0;i<GUIKontroler.predmeti.size();i++){
				comboBoxPredmeti.addItem(GUIKontroler.predmeti.get(i).getNaziv());
			}
			comboBoxPredmeti.setAlignmentX(comboBoxPredmeti.CENTER_ALIGNMENT);
			comboBoxPredmeti.setBounds(86, 74, 250, 35);
		}
		return comboBoxPredmeti;
	}
	private JLabel getLblIzaberiPredmet() {
		if (lblIzaberiPredmet == null) {
			lblIzaberiPredmet = new JLabel("Izaberi predmet:*");
			lblIzaberiPredmet.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIzaberiPredmet.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzaberiPredmet.setBounds(86, 45, 250, 27);
		}
		return lblIzaberiPredmet;
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
	private JTextField getTextFieldVreme() {
		if (textFieldVreme == null) {
			textFieldVreme = new JTextField();
			textFieldVreme.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldVreme.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldVreme.setText("h:m");
			textFieldVreme.setBounds(133, 136, 153, 35);
			textFieldVreme.setColumns(10);
		}
		return textFieldVreme;
	}
	private JLabel getLblMesto() {
		if (lblMesto == null) {
			lblMesto = new JLabel("Amfiteatar/ucionica");
			lblMesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblMesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblMesto.setBounds(86, 171, 250, 27);
		}
		return lblMesto;
	}
	private JTextField getTextFieldMesto() {
		if (textFieldMesto == null) {
			textFieldMesto = new JTextField();
			textFieldMesto.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldMesto.setFont(new Font("Courier New", Font.PLAIN, 15));
			textFieldMesto.setColumns(10);
			textFieldMesto.setBounds(133, 194, 153, 35);
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
					Ispit i = new Ispit();
					i.setPredmet(GUIKontroler.predmeti.get(comboBoxPredmeti.getSelectedIndex()));
					GregorianCalendar g = new GregorianCalendar();
					g.set(GregorianCalendar.YEAR, GUIKontroler.gc.get(GregorianCalendar.YEAR));
					g.set(GregorianCalendar.MONTH,GUIKontroler.gc.get(GregorianCalendar.MONTH));
					g.set(GregorianCalendar.DATE, Integer.parseInt((String) GlavniProzorGUI.table.getValueAt(GlavniProzorGUI.table.getSelectedRow(),
							GlavniProzorGUI.table.getSelectedColumn())));
					String sat = textFieldVreme.getText().substring(0, textFieldVreme.getText().indexOf(':'));
					String minut = textFieldVreme.getText().substring(textFieldVreme.getText().indexOf(':')+1,textFieldVreme.getText().length() );
					g.set(GregorianCalendar.HOUR, Integer.parseInt(sat));
					g.set(GregorianCalendar.MINUTE, Integer.parseInt(minut));	
					i.setVremePolaganja(g);
					i.setMesto(textFieldMesto.getText());
					GUIKontroler.aktivnosti.add(i);
					GlavniProzorGUI.azurirajTabelu(); //GuiKontroler?
					dispose();
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
			btnOdustani.setBounds(217, 240, 140, 35);
			btnOdustani.setFocusPainted(false);
		}
		return btnOdustani;
	}

	private JLabel getLblDodajIspit() {
		if (lblDodajIspit == null) {
			lblDodajIspit = new JLabel("Dodaj ispit");
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
}
