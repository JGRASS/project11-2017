package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.java.accessibility.util.GUIInitializedListener;

import aktivnosti.Aktivnost;
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
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PregledKolokvijumaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNaslov;
	private JLabel lblX;
	private List<Kolokvijum> kolokvijumi = new LinkedList<>();
	private JPanel panel_1;
	private JTextArea textArea;
	private JButton btnNewButton;
	
	public PregledKolokvijumaGUI() {
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
		List<Aktivnost> sveAktivnosti = GUIKontroler.vratiSveAktivnosti();
		String nazivPredmeta = GUIKontroler.predmeti.get(GlavniProzorGUI.tablePredmeti.getSelectedRow()).getNaziv();
		for(int i=0;i<sveAktivnosti.size();i++){
			if(sveAktivnosti.get(i).getPredmet().getNaziv().equals(nazivPredmeta) && (sveAktivnosti.get(i) instanceof Kolokvijum)){
				kolokvijumi.add((Kolokvijum)sveAktivnosti.get(i));
			}
		}
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
			panel_1.add(getTextArea());
			panel_1.add(getBtnNewButton());
		}
		return panel_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(10, 10, 430, 225);
		}
		return textArea;
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
}
