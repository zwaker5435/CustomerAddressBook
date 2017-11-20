package customerAddressBook;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class SearchEngine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public SearchEngine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("ID: ");
		idLabel.setBounds(12, 35, 21, 16);
		contentPane.add(idLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(78, 31, 97, 25);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(32, 32, 34, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 32, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	}
}
