import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame7Manger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame7Manger frame = new frame7Manger();
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
	public frame7Manger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello Manager!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(161, 34, 153, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("please choose:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(177, 80, 127, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Edit Employees");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame8Employee f8 = new frame8Employee();
				f8.setVisible(true);
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(64, 140, 147, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit Customers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame4Customer frame = new frame4Customer();
				frame.setVisible(true);
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(261, 140, 147, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit Reservations");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame5Reservation frame = new frame5Reservation();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(64, 190, 147, 49);
		contentPane.add(btnNewButton_2);
		
		JButton btnRetrievals = new JButton("Retrievals");
		btnRetrievals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame9MangerRetrievals f9 = new frame9MangerRetrievals();
				setVisible(false);
				f9.setVisible(true);
			}
		});
		btnRetrievals.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetrievals.setBounds(261, 190, 147, 49);
		contentPane.add(btnRetrievals);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame2MangerVerification f2 = new frame2MangerVerification();
				f2.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 319, 93, 33);
		contentPane.add(btnBack);
	}

}
