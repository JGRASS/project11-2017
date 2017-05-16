package gui.predmetFunkcije;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Window;

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
 * Klasa za izmenu predmeta u programu
 * @author Ivan Stanimirovic
 *
 */
public class IzmeniPredmetGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8376192939809818779L;
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
	private JButton btnIzmeniPredmet;
	private JButton btnOdustani;
	private static Predmet predmet;
	private JPanel panel;
	private JLabel lblIzmeniPredmet;
	private JLabel label_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IzmeniPredmetGUI frame = new IzmeniPredmetGUI();
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
	public IzmeniPredmetGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Izmeni predmet");		
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
		contentPane.add(getBtnIzmeniPredmet());
		contentPane.add(getBtnOdustani());
		contentPane.add(getPanel());
		FrameDragListener frameDragListener = new FrameDragListener(this);
		addMouseListener(frameDragListener);
		addMouseMotionListener(frameDragListener);
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setBounds(10, 36, 46, 14);
		}
		return lblNaziv;
	}

	private JTextField getTextFieldNaziv() {
		if (textFieldNaziv == null) {
			textFieldNaziv = new JTextField();
			textFieldNaziv.setBounds(10, 63, 107, 20);
			textFieldNaziv.setColumns(10);
		}
		return textFieldNaziv;
	}

	private JLabel getLblEsbp() {
		if (lblEsbp == null) {
			lblEsbp = new JLabel("ESBP");
			lblEsbp.setBounds(173, 36, 46, 14);
		}
		return lblEsbp;
	}

	private JTextField getTextFieldESBP() {
		if (textFieldESBP == null) {
			textFieldESBP = new JTextField();
			textFieldESBP.setBounds(173, 63, 107, 20);
			textFieldESBP.setColumns(10);
		}
		return textFieldESBP;
	}

	private JLabel getLblSkolskaGodina() {
		if (lblSkolskaGodina == null) {
			lblSkolskaGodina = new JLabel("Skolska godina");
			lblSkolskaGodina.setBounds(345, 36, 107, 14);
		}
		return lblSkolskaGodina;
	}

	private JTextField getTextFieldSkolska() {
		if (textFieldSkolska == null) {
			textFieldSkolska = new JTextField();
			textFieldSkolska.setBounds(345, 63, 107, 20);
			textFieldSkolska.setColumns(10);
		}
		return textFieldSkolska;
	}

	private JLabel getLblSemestar() {
		if (lblSemestar == null) {
			lblSemestar = new JLabel("Semestar");
			lblSemestar.setBounds(10, 110, 56, 14);
		}
		return lblSemestar;
	}

	private JTextField getTextFieldSemestar() {
		if (textFieldSemestar == null) {
			textFieldSemestar = new JTextField();
			textFieldSemestar.setBounds(10, 133, 107, 20);
			textFieldSemestar.setColumns(10);
		}
		return textFieldSemestar;
	}

	private JCheckBox getChckbxJednosemestralan() {
		if (chckbxJednosemestralan == null) {
			chckbxJednosemestralan = new JCheckBox("Jednosemestralan");
			chckbxJednosemestralan.setBounds(141, 132, 144, 23);
		}
		return chckbxJednosemestralan;
	}

	private JCheckBox getChckbxPolozen() {
		if (chckbxPolozen == null) {
			chckbxPolozen = new JCheckBox("Polozen");
			chckbxPolozen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (chckbxPolozen.isSelected()) {
						textFieldOcena.setEditable(true);
					} else {
						textFieldOcena.setEditable(false);
					}
				}
			});
			chckbxPolozen.setBounds(285, 132, 78, 23);
		}
		return chckbxPolozen;
	}

	private JLabel getLblOcena() {
		if (lblOcena == null) {
			lblOcena = new JLabel("Ocena");
			lblOcena.setBounds(370, 110, 46, 14);
		}
		return lblOcena;
	}

	private JTextField getTextFieldOcena() {
		if (textFieldOcena == null) {
			textFieldOcena = new JTextField();
			textFieldOcena.setEditable(false);
			textFieldOcena.setBounds(370, 133, 107, 20);
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
			scrollPane.setBounds(10, 201, 230, 104);
			scrollPane.setViewportView(getTextAreaNapomena());
		}
		return scrollPane;
	}

	private JLabel getLblNapomena() {
		if (lblNapomena == null) {
			lblNapomena = new JLabel("Napomena");
			lblNapomena.setBounds(10, 178, 78, 14);
		}
		return lblNapomena;
	}

	private JLabel getLblFonforumLink() {
		if (lblFonforumLink == null) {
			lblFonforumLink = new JLabel("FonForum link");
			lblFonforumLink.setBounds(298, 178, 107, 14);
		}
		return lblFonforumLink;
	}

	private JTextField getTextFieldForum() {
		if (textFieldForum == null) {
			textFieldForum = new JTextField();
			textFieldForum.setBounds(298, 204, 107, 20);
			textFieldForum.setColumns(10);
		}
		return textFieldForum;
	}

	private JLabel getLblPuskiceLink() {
		if (lblPuskiceLink == null) {
			lblPuskiceLink = new JLabel("Puskice link");
			lblPuskiceLink.setBounds(298, 256, 107, 14);
		}
		return lblPuskiceLink;
	}

	private JTextField getTextFieldPuskice() {
		if (textFieldPuskice == null) {
			textFieldPuskice = new JTextField();
			textFieldPuskice.setBounds(298, 281, 107, 20);
			textFieldPuskice.setColumns(10);
		}
		return textFieldPuskice;
	}

	private JButton getBtnIzmeniPredmet() {
		if (btnIzmeniPredmet == null) {
			btnIzmeniPredmet = new JButton("Izmeni predmet");
			btnIzmeniPredmet.setBackground(Color.GRAY);
			btnIzmeniPredmet.setForeground(Color.WHITE);
			btnIzmeniPredmet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int ocena;
						if (chckbxPolozen.isSelected()) {
							ocena = Integer.parseInt(textFieldOcena.getText());
						} else {
							ocena = 5;
						}
						String naziv = textFieldNaziv.getText();
						int ESBP = Integer.parseInt(textFieldESBP.getText());
						String skolskaGodina=textFieldSkolska.getText();
						boolean jednosemestralan = chckbxJednosemestralan.isSelected();
						int semestar= Integer.parseInt(textFieldSemestar.getText());
						boolean polozen = chckbxPolozen.isSelected();
						String napomena = textAreaNapomena.getText();
						String forum=textFieldForum.getText();
						String puskice=textFieldPuskice.getText();
						Predmet p = new Predmet(naziv, ESBP, skolskaGodina, jednosemestralan, semestar, polozen, ocena, napomena, forum, puskice);
						GUIKontroler.azurirajTabeluPolozeni();
						GUIKontroler.predmeti.add(p);
						GUIKontroler.azurirajTabeluPredmet();
						GUIKontroler.azurirajTabeluPolozeni();
						GUIKontroler.azurirajProsek();
						dispose();
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(IzmeniPredmetGUI.this, "Doslo je do greske prilikom unosa brojevnih vrednosti",
								"Greska", JOptionPane.ERROR_MESSAGE);
					}catch(RuntimeException e2){
						JOptionPane.showMessageDialog(IzmeniPredmetGUI.this, "Doslo je do greske prilikom unosa skolske godine",
								"Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
				
			btnIzmeniPredmet.setBounds(30, 349, 169, 35);
		}
		return btnIzmeniPredmet;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setBackground(Color.GRAY);
			btnOdustani.setForeground(Color.WHITE);
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.predmeti.add(predmet);
					dispose();
				}
			});
			btnOdustani.setBounds(290, 349, 169, 35);
		}
		return btnOdustani;
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
			textFieldForum.setText(p.getForum());
			textFieldPuskice.setText(p.getPuskice());
			chckbxJednosemestralan.setSelected(p.getJednosemestralan());
			textFieldSemestar.setText(p.getSemestar() + "");
			textFieldSkolska.setText(p.getSkolskaGodina());
			for (int i = 0; i < GUIKontroler.predmeti.size(); i++) {
				if(GUIKontroler.predmeti.get(i).equals(p)){
					predmet = GUIKontroler.predmeti.get(i);
					GUIKontroler.predmeti.remove(i);
					break;
				}
			}
		}
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 493, 25);
			panel.setLayout(null);
			panel.add(getLblIzmeniPredmet());
			panel.add(getLabel_1());
		}
		return panel;
	}
	private JLabel getLblIzmeniPredmet() {
		if (lblIzmeniPredmet == null) {
			lblIzmeniPredmet = new JLabel("Izmeni predmet");
			lblIzmeniPredmet.setForeground(Color.WHITE);
			lblIzmeniPredmet.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIzmeniPredmet.setBackground(Color.GRAY);
			lblIzmeniPredmet.setBounds(5, 0, 405, 25);
		}
		return lblIzmeniPredmet;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("x");
			label_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					GUIKontroler.predmeti.add(predmet);
					GUIKontroler.azurirajTabeluPredmet();
					dispose();
				}
			});
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setForeground(Color.WHITE);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
			label_1.setBackground(Color.GRAY);
			label_1.setBounds(463, 0, 30, 20);
		}
		return label_1;
	}
}
