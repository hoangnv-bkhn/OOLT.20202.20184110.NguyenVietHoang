package Lab02;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ChoosingOption {

	public static void main(String[] args) {
		
//		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		
		Object[] options = {"Yes", "No"};
		int n = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Select an Option", 
		JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		JOptionPane.showMessageDialog(null, "You're chosen: "+(n==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
