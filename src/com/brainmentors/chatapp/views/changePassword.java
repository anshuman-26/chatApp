package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.dao.UserDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class changePassword extends JFrame {

	private JPanel contentPane;
	private JTextField useridtxt;
	private JPasswordField np;
	private JPasswordField cp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		changePassword frame = new changePassword();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 */
	
	public void updatePassword() throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		String userid = useridtxt.getText();
		char[] NP = np.getPassword();
		char[] CP = cp.getPassword();
		if(new String(NP).equals(new String(CP))) {
			int change = UserDAO.changePassword(userid, NP);
			if(change == 1) {
				JOptionPane.showMessageDialog(this, "Password changed successfully");
				UserScreen us1 = new UserScreen();
			}
			else {
				JOptionPane.showMessageDialog(this, "Userid not matched");
			}
		}else {
			String message = "Password not matched";
			JOptionPane.showInternalMessageDialog(this, message);
		}
	}
	
	public changePassword() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userid = new JLabel("User Id");
		userid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userid.setBounds(112, 106, 139, 36);
		contentPane.add(userid);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(314, 100, 312, 36);
		contentPane.add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewPassword.setBounds(112, 187, 139, 36);
		contentPane.add(lblNewPassword);
		
		np = new JPasswordField();
		np.setColumns(10);
		np.setBounds(314, 190, 312, 36);
		contentPane.add(np);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(112, 270, 139, 36);
		contentPane.add(lblConfirmPassword);
		
		cp = new JPasswordField();
		cp.setColumns(10);
		cp.setBounds(314, 273, 312, 36);
		contentPane.add(cp);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updatePassword();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(433, 363, 109, 29);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
