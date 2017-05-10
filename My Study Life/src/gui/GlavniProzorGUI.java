package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.model.PrikazPredmetaTabelaModel;
import gui.predmetFunkcije.DodajPredmetGUI;

import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzorGUI extends JFrame {

	private static final Component GlavniProzorGUI = null;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelPlaner;
	private JPanel panelPredmeti;
	private JPanel panelRasporedNastave;
	private JPanel panelPolozeniIspiti;
	private JPanel panel;
	private JButton btnDodaj;
	private JButton btnIzmeni;
	private JButton btnObrisi;
	private JScrollPane scrollPane;
	private JTable table;
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
		setTitle("MyStudyLife");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 550);
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
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tabbedPane.setFocusable(false);
			tabbedPane.addTab("Planer", null, getPanelPlaner(), null);
			tabbedPane.addTab("Predmeti", null, getPanelPredmeti(), null);
			tabbedPane.addTab("Raspored nastave", null, getPanelRasporedNastave(), null);
			tabbedPane.addTab("Polozeni ispiti", null, getPanelPolozeniIspiti(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelPlaner() {
		if (panelPlaner == null) {
			panelPlaner = new JPanel();
			panelPlaner.setLayout(new BorderLayout(0, 0));
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
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(130, 10));
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
			btnDodaj.setPreferredSize(new Dimension(120, 23));
		}
		return btnDodaj;
	}
	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton("Izmeni predmet");
			btnIzmeni.setPreferredSize(new Dimension(120, 23));
			btnIzmeni.setEnabled(false);
		}
		return btnIzmeni;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi predmet");
			btnObrisi.setPreferredSize(new Dimension(120, 23));
			btnObrisi.setEnabled(false);
		}
		return btnObrisi;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new PrikazPredmetaTabelaModel(null));
		}
		return table;
	}
	private JButton getBtnPregledPredmeta() {
		if (btnPregledPredmeta == null) {
			btnPregledPredmeta = new JButton("Pregled predmeta");
			btnPregledPredmeta.setEnabled(false);
			btnPregledPredmeta.setPreferredSize(new Dimension(120, 23));
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
}
