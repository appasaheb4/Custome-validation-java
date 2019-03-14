package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.JTextFieldFilter;
import Helper.SadFaceSimpleAlert;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextArea;

import javax.mail.internet.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtMobileNo;
	private JTextField txtSalary;
	SadFaceSimpleAlert sd = new SadFaceSimpleAlert();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(90, 63, 44, 16);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(194, 51, 238, 40);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(194, 103, 238, 40);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(90, 115, 44, 16);
		contentPane.add(lblEmail);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setColumns(10);
		txtMobileNo.setBounds(194, 155, 238, 40);
		contentPane.add(txtMobileNo);
		
		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setBounds(90, 167, 68, 16);
		contentPane.add(lblMobileNo);
		
		TextArea txtAddress = new TextArea();
		txtAddress.setBounds(194, 201, 238, 57);
		contentPane.add(txtAddress);
		
		JLabel lblNewLabel_1 = new JLabel("Address :");
		lblNewLabel_1.setBounds(90, 201, 59, 16);
		contentPane.add(lblNewLabel_1);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(194, 264, 238, 40);
		contentPane.add(txtSalary);
		txtSalary.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Salary :");
		lblNewLabel_2.setBounds(90, 276, 45, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().toString();
				String email = txtEmail.getText().toString();
				String mobileNo = txtMobileNo.getText().toString();
				String address = txtAddress.getText().toString();
				String salary = txtSalary.getText().toString();
				
				String msg = validation(name,email,mobileNo,salary);
				
				if(msg == "") {
					
				}else {
					 sd.setBounds(200, 150, 360, 210);
						sd.lblTitle.setText("Sign Up !");
						sd.lblMessage.setText(msg); 
						sd.setUndecorated(true);
						sd.setModal(true);
						sd.setVisible(true);
				}
				
				
				
				
						
						
			}

			private String validation(String name, String email, String mobileNo, String salary) {
				String msg = "";
				
				 InternetAddress emailAddr;
				try {
					emailAddr = new InternetAddress(email);
					emailAddr.validate();
				} catch (AddressException e) {
					msg = "Plese enter correct email address.";
					e.printStackTrace();
				}
			    if(name.isEmpty()) {
					msg = "Please enter name.";
				}
				else if(email.isEmpty()) {
					msg = "Plese enter email.";
				}
				
				else if(mobileNo.isEmpty()) {
					msg = "Please enter mobile no.";
				}else if(salary.isEmpty()) {
					msg = "Please entery salary.";
				}
				return msg;
			}
		});
		btnSave.setBounds(194, 316, 238, 42);
		contentPane.add(btnSave);
		  
		
		//Validation apply
		//Validation Apply

		JTextFieldFilter validationNumeric = new JTextFieldFilter(JTextFieldFilter.NUMERIC);  
		JTextFieldFilter validationDecimal = new JTextFieldFilter(JTextFieldFilter.DECIMAL); 
		JTextFieldFilter validationEmail = new JTextFieldFilter(JTextFieldFilter.EMAIL);
		validationNumeric.setNegativeAccepted(true);
		validationDecimal.setNegativeAccepted(true);
		validationEmail.setNegativeAccepted(true);
		txtMobileNo.setDocument(validationNumeric);  
		txtSalary.setDocument(validationDecimal); 
		txtEmail.setDocument(validationEmail);   
		
	}
	

}
