package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aktivnosti.Aktivnost;
import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import gui.modeli.FrameDragListener;
import sismeskiKontroler.SistemskiKontroler;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class PregledIspitaGUI extends JFrame {

	private JPanel contentPane;
	private List<Ispit> ispiti = new LinkedList<>();
	private JPanel panel;
	private JLabel lblNaziv;
	private JLabel lblX;
	private JPanel panel_1;
	private JButton btnIzlaz;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	public PregledIspitaGUI() {
		List<Aktivnost> sveAktivnosti = GUIKontroler.vratiSveAktivnosti();
		String nazivPredmeta = SistemskiKontroler.predmeti.get(GlavniProzorGUI.tablePredmeti.getSelectedRow()).getNaziv();
		for(int i=0;i<sveAktivnosti.size();i++){
			if(sveAktivnosti.get(i).getPredmet().getNaziv().equals(nazivPredmeta) && (sveAktivnosti.get(i) instanceof Ispit)){
				ispiti.add((Ispit)sveAktivnosti.get(i));
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 450, 25);
			panel.setLayout(null);
			panel.add(getLblNaziv());
			panel.add(getLblX());
		}
		return panel;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Ispiti");
			lblNaziv.setForeground(Color.WHITE);
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNaziv.setBounds(5, 0, 405, 25);
		}
		return lblNaziv;
	}
	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("x");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setForeground(Color.WHITE);
			lblX.setFont(new Font("Tahoma", Font.BOLD, 19));
			lblX.setBounds(420, 0, 30, 20);
		}
		return lblX;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBounds(0, 25, 450, 275);
			panel_1.add(getBtnIzlaz());
			panel_1.add(getScrollPane());
		}
		return panel_1;
	}
	private JButton getBtnIzlaz() {
		if (btnIzlaz == null) {
			btnIzlaz = new JButton("Izlaz");
			btnIzlaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnIzlaz.setForeground(Color.WHITE);
			btnIzlaz.setBackground(Color.GRAY);
			btnIzlaz.setBounds(170, 240, 110, 35);
		}
		return btnIzlaz;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane((Component) null);
			scrollPane.setBounds(10, 11, 430, 224);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
			textArea.setBackground(SystemColor.menu);
			String tekst = String.format("%s%13s%10s%10s\n","Datum","Ocena","Mesto","Vreme");
			for(int i=0;i<ispiti.size();i++){
				Ispit ispit = ispiti.get(i);
				String ocena = ispit.vratiOcenu()+"";
				String mesto = ispit.getMesto();
				if(ocena.equals("-1"));
					ocena = "/";
				if(mesto==null)
						mesto = "/";
				tekst+=String.format("%s%6s%10s%12s\n",GUIKontroler.vratiDatumString(ispit.getVremePolaganja()),
				ocena,mesto,GUIKontroler.vratiVremeString(ispit.getVremePolaganja()));
			}
			textArea.setText(tekst);
		}
		return textArea;
	}
}
