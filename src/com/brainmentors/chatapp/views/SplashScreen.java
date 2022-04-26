package com.brainmentors.chatapp.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgressBar();
	}

	/**
	 * Create the frame.
	 */
	private Timer timer;
	private void runProgressBar() {
		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				progressBar.setValue(count);
				count++;
				if(count > 100) {
					if(timer != null) {
						timer.stop();
						SplashScreen.this.setVisible(false);
						SplashScreen.this.dispose();
						UserScreen userScreen = new UserScreen();
						userScreen.setVisible(true);
					}
			}
			}
		}) ;
		timer.start();
	}
	private int count = 0;
	JProgressBar progressBar = new JProgressBar();
	
	
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 16));
		progressBar.setStringPainted(true);
		progressBar.setBounds(63, 434, 809, 27);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/live-chat.jpg")));
		lblNewLabel.setBounds(0, 0, 954, 518);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}


	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
}
