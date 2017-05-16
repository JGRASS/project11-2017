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
import gui.modeli.PrikazPredmetaTabelaModel;
import gui.predmetFunkcije.DodajPredmetGUI;
import gui.predmetFunkcije.IzmeniPredmetGUI;
import gui.predmetFunkcije.PregledPredmeta;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.border.LineBorder;


public class GlavniProzorGUI extends JFrame {
	private static final long serialVersionUID = 7088262915872956309L;
	private static final Component GlavniProzorGUI = null;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelPlaner;
	private JPanel panelPredmeti;
	private JPanel panelRasporedNastave;
	private JPanel panelPolozeniIspiti;
	public static MojaTabela table;  //GuiKontroler?
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
	private JPanel panel;
	private JButton btnDodaj;
	private JButton btnIzmeni;
	private JButton btnObrisi;
	private JScrollPane scrollPane;
	public static JTable tablePredmeti;
	private JButton btnPregledPredmeta;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenuItem mntmDodajPredmet;
	private JMenuItem mntmDodajIspit;
	private JMenuItem mntmDodajKolokvijum;
	private JMenuItem mntmAbout;
	private JMenuItem mntmIzlaz;
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
	
	public GlavniProzorGUI() {
		setResizable(false);
		setTitle("MyStudyLife");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		setLocationRelativeTo(null);
		setUndecorated(true); //Uklanjanje default oblika prozora
		//setJMenuBar(getMenuBar_1()); //Privremeno iskljuceno zbog estetike
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
			tabbedPane.addTab("Raspored nastave", null, getPanelRasporedNastave(), null);
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
			panelPredmeti.setLayout(new BorderLayout(0, 0));
			panelPredmeti.add(getPanel(), BorderLayout.EAST);
			panelPredmeti.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panelPredmeti;
	}
	private JPanel getPanelRasporedNastave() {
		if (panelRasporedNastave == null) {
			panelRasporedNastave = new JPanel();
			panelRasporedNastave.setLayout(null);
			
			JLabel label = new JLabel("NED");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label.setBackground(Color.GRAY);
			label.setBounds(52, 11, 98, 35);
			label.setOpaque(true);
			panelRasporedNastave.add(label);
			
			JLabel label_1 = new JLabel("PON");
			label_1.setOpaque(true);
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_1.setBackground(Color.GRAY);
			label_1.setBounds(149, 11, 98, 35);
			panelRasporedNastave.add(label_1);
			
			JLabel label_2 = new JLabel("UTO");
			label_2.setOpaque(true);
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.WHITE);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_2.setBackground(Color.GRAY);
			label_2.setBounds(245, 11, 108, 35);
			panelRasporedNastave.add(label_2);
			
			JLabel label_3 = new JLabel("SRE");
			label_3.setOpaque(true);
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setForeground(Color.WHITE);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_3.setBackground(Color.GRAY);
			label_3.setBounds(349, 11, 93, 35);
			panelRasporedNastave.add(label_3);
			
			JLabel label_4 = new JLabel("CET");
			label_4.setOpaque(true);
			label_4.setHorizontalAlignment(SwingConstants.CENTER);
			label_4.setForeground(Color.WHITE);
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_4.setBackground(Color.GRAY);
			label_4.setBounds(432, 11, 108, 35);
			panelRasporedNastave.add(label_4);
			
			JLabel label_5 = new JLabel("PET");
			label_5.setOpaque(true);
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setForeground(Color.WHITE);
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_5.setBackground(Color.GRAY);
			label_5.setBounds(538, 11, 98, 35);
			panelRasporedNastave.add(label_5);
			
			JLabel label_6 = new JLabel("SUB");
			label_6.setOpaque(true);
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			label_6.setForeground(Color.WHITE);
			label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_6.setBackground(Color.GRAY);
			label_6.setBounds(631, 11, 101, 35);
			panelRasporedNastave.add(label_6);
			panelRasporedNastave.add(getLabel_7());
			panelRasporedNastave.add(getLabel_8());
			panelRasporedNastave.add(getLabel_9());
			panelRasporedNastave.add(getLabel_10());
			panelRasporedNastave.add(getLabel_11());
			panelRasporedNastave.add(getLabel_12());
			
			JLabel label_13 = new JLabel("20:00");
			label_13.setOpaque(true);
			label_13.setHorizontalAlignment(SwingConstants.CENTER);
			label_13.setForeground(Color.WHITE);
			label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_13.setBackground(Color.BLACK);
			label_13.setBounds(10, 435, 46, 65);
			panelRasporedNastave.add(label_13);
		}
		return panelRasporedNastave;
	}
	private JPanel getPanelPolozeniIspiti() {
		if (panelPolozeniIspiti == null) {
			panelPolozeniIspiti = new JPanel();
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
					int datum = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
					GregorianCalendar g = new GregorianCalendar();
					g.set(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR), GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH), datum);
					for(int i=0;i<GUIKontroler.vratiSveAktivnosti().size();i++){
						if(GUIKontroler.istiDan(GUIKontroler.vratiSveAktivnosti().get(i).getVremePolaganja(),g)){
							GUIKontroler.otvoriOpisAktivnosti();
							return;
						}
					}
				}
			});
			azurirajLblDatum();
			azurirajTabelu();
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); //Centriranje teksta u celijama
			centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			for(int i=0;i<table.getModel().getColumnCount();i++)
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
					if(mesec-1==-1){
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH,11);
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR)-1);
					}
					else
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH)-1);
					GUIKontroler.popuniMatricuDatuma();
					azurirajTabelu();
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
					if(mesec+1==12){
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH, 0);
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR)+1);
					}
					else
						GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.MONTH, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH)+1);
					GUIKontroler.popuniMatricuDatuma();
					azurirajTabelu();
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
					GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR,GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR)-1);
					GUIKontroler.popuniMatricuDatuma();
					azurirajTabelu();
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
					GUIKontroler.vratiTrenutnoVreme().set(GregorianCalendar.YEAR,GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR)+1);
					GUIKontroler.popuniMatricuDatuma();
					azurirajTabelu();
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
			lblDatum.setForeground(Color.BLACK);
			lblDatum.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatum.setFont(new Font("Courier New", Font.BOLD, 21));
			lblDatum.setBounds(79, 0, 650, 23);
		}
		return lblDatum;
	}
	
	private void azurirajLblDatum(){
		String datum = GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH)+1+"/"+ GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR);
		getLblDatum().setText(datum);
	}
	
	public static void azurirajTabelu(){
		PlanerTabelaModel model = (PlanerTabelaModel)table.getModel();
		model.azurirajTabelu(GUIKontroler.vratiDatume());
	}
	public static GregorianCalendar selektovanDatum(){
		GregorianCalendar g = new GregorianCalendar();
		int datum = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
		g.set(GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.YEAR)
				, GUIKontroler.vratiTrenutnoVreme().get(GregorianCalendar.MONTH),datum);
		return g;
	}
	
	private JButton getBtnDodajKolokvijum() {
		if (btnDodajKolokvijum == null) {
			btnDodajKolokvijum = new JButton();
			Image img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
			btnDodajKolokvijum.setIcon(new ImageIcon(img));
			btnDodajKolokvijum.setForeground(Color.WHITE);
			btnDodajKolokvijum.setBackground(new Color(112, 155, 179));
			btnDodajKolokvijum.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajKolokvijum.setBounds(684, 459, 60, 35);
			btnDodajKolokvijum.setFocusPainted(false);
			btnDodajKolokvijum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedColumn()==-1){
						JOptionPane.showMessageDialog(GlavniProzorGUI, "Morate prvo odabrati datum", "Greska",JOptionPane.OK_OPTION);
					}
					else
						GUIKontroler.otvoriDodajKolokvujumGUI();				}
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
			btnDodajIspit.setBackground(new Color(0, 155, 179));
			btnDodajIspit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajIspit.setBounds(614, 459, 60, 35);
			btnDodajIspit.setFocusPainted(false);
			btnDodajIspit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedColumn()==-1){
						JOptionPane.showMessageDialog(GlavniProzorGUI, "Morate prvo odabrati datum", "Greska",JOptionPane.OK_OPTION);
					}
					else
						GUIKontroler.otvoriDodajIspitGUI();
				}
			});
		}
		return btnDodajIspit;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(150, 10));
			panel.add(getBtnDodaj());
			panel.add(getBtnPregledPredmeta());
			panel.add(getBtnIzmeni());
			panel.add(getBtnObrisi());
		}
		return panel;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj predmet");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					otvoriDodajPredmetGUI();
				}
			});
			btnDodaj.setPreferredSize(new Dimension(140, 23));
		}
		return btnDodaj;
	}
	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton("Izmeni predmet");
			btnIzmeni.setEnabled(false);
			btnIzmeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					otvoriIzmeniPredmetGUI();
				}
			});
			btnIzmeni.setPreferredSize(new Dimension(140, 23));
		}
		return btnIzmeni;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi predmet");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int red =tablePredmeti.getSelectedRow();
					if(red!=-1){
						GUIKontroler.predmeti.remove(red);
						GUIKontroler.azurirajTabeluPredmet();
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
			scrollPane.setViewportView(getTablePredmeti());
		}
		return scrollPane;
	}
	private JTable getTablePredmeti() {
		if (tablePredmeti == null) {
			tablePredmeti = new JTable();
			tablePredmeti.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					btnIzmeni.setEnabled(true);
					btnObrisi.setEnabled(true);
					btnPregledPredmeta.setEnabled(true);
				}
			});
			tablePredmeti.setModel(new PrikazPredmetaTabelaModel(null));
			GUIKontroler.azurirajTabeluPredmet();
		}
		return tablePredmeti;
	}
	private JButton getBtnPregledPredmeta() {
		if (btnPregledPredmeta == null) {
			btnPregledPredmeta = new JButton("Pregled predmeta");
			btnPregledPredmeta.setEnabled(false);
			btnPregledPredmeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					otvoriPregledPredmeta();
				}
			});
			btnPregledPredmeta.setPreferredSize(new Dimension(140, 23));
		}
		return btnPregledPredmeta;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnEdit());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmDodajPredmet());
			mnFile.add(getMntmDodajIspit());
			mnFile.add(getMntmDodajKolokvijum());
			mnFile.add(getMntmIzlaz());
		}
		return mnFile;
	}
	private JMenu getMnEdit() {
		if (mnEdit == null) {
			mnEdit = new JMenu("Edit");
		}
		return mnEdit;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmDodajPredmet() {
		if (mntmDodajPredmet == null) {
			mntmDodajPredmet = new JMenuItem("Dodaj predmet");
			mntmDodajPredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		}
		return mntmDodajPredmet;
	}
	private JMenuItem getMntmDodajIspit() {
		if (mntmDodajIspit == null) {
			mntmDodajIspit = new JMenuItem("Dodaj ispit");
			mntmDodajIspit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		}
		return mntmDodajIspit;
	}
	private JMenuItem getMntmDodajKolokvijum() {
		if (mntmDodajKolokvijum == null) {
			mntmDodajKolokvijum = new JMenuItem("Dodaj kolokvijum");
			mntmDodajKolokvijum.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
		}
		return mntmDodajKolokvijum;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
		}
		return mntmAbout;
	}
	private JMenuItem getMntmIzlaz() {
		if (mntmIzlaz == null) {
			mntmIzlaz = new JMenuItem("Izlaz");
			mntmIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Component frame = null;

					int odgovor = JOptionPane.showConfirmDialog(frame, "Da li zelite da zatvorite aplikaciju?",
							"Exit", JOptionPane.YES_NO_CANCEL_OPTION);
					if (odgovor == JOptionPane.YES_OPTION)
						System.exit(0);

				}
			});
			mntmIzlaz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmIzlaz;
	}
	private void otvoriDodajPredmetGUI(){
		DodajPredmetGUI d = new DodajPredmetGUI();
		d.setVisible(true);
		d.setLocationRelativeTo(GlavniProzorGUI);
	}
	private void otvoriIzmeniPredmetGUI(){
		IzmeniPredmetGUI i = new IzmeniPredmetGUI();
		//i.popuniPolja("das", 5, "dasds", true, 5, true, 8, "dassa", "dsasa", "dassa");
		i.setVisible(true);
		i.setLocationRelativeTo(GlavniProzorGUI);
	}
	private void otvoriPregledPredmeta(){
		PregledPredmeta p = new PregledPredmeta();
		//p.popuniPolja("das", 5, "dasds", true, 5, true, 8, "dassa", "dsasa", "dassa");
		p.setVisible(true);
		p.setLocationRelativeTo(GlavniProzorGUI);
		p.popuniPolja();
		
	}
	private JLabel getLblKolokvijumBoja() {
		if (lblKolokvijumBoja == null) {
			lblKolokvijumBoja = new JLabel("");
			lblKolokvijumBoja.setBounds(70, 461, 15, 15);
			lblKolokvijumBoja.setBackground(new Color(112, 155, 179));
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
			lblIspitBoja.setBackground(new Color(0, 155, 179));
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
			label_7.setBounds(10, 45, 46, 65);
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
			label_8.setBounds(10, 110, 46, 65);
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
			label_9.setBounds(10, 175, 46, 65);
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
			label_10.setBounds(10, 240, 46, 65);
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
			label_11.setBounds(10, 305, 46, 65);
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
			label_12.setBounds(10, 370, 46, 65);
		}
		return label_12;
	}
	private void podesiPozadinu(){
		Image img = new ImageIcon(this.getClass().getResource(GUIKontroler.vratiNazivSlike())).getImage();
		JLabel picLabelPlaner = new JLabel(new ImageIcon(img));
		picLabelPlaner.setSize(850,600);
		JLabel picLabelPolozeniIspiti = new JLabel(new ImageIcon(img));
		picLabelPolozeniIspiti.setLocation(-545, 5);
		picLabelPolozeniIspiti.setSize(1920,1075);
		JLabel picLabelPredmeti = new JLabel(new ImageIcon(img));
		picLabelPredmeti.setSize(850,600);
		JLabel picLabelRasporedNastave = new JLabel(new ImageIcon(img));
		picLabelRasporedNastave.setSize(850,600);
		panelPlaner.add(picLabelPlaner);
		//Ovde palite pozadinu na vasem jPanelu!!!
		//panelPolozeniIspiti.add(picLabelPolozeniIspiti);
		//panelPredmeti.add(picLabelPredmeti);
		//panelRasporedNastave.add(picLabelRasporedNastave);
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
			lblNaslov = new JLabel("MyStudyLife");
			lblNaslov.setForeground(Color.WHITE);
			lblNaslov.setFont(new Font("Segoe Script", Font.BOLD, 17));
			lblNaslov.setBounds(5, 0, 800, 25);
		}
		return lblNaslov;
	}
}
