package blancaDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class frame3Host extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3Host frame = new frame3Host();
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
	public frame3Host() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select a tabel to Insert,Delete or Update");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 61, 416, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("CUSTOMER");
		btnNewButton_1.setFont(new Font("Georgia", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4HostCustomer frame = new frame4HostCustomer();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(97, 86, 120, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("RESERVATION");
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 12));
		btnNewButton.setBounds(225, 86, 120, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame5HostReservation frame = new frame5HostReservation();
				frame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("For retrieval operations click here!");
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 139, 416, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("here!");
		btnNewButton_2.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame6HostRetrievals frame = new frame6HostRetrievals();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(97, 164, 248, 36);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Hello host!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Eras Bold ITC", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(97, 11, 248, 50);
		contentPane.add(lblNewLabel_2);
	}

}
