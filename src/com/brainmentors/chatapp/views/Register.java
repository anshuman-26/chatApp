package com.brainmentors.chatapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;

public class Register extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField emailtxt;
	private JTextField citytxt;
	private JTextField phntxt;
	private JTextField useridtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Register frame = new Register();
	}

	/**
	 * Create the frame.
	 */
	UserScreen us = new UserScreen();
	UserDAO userDAO1 = new UserDAO();
	public void Registeration() {
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword();
		String email = emailtxt.getText();
		String city = citytxt.getText();
		String phone = phntxt.getText();
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password, email, city, phone);
		try {
		int result = userDAO1.add(userDTO);
		if(result > 0) {
			//System.out.println("Record Added...");
			JOptionPane.showMessageDialog(this, "Registered successfully");
			setVisible(false);
			dispose();
	
		}else {
			JOptionPane.showMessageDialog(this, "Registeration fail...");
		}
		}
		catch(ClassNotFoundException |SQLException ex) {
			System.out.println("DB issue...");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some generic exception raised...");
			ex.printStackTrace();
		}
		System.out.println("Userid: " + userid + " Password: " +password);  //ClassName@HashCode(Hexa)
	}

	
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(140, 169, 90, 30);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(346, 164, 330, 48);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblCity = new JLabel("E-mail");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCity.setBounds(140, 245, 65, 30);
		contentPane.add(lblCity);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(346, 240, 330, 48);
		contentPane.add(emailtxt);
		
		JLabel lblPhone = new JLabel("City");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(140, 328, 65, 30);
		contentPane.add(lblPhone);
		
		citytxt = new JTextField();
		citytxt.setColumns(10);
		citytxt.setBounds(346, 323, 330, 48);
		contentPane.add(citytxt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Registeration();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		registerbt.setBounds(431, 493, 117, 42);
		contentPane.add(registerbt);
		
		phntxt = new JTextField();
		phntxt.setColumns(10);
		phntxt.setBounds(346, 404, 330, 48);
		contentPane.add(phntxt);
		
		JLabel lblPhone_1 = new JLabel("Phone");
		lblPhone_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone_1.setBounds(140, 409, 65, 30);
		contentPane.add(lblPhone_1);
		
		useridtxt = new JTextField();
		useridtxt.setColumns(10);
		useridtxt.setBounds(346, 91, 330, 48);
		contentPane.add(useridtxt);
		
		JLabel lblUsernid = new JLabel("Userid");
		lblUsernid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsernid.setBounds(140, 96, 90, 30);
		contentPane.add(lblUsernid);
		setLocationRelativeTo(null);
	}
}
