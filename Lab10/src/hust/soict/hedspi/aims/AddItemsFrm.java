package hust.soict.hedspi.aims;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.naming.directory.InvalidAttributesException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class AddItemsFrm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtTitle;
	private JTextField txtCat;
	private JTextField txtCost;
	private JTextField txtNoAuthor;
	private JTextField txtIDdvd;
	private JTextField txtTitledvd;
	private JTextField txtCatdvd;
	private JTextField txtCostdvd;
	private JTextField txtDirdvd;
	private JTextField txtLendvd;
	private JTextField txtIDcd;
	private JTextField txtTitlecd;
	private JTextField txtCatcd;
	private JTextField txtCostcd;
	private JTextField txtArtcd;
	private JTextField txtNOTrackcd;
	
	public AddItemsFrm() {
		setTitle("Add Items");
		setBounds(100, 100, 577, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 21, 220, 319);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(22, 51, 168, 41);
		panel_1.add(btnBook);
		btnBook.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Please choose type of item: ");
		lblNewLabel_1.setBounds(0, 0, 220, 41);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(22, 245, 168, 41);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(240, 21, 313, 335);
		contentPanel.add(tabbedPane);
		
		JPanel Book = new JPanel();
		tabbedPane.addTab("Add Book", null, Book, null);
		Book.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 27, 76, 29);
		Book.add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTitle.setBounds(25, 73, 76, 29);
		Book.add(lblTitle);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCategory.setBounds(25, 119, 76, 29);
		Book.add(lblCategory);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCost.setBounds(25, 168, 76, 29);
		Book.add(lblCost);
		
		JLabel lblNoauthor = new JLabel("NOAuthor");
		lblNoauthor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNoauthor.setBounds(25, 217, 76, 29);
		Book.add(lblNoauthor);
		
		txtID = new JTextField();
		txtID.setBounds(111, 33, 160, 19);
		Book.add(txtID);
		txtID.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setColumns(10);
		txtTitle.setBounds(111, 79, 160, 19);
		Book.add(txtTitle);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		txtCat.setBounds(111, 125, 160, 19);
		Book.add(txtCat);
		
		txtCost = new JTextField();
		txtCost.setColumns(10);
		txtCost.setBounds(111, 174, 160, 19);
		Book.add(txtCost);
		
		txtNoAuthor = new JTextField();
		txtNoAuthor.setColumns(10);
		txtNoAuthor.setBounds(111, 223, 160, 19);
		Book.add(txtNoAuthor);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean check = true;
				int numOfAuthors = 0;
				int id = 0;
				float cost = 0;
				try {
					id = Integer.parseInt(txtID.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ID must be Integer!!!");
					check = false;
				}
				String title = txtTitle.getText();
				String category = txtCat.getText();
				try {
					cost = Float.parseFloat(txtCost.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Cost must be Float !!!");
					check = false;
				}
				try {
					numOfAuthors = Integer.parseInt(txtNoAuthor.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Number of authors must be Integer !!!");
					check = false;
				}
				if (numOfAuthors <=0) {
					JOptionPane.showMessageDialog(null, "Number of authors must be > 0");
					check = false;
				}
				if (check) {
					Book book = null;
					try {
						book = new Book(id, title, category, cost);
					} catch (InvalidAttributesException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < numOfAuthors; i++) {
						String author = JOptionPane.showInputDialog("Enter author's name: ");
						do {
							if (author.equals("")) {
								JOptionPane.showMessageDialog(null, "Author's name error !!!");
								author = JOptionPane.showInputDialog("Enter author's name: ");
							}
						} while (author.equals(""));
						book.addAuthor(author);
					}
					GUI.addBook(book);
				}
				txtID.setText(null);
				txtTitle.setText(null);
				txtCat.setText(null);
				txtCost.setText(null);
				txtNoAuthor.setText(null);
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAdd.setBounds(150, 265, 85, 21);
		Book.add(btnAdd);
		
		JPanel DVD = new JPanel();
		tabbedPane.addTab("Add DVD", null, DVD, null);
		DVD.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(31, 10, 76, 29);
		DVD.add(lblNewLabel_2);
		
		JLabel lblTitle_1 = new JLabel("Title");
		lblTitle_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTitle_1.setBounds(31, 56, 76, 29);
		DVD.add(lblTitle_1);
		
		JLabel lblCategory_1 = new JLabel("Category");
		lblCategory_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCategory_1.setBounds(31, 102, 76, 29);
		DVD.add(lblCategory_1);
		
		JLabel lblCost_1 = new JLabel("Cost");
		lblCost_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCost_1.setBounds(31, 145, 76, 29);
		DVD.add(lblCost_1);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDirector.setBounds(31, 187, 76, 29);
		DVD.add(lblDirector);
		
		txtIDdvd = new JTextField();
		txtIDdvd.setColumns(10);
		txtIDdvd.setBounds(117, 16, 160, 19);
		DVD.add(txtIDdvd);
		
		txtTitledvd = new JTextField();
		txtTitledvd.setColumns(10);
		txtTitledvd.setBounds(117, 62, 160, 19);
		DVD.add(txtTitledvd);
		
		txtCatdvd = new JTextField();
		txtCatdvd.setColumns(10);
		txtCatdvd.setBounds(117, 108, 160, 19);
		DVD.add(txtCatdvd);
		
		txtCostdvd = new JTextField();
		txtCostdvd.setColumns(10);
		txtCostdvd.setBounds(117, 150, 160, 19);
		DVD.add(txtCostdvd);
		
		txtDirdvd = new JTextField();
		txtDirdvd.setColumns(10);
		txtDirdvd.setBounds(117, 192, 160, 19);
		DVD.add(txtDirdvd);
		
		JButton btnAdddvd = new JButton("Add");
		btnAdddvd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = true;
				int length = 0;
				int id = 0;
				float cost = 0;
				try {
					id = Integer.parseInt(txtIDdvd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ID must be Integer!!!");
					check = false;
				}
				String title = txtTitledvd.getText();
				String category = txtCatdvd.getText();
				String director = txtDirdvd.getText();
				try {
					cost = Float.parseFloat(txtCostdvd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Cost must be Float !!!");
					check = false;
				}
				if (cost <= 0) {
					JOptionPane.showMessageDialog(null, "Cost must be positive!!!");
					check = false;
				}
				try {
					length = Integer.parseInt(txtLendvd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Length must be Integer !!!");
					check = false;
				}
				
				if (check) {
					DigitalVideoDisc dvd = null;
					try {
						dvd = new DigitalVideoDisc(title, category, director, length, cost, id);
					} catch (InvalidAttributesException e1) {
						e1.printStackTrace();
					}
					GUI.addDisc(dvd);
				}
				txtIDdvd.setText(null);
				txtTitledvd.setText(null);
				txtCatdvd.setText(null);
				txtCostdvd.setText(null);
				txtDirdvd.setText(null);
				txtLendvd.setText(null);
			}
		});
		btnAdddvd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAdddvd.setBounds(156, 268, 85, 21);
		DVD.add(btnAdddvd);
		
		txtLendvd = new JTextField();
		txtLendvd.setColumns(10);
		txtLendvd.setBounds(117, 235, 160, 19);
		DVD.add(txtLendvd);
		
		JLabel lblLength = new JLabel("Length");
		lblLength.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblLength.setBounds(31, 229, 76, 29);
		DVD.add(lblLength);
		
		JPanel CD = new JPanel();
		tabbedPane.addTab("Add CD", null, CD, null);
		CD.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ID");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(31, 19, 76, 29);
		CD.add(lblNewLabel_2_1);
		
		JLabel lblTitle_1_1 = new JLabel("Title");
		lblTitle_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTitle_1_1.setBounds(31, 65, 76, 29);
		CD.add(lblTitle_1_1);
		
		JLabel lblCategory_1_1 = new JLabel("Category");
		lblCategory_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCategory_1_1.setBounds(31, 111, 76, 29);
		CD.add(lblCategory_1_1);
		
		JLabel lblCost_1_1 = new JLabel("Cost");
		lblCost_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCost_1_1.setBounds(31, 154, 76, 29);
		CD.add(lblCost_1_1);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblArtist.setBounds(31, 196, 76, 29);
		CD.add(lblArtist);
		
		txtIDcd = new JTextField();
		txtIDcd.setColumns(10);
		txtIDcd.setBounds(117, 25, 160, 19);
		CD.add(txtIDcd);
		
		txtTitlecd = new JTextField();
		txtTitlecd.setColumns(10);
		txtTitlecd.setBounds(117, 71, 160, 19);
		CD.add(txtTitlecd);
		
		txtCatcd = new JTextField();
		txtCatcd.setColumns(10);
		txtCatcd.setBounds(117, 117, 160, 19);
		CD.add(txtCatcd);
		
		txtCostcd = new JTextField();
		txtCostcd.setColumns(10);
		txtCostcd.setBounds(117, 159, 160, 19);
		CD.add(txtCostcd);
		
		txtArtcd = new JTextField();
		txtArtcd.setColumns(10);
		txtArtcd.setBounds(117, 201, 160, 19);
		CD.add(txtArtcd);
		
		JButton btnAddcd = new JButton("Add");
		btnAddcd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = true;
				int id = 0;
				float cost = 0;
				int nbOfTrack = 0;
				int length = 0;
				try {
					id = Integer.parseInt(txtIDcd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ID must be Integer!!!");
					check = false;
				}
				String title = txtTitlecd.getText();
				String category = txtCatcd.getText();
				String artist = txtArtcd.getText();
				try {
					cost = Float.parseFloat(txtCostcd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Cost must be Float !!!");
					check = false;
				}
				if (cost <= 0 ) {
					JOptionPane.showMessageDialog(null, "Cost must be positive!!!");
					check = false;
				}
				try {
					nbOfTrack = Integer.parseInt(txtNOTrackcd.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Number of tracks must be Integer !!!");
					check = false;
				}
				if (nbOfTrack <=0) {
					JOptionPane.showMessageDialog(null, "Number of tracks must be > 0");
					check = false;
				}
				
				if (check) {
					int k;
					CompactDisc cd = null;
					try {
						cd = new CompactDisc(id, title, category, cost, artist);
					} catch (InvalidAttributesException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < nbOfTrack; i++) {
						String titleString = JOptionPane.showInputDialog("Enter track's title: ");
						do {
							if (titleString.equals("")) {
								JOptionPane.showMessageDialog(null, "Track's name error !!!");
								titleString = JOptionPane.showInputDialog("Enter track's title: ");
							}
						} while (titleString.equals(""));
						
						do {
							k = 0;
							try {
								length = Integer.parseInt(JOptionPane.showInputDialog("Enter track's length: "));
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Invalid Input");
								k = 1;
							}
							if (length <= 0) {
								JOptionPane.showMessageDialog(null, "Length must be positive!!!");
								k = 1;
							}
						} while (k == 1);
						
						try {
							cd.addTrack(new Track(titleString, length));
						} catch (InvalidAttributesException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage()+"\n"+e1.toString());
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					GUI.addCompactDisc(cd);
				}
				txtIDcd.setText(null);
				txtTitlecd.setText(null);
				txtCatcd.setText(null);
				txtCostcd.setText(null);
				txtArtcd.setText(null);
				txtNOTrackcd.setText(null);
				
				
			}
		});
		btnAddcd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnAddcd.setBounds(156, 277, 85, 21);
		CD.add(btnAddcd);
		
		txtNOTrackcd = new JTextField();
		txtNOTrackcd.setColumns(10);
		txtNOTrackcd.setBounds(117, 244, 160, 19);
		CD.add(txtNOTrackcd);
		
		JLabel lblNotrack = new JLabel("NOTrack");
		lblNotrack.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNotrack.setBounds(31, 238, 76, 29);
		CD.add(lblNotrack);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		JButton btnDigitalVideoDisc = new JButton("Digital Video Disc");
		btnDigitalVideoDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnDigitalVideoDisc.setBounds(22, 115, 168, 41);
		panel_1.add(btnDigitalVideoDisc);
		btnDigitalVideoDisc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnCompactdisc = new JButton("CompactDisc");
		btnCompactdisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnCompactdisc.setBounds(22, 183, 168, 41);
		panel_1.add(btnCompactdisc);
		btnCompactdisc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
	}
}
