package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import gui.modeli.FrameDragListener;
import gui.modeli.MojaTabela;
import gui.modeli.PlanerTabelaModel;
import gui.modeli.PrikazPolozenihTabelaModel;
import gui.modeli.PrikazPredmetaTabelaModel;
import gui.modeli.PrikazRasporedTabelaModel;
import jdk.net.NetworkPermission;

import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Ivan Stanimirovic
 * @author Milos Mirkovic
 * @author Miro Maric
 * @version 1.0.0
 *
 */
public class GlavniProzorGUI extends JFrame {
	private static final long serialVersionUID = 7088262915872956309L;
	public static final Component GlavniProzorGUI = null;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelPlaner;
	private JPanel panelPredmeti;
	private JPanel panelRasporedObaveza;
	private JPanel panelPolozeniIspiti;
	public static MojaTabela table; // GuiKontroler?
	private JLabel lblNed;
	private JLabel lblPon;
	private JLabel lblUto;
	private JLabel lblSre;
	private JLabel lblCet;
	private JLabel lblPet;
	private JLabel lblSub;
	private JButton btnPrethodniMesec;
	private JButton btnSledeciMesec;
	private JLabel lblDatum;
	private JButton btnPrethodnaGodina;
	private JButton btnSledecaGodina;
	private JButton btnDodajKolokvijum;
	private JButton btnDodajIspit;
	private JButton btnDodaj;
	private JButton btnIzmeni;
	private JButton btnObrisi;
	private JScrollPane scrollPane;
	public static JTable tablePredmeti;
	private JButton btnPregledPredmeta;
	private JLabel lblKolokvijumBoja;
	private JLabel lblKolokvijum;
	private JLabel lblIspitBoja;
	private JLabel lblIspit;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JPanel panelTitleBar;
	private JPanel panelNaslov;
	private JLabel lblX;
	private JLabel lblNaslov;
	public static JTable tablePolozeni;
	private JScrollPane scrollPanePolozeni;
	private JLabel lblProsek;
	public static JTextField textFieldProsek;
	private JLabel labelBrBodova;
	public static JTextField textFieldBrojBodova;
	private JButton btnDodajObavezu;
	private JButton btnIzbrisiObavezu;
	private String[][] raspored = new String[7][7];
	private JTable tableraspored;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;

