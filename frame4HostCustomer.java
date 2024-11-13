package blancaDB;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame4HostCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtphonenum;
	private JTextField txtmail;
	private JTable table;
	
	static Connection con = null;
	static Statement stat = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect();
					frame4HostCustomer frame = new frame4HostCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//=================================forConnection???????==================================
	public static void Connect() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blancadatabase", "root", "12345Abcde.");
			stat = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
    //=========================================================================================

	/**
	 * Create the frame.
	 */
	public frame4HostCustomer() {
		setBounds(100, 100, 524, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 11, 344, 158);
		panel.setBorder(new TitledBorder(null, "customer information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(6, 16, 81, 17);
		panel.add(lblNewLabel_1);
		
		txtfname = new JTextField();
		txtfname.setBounds(97, 15, 237, 17);
		panel.add(txtfname);
		txtfname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(6, 44, 81, 17);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number");
		lblNewLabel_1_2.setBounds(6, 72, 81, 17);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setBounds(6, 100, 81, 17);
		panel.add(lblNewLabel_1_3);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(97, 42, 237, 17);
		panel.add(txtlname);
		
		txtphonenum = new JTextField();
		txtphonenum.setColumns(10);
		txtphonenum.setBounds(97, 70, 237, 17);
		panel.add(txtphonenum);
		
		txtmail = new JTextField();
		txtmail.setColumns(10);
		txtmail.setBounds(97, 98, 237, 17);
		panel.add(txtmail);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//blancaDB.InsertCustomer();
				
				String fname,lname,phone,email;
				
				fname = txtfname.getText();
				lname = txtlname.getText();
				phone = txtphonenum.getText();
				email = txtmail.getText();
				try {
				stat.executeUpdate(
						"INSERT INTO CUSTOMER VALUES('" + fname + "', '" + lname + "', '" + phone + "', '" + email + "');");
				JOptionPane.showMessageDialog(null, "Operation executed successfully!");
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				System.out.println("Operation Unseccesful");
			}
		}
		});
		btnInsert.setBounds(354, 15, 150, 49);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnUpdate.setBounds(354, 117, 150, 49);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
						String phone = txtphonenum.getText();
						try {
						stat.executeUpdate("DELETE FROM CUSTOMER WHERE Cphone_num = '" + phone + "';");
						JOptionPane.showMessageDialog(null, "Operation executed successfully!");

					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						System.out.println("Operation Unseccesful");
					}
			}
		});
		btnDelete.setBounds(354, 66, 150, 49);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 173, 496, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
