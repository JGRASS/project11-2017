package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Font;

public class GlavniProzorGUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelPlaner;
	private JPanel panelPredmeti;
	private JPanel panelRasporedNastave;
	private JPanel panelPolozeniIspiti;
	
	public GlavniProzorGUI() {
		setTitle("MyStudyLife");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tabbedPane.setFocusable(false);
			tabbedPane.addTab("Planer", null, getPanelPlaner(), null);
			tabbedPane.addTab("Predmeti", null, getPanelPredmeti(), null);
			tabbedPane.addTab("Raspored nastave", null, getPanelRasporedNastave(), null);
			tabbedPane.addTab("Poloeni ispiti", null, getPanelPolozeniIspiti(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelPlaner() {
		if (panelPlaner == null) {
			panelPlaner = new JPanel();
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
}
