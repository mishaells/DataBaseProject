import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class frame2Manger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static Connection con = null;
	static Statement stat = null;
	static ResultSet rs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2Manger frame = new frame2Manger();
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
	public frame2Manger() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blancadatabase", "root", "12345Abcde.");
			stat = con.createStatement();
			//System.out.println("Database connected successfully.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Verify Identity");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(94, 11, 294, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Manager ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(23, 76, 128, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(23, 156, 99, 31);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(33, 118, 398, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(33, 198, 398, 27);
		contentPane.add(textField_1);
		
		JButton btn1 = new JButton("Enter");
		btn1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	
	        String inputId = textField.getText().trim(); // Get the input from JTextField

	        String query = "SELECT ID FROM employee WHERE Position = 'Manager'";
	        boolean isValidManager = false; // Flag to check if the ID is valid

	        try {
	            // Execute the query
	            ResultSet rs = stat.executeQuery(query);

	            // Loop through the result set
	            while (rs.next()) {
	                String id = rs.getString("ID");

	                // Check if the JTextField input matches any manager ID in the database
	                if (id.equals(inputId)) {
	                	isValidManager = true;
	                    if(!textField_1.getText().equals("12345")) { //check password
	        	            JOptionPane.showMessageDialog( frame2Manger.this , "wrong password");
	                    	continue; }
	                    
	                    frame7Manger f = new frame7Manger();
	                    setVisible(false);
	                    f.setVisible(true);
	                    break; // Exit the loop if a match is found
	                }
	            } //end while
	            
	            if(!isValidManager) 
	            JOptionPane.showMessageDialog( frame2Manger.this , "wrong manager ID!"); 

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	});

		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setBounds(85, 262, 128, 47);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Reset");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setBounds(263, 262, 128, 47);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame1 f1 = new frame1();
				f1.setVisible(true);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn3.setBounds(10, 325, 84, 27);
		contentPane.add(btn3);
	}
}