	public GlavniProzorGUI() {
		setResizable(false);
		setTitle("MyStudyLife");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
		contentPane.add(getPanelTitleBar(), BorderLayout.NORTH);
		podesiPozadinu();
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);

	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setForeground(Color.WHITE);
			tabbedPane.setBackground(Color.GRAY);
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
			tabbedPane.setFocusable(false);
			tabbedPane.addTab("Planer", null, getPanelPlaner(), null);
			tabbedPane.addTab("Raspored nastave", null, getPanelRasporedObaveza(), null);
			tabbedPane.addTab("Predmeti", null, getPanelPredmeti(), null);
			tabbedPane.addTab("Poloeni ispiti", null, getPanelPolozeniIspiti(), null);
			tabbedPane.addTab("Polozeni ispiti", null, getPanelPolozeniIspiti(), null);

		}
		return tabbedPane;
	}

	private JPanel getPanelPlaner() {
		if (panelPlaner == null) {
			panelPlaner = new JPanel();
			panelPlaner.setLayout(null);
			panelPlaner.setLayout(null);
			panelPlaner.add(getTable());
			panelPlaner.add(getLblNed());
			panelPlaner.add(getLblPon());
			panelPlaner.add(getLblUto());
			panelPlaner.add(getLblSre());
			panelPlaner.add(getLblCet());
			panelPlaner.add(getLblPet());
			panelPlaner.add(getLblSub());
			panelPlaner.add(getBtnPrethodniMesec());
			panelPlaner.add(getBtnSledeciMesec());
			panelPlaner.add(getLblDatum());
			panelPlaner.add(getBtnPrethodnaGodina());
			panelPlaner.add(getBtnSledecaGodina());
			panelPlaner.add(getBtnDodajKolokvijum());
			panelPlaner.add(getBtnDodajIspit());
			panelPlaner.add(getLblKolokvijumBoja());
			panelPlaner.add(getLblKolokvijum());
			panelPlaner.add(getLblIspitBoja());
			panelPlaner.add(getLblIspit());
		}
		return panelPlaner;
	}

	private JPanel getPanelPredmeti() {
		if (panelPredmeti == null) {
			panelPredmeti = new JPanel();
			panelPredmeti.setLayout(null);

			panelPredmeti.add(getScrollPane());
			panelPredmeti.add(getBtnDodaj());
			panelPredmeti.add(getBtnPregledPredmeta());
			panelPredmeti.add(getBtnIzmeni());
			panelPredmeti.add(getBtnObrisi());

		}
		return panelPredmeti;
	}

	private JPanel getPanelRasporedObaveza() {
		if (panelRasporedObaveza == null) {
			panelRasporedObaveza = new JPanel();
			panelRasporedObaveza.setLayout(null);

			JLabel label = new JLabel("NED");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label.setBackground(Color.GRAY);
			label.setBounds(52, 11, 98, 35);
			label.setOpaque(true);
			panelRasporedObaveza.add(label);

			JLabel label_1 = new JLabel("PON");
			label_1.setOpaque(true);
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_1.setBackground(Color.GRAY);
			label_1.setBounds(149, 11, 98, 35);
			panelRasporedObaveza.add(label_1);

			JLabel label_2 = new JLabel("UTO");
			label_2.setOpaque(true);
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_2.setBackground(Color.GRAY);
			label_2.setBounds(245, 11, 108, 35);
			panelRasporedObaveza.add(label_2);

			JLabel label_3 = new JLabel("SRE");
			label_3.setOpaque(true);
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_3.setBackground(Color.GRAY);
			label_3.setBounds(349, 11, 93, 35);
			panelRasporedObaveza.add(label_3);

			JLabel label_4 = new JLabel("CET");
			label_4.setOpaque(true);
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_4.setBackground(Color.GRAY);
			label_4.setBounds(432, 11, 108, 35);
			panelRasporedObaveza.add(label_4);

			JLabel label_5 = new JLabel("PET");
			label_5.setOpaque(true);
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setForeground(Color.WHITE);
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_5.setBackground(Color.GRAY);
			label_5.setBounds(538, 11, 98, 35);
			panelRasporedObaveza.add(label_5);

			JLabel label_6 = new JLabel("SUB");
			label_6.setOpaque(true);
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			label_6.setForeground(Color.WHITE);
			label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_6.setBackground(Color.GRAY);
			label_6.setBounds(631, 11, 101, 35);
			panelRasporedObaveza.add(label_6);
			panelRasporedObaveza.add(getLabel_7());
			panelRasporedObaveza.add(getLabel_14());
			panelRasporedObaveza.add(getLabel_8());
			panelRasporedObaveza.add(getLabel_9());
			panelRasporedObaveza.add(getLabel_10());
			panelRasporedObaveza.add(getLabel_11());
			panelRasporedObaveza.add(getLabel_12());

			JLabel label_13 = new JLabel("19:00");
			label_13.setOpaque(true);
			label_13.setHorizontalAlignment(SwingConstants.CENTER);
			label_13.setForeground(Color.WHITE);
			label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_13.setBackground(Color.BLACK);
			label_13.setBounds(10, 460, 46, 40);
			panelRasporedObaveza.add(label_13);
			panelRasporedObaveza.add(getLabel_15());
			panelRasporedObaveza.add(getLabel_16());
			panelRasporedObaveza.add(getLabel_17());
			panelRasporedObaveza.add(getLabel_18());
			panelRasporedObaveza.add(getBtnDodajObavezu());
			panelRasporedObaveza.add(getBtnIzbrisiObavezu());
			panelRasporedObaveza.add(getTableraspored());
		}
		return panelRasporedObaveza;
	}

	private JPanel getPanelPolozeniIspiti() {
		if (panelPolozeniIspiti == null) {
			panelPolozeniIspiti = new JPanel();
			panelPolozeniIspiti.setBorder(null);
			panelPolozeniIspiti.add(getScrollPanePolozeni());
			panelPolozeniIspiti.add(getLblProsek());
			panelPolozeniIspiti.add(getTextFieldProsek());
			panelPolozeniIspiti.add(getLabelBrBodova());
			panelPolozeniIspiti.add(getTextFieldBrojBodova());
		}
		return panelPolozeniIspiti;
	}

	private JTable getTable() {
		if (table == null) {
			table = new MojaTabela();
			table.setBorder(new LineBorder(Color.WHITE));
			table.setModel(new PlanerTabelaModel(GUIKontroler.vratiDatume()));
			table.setBounds(64, 60, 680, 390);
			table.setRowHeight(65);
			table.setCellSelectionEnabled(true);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int datum = Integer
							.parseInt((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
					GregorianCalendar g = new GregorianCalendar();
					g.set(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR),
							GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH), datum);
					for (int i = 0; i < GUIKontroler.vratiSveAktivnosti().size(); i++) {
						if (GUIKontroler.istiDan(GUIKontroler.vratiSveAktivnosti().get(i).getVremePolaganja(), g)) {
							GUIKontroler.otvoriOpisAktivnosti();
							return;
						}
					}
				}
			});
			azurirajLblDatum();
			GUIKontroler.azurirajTabelu(table);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); // Centriranje
																						// teksta
																						// u
																						// celijama
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			for (int i = 0; i < table.getModel().getColumnCount(); i++)
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		return table;
	}

	private JLabel getLblNed() {
		if (lblNed == null) {
			lblNed = new JLabel("NED");
			lblNed.setForeground(Color.WHITE);
			lblNed.setBackground(Color.GRAY);
			lblNed.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNed.setHorizontalAlignment(SwingConstants.CENTER);
			lblNed.setBounds(64, 25, 98, 35);
			lblNed.setOpaque(true);
		}
		return lblNed;
	}

	private JLabel getLblPon() {
		if (lblPon == null) {
			lblPon = new JLabel("PON");
			lblPon.setForeground(Color.WHITE);
			lblPon.setBackground(Color.GRAY);
			lblPon.setHorizontalAlignment(SwingConstants.CENTER);
			lblPon.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPon.setBounds(161, 25, 98, 35);
			lblPon.setOpaque(true);
		}
		return lblPon;
	}

	private JLabel getLblUto() {
		if (lblUto == null) {
			lblUto = new JLabel("UTO");
			lblUto.setForeground(Color.WHITE);
			lblUto.setBackground(Color.GRAY);
			lblUto.setHorizontalAlignment(SwingConstants.CENTER);
			lblUto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUto.setBounds(256, 25, 108, 35);
			lblUto.setOpaque(true);
		}
		return lblUto;
	}

	private JLabel getLblSre() {
		if (lblSre == null) {
			lblSre = new JLabel("SRE");
			lblSre.setForeground(Color.WHITE);
			lblSre.setBackground(Color.GRAY);
			lblSre.setHorizontalAlignment(SwingConstants.CENTER);
			lblSre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSre.setBounds(360, 25, 93, 35);
			lblSre.setOpaque(true);
		}
		return lblSre;
	}

	private JLabel getLblCet() {
		if (lblCet == null) {
			lblCet = new JLabel("CET");
			lblCet.setForeground(Color.WHITE);
			lblCet.setBackground(Color.GRAY);
			lblCet.setHorizontalAlignment(SwingConstants.CENTER);
			lblCet.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblCet.setBounds(444, 25, 108, 35);
			lblCet.setOpaque(true);
		}
		return lblCet;
	}

	private JLabel getLblPet() {
		if (lblPet == null) {
			lblPet = new JLabel("PET");
			lblPet.setForeground(Color.WHITE);
			lblPet.setBackground(Color.GRAY);
			lblPet.setHorizontalAlignment(SwingConstants.CENTER);
			lblPet.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPet.setBounds(550, 25, 98, 35);
			lblPet.setOpaque(true);
		}
		return lblPet;
	}

	private JLabel getLblSub() {
		if (lblSub == null) {
			lblSub = new JLabel("SUB");
			lblSub.setForeground(Color.WHITE);
			lblSub.setBackground(Color.GRAY);
			lblSub.setHorizontalAlignment(SwingConstants.CENTER);
			lblSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSub.setBounds(643, 25, 101, 35);
			lblSub.setOpaque(true);
		}
		return lblSub;
	}

	private JButton getBtnPrethodniMesec() {
		if (btnPrethodniMesec == null) {
			btnPrethodniMesec = new JButton("<");
			btnPrethodniMesec.setForeground(Color.WHITE);
			btnPrethodniMesec.setBackground(Color.GRAY);
			btnPrethodniMesec.setBounds(338, 459, 60, 35);
			btnPrethodniMesec.setFocusPainted(false);
			btnPrethodniMesec.setBorder(new LineBorder(Color.WHITE));
			btnPrethodniMesec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int mesec = GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH);
					if (mesec - 1 == -1) {
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH, 11);
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR,
								GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR) - 1);
					} else
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH,
								GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH) - 1);
					GUIKontroler.popuniMatricuDatuma();
					GUIKontroler.azurirajTabelu(table);
					azurirajLblDatum();
				}
			});
		}
		return btnPrethodniMesec;
	}

	private JButton getBtnSledeciMesec() {
		if (btnSledeciMesec == null) {
			btnSledeciMesec = new JButton(">");
			btnSledeciMesec.setForeground(Color.WHITE);
			btnSledeciMesec.setBackground(Color.GRAY);
			btnSledeciMesec.setBounds(402, 459, 60, 35);
			btnSledeciMesec.setFocusPainted(false);
			btnSledeciMesec.setBorder(new LineBorder(Color.WHITE));
			btnSledeciMesec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int mesec = GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH);
					if (mesec + 1 == 12) {
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH, 0);
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR,
								GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR) + 1);
					} else
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH,
								GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH) + 1);
					GUIKontroler.popuniMatricuDatuma();
					GUIKontroler.azurirajTabelu(table);
					azurirajLblDatum();
				}
			});
		}
		return btnSledeciMesec;
	}

	private JButton getBtnPrethodnaGodina() {
		if (btnPrethodnaGodina == null) {
			btnPrethodnaGodina = new JButton("<<");
			btnPrethodnaGodina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR,
							GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR) - 1);
					GUIKontroler.popuniMatricuDatuma();
					GUIKontroler.azurirajTabelu(table);
					azurirajLblDatum();
				}
			});
			btnPrethodnaGodina.setForeground(Color.WHITE);
			btnPrethodnaGodina.setFocusPainted(false);
			btnPrethodnaGodina.setBackground(Color.GRAY);
			btnPrethodnaGodina.setBounds(254, 459, 80, 35);
			btnPrethodnaGodina.setBorder(new LineBorder(Color.WHITE));
		}
		return btnPrethodnaGodina;
	}

	private JButton getBtnSledecaGodina() {
		if (btnSledecaGodina == null) {
			btnSledecaGodina = new JButton(">>");
			btnSledecaGodina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR,
							GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR) + 1);
					GUIKontroler.popuniMatricuDatuma();
					GUIKontroler.azurirajTabelu(table);
					azurirajLblDatum();
				}
			});
			btnSledecaGodina.setForeground(Color.WHITE);
			btnSledecaGodina.setFocusPainted(false);
			btnSledecaGodina.setBackground(Color.GRAY);
			btnSledecaGodina.setBounds(466, 459, 80, 35);
			btnSledecaGodina.setBorder(new LineBorder(Color.WHITE));
		}
		return btnSledecaGodina;
	}

	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("");
			lblDatum.setBackground(Color.DARK_GRAY);
			lblDatum.setForeground(Color.WHITE);
			lblDatum.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatum.setFont(new Font("Courier New", Font.BOLD, 21));
			lblDatum.setBounds(79, 0, 650, 23);
		}
		return lblDatum;
	}
	/**
	 * Metoda koja azurira datum
	 */
	//Potrabna samo u okviru ove klase
	private void azurirajLblDatum() {
		String datum = GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH) + 1 + "/"
				+ GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR);
		getLblDatum().setText(datum);
	}

	private JButton getBtnDodajKolokvijum() {
		if (btnDodajKolokvijum == null) {
			btnDodajKolokvijum = new JButton();
			Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
			btnDodajKolokvijum.setIcon(new ImageIcon(img));
			btnDodajKolokvijum.setForeground(Color.WHITE);
			btnDodajKolokvijum.setBackground(new Color(112, 155, 179));
			btnDodajKolokvijum.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajKolokvijum.setBounds(614, 459, 60, 35);
			btnDodajKolokvijum.setFocusPainted(false);
			btnDodajKolokvijum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedColumn() == -1) {
						JOptionPane.showMessageDialog(GlavniProzorGUI, "Morate prvo odabrati datum", "Greska",
								JOptionPane.OK_OPTION);
					} else
						GUIKontroler.otvoriDodajKolokvujumGUI();
				}
			});
		}
		return btnDodajKolokvijum;
	}

	private JButton getBtnDodajIspit() {
		if (btnDodajIspit == null) {
			btnDodajIspit = new JButton();
			Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
			btnDodajIspit.setIcon(new ImageIcon(img));
			btnDodajKolokvijum.setForeground(Color.WHITE);
			btnDodajIspit.setBackground(GUIKontroler.plavaT);
			btnDodajIspit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajIspit.setBounds(684, 459, 60, 35);
			btnDodajIspit.setFocusPainted(false);
			btnDodajIspit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedColumn() == -1) {
						JOptionPane.showMessageDialog(GlavniProzorGUI, "Morate prvo odabrati datum", "Greska",
								JOptionPane.OK_OPTION);
					} else
						GUIKontroler.otvoriDodajIspitGUI();
				}
			});
		}
		return btnDodajIspit;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton();
			btnDodaj.setToolTipText("Dodaj predmet");
			Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
			btnDodaj.setIcon(new ImageIcon(img));
			btnDodaj.setBounds(752, 32, 60, 35);
			btnDodaj.setBackground(GUIKontroler.plavaS);
			btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodaj.setFocusPainted(false);
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriDodajPredmetGUI();
				}
			});
		}
		return btnDodaj;
	}

	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton();
			btnIzmeni.setToolTipText("Izmeni predmet");
			btnIzmeni.setBounds(752, 139, 60, 35);
			Image img = new ImageIcon(this.getClass().getResource("/izmeni.png")).getImage();
			btnIzmeni.setIcon(new ImageIcon(img));
			btnIzmeni.setToolTipText("Izmeni predmet");

			btnIzmeni.setBackground(new Color(0, 155, 179));
			btnIzmeni.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIzmeni.setFocusPainted(false);
			btnIzmeni.setEnabled(false);
			btnIzmeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriIzmeniPredmetGUI();
				}
			});
			btnIzmeni.setPreferredSize(new Dimension(140, 23));
		}
		return btnIzmeni;
	}

	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton();
			btnObrisi.setToolTipText("Obrisi predmet");
			Image img = new ImageIcon(this.getClass().getResource("/obrisi.png")).getImage();
			btnObrisi.setIcon(new ImageIcon(img));
			btnObrisi.setToolTipText("Obrisi predmet");
			btnObrisi.setBackground(new Color(0, 155, 179));
			btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnObrisi.setFocusPainted(false);
			btnObrisi.setBounds(752, 199, 60, 35);
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int broj = JOptionPane.showConfirmDialog(GlavniProzorGUI, "Da li zelite da obrisete predmet?","Obrisi predmet", 0);
					if (broj == JOptionPane.YES_OPTION) {
						int red = tablePredmeti.getSelectedRow();
						if (red != -1) {
							GUIKontroler.predmeti.remove(red);
							GUIKontroler.azurirajTabeluPredmet();
							GUIKontroler.azurirajTabeluPolozeni();
							GUIKontroler.azurirajProsek();
						}
					}
				}
			});
			btnObrisi.setPreferredSize(new Dimension(140, 23));
			btnObrisi.setEnabled(false);
		}
		return btnObrisi;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(null);
			scrollPane.setBorder(null);
			scrollPane.setBounds(0, 0, 729, 530);
			scrollPane.setViewportView(getTablePredmeti());
		}
		return scrollPane;
	}

	private JTable getTablePredmeti() {
		if (tablePredmeti == null) {
			tablePredmeti = new JTable();
			tablePredmeti.setBorder(null);
			tablePredmeti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					btnIzmeni.setEnabled(true);
					btnObrisi.setEnabled(true);
					btnPregledPredmeta.setEnabled(true);
				}
			});
			tablePredmeti.setModel(new PrikazPredmetaTabelaModel(null));
			tablePredmeti.setOpaque(false);
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);
			tablePredmeti.setShowGrid(false);
			tablePredmeti.setRowHeight(25);
			GUIKontroler.azurirajTabeluPredmet();
		}
		return tablePredmeti;
	}

	private JButton getBtnPregledPredmeta() {
		if (btnPregledPredmeta == null) {
			btnPregledPredmeta = new JButton();
			Image img = new ImageIcon(this.getClass().getResource("/trazi.png")).getImage();
			btnPregledPredmeta.setIcon(new ImageIcon(img));
			btnPregledPredmeta.setToolTipText("Pregled predmeta");
			btnPregledPredmeta.setBounds(752, 88, 60, 35);
			btnPregledPredmeta.setBackground(new Color(0, 155, 179));
			btnPregledPredmeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnPregledPredmeta.setFocusPainted(false);
			btnPregledPredmeta.setEnabled(false);
			btnPregledPredmeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriPregledPredmeta();
				}
			});
			btnPregledPredmeta.setPreferredSize(new Dimension(140, 23));
		}
		return btnPregledPredmeta;
	}

	private JLabel getLblKolokvijumBoja() {
		if (lblKolokvijumBoja == null) {
			lblKolokvijumBoja = new JLabel("");
			lblKolokvijumBoja.setBounds(70, 461, 15, 15);
			lblKolokvijumBoja.setBackground(GUIKontroler.plavaS);
			lblKolokvijumBoja.setOpaque(true);
			lblKolokvijumBoja.setBorder(new LineBorder(Color.WHITE));
		}
		return lblKolokvijumBoja;
	}

	private JLabel getLblKolokvijum() {
		if (lblKolokvijum == null) {
			lblKolokvijum = new JLabel("Kolokvijum");
			lblKolokvijum.setForeground(Color.WHITE);
			lblKolokvijum.setBounds(90, 462, 72, 15);
		}
		return lblKolokvijum;
	}

	private JLabel getLblIspitBoja() {
		if (lblIspitBoja == null) {
			lblIspitBoja = new JLabel("");
			lblIspitBoja.setOpaque(true);
			lblIspitBoja.setBackground(GUIKontroler.plavaT);
			lblIspitBoja.setBounds(70, 478, 15, 15);
			lblIspitBoja.setBorder(new LineBorder(Color.WHITE));
		}
		return lblIspitBoja;
	}

	private JLabel getLblIspit() {
		if (lblIspit == null) {
			lblIspit = new JLabel("Ispit");
			lblIspit.setForeground(Color.WHITE);
			lblIspit.setBounds(90, 479, 72, 15);
		}
		return lblIspit;
	}

	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("8:00");
			label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setForeground(Color.WHITE);
			label_7.setBackground(Color.BLACK);
			label_7.setBounds(10, 45, 46, 40);
			label_7.setOpaque(true);
		}
		return label_7;
	}

	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("10:00");
			label_8.setOpaque(true);
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setForeground(Color.WHITE);
			label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_8.setBackground(Color.BLACK);
			label_8.setBounds(10, 119, 46, 40);
		}
		return label_8;
	}

	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel("12:00");
			label_9.setOpaque(true);
			label_9.setHorizontalAlignment(SwingConstants.CENTER);
			label_9.setForeground(Color.WHITE);
			label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_9.setBackground(Color.BLACK);
			label_9.setBounds(10, 197, 46, 40);
		}
		return label_9;
	}

	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("14:00");
			label_10.setOpaque(true);
			label_10.setHorizontalAlignment(SwingConstants.CENTER);
			label_10.setForeground(Color.WHITE);
			label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_10.setBackground(Color.BLACK);
			label_10.setBounds(10, 272, 46, 40);
		}
		return label_10;
	}

	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("16:00");
			label_11.setOpaque(true);
			label_11.setHorizontalAlignment(SwingConstants.CENTER);
			label_11.setForeground(Color.WHITE);
			label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_11.setBackground(Color.BLACK);
			label_11.setBounds(10, 349, 46, 40);
		}
		return label_11;
	}

	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("18:00");
			label_12.setOpaque(true);
			label_12.setHorizontalAlignment(SwingConstants.CENTER);
			label_12.setForeground(Color.WHITE);
			label_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_12.setBackground(Color.BLACK);
			label_12.setBounds(10, 425, 46, 35);
		}
		return label_12;
	}
	/**
	 * Metoda koja podesava pozadinu u celom prog
	 */
	private void podesiPozadinu() {
		Image img = new ImageIcon(this.getClass().getResource(GUIKontroler.vratiNazivSlike())).getImage();
		JLabel picLabelPlaner = new JLabel(new ImageIcon(img));
		picLabelPlaner.setSize(850, 600);
		JLabel picLabelPolozeniIspiti = new JLabel(new ImageIcon(img));
		picLabelPolozeniIspiti.setLocation(0, 0);
		// picLabelPolozeniIspiti.setLocation(-545, 5);
		picLabelPolozeniIspiti.setSize(850, 600);
		JLabel picLabelRasporedNastave = new JLabel(new ImageIcon(img));
		picLabelRasporedNastave.setSize(850, 600);
		JLabel picLabelPredmeti = new JLabel(new ImageIcon(img));
		picLabelPredmeti.setLocation(0, 0);
		// picLabelPredmeti.setLocation(-545, 5);
		picLabelPredmeti.setSize(850, 600);
		panelPredmeti.add(picLabelPredmeti);
		panelPlaner.add(picLabelPlaner);
		getPanelPolozeniIspiti().setLayout(null);
		panelPolozeniIspiti.add(picLabelPolozeniIspiti);
		// Ovde palite pozadinu na vasem jPanelu!!!
		// panelPolozeniIspiti.add(picLabelPolozeniIspiti);

		// panelRasporedNastave.add(picLabelRasporedNastave);
	}

	private JPanel getPanelTitleBar() {
		if (panelTitleBar == null) {
			panelTitleBar = new JPanel();
			panelTitleBar.setBackground(Color.GRAY);
			panelTitleBar.setLayout(null);
			panelTitleBar.setPreferredSize(new Dimension(0, 25));
			panelTitleBar.add(getPanelNaslov());

		}
		return panelTitleBar;
	}

	private JPanel getPanelNaslov() {
		if (panelNaslov == null) {
			panelNaslov = new JPanel();
			panelNaslov.setLayout(null);
			panelNaslov.setPreferredSize(new Dimension(0, 20));
			panelNaslov.setBackground(Color.GRAY);
			panelNaslov.setBounds(0, 0, 840, 25);
			panelNaslov.add(getLblNaslov());
			panelNaslov.add(getLblX());
		}
		return panelNaslov;
	}

	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("x");
			lblX.setBounds(810, 0, 30, 20);
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					GUIKontroler.serijalizujAktivnosti();
					GUIKontroler.serijalizujPredmete();
					GUIKontroler.serijalizujPolozene();
					GUIKontroler.serijalizujObaveze();
					dispose();
				}
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Tahoma", Font.BOLD, 19));
		}
		return lblX;
	}

	private JLabel getLblNaslov() {
		if (lblNaslov == null) {
			lblNaslov = new JLabel("My Study Life");
			lblNaslov.setBackground(Color.LIGHT_GRAY);
			lblNaslov.setForeground(Color.WHITE);
			lblNaslov.setFont(new Font("Segoe Script", Font.BOLD, 17));
			lblNaslov.setBounds(5, 0, 800, 25);
		}
		return lblNaslov;
	}

	private JTable getTablePolozeni() {
		if (tablePolozeni == null) {
			tablePolozeni = new JTable();
		}
		tablePolozeni.setModel(new PrikazPolozenihTabelaModel(null));
		GUIKontroler.azurirajTabeluPolozeni();
		tablePolozeni.setOpaque(false);
		scrollPanePolozeni.setOpaque(false);
		scrollPanePolozeni.getViewport().setOpaque(false);
		tablePolozeni.setShowGrid(false);
		tablePolozeni.setRowHeight(25);

		return tablePolozeni;
	}

	private JScrollPane getScrollPanePolozeni() {
		if (scrollPanePolozeni == null) {
			scrollPanePolozeni = new JScrollPane();
			scrollPanePolozeni.setBounds(0, 0, 835, 485);
			scrollPanePolozeni.setViewportView(getTablePolozeni());
		}
		return scrollPanePolozeni;
	}
	private JLabel getLblProsek() {
		if (lblProsek == null) {
			lblProsek = new JLabel("Prosek");
			lblProsek.setFont(new Font("Segoe Script", Font.BOLD, 16));
			lblProsek.setForeground(Color.WHITE);
			lblProsek.setBounds(492, 496, 103, 25);
		}
		return lblProsek;
	}
	private JTextField getTextFieldProsek() {
		if (textFieldProsek == null) {
			textFieldProsek = new JTextField();
			textFieldProsek.setEditable(false);
			textFieldProsek.setForeground(Color.BLACK);
			textFieldProsek.setFont(new Font("Segoe Script", Font.BOLD, 17));
			textFieldProsek.setBounds(571, 499, 86, 20);
			textFieldProsek.setColumns(10);
			textFieldProsek.setText("" + GUIKontroler.vratiProsek());
		}
		return textFieldProsek;
	}
	
	private JLabel getLabelBrBodova() {
		if (labelBrBodova == null) {
			labelBrBodova = new JLabel("Ukupan broj ESPB");
			labelBrBodova.setForeground(Color.WHITE);
			labelBrBodova.setFont(new Font("Segoe Script", Font.BOLD, 16));
			labelBrBodova.setBounds(55, 496, 194, 25);
		}
		return labelBrBodova;
	}
	private JTextField getTextFieldBrojBodova() {
		if (textFieldBrojBodova == null) {
			textFieldBrojBodova = new JTextField();
			textFieldBrojBodova.setForeground(Color.BLACK);
			textFieldBrojBodova.setFont(new Font("Segoe Script", Font.BOLD, 17));
			textFieldBrojBodova.setEditable(false);
			textFieldBrojBodova.setColumns(10);
			textFieldBrojBodova.setBounds(259, 496, 86, 20);
			textFieldBrojBodova.setText("" + GUIKontroler.vratiESPB());
		}
		
		return textFieldBrojBodova;
	}
	private JButton getBtnDodajObavezu() {
		if (btnDodajObavezu == null) {
			btnDodajObavezu = new JButton();
			btnDodajObavezu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriDodajObavezu();
				}
			});
			btnDodajObavezu.setToolTipText("Dodaj predmet");
			btnDodajObavezu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajObavezu.setFocusPainted(false);
			btnDodajObavezu.setBackground(new Color(0, 155, 179));
			btnDodajObavezu.setBounds(752, 75, 60, 35);
			Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
			btnDodajObavezu.setIcon(new ImageIcon(img));
		}
		return btnDodajObavezu;
	}
	private JButton getBtnIzbrisiObavezu() {
		if (btnIzbrisiObavezu == null) {
			btnIzbrisiObavezu = new JButton();
			btnIzbrisiObavezu.setToolTipText("Obrisi predmet");
			btnIzbrisiObavezu.setPreferredSize(new Dimension(140, 23));
			btnIzbrisiObavezu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIzbrisiObavezu.setFocusPainted(false);
			btnIzbrisiObavezu.setEnabled(false);
			btnIzbrisiObavezu.setBackground(new Color(0, 155, 179));
			btnIzbrisiObavezu.setBounds(752, 158, 60, 35);
			Image img = new ImageIcon(this.getClass().getResource("/obrisi.png")).getImage();
			btnIzbrisiObavezu.setIcon(new ImageIcon(img));
		}
		return btnIzbrisiObavezu;
	}
	private JTable getTableraspored() {
		if (tableraspored == null) {
			tableraspored = new JTable();
			tableraspored.setRowHeight(38);
			tableraspored.setPreferredScrollableViewportSize(new Dimension(450, 450));
			tableraspored.setBounds(52, 45, 682, 455);
			tableraspored.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"Ponedeljak", "Utorak", "Sreda", "Cetvratk", "Petak", "Subota", "Nedelja"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		}
		return tableraspored;
	}
	private JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("9:00");
			label_14.setOpaque(true);
			label_14.setHorizontalAlignment(SwingConstants.CENTER);
			label_14.setForeground(Color.WHITE);
			label_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_14.setBackground(Color.BLACK);
			label_14.setBounds(10, 83, 46, 40);
		}
		return label_14;
	}
	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("11:00");
			label_15.setOpaque(true);
			label_15.setHorizontalAlignment(SwingConstants.CENTER);
			label_15.setForeground(Color.WHITE);
			label_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_15.setBackground(Color.BLACK);
			label_15.setBounds(10, 158, 46, 40);
		}
		return label_15;
	}
	private JLabel getLabel_16() {
		if (label_16 == null) {
			label_16 = new JLabel("13:00");
			label_16.setOpaque(true);
			label_16.setHorizontalAlignment(SwingConstants.CENTER);
			label_16.setForeground(Color.WHITE);
			label_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_16.setBackground(Color.BLACK);
			label_16.setBounds(10, 234, 46, 40);
		}
		return label_16;
	}
	private JLabel getLabel_17() {
		if (label_17 == null) {
			label_17 = new JLabel("15:00");
			label_17.setOpaque(true);
			label_17.setHorizontalAlignment(SwingConstants.CENTER);
			label_17.setForeground(Color.WHITE);
			label_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_17.setBackground(Color.BLACK);
			label_17.setBounds(10, 310, 46, 40);
		}
		return label_17;
	}
	private JLabel getLabel_18() {
		if (label_18 == null) {
			label_18 = new JLabel("17:00");
			label_18.setOpaque(true);
			label_18.setHorizontalAlignment(SwingConstants.CENTER);
			label_18.setForeground(Color.WHITE);
			label_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_18.setBackground(Color.BLACK);
			label_18.setBounds(10, 386, 46, 40);
		}
		return label_18;
	}
}
