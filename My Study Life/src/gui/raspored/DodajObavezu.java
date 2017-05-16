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
import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import gui.modeli.FrameDragListener;

public class DodajObavezu extends JFrame {
	private JPanel contentPane;
	private JLabel lblIzaberiPredmet;
	private JLabel lblVreme;
	private JTextField textFieldH;
	private JLabel lblMesto;
	private JTextField textFieldMesto;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JLabel lblDodajIspit;
	private JLabel lblX;
	private JPanel panel;
	private JTextField textFieldM;
	private JLabel lblDvotacka;
	private JTextField textFieldObaveza;
	private JTextField txtDan;
	
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
		contentPane.add(getLblIzaberiPredmet());
		contentPane.add(getLblVreme());
		contentPane.add(getTextFieldH());
		contentPane.add(getLblMesto());
		contentPane.add(getTextFieldMesto());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		contentPane.add(getTextFieldM());
		contentPane.add(getLblDvotacka());
		contentPane.add(getTextFieldObaveza());
		contentPane.add(getTxtDan());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}
	private JLabel getLblIzaberiPredmet() {
		if (lblIzaberiPredmet == null) {
			lblIzaberiPredmet = new JLabel("Unesite obavezu");
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
	private JTextField getTextFieldH() {
		if (textFieldH == null) {
			textFieldH = new JTextField();
			textFieldH.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldH.setText("h");
			textFieldH.setBounds(214, 137, 50, 35);
			textFieldH.setColumns(10);
		}
		return textFieldH;
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
	private JTextField getTextFieldM() {
		if (textFieldM == null) {
			textFieldM = new JTextField();
			textFieldM.setText("m");
			textFieldM.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldM.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldM.setColumns(10);
			textFieldM.setBounds(279, 137, 50, 35);
		}
		return textFieldM;
	}
	private JLabel getLblDvotacka() {
		if (lblDvotacka == null) {
			lblDvotacka = new JLabel(":");
			lblDvotacka.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblDvotacka.setBounds(268, 139, 10, 27);
		}
		return lblDvotacka;
	}
	private JTextField getTextFieldObaveza() {
		if (textFieldObaveza == null) {
			textFieldObaveza = new JTextField();
			textFieldObaveza.setBounds(86, 78, 243, 25);
			textFieldObaveza.setColumns(10);
		}
		return textFieldObaveza;
	}
	private JTextField getTxtDan() {
		if (txtDan == null) {
			txtDan = new JTextField();
			txtDan.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txtDan.setHorizontalAlignment(SwingConstants.CENTER);
			txtDan.setText("dan");
			txtDan.setBounds(118, 137, 86, 35);
			txtDan.setColumns(10);
		}
		return txtDan;
	}
}
