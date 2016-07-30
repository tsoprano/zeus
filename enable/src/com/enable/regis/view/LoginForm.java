package com.enable.regis.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.enable.regis.dao.LoginDao;
import com.enable.regis.dto.LoginDto;


import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class LoginForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel loginPanel;
	private JLayeredPane SignUpPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textFieldName;
	private JPasswordField textFieldPass;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(25, 31, 626, 431);
		loginPanel.setLayout(null);
		contentPane.add(loginPanel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(95, 101, 172, 37);
		loginPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(95, 188, 172, 37);
		loginPanel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(359, 101, 236, 37);
		loginPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(359, 188, 236, 37);
		loginPanel.add(textField_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginDto ldto = new LoginDto();
				LoginDao ldao = new LoginDao();
				
				if (textField.getText().isEmpty() || textField_1.getPassword().length == 0) {
					JOptionPane.showMessageDialog(LoginForm.this, "Please fill empty fields!", "Bad",
							JOptionPane.ERROR_MESSAGE);
				} else {

					ldto.setTextField(textField.getText());
					ldto.setTextField_1(new String(textField_1.getPassword()));
					boolean success = ldao.checkLogin(textField.getText(), new String(textField_1.getPassword()));
					
					if (success) {
						dispose();
						new RecipientList().setVisible(true);
					} else {
						JOptionPane.showMessageDialog(LoginForm.this, "Wrong User Name or Password!", "Bad", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		btnLogin.setBounds(478, 290, 117, 25);
		loginPanel.add(btnLogin);
		
		JLabel lblAreYouA = new JLabel("Are you a new user?");
		lblAreYouA.setBounds(282, 371, 178, 51);
		loginPanel.add(lblAreYouA);

	
		
		
		

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginPanel.setVisible(false);
				SignUpPane = new JLayeredPane();
				SignUpPane.setBounds(33, 31, 623, 418);
				SignUpPane.setLayout(null);
				contentPane.add(SignUpPane);
				SignUpPane.setVisible(true);
				
				JLabel lblEnableRecipientRegistration = new JLabel("ENABLE RECIPIENT REGISTRATION SYSTEM");
				lblEnableRecipientRegistration.setHorizontalAlignment(SwingConstants.CENTER);
				lblEnableRecipientRegistration.setFont(new Font("MathJax_AMS", Font.BOLD | Font.ITALIC, 20));
				lblEnableRecipientRegistration.setBounds(84, 52, 485, 37);
				SignUpPane.add(lblEnableRecipientRegistration);
				
				
				JLabel lblSignupUserName = new JLabel("Enter User Name");
				lblSignupUserName.setBounds(95, 101, 172, 37);
				SignUpPane.add(lblSignupUserName);
				
				JLabel lblSignupPassword = new JLabel("Enter Password");
				lblSignupPassword.setBounds(95, 188, 172, 37);
				SignUpPane.add(lblSignupPassword);
				
				textFieldName = new JTextField();
				textFieldName.setBounds(359, 101, 236, 37);
				SignUpPane.add(textFieldName);
				textFieldName.setColumns(10);
				
				textFieldPass = new JPasswordField();
				textFieldPass.setColumns(10);
				textFieldPass.setBounds(359, 188, 236, 37);
				SignUpPane.add(textFieldPass);
				
				JButton btnRegister = new JButton("Register");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						LoginDto ldto = new LoginDto();
						LoginDao ldao = new LoginDao();
						
						if (textFieldName.getText().isEmpty() || textFieldPass.getPassword().length == 0) {
							JOptionPane.showMessageDialog(LoginForm.this, "Please fill empty fields!", "Bad",
									JOptionPane.ERROR_MESSAGE);
						} else {
							
							ldto.setTextFieldName(textFieldName.getText());
							ldto.setTextFieldPass(new String(textFieldPass.getPassword()));
							int success = ldao.signUp(ldto);
							if (success > 0) {
								JOptionPane.showMessageDialog(LoginForm.this, "Saved!", "Good", JOptionPane.OK_OPTION);
								SignUpPane.setVisible(false);
								loginPanel.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(LoginForm.this, "Error!", "Bad", JOptionPane.ERROR_MESSAGE);
							}
							
						}

						
					}
					
				});
				btnRegister.setBounds(478, 290, 117, 25);
				SignUpPane.add(btnRegister);
				
				JButton buttonBack = new JButton("<<<Back");
				buttonBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						loginPanel.setVisible(true);
						SignUpPane.setVisible(false);
							
						}
						
					});
				buttonBack.setBounds(95, 290, 117, 25);
				SignUpPane.add(buttonBack);
				

				
			}
		});
		btnSignUp.setBounds(478, 384, 117, 25);
		loginPanel.add(btnSignUp);
		
		JLabel lblEnableRecipientRegistration = new JLabel("ENABLE RECIPIENT REGISTRATION SYSTEM");
		lblEnableRecipientRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnableRecipientRegistration.setFont(new Font("MathJax_AMS", Font.BOLD | Font.ITALIC, 20));
		lblEnableRecipientRegistration.setBounds(84, 52, 485, 37);
		loginPanel.add(lblEnableRecipientRegistration);
		
		
		//JScrollPane scrollPane = new JScrollPane(loginPanel);
		//scrollPane.setBounds(42, 33, 572, 214);
		//contentPane.add(scrollPane);
		
		

		
		
		
	}
}
