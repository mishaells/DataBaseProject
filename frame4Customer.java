import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

public class frame4Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtphonenum;
	private JTextField txtmail;
	
	static ResultSet rs;
	
	static Connection con = null;
	static Statement stat = null;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4Customer frame = new frame4Customer();
					frame.setVisible(true);
					table_load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame and initialize the database connection.
	 */
	public frame4Customer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Initialize database connection in the constructor
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blancadatabase", "root", "12345Abcde.");
			stat = con.createStatement();
			//System.out.println("Database connected successfully.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
			e.printStackTrace();
		}

		setBounds(100, 100, 525, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 11, 344, 187);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Customer Information", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.darkShadow")));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblFirstName.setBounds(10, 43, 100, 17);
		panel.add(lblFirstName);
		
		txtfname = new JTextField();
		txtfname.setBounds(120, 42, 214, 17);
		panel.add(txtfname);
		txtfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblLastName.setBounds(10, 71, 100, 17);
		panel.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblPhoneNumber.setBounds(10, 99, 100, 17);
		panel.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblEmail.setBounds(10, 125, 100, 17);
		panel.add(lblEmail);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(120, 69, 214, 17);
		panel.add(txtlname);
		
		txtphonenum = new JTextField();
		txtphonenum.setColumns(10);
		txtphonenum.setBounds(120, 97, 214, 17);
		panel.add(txtphonenum);
		
		txtmail = new JTextField();
		txtmail.setColumns(10);
		txtmail.setBounds(120, 125, 214, 17);
		panel.add(txtmail);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = txtfname.getText();
				String lname = txtlname.getText();
				String phone = txtphonenum.getText();
				String email = txtmail.getText();
				
				// Check if stat is initialized before executing SQL command
				if (stat != null) {
					try {
						stat.executeUpdate("INSERT INTO CUSTOMER (C_Fname, C_Lname, Cphone_num, Email) VALUES('" + fname + "', '" + lname + "', '" + phone + "', '" + email + "');");
						table_load();
						JOptionPane.showMessageDialog(null, "Customer added successfully!");
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Insert operation failed: " + ex.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Database connection not established.");
				}
			}
		});
		btnInsert.setBounds(354, 15, 150, 49);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String phone = txtphonenum.getText();
				if (stat != null) {
					try {
						stat.executeUpdate("DELETE FROM CUSTOMER WHERE Cphone_num = '" + phone + "';");
						table_load();
						JOptionPane.showMessageDialog(null, "Customer deleted successfully!");
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Delete operation failed: " + ex.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Database connection not established.");
				}
			}
		});
		btnDelete.setBounds(354, 66, 150, 49);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String phone = txtphonenum.getText();
				String email = txtmail.getText();
				
				if (stat != null) {
					try {
						stat.executeUpdate("UPDATE CUSTOMER SET Email = '" + email + "' WHERE Cphone_num = '" + phone + "';");
						table_load();
						JOptionPane.showMessageDialog(null, "Customer email updated successfully!");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "update operation failed: " + e1.getMessage());
					}
				} else {
						JOptionPane.showMessageDialog(null, "Database connection not established.");
					}
				
			}
		});
		btnUpdate.setBounds(354, 117, 150, 49);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 494, 110);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNoteToUpdate = new JLabel("<html> Note: To delete a customer enter their phone number only. To update a customer's email, enter their phone number and updated email only. </html>");
		lblNoteToUpdate.setFont(new Font("Georgia", Font.PLAIN, 8));
		lblNoteToUpdate.setBounds(354, 169, 150, 38);
		contentPane.add(lblNoteToUpdate);
		table_load();
	}
	
	
	public static void table_load() {
		if (stat != null) {
	    try {
	        rs = stat.executeQuery("SELECT * FROM customer");
	        
	        // Assuming ResultSet has columns that match your JTable structure
	        DefaultTableModel model = new DefaultTableModel(new String[]{"First name", "Last name", "Phone number", "Email"}, 0); // Define your column names
	        while (rs.next())
	            model.addRow(new Object[]{rs.getString("C_Fname"), rs.getString("C_Lname"),rs.getString("Cphone_num"),rs.getString("Email")});
	        
	        table.setModel(model);
	    } catch (SQLException e1) {
	    e1.printStackTrace();
	    }
		}
	 else {
		JOptionPane.showMessageDialog(null, "Database connection not established.");
	}
	}
	
	
	
}
