package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.UserInfo;

public class UserScreen extends JFrame {

	private JFrame frame;
	private JTextField useridtxt;
	private JPasswordField passwordField;
	

	
	public static void main(String[] args) {
			
		UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO = new UserDAO();
	private void doLogin() {
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword();
		
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = "";
			if(userDAO.isLogin(userDTO)){
			message = "Welcome " + userid;
			UserInfo.USER_NAME = userid;
			JOptionPane.showMessageDialog(this, message);
			setVisible(false);
			dispose();
			
			DashBoard dashboard = new DashBoard(message);
			dashboard.setVisible(true);
			} else {
				message = "Invalid userid or password";
				JOptionPane.showMessageDialog(this, message);
			}
			//JOptionPane.showMessageDialog(this, message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register() {
		setVisible(false);
		dispose();
		
		Register registeration = new Register();
		registeration.setVisible(true);
		
	}
	
	private void clear() {
		useridtxt.setText("");
		passwordField.setText("");
	}
	
	
	private void changePassword() {
		setVisible(false);
		dispose();
		
		changePassword changepassword = new changePassword();
		changepassword.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(327, 10, 164, 93);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(385, 153, 301, 50);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel useridlbl = new JLabel("Userid");
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		useridlbl.setBounds(191, 159, 107, 31);
		getContentPane().add(useridlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdlbl.setBounds(191, 245, 107, 31);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(385, 239, 301, 50);
		getContentPane().add(passwordField);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(287, 319, 94, 31);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(438, 319, 94, 31);
		getContentPane().add(registerbt);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(601, 324, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change Password?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(396, 370, 173, 32);
		getContentPane().add(btnNewButton_1);
		setBackground(Color.WHITE);
		setSize(875, 525);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	} 
}
