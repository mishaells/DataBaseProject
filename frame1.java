import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 frame = new frame1();
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
	public frame1() {
		setTitle("mainFrame");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 39, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BLANCA PIZZERIA DATABASE SYSTEM");
		lblNewLabel.setBounds(64, 50, 307, 23);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Choose your view!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 102, 416, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("MANAGER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2MangerVerification addframe = new frame2MangerVerification();
				setVisible(false);
				addframe.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 11));
		btnNewButton.setBounds(158, 127, 120, 30);
		contentPane.add(btnNewButton);
		
		JButton btnHost = new JButton("HOST");
		btnHost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3Host frame = new frame3Host();
				frame.setVisible(true);
			}
		});
		btnHost.setFont(new Font("Sitka Text", Font.BOLD, 11));
		btnHost.setBounds(158, 168, 120, 30);
		contentPane.add(btnHost);
	}
}
