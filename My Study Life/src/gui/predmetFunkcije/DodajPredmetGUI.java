package gui.predmetFunkcije;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.GUIKontroler;
import gui.modeli.FrameDragListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasa sluzi za dodavanje novog predmeta u tabelu
 * 
 * @author Ivan Stanimirovic
 *
 */
public class DodajPredmetGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4577476079852982437L;
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
	private JLabel lblFonforumLink;
	private JTextField textFieldForum;
	private JLabel lblPuskiceLink;
	private JTextField textFieldPuskice;
	private JButton btnDodajPredmet;
	private JButton btnOdustani;
	private JPanel panel;
	private JLabel lblDodajPredmet;
	private JLabel lblX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajPredmetGUI frame = new DodajPredmetGUI();
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
	public DodajPredmetGUI() {
		setResizable(false);
		setTitle("Dodaj predmet");
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
		contentPane.add(getLblFonforumLink());
		contentPane.add(getTextFieldForum());
		contentPane.add(getLblPuskiceLink());
		contentPane.add(getTextFieldPuskice());
		contentPane.add(getBtnDodajPredmet());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNaziv.setBounds(10, 36, 150, 25);
		}
		return lblNaziv;
	}

	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setBounds(10, 63, 150, 35);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}

	private JLabel getLblEsbp() {
		if (lblEsbp == null) {
			lblEsbp = new JLabel("ESBP");
			lblEsbp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEsbp.setBounds(173, 36, 150, 25);
		}
		return lblEsbp;
	}

	private JTextField getTextFieldESBP() {
		if (textFieldESBP == null) {
			textFieldESBP = new JTextField();
			textFieldESBP.setBounds(173, 63, 150, 35);
			textFieldESBP.setColumns(10);
		}
		return textFieldESBP;
	}

	private JLabel getLblSkolskaGodina() {
		if (lblSkolskaGodina == null) {
			lblSkolskaGodina = new JLabel("Skolska godina");
			lblSkolskaGodina.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSkolskaGodina.setBounds(335, 36, 150, 25);
		}
		return lblSkolskaGodina;
	}

	private JTextField getTextFieldSkolska() {
		if (textFieldSkolska == null) {
			textFieldSkolska = new JTextField();
			textFieldSkolska.setText("yyyy/yyyy");
			textFieldSkolska.setBounds(335, 63, 150, 35);
			textFieldSkolska.setColumns(10);
		}
		return textFieldSkolska;
	}

	private JLabel getLblSemestar() {
		if (lblSemestar == null) {
			lblSemestar = new JLabel("Semestar");
			lblSemestar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSemestar.setBounds(10, 110, 75, 25);
		}
		return lblSemestar;
	}

	private JTextField getTextFieldSemestar() {
		if (textFieldSemestar == null) {
			textFieldSemestar = new JTextField();
			textFieldSemestar.setBounds(10, 133, 75, 35);
			textFieldSemestar.setColumns(10);
		}
		return textFieldSemestar;
	}

	private JCheckBox getChckbxJednosemestralan() {
		if (chckbxJednosemestralan == null) {
			chckbxJednosemestralan = new JCheckBox("Jednosemestralan");
			chckbxJednosemestralan.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxJednosemestralan.setBounds(92, 133, 144, 35);
		}
		return chckbxJednosemestralan;
	}

	private JCheckBox getChckbxPolozen() {
		if (chckbxPolozen == null) {
			chckbxPolozen = new JCheckBox("Polozen");
			chckbxPolozen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			chckbxPolozen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chckbxPolozen.isSelected()) {
						textFieldOcena.setEditable(true);
					} else {
						textFieldOcena.setEditable(false);
					}
				}
			});
			chckbxPolozen.setBounds(236, 133, 87, 35);
		}
		return chckbxPolozen;
	}

	private JLabel getLblOcena() {
		if (lblOcena == null) {
			lblOcena = new JLabel("Ocena");
			lblOcena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblOcena.setBounds(335, 109, 150, 25);
		}
		return lblOcena;
	}

	private JTextField getTextFieldOcena() {
		if (textFieldOcena == null) {
			textFieldOcena = new JTextField();
			textFieldOcena.setEditable(false);
			textFieldOcena.setBounds(335, 133, 150, 35);
			textFieldOcena.setColumns(10);
		}
		return textFieldOcena;
	}

	private JTextArea getTextAreaNapomena() {
		if (textAreaNapomena == null) {
			textAreaNapomena = new JTextArea();
		}
		return textAreaNapomena;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 201, 313, 116);
			scrollPane.setViewportView(getTextAreaNapomena());
		}
		return scrollPane;
	}

	private JLabel getLblNapomena() {
		if (lblNapomena == null) {
			lblNapomena = new JLabel("Napomena");
			lblNapomena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNapomena.setBounds(10, 178, 313, 25);
		}
		return lblNapomena;
	}

	private JLabel getLblFonforumLink() {
		if (lblFonforumLink == null) {
			lblFonforumLink = new JLabel("FonForum link");
			lblFonforumLink.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFonforumLink.setBounds(333, 179, 152, 25);
		}
		return lblFonforumLink;
	}

	private JTextField getTextFieldForum() {
		if (textFieldForum == null) {
			textFieldForum = new JTextField();
			textFieldForum.setBounds(333, 205, 150, 35);
			textFieldForum.setColumns(10);
		}
		return textFieldForum;
	}

	private JLabel getLblPuskiceLink() {
		if (lblPuskiceLink == null) {
			lblPuskiceLink = new JLabel("Puskice link");
			lblPuskiceLink.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPuskiceLink.setBounds(333, 257, 150, 25);
		}
		return lblPuskiceLink;
	}

	private JTextField getTextFieldPuskice() {
		if (textFieldPuskice == null) {
			textFieldPuskice = new JTextField();
			textFieldPuskice.setBounds(333, 282, 150, 35);
			textFieldPuskice.setColumns(10);
		}
		return textFieldPuskice;
	}

	private JButton getBtnDodajPredmet() {
		if (btnDodajPredmet == null) {
			btnDodajPredmet = new JButton("Dodaj predmet");
			btnDodajPredmet.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnDodajPredmet.setForeground(Color.WHITE);
			btnDodajPredmet.setBackground(Color.GRAY);
			btnDodajPredmet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String ocena;
					if (chckbxPolozen.isSelected()) {
						ocena = textFieldOcena.getText();
					} else {
						ocena = "5";
					}
					String naziv = textFieldNaziv.getText();
					String ESBP = textFieldESBP.getText();
					String skolskaGodina = textFieldSkolska.getText();
					boolean jednosemestralan = chckbxJednosemestralan.isSelected();
					String semestar = textFieldSemestar.getText();
					boolean polozen = chckbxPolozen.isSelected();
					String napomena = textAreaNapomena.getText();
					String forum = textFieldForum.getText();
					String puskice = textFieldPuskice.getText();
					int provera = GUIKontroler.dodajPredmet(naziv, ESBP, skolskaGodina, jednosemestralan, semestar,
							polozen, ocena, napomena, forum, puskice);
					if (provera == 1) {
						GUIKontroler.azurirajTabeluPredmet();
						GUIKontroler.azurirajTabeluPolozeni();
						GUIKontroler.azurirajProsek();
						dispose();
					}

				}
			});
			btnDodajPredmet.setBounds(30, 349, 140, 35);
		}
		return btnDodajPredmet;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnOdustani.setForeground(Color.WHITE);
			btnOdustani.setBackground(Color.GRAY);
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(320, 349, 140, 35);
		}
		return btnOdustani;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 493, 25);
			panel.setLayout(null);
			panel.add(getLblDodajPredmet());
			panel.add(getLblX());
		}
		return panel;
	}

	private JLabel getLblDodajPredmet() {
		if (lblDodajPredmet == null) {
			lblDodajPredmet = new JLabel("Dodaj predmet");
			lblDodajPredmet.setForeground(Color.WHITE);
			lblDodajPredmet.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDodajPredmet.setBackground(Color.GRAY);
			lblDodajPredmet.setBounds(5, 0, 405, 25);
		}
		return lblDodajPredmet;
	}

	private JLabel getLblX() {
		if (lblX == null) {
			lblX = new JLabel("x");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
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
}
