package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aktivnosti.Aktivnost;
import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import gui.modeli.FrameDragListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PregledKolokvijumaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNaslov;
	private JLabel lblX;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private List<Kolokvijum> kolokvijumi = new LinkedList<>();
	
	public PregledKolokvijumaGUI() {
		List<Aktivnost> sveAktivnosti = GUIKontroler.vratiSveAktivnosti();
		String nazivPredmeta = GUIKontroler.SK.predmeti.get(GlavniProzorGUI.tablePredmeti.getSelectedRow()).getNaziv();
		for(int i=0;i<sveAktivnosti.size();i++){
			if(sveAktivnosti.get(i).getPredmet().getNaziv().equals(nazivPredmeta) && (sveAktivnosti.get(i) instanceof Kolokvijum)){
				kolokvijumi.add((Kolokvijum)sveAktivnosti.get(i));
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
			panel.add(getLblNaslov());
			panel.add(getLblX());
		}
		return panel;
	}
	private JLabel getLblNaslov() {
		if (lblNaslov == null) {
			lblNaslov = new JLabel("Kolokvijumi");
			lblNaslov.setForeground(Color.WHITE);
			lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNaslov.setBounds(5, 0, 405, 25);
		}
		return lblNaslov;
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
			panel_1.setBounds(0, 25, 450, 275);
			panel_1.setLayout(null);
			panel_1.add(getBtnNewButton());
			panel_1.add(getScrollPane());
		}
		return panel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Izlaz");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNewButton.setBackground(Color.GRAY);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setBounds(170, 240, 110, 35);
		}
		return btnNewButton;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
			textArea.setBackground(SystemColor.menu);
			String tekst = String.format("%s%13s%10s%10s\n","Datum","Br poena","Mesto","Vreme");
			for(int i=0;i<kolokvijumi.size();i++){
				Kolokvijum k = kolokvijumi.get(i);
				String brojPoena = k.vratiBrojPoena()+"";
				String mesto = k.getMesto();
				if(brojPoena.equals("-1"));
					brojPoena = "/";
				if(mesto==null)
						mesto = "/";
				tekst+=String.format("%s%5s%12s%11s\n",GUIKontroler.vratiDatumString(k.getVremePolaganja()),
				brojPoena,k.getMesto(),GUIKontroler.vratiVremeString(k.getVremePolaganja()));
			}
			textArea.setText(tekst);
		}
		return textArea;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane(textArea);
			scrollPane.setBounds(10, 11, 430, 224);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
}
