package gui.predmetFunkcije;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import gui.modeli.FrameDragListener;
import predmeti.Predmet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Klasa za pregled predmeta iz tabele
 * @author Ivan Stanimirovic
 *
 */
public class PregledPredmeta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7481533085338081853L;
	protected static final Component PregledPredmeta  = null;
	private JPanel contentPane;
	private JLabel lblNaziv;
	private JTextField textFieldNaziv;
	private JLabel lblEsbp;
	private JTextField textFieldESBP;
	private JLabel lblSkolskaGodina;
	private JTextField textFieldSkolska;
	private JLabel lblSemestar;
	private JTextField textFieldSemestar;
	private JCheckBox chckbxJednosemestralan;
	private JCheckBox chckbxPolozen;
	private JLabel lblOcena;
	private JTextField textFieldOcena;
	private JTextArea textAreaNapomena;
	private JScrollPane scrollPane;
	private JLabel lblNapomena;
	private JButton btnFonforum;
	private JButton btnPuskice;
	private JButton btnKolokvijum;
	private JButton btnIspit;
	private URI forum;
	private URI puskice;
	private JPanel panel;
	private JLabel lblPregledPredmeta;
	private JLabel lblX;
	private JButton btnIzlaz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledPredmeta frame = new PregledPredmeta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PregledPredmeta() {
		setResizable(false);
		setTitle("Pregled predmeta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 416);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNaziv());
		contentPane.add(getTextFieldNaziv());
		contentPane.add(getLblEsbp());
		contentPane.add(getTextFieldESBP());
		contentPane.add(getLblSkolskaGodina());
		contentPane.add(getTextFieldSkolska());
		contentPane.add(getLblSemestar());
		contentPane.add(getTextFieldSemestar());
		contentPane.add(getChckbxJednosemestralan());
		contentPane.add(getChckbxPolozen());
		contentPane.add(getLblOcena());
		contentPane.add(getTextFieldOcena());
		contentPane.add(getScrollPane());
		contentPane.add(getLblNapomena());
		contentPane.add(getBtnFonforum());
		contentPane.add(getBtnPuskice());
		contentPane.add(getBtnKolokvijum());
		contentPane.add(getBtnIspit());
		contentPane.add(getPanel());
		contentPane.add(getBtnIzlaz());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNaziv.setBounds(10, 36, 150, 14);
		}
		return lblNaziv;
	}

	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setEnabled(false);
			textFieldNaziv.setEditable(false);
			textFieldNaziv.setBounds(10, 63, 150, 35);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}

	private JLabel getLblEsbp() {
		if (lblEsbp == null) {
			lblEsbp = new JLabel("ESBP");
			lblEsbp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEsbp.setBounds(173, 36, 150, 14);
		}
		return lblEsbp;
	}

	private JTextField getTextFieldESBP() {
		if (textFieldESBP == null) {
			textFieldESBP = new JTextField();
			textFieldESBP.setEnabled(false);
			textFieldESBP.setEditable(false);
			textFieldESBP.setBounds(173, 63, 150, 35);
			textFieldESBP.setColumns(10);
		}
		return textFieldESBP;
	}

	private JLabel getLblSkolskaGodina() {
		if (lblSkolskaGodina == null) {
			lblSkolskaGodina = new JLabel("Skolska godina");
			lblSkolskaGodina.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSkolskaGodina.setBounds(333, 36, 150, 14);
		}
		return lblSkolskaGodina;
	}

	private JTextField getTextFieldSkolska() {
		if (textFieldSkolska == null) {
			textFieldSkolska = new JTextField();
			textFieldSkolska.setEnabled(false);
			textFieldSkolska.setEditable(false);
			textFieldSkolska.setBounds(333, 63, 150, 35);
			textFieldSkolska.setColumns(10);
		}
		return textFieldSkolska;
	}

	private JLabel getLblSemestar() {
		if (lblSemestar == null) {
			lblSemestar = new JLabel("Semestar");
			lblSemestar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSemestar.setBounds(10, 110, 65, 25);
		}
		return lblSemestar;
	}

	private JTextField getTextFieldSemestar() {
		if (textFieldSemestar == null) {
			textFieldSemestar = new JTextField();
			textFieldSemestar.setEnabled(false);
			textFieldSemestar.setEditable(false);
			textFieldSemestar.setBounds(10, 133, 65, 35);
			textFieldSemestar.setColumns(10);
		}
		return textFieldSemestar;
	}

	private JCheckBox getChckbxJednosemestralan() {
		if (chckbxJednosemestralan == null) {
			chckbxJednosemestralan = new JCheckBox("Jednosemestralan");
			chckbxJednosemestralan.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxJednosemestralan.setEnabled(false);
			chckbxJednosemestralan.setBounds(99, 133, 144, 35);
		}
		return chckbxJednosemestralan;
	}

	private JCheckBox getChckbxPolozen() {
		if (chckbxPolozen == null) {
			chckbxPolozen = new JCheckBox("Polozen");
			chckbxPolozen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxPolozen.setEnabled(false);
			chckbxPolozen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chckbxPolozen.isSelected()) {
						textFieldOcena.setEditable(true);
					} else {
						textFieldOcena.setEditable(false);
					}
				}
			});
			chckbxPolozen.setBounds(245, 133, 78, 35);
		}
		return chckbxPolozen;
	}

	private JLabel getLblOcena() {
		if (lblOcena == null) {
			lblOcena = new JLabel("Ocena");
			lblOcena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOcena.setBounds(333, 110, 150, 14);
		}
		return lblOcena;
	}

	private JTextField getTextFieldOcena() {
		if (textFieldOcena == null) {
			textFieldOcena = new JTextField();
			textFieldOcena.setEditable(false);
			textFieldOcena.setBounds(333, 133, 150, 35);
			textFieldOcena.setColumns(10);
		}
		return textFieldOcena;
	}

	private JTextArea getTextAreaNapomena() {
		if (textAreaNapomena == null) {
			textAreaNapomena = new JTextArea();
			textAreaNapomena.setEditable(false);
			textAreaNapomena.setEnabled(false);
		}
		return textAreaNapomena;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 250, 313, 134);
			scrollPane.setViewportView(getTextAreaNapomena());
		}
		return scrollPane;
	}

	private JLabel getLblNapomena() {
		if (lblNapomena == null) {
			lblNapomena = new JLabel("Napomena");
			lblNapomena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNapomena.setBounds(10, 225, 78, 14);
		}
		return lblNapomena;
	}
	/**
	 * Metoda sluzi da iz tabele izvuce predmet i da popuni polja u prozoru IzmeniPredmetGUI sa podacima o tom predmetu
	 */
	public void popuniPolja() {
		int red = GlavniProzorGUI.tablePredmeti.getSelectedRow();
		if (red != -1) {
			Predmet p = GUIKontroler.vratiPredmete().get(red);
			textAreaNapomena.setText(p.getNapomena());
			textFieldESBP.setText(p.getESBP() + "");
			textFieldNaziv.setText(p.getNaziv());
			if (p.getOcena() > 5 && p.isPolozen()) {
				textFieldOcena.setText(p.getOcena() + "");
				chckbxPolozen.setSelected(true);
			}
			try {
				this.forum = new URI(p.getForum());
				this.puskice = new URI(p.getPuskice());
				btnFonforum.setEnabled(true);
				btnPuskice.setEnabled(true);
			} catch (URISyntaxException e) {
				this.forum = null;
				this.puskice = null;
			}
			chckbxJednosemestralan.setSelected(p.getJednosemestralan());
			textFieldSemestar.setText(p.getSemestar() + "");
			textFieldSkolska.setText(p.getSkolskaGodina());
		}
	}

	private JButton getBtnFonforum() {
		if (btnFonforum == null) {
			btnFonforum = new JButton("FonForum");
			btnFonforum.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFonforum.setBackground(Color.GRAY);
			btnFonforum.setForeground(Color.WHITE);
			
			btnFonforum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					open(forum);
				}
			});
			btnFonforum.setBounds(173, 190, 130, 35);
			btnFonforum.setFocusPainted(false);
		}
		return btnFonforum;
	}

	private JButton getBtnPuskice() {
		if (btnPuskice == null) {
			btnPuskice = new JButton("Puskice");
			btnPuskice.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPuskice.setBackground(Color.GRAY);
			btnPuskice.setForeground(Color.WHITE);
			
			btnPuskice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					open(puskice);
				}
			});
			btnPuskice.setBounds(333, 190, 130, 35);
			btnPuskice.setFocusPainted(false);
		}
		return btnPuskice;
	}

	private JButton getBtnKolokvijum() {
		if (btnKolokvijum == null) {
			btnKolokvijum = new JButton("Kolokvijum");
			btnKolokvijum.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnKolokvijum.setBackground(Color.GRAY);
			btnKolokvijum.setForeground(Color.WHITE);
			btnKolokvijum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriPregledKolokvijuma();
				}
			});
			btnKolokvijum.setBounds(333, 252, 130, 35);
			btnKolokvijum.setFocusPainted(false);
		}
		return btnKolokvijum;
	}

	private JButton getBtnIspit() {
		if (btnIspit == null) {
			btnIspit = new JButton("Ispit");
			btnIspit.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnIspit.setBackground(Color.GRAY);
			btnIspit.setForeground(Color.WHITE);
			btnIspit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.otvoriPregledIspita();
				}
				
			});
			btnIspit.setBounds(333, 305, 130, 35);
			btnIspit.setFocusPainted(false);
		}
		return btnIspit;
	}

	private static void open(URI uri) {
		if(uri==null || uri.toString().equals("")) return;
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
			}
		} else {
		 }
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 493, 25);
			panel.setLayout(null);
			panel.add(getLblPregledPredmeta());
			panel.add(getLblX());
		}
		return panel;
	}
	private JLabel getLblPregledPredmeta() {
		if (lblPregledPredmeta == null) {
			lblPregledPredmeta = new JLabel("Pregled predmeta");
			lblPregledPredmeta.setForeground(Color.WHITE);
			lblPregledPredmeta.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPregledPredmeta.setBackground(Color.GRAY);
			lblPregledPredmeta.setBounds(5, 0, 405, 25);
		}
		return lblPregledPredmeta;
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
			lblX.setBackground(Color.GRAY);
			lblX.setBounds(463, 0, 30, 20);
		}
		return lblX;
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
			btnIzlaz.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnIzlaz.setFocusPainted(false);
			btnIzlaz.setBackground(Color.GRAY);
			btnIzlaz.setBounds(333, 356, 130, 35);
		}
		return btnIzlaz;
	}
}
