package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import aktivnosti.Aktivnost;
import gui.modeli.MojaTabela;
import gui.modeli.PlanerTabelaModel;
import gui.model.PrikazPredmetaTabelaModel;
import gui.predmetFunkcije.DodajPredmetGUI;
import gui.predmetFunkcije.IzmeniPredmetGUI;
import gui.predmetFunkcije.PregledPredmeta;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
	
	public GlavniProzorGUI() {
		setResizable(false);
		setTitle("MyStudyLife");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
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
			table.setBorder(new LineBorder(new Color(128, 128, 128)));
			table.setModel(new PlanerTabelaModel(GUIKontroler.datumi));
			table.setBounds(64, 60, 680, 390);
			table.setRowHeight(65);
			table.setCellSelectionEnabled(true);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int datum = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
					GregorianCalendar g = new GregorianCalendar();
					g.set(GUIKontroler.gc.get(GregorianCalendar.YEAR), GUIKontroler.gc.get(GregorianCalendar.MONTH), datum);
					for(int i=0;i<GUIKontroler.aktivnosti.size();i++){
						if(GUIKontroler.istiDan(GUIKontroler.aktivnosti.get(i).getVremePolaganja(),g)){
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
			btnSledeciMesec.setBounds(402, 459, 60, 35);
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
			btnPrethodnaGodina.setBounds(254, 459, 80, 35);
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
			btnSledecaGodina.setBounds(466, 459, 80, 35);
		}
		return btnSledecaGodina;
	}
	
	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("");
			lblDatum.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatum.setFont(new Font("Courier New", Font.PLAIN, 21));
			lblDatum.setBounds(79, 0, 650, 23);
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
			Image img;
			try {
				img = ImageIO.read(getClass().getResource("icons/add.png"));
				btnDodajKolokvijum.setIcon(new ImageIcon(img));
			} catch (IOException e1) {
				System.out.println(e1);
			}
			btnDodajKolokvijum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedColumn()==-1){
						JOptionPane.showMessageDialog(GlavniProzorGUI, "Morate prvo odabrati datum", "Greska",JOptionPane.OK_OPTION);
					}
					else
						GUIKontroler.otvoriDodajKolokvujumGUI();				}
			});
			btnDodajKolokvijum.setForeground(Color.WHITE);
			btnDodajKolokvijum.setBackground(Color.GRAY);
			btnDodajKolokvijum.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajKolokvijum.setBounds(594, 457, 150, 35);
			btnDodajKolokvijum.setFocusPainted(false);
		}
		return btnDodajKolokvijum;
	}
	private JButton getBtnDodajIspit() {
		if (btnDodajIspit == null) {
			btnDodajIspit = new JButton("Dodaj ispit");
			btnDodajIspit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedColumn()==-1){
						JOptionPane.showMessageDialog(GlavniProzorGUI, "Morate prvo odabrati datum", "Greska",JOptionPane.OK_OPTION);
					}
					else
						GUIKontroler.otvoriDodajIspitGUI();
				}
			});
			btnDodajIspit.setForeground(Color.WHITE);
			btnDodajIspit.setBackground(Color.GRAY);
			btnDodajIspit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnDodajIspit.setBounds(64, 457, 150, 35);
			btnDodajIspit.setFocusPainted(false);
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
}
