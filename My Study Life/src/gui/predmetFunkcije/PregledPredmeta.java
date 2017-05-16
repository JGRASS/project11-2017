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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import aktivnosti.Ispit;
import aktivnosti.Kolokvijum;
import aktivnosti.Planer;
import gui.GUIKontroler;
import gui.GlavniProzorGUI;
import predmeti.Predmet;
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
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(10, 11, 46, 14);
		}
		return lblNaziv;
	}

	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setEnabled(false);
			textFieldNaziv.setEditable(false);
			textFieldNaziv.setBounds(10, 38, 107, 20);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}

	private JLabel getLblEsbp() {
		if (lblEsbp == null) {
			lblEsbp = new JLabel("ESBP");
			lblEsbp.setBounds(173, 11, 46, 14);
		}
		return lblEsbp;
	}

	private JTextField getTextFieldESBP() {
		if (textFieldESBP == null) {
			textFieldESBP = new JTextField();
			textFieldESBP.setEnabled(false);
			textFieldESBP.setEditable(false);
			textFieldESBP.setBounds(173, 38, 107, 20);
			textFieldESBP.setColumns(10);
		}
		return textFieldESBP;
	}

	private JLabel getLblSkolskaGodina() {
		if (lblSkolskaGodina == null) {
			lblSkolskaGodina = new JLabel("Skolska godina");
			lblSkolskaGodina.setBounds(345, 11, 107, 14);
		}
		return lblSkolskaGodina;
	}

	private JTextField getTextFieldSkolska() {
		if (textFieldSkolska == null) {
			textFieldSkolska = new JTextField();
			textFieldSkolska.setEnabled(false);
			textFieldSkolska.setEditable(false);
			textFieldSkolska.setBounds(345, 38, 107, 20);
			textFieldSkolska.setColumns(10);
		}
		return textFieldSkolska;
	}

	private JLabel getLblSemestar() {
		if (lblSemestar == null) {
			lblSemestar = new JLabel("Semestar");
			lblSemestar.setBounds(10, 85, 56, 14);
		}
		return lblSemestar;
	}

	private JTextField getTextFieldSemestar() {
		if (textFieldSemestar == null) {
			textFieldSemestar = new JTextField();
			textFieldSemestar.setEnabled(false);
			textFieldSemestar.setEditable(false);
			textFieldSemestar.setBounds(10, 108, 107, 20);
			textFieldSemestar.setColumns(10);
		}
		return textFieldSemestar;
	}

	private JCheckBox getChckbxJednosemestralan() {
		if (chckbxJednosemestralan == null) {
			chckbxJednosemestralan = new JCheckBox("Jednosemestralan");
			chckbxJednosemestralan.setEnabled(false);
			chckbxJednosemestralan.setBounds(10, 148, 144, 23);
		}
		return chckbxJednosemestralan;
	}

	private JCheckBox getChckbxPolozen() {
		if (chckbxPolozen == null) {
			chckbxPolozen = new JCheckBox("Polozen");
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
			chckbxPolozen.setBounds(173, 107, 78, 23);
		}
		return chckbxPolozen;
	}

	private JLabel getLblOcena() {
		if (lblOcena == null) {
			lblOcena = new JLabel("Ocena");
			lblOcena.setBounds(298, 85, 46, 14);
		}
		return lblOcena;
	}

	private JTextField getTextFieldOcena() {
		if (textFieldOcena == null) {
			textFieldOcena = new JTextField();
			textFieldOcena.setEditable(false);
			textFieldOcena.setBounds(298, 108, 107, 20);
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
			scrollPane.setBounds(10, 225, 270, 134);
			scrollPane.setViewportView(getTextAreaNapomena());
		}
		return scrollPane;
	}

	private JLabel getLblNapomena() {
		if (lblNapomena == null) {
			lblNapomena = new JLabel("Napomena");
			lblNapomena.setBounds(10, 200, 78, 14);
		}
		return lblNapomena;
	}

	public void popuniPolja() {
		int red = GlavniProzorGUI.tablePredmeti.getSelectedRow();
		if (red != -1) {
			Predmet p = GUIKontroler.predmeti.get(red);
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
			
			btnFonforum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					open(forum);
				}
			});
			btnFonforum.setBounds(173, 148, 107, 23);
		}
		return btnFonforum;
	}

	private JButton getBtnPuskice() {
		if (btnPuskice == null) {
			btnPuskice = new JButton("Puskice");
			
			btnPuskice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					open(puskice);
				}
			});
			btnPuskice.setBounds(298, 148, 107, 23);
		}
		return btnPuskice;
	}

	private JButton getBtnKolokvijum() {
		if (btnKolokvijum == null) {
			btnKolokvijum = new JButton("Kolokvijum");
			btnKolokvijum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Planer p = new Planer();
					String naziv= textFieldNaziv.getText();
					for(int i = 0; i<p.aktivnosti.size();i++){
						if((p.aktivnosti.get(i) instanceof Kolokvijum) && p.aktivnosti.get(i).getPredmet().getNaziv().equals(naziv)){
							String poruka = "Kolokvijum iz predmeta " + naziv + "je " + p.aktivnosti.get(i).getVremePolaganja().getTime();
							JOptionPane.showMessageDialog(PregledPredmeta, poruka);
							break;
						}
					}
				}
			});
			btnKolokvijum.setBounds(333, 227, 107, 23);
		}
		return btnKolokvijum;
	}

	private JButton getBtnIspit() {
		if (btnIspit == null) {
			btnIspit = new JButton("Ispit");
			btnIspit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Planer p = new Planer();
					String naziv= textFieldNaziv.getText();
					for(int i = 0; i<p.aktivnosti.size();i++){
						if((p.aktivnosti.get(i) instanceof Ispit) && p.aktivnosti.get(i).getPredmet().getNaziv().equals(naziv)){
							String poruka = "Ispit iz predmeta " + naziv + "je " + p.aktivnosti.get(i).getVremePolaganja().getTime();
							JOptionPane.showMessageDialog(PregledPredmeta, poruka);
							break;
						}
					}
				}
				
			});
			btnIspit.setBounds(333, 285, 107, 23);
		}
		return btnIspit;
	}

	private static void open(URI uri) {
		if(uri==null || uri.toString().equals("")) return;
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				/* TODO: error handling */ }
		} else {
			/* TODO: error handling */ }
	}

}
