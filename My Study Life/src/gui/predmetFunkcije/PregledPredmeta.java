package gui.predmetFunkcije;

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


public class PregledPredmeta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7481533085338081853L;
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
	public void popuniPolja(String naziv, int ESBP, String skolskaGodina, boolean jednosemestralan,
			int semsetar, boolean polozen, int ocena, String napomena, String forum, String puskice) {
		textAreaNapomena.setText(napomena);
		textFieldESBP.setText(ESBP+"");
		textFieldNaziv.setText(naziv);
		if(ocena>5 && polozen){
			textFieldOcena.setText(ocena+"");
			chckbxPolozen.setSelected(true);
		}
		try {
			this.forum = new URI(forum);
			this.puskice = new URI(puskice);
		} catch (URISyntaxException e) {
			this.forum=null;
			this.puskice=null;
		}
		chckbxJednosemestralan.setSelected(jednosemestralan);
		textFieldSemestar.setText(semsetar+"");
		textFieldSkolska.setText(skolskaGodina);
	}
	private JButton getBtnFonforum() {
		if (btnFonforum == null) {
			btnFonforum = new JButton("FonForum");
			if(forum==null){
				btnFonforum.setEnabled(false);
			}
			btnFonforum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						open(forum);
					
				}
			});
			btnFonforum.setBounds(173, 148, 89, 23);
		}
		return btnFonforum;
	}
	private JButton getBtnPuskice() {
		if (btnPuskice == null) {
			btnPuskice = new JButton("Puskice");
			if(puskice==null){
				btnPuskice.setEnabled(false);
			}
			btnPuskice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					open(puskice);
				}
			});
			btnPuskice.setBounds(298, 148, 89, 23);
		}
		return btnPuskice;
	}
	private JButton getBtnKolokvijum() {
		if (btnKolokvijum == null) {
			btnKolokvijum = new JButton("Kolokvijum");
			btnKolokvijum.setBounds(333, 227, 89, 23);
		}
		return btnKolokvijum;
	}
	private JButton getBtnIspit() {
		if (btnIspit == null) {
			btnIspit = new JButton("Ispit");
			btnIspit.setBounds(333, 285, 89, 23);
		}
		return btnIspit;
	}
	private static void open(URI uri) {
	    if (Desktop.isDesktopSupported()) {
	      try {
	        Desktop.getDesktop().browse(uri);
	      } catch (IOException e) { 
	    	  /* TODO: error handling */ }
	    } else {
	    	/* TODO: error handling */ }
	  }
}
