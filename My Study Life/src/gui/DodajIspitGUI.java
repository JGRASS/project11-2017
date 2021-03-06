package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import gui.modeli.FrameDragListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Klasa predstavlja GUI za dodavanje ispita
 * @author Miro Maric
 * @version 1.0
 */
public class DodajIspitGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBoxPredmeti;
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
	private JLabel lblDvodatcka;
	
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
		contentPane.add(getTextFieldH());
		contentPane.add(getLblMesto());
		contentPane.add(getTextFieldMesto());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		contentPane.add(getTextFieldM());
		contentPane.add(getLblDvodatcka());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}
	private JComboBox<String> getComboBoxPredmeti() { 
		if (comboBoxPredmeti == null) {
			comboBoxPredmeti = new JComboBox<String>();
			comboBoxPredmeti.setForeground(Color.WHITE);
			comboBoxPredmeti.setBackground(Color.GRAY);
			for(int i=0;i<GUIKontroler.vratiPredmete().size();i++){
				if(GUIKontroler.vratiPredmete().get(i).isPolozen()) continue;
				comboBoxPredmeti.addItem(GUIKontroler.vratiPredmete().get(i).getNaziv());
			}
			comboBoxPredmeti.setAlignmentX(Component.CENTER_ALIGNMENT);
			comboBoxPredmeti.setBounds(100, 77, 250, 35);
		}
		return comboBoxPredmeti;
	}
	private JLabel getLblIzaberiPredmet() {
		if (lblIzaberiPredmet == null) {
			lblIzaberiPredmet = new JLabel("Izaberi predmet:*");
			lblIzaberiPredmet.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIzaberiPredmet.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzaberiPredmet.setBounds(100, 47, 250, 27);
		}
		return lblIzaberiPredmet;
	}
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme:");
			lblVreme.setHorizontalAlignment(SwingConstants.CENTER);
			lblVreme.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblVreme.setBounds(100, 111, 250, 27);
		}
		return lblVreme;
	}
	private JTextField getTextFieldH() {
		if (textFieldH == null) {
			textFieldH = new JTextField();
			textFieldH.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldH.setText("h");
			textFieldH.setBounds(166, 138, 50, 35);
			textFieldH.setColumns(10);
		}
		return textFieldH;
	}
	private JLabel getLblMesto() {
		if (lblMesto == null) {
			lblMesto = new JLabel("Amfiteatar/ucionica");
			lblMesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblMesto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMesto.setBounds(100, 173, 250, 27);
		}
		return lblMesto;
	}
	private JTextField getTextFieldMesto() {
		if (textFieldMesto == null) {
			textFieldMesto = new JTextField();
			textFieldMesto.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldMesto.setFont(new Font("Courier New", Font.PLAIN, 15));
			textFieldMesto.setColumns(10);
			textFieldMesto.setBounds(150, 196, 150, 35);
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
					GregorianCalendar g = new GregorianCalendar();
					try {
						String naziv = comboBoxPredmeti.getItemAt(comboBoxPredmeti.getSelectedIndex());
						int index = GUIKontroler.vratiIndexPredmeta(naziv);
						if(index==-1)
							throw new IndexOutOfBoundsException();
						i.setPredmet(GUIKontroler.vratiPredmete().get(index));
						
						g.set(GregorianCalendar.YEAR, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR));
						g.set(GregorianCalendar.MONTH,GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH));
						g.set(GregorianCalendar.DATE, Integer.parseInt((String) GlavniProzorGUI.table.getValueAt(GlavniProzorGUI.table.getSelectedRow(),
								GlavniProzorGUI.table.getSelectedColumn())));
						i.setVremePolaganja(g);
						String satString = textFieldH.getText();
						String minutString = textFieldM.getText();
						if(!satString.equals("") || !minutString.equals("")){
							int sat = Integer.parseInt(satString);
							int minut = Integer.parseInt(minutString);
							g.set(GregorianCalendar.HOUR, sat);
							g.set(GregorianCalendar.MINUTE, minut);
							i.setVremePolaganja(g);
						}
						i.setMesto(textFieldMesto.getText());
						GUIKontroler.vratiSveAktivnosti().add(i);
						GUIKontroler.azurirajTabelu(GlavniProzorGUI.table);
						dispose();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Greska prilikom unosa vremena", "Greska", JOptionPane.OK_OPTION);
					}catch (IndexOutOfBoundsException e2){
						JOptionPane.showMessageDialog(null, "Nema unetih predmeta", "Greska", JOptionPane.OK_OPTION);
					}catch(Exception e3){
						System.out.println(e3);
					}
				}
			});
			btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnDodaj.setBounds(50, 240, 140, 35);
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
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnOdustani.setBounds(250, 240, 140, 35);
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
	private JTextField getTextFieldM() {
		if (textFieldM == null) {
			textFieldM = new JTextField();
			textFieldM.setText("m");
			textFieldM.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldM.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldM.setColumns(10);
			textFieldM.setBounds(231, 138, 50, 35);
		}
		return textFieldM;
	}
	private JLabel getLblDvodatcka() {
		if (lblDvodatcka == null) {
			lblDvodatcka = new JLabel(":");
			lblDvodatcka.setFont(new Font("Tahoma", Font.PLAIN, 19));
			lblDvodatcka.setBounds(220, 140, 10, 27);
		}
		return lblDvodatcka;
	}
}
