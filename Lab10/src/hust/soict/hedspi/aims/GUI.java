package hust.soict.hedspi.aims;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import javax.naming.LimitExceededException;
import javax.swing.JButton;
import javax.swing.JTextArea;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class GUI {

	int choice;
	static Order anOrder = null;

	private JFrame main;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GUI() {
		initialize();
	}


	static JTextArea showInfor = new JTextArea();

	private void initialize() {

		main = new JFrame();
		main.setTitle("An Internet Media Store");
		main.setBounds(100, 100, 818, 522);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.getContentPane().setLayout(null);

//		JTextArea showInfor = new JTextArea();
		showInfor.setBounds(10, 62, 784, 413);
		main.getContentPane().add(showInfor);

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setBounds(10, 21, 41, 31);
		main.getContentPane().add(lblNewLabel);

		JButton btnAddItems = new JButton("Create Order");
		btnAddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					anOrder = new Order();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				showInfor.setText("An Order is created!!!");
			}
		});
		btnAddItems.setBounds(61, 26, 109, 21);
		main.getContentPane().add(btnAddItems);

		JButton btnAddItem = new JButton("Add Items");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemsFrm addItemsFrm = new AddItemsFrm();
				addItemsFrm.setVisible(true);

			}
		});
		btnAddItem.setBounds(175, 26, 109, 21);
		main.getContentPane().add(btnAddItem);

		JButton btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k;
				int id = 0;
				if (anOrder == null) {
					JOptionPane.showMessageDialog(main, "Order has not been created!!!");
				} else {
					do {
						k = 0;
						try {
							id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to remove: "));
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Invalid Input");
							k = 1;
						}
					} while (k == 1);
					
					if (anOrder.searchById(id) == null) {
						JOptionPane.showMessageDialog(null, "Does not exist this product.");
					}else {
						try {
							anOrder.removeMedia(anOrder.searchById(id));
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Item has been deleted!");
					}
					
				}
			}
		});
		btnRemoveItem.setBounds(290, 26, 109, 21);
		main.getContentPane().add(btnRemoveItem);

		JButton btnPrintDetails = new JButton("Print Detail");
		btnPrintDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (anOrder == null) {
					JOptionPane.showMessageDialog(main, "Order has not been created!!!");
				} else {
					showInfor.setText(anOrder.printDetalsString());
				}
			}
		});
		btnPrintDetails.setBounds(403, 26, 109, 21);
		main.getContentPane().add(btnPrintDetails);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(517, 26, 109, 21);
		main.getContentPane().add(btnExit);

	}

	static void addDisc(DigitalVideoDisc dvd) {
		if (anOrder.searchById(dvd.id) != null) {
			JOptionPane.showMessageDialog(null, "Error!!! Item already exists");
		} else {
			try {
				anOrder.addMedia(dvd);
			} catch (LimitExceededException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Success! A DVD is added.");

			int p1 = 2;
			int k;
			do {
				k = 0;
				String p = JOptionPane.showInputDialog("Do you want to play DVD?\n1. Yes\n2. No");
				try {
					p1 = Integer.parseInt(p);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					k = 1;
				}
			} while (k == 1);

			switch (p1) {
			case 1:
				try {
					showInfor.setText(dvd.playGUI());
				} catch (PlayerException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		}
	}

	static void addBook(Book book) {
		if (anOrder.searchById(book.id) != null) {
			JOptionPane.showMessageDialog(null, "Error!!! Item already exists");
		} else {
			try {
				anOrder.addMedia(book);
			} catch (LimitExceededException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Success! A book is added.");
		}
	}

	static void addCompactDisc(CompactDisc cd) {
		if (anOrder.searchById(cd.id) != null) {
			JOptionPane.showMessageDialog(null, "Error!!! Item already exists");
		} else {
			try {
				anOrder.addMedia(cd);
			} catch (LimitExceededException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Success! A CD is added.");
			
			int p1 = 2;
			int k;
			do {
				k = 0;
				String p = JOptionPane.showInputDialog("Do you want to play CD?\n1. Yes\n2. No");
				try {
					p1 = Integer.parseInt(p);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input");
					k = 1;
				}
			} while (k == 1);

			switch (p1) {
			case 1:
				try {
					showInfor.setText(cd.playGUI());
				} catch (PlayerException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				break;
			default:
				break;
			}
		}
	}

}
