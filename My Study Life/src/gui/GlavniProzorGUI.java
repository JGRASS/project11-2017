package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import gui.modeli.MojaTabela;
import gui.modeli.PlanerTabelaModel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GlavniProzorGUI extends JFrame {
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
	
	public GlavniProzorGUI() {
		setTitle("MyStudyLife");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
			tabbedPane.setFocusable(false);
			tabbedPane.addTab("Planer", null, getPanelPlaner(), null);
			tabbedPane.addTab("Raspored nastave", null, getPanelRasporedNastave(), null);
			tabbedPane.addTab("Predmeti", null, getPanelPredmeti(), null);
			tabbedPane.addTab("Poloeni ispiti", null, getPanelPolozeniIspiti(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelPlaner() {
		if (panelPlaner == null) {
			panelPlaner = new JPanel();
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
		}
		return panelPlaner;
	}
	private JPanel getPanelPredmeti() {
		if (panelPredmeti == null) {
			panelPredmeti = new JPanel();
		}
		return panelPredmeti;
	}
	private JPanel getPanelRasporedNastave() {
		if (panelRasporedNastave == null) {
			panelRasporedNastave = new JPanel();
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
			GUIKontroler.popuniMatricuDatuma(GUIKontroler.datumi,GUIKontroler.gc);
			table = new MojaTabela();
			table.setModel(new PlanerTabelaModel(GUIKontroler.datumi));
			table.setBounds(10, 65, 650, 360);
			table.setRowHeight(60);
			table.setCellSelectionEnabled(true);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnDodajKolokvijum.setEnabled(true);
					btnDodajIspit.setEnabled(true);
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
			lblNed.setBounds(10, 30, 93, 35);
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
			lblPon.setBounds(101, 30, 102, 35);
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
			lblUto.setBounds(192, 30, 108, 35);
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
			lblSre.setBounds(290, 30, 93, 35);
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
			lblCet.setBounds(375, 30, 102, 35);
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
			lblPet.setBounds(466, 30, 102, 35);
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
			lblSub.setBounds(567, 30, 93, 35);
			lblSub.setOpaque(true);
		}
		return lblSub;
	}
	
	private JButton getBtnPrethodniMesec() {
		if (btnPrethodniMesec == null) {
			btnPrethodniMesec = new JButton("<");
			btnPrethodniMesec.setForeground(Color.WHITE);
			btnPrethodniMesec.setBackground(Color.GRAY);
			btnPrethodniMesec.setBounds(271, 430, 60, 35);
			btnPrethodniMesec.setFocusPainted(false);
			btnPrethodniMesec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int mesec = GUIKontroler.gc.get(GregorianCalendar.MONTH);
					if(mesec-1==-1){
						GUIKontroler.gc.set(GregorianCalendar.MONTH,11);
						GUIKontroler.gc.set(GregorianCalendar.YEAR, GUIKontroler.gc.get(GregorianCalendar.YEAR)-1);
					}
					else
						GUIKontroler.gc.set(GregorianCalendar.MONTH, GUIKontroler.gc.get(GregorianCalendar.MONTH)-1);
					GUIKontroler.popuniMatricuDatuma(GUIKontroler.datumi,GUIKontroler.gc);
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
			btnSledeciMesec.setBounds(335, 430, 60, 35);
			btnSledeciMesec.setFocusPainted(false);
			btnSledeciMesec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int mesec = GUIKontroler.gc.get(GregorianCalendar.MONTH);
					if(mesec+1==12){
						GUIKontroler.gc.set(GregorianCalendar.MONTH, 0);
						GUIKontroler.gc.set(GregorianCalendar.YEAR, GUIKontroler.gc.get(GregorianCalendar.YEAR)+1);
					}
					else
						GUIKontroler.gc.set(GregorianCalendar.MONTH, GUIKontroler.gc.get(GregorianCalendar.MONTH)+1);
					GUIKontroler.popuniMatricuDatuma(GUIKontroler.datumi,GUIKontroler.gc);
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
					GUIKontroler.gc.set(GregorianCalendar.YEAR,GUIKontroler.gc.get(GregorianCalendar.YEAR)-1);
					GUIKontroler.popuniMatricuDatuma(GUIKontroler.datumi,GUIKontroler.gc);
					azurirajTabelu();
					azurirajLblDatum();
				}
			});
			btnPrethodnaGodina.setForeground(Color.WHITE);
			btnPrethodnaGodina.setFocusPainted(false);
			btnPrethodnaGodina.setBackground(Color.GRAY);
			btnPrethodnaGodina.setBounds(187, 430, 80, 35);
		}
		return btnPrethodnaGodina;
	}
	private JButton getBtnSledecaGodina() {
		if (btnSledecaGodina == null) {
			btnSledecaGodina = new JButton(">>");
			btnSledecaGodina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.gc.set(GregorianCalendar.YEAR,GUIKontroler.gc.get(GregorianCalendar.YEAR)+1);
					GUIKontroler.popuniMatricuDatuma(GUIKontroler.datumi,GUIKontroler.gc);
					azurirajTabelu();
					azurirajLblDatum();
				}
			});
			btnSledecaGodina.setForeground(Color.WHITE);
			btnSledecaGodina.setFocusPainted(false);
			btnSledecaGodina.setBackground(Color.GRAY);
			btnSledecaGodina.setBounds(399, 430, 80, 35);
		}
		return btnSledecaGodina;
	}
	
	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("");
			lblDatum.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatum.setFont(new Font("Courier New", Font.PLAIN, 21));
			lblDatum.setBounds(10, 5, 650, 23);
			//lblDatum.setOpaque(true);
		}
		return lblDatum;
	}
	
	private void azurirajLblDatum(){
		String datum = GUIKontroler.gc.get(GregorianCalendar.MONTH)+1+"/"+ GUIKontroler.gc.get(GregorianCalendar.YEAR);
		getLblDatum().setText(datum);
	}
	
	public static void azurirajTabelu(){
		PlanerTabelaModel model = (PlanerTabelaModel)table.getModel();
		model.azurirajTabelu(GUIKontroler.datumi);
	}
	
	private JButton getBtnDodajKolokvijum() {
		if (btnDodajKolokvijum == null) {
			btnDodajKolokvijum = new JButton("Dodaj kolokvijum");
			btnDodajKolokvijum.setEnabled(false);
			btnDodajKolokvijum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriDodajKolokvujumGUI();
				}
			});
			btnDodajKolokvijum.setForeground(Color.BLACK);
			btnDodajKolokvijum.setBackground(Color.GRAY);
			btnDodajKolokvijum.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajKolokvijum.setBounds(665, 60, 150, 35);
			btnDodajKolokvijum.setContentAreaFilled(false);
			btnDodajKolokvijum.setFocusPainted(false);
		}
		return btnDodajKolokvijum;
	}
	private JButton getBtnDodajIspit() {
		if (btnDodajIspit == null) {
			btnDodajIspit = new JButton("Dodaj ispit");
			btnDodajIspit.setEnabled(false);
			btnDodajIspit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.otvoriDodajIspitGUI();
				}
			});
			btnDodajIspit.setForeground(Color.BLACK);
			btnDodajIspit.setBackground(Color.GRAY);
			btnDodajIspit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajIspit.setBounds(665, 106, 150, 35);
			btnDodajIspit.setContentAreaFilled(false);
			btnDodajIspit.setFocusPainted(false);
		}
		return btnDodajIspit;
	}
}
