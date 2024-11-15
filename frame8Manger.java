import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.ScrollPaneConstants;

public class frame8Manger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private static JTable table;
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
					frame8Manger frame = new frame8Manger();
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
	public frame8Manger() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blancadatabase", "root", "12345Abcde.");
			stat = con.createStatement();
			//System.out.println("Database connected successfully.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
			e.printStackTrace();
		}
		setTitle("Manger view");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Employees");
		lblNewLabel.setBounds(248, 10, 290, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
		panel.setBounds(10, 58, 650, 313);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 28, 49, 14);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 44, 270, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("first name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 75, 70, 14);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 97, 80, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 97, 80, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(200, 97, 80, 20);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("middle name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(100, 75, 88, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Last name");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(200, 75, 88, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Position");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 134, 59, 14);
		panel.add(lblNewLabel_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 153, 120, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Salary");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(160, 134, 59, 14);
		panel.add(lblNewLabel_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 153, 120, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Phone number");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1.setBounds(10, 199, 113, 14);
		panel.add(lblNewLabel_1_2_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 215, 270, 20);
		panel.add(textField_6);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Street");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(334, 28, 59, 14);
		panel.add(lblNewLabel_1_2_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(335, 44, 270, 20);
		panel.add(textField_7);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("District");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2_1.setBounds(334, 81, 59, 14);
		panel.add(lblNewLabel_1_2_2_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(335, 97, 270, 20);
		panel.add(textField_8);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("Postal Code");
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2_2.setBounds(334, 137, 88, 14);
		panel.add(lblNewLabel_1_2_2_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(335, 153, 270, 20);
		panel.add(textField_9);
		
		JLabel lblNewLabel_1_2_2_2_1 = new JLabel("City");
		lblNewLabel_1_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2_2_1.setBounds(334, 199, 59, 14);
		panel.add(lblNewLabel_1_2_2_2_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(335, 215, 270, 20);
		panel.add(textField_10);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Nationality");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1_1_1.setBounds(10, 255, 113, 14);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(10, 271, 270, 20);
		panel.add(textField_11);
		
		JLabel lblNewLabel_1_2_2_2_1_1 = new JLabel("Branch code");
		lblNewLabel_1_2_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2_2_1_1.setBounds(334, 255, 120, 14);
		panel.add(lblNewLabel_1_2_2_2_1_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(335, 271, 270, 20);
		panel.add(textField_12);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText(); // Employee ID
				String fname = textField_1.getText(); // First Name
				String mname = textField_2.getText(); // Middle Name
				String lname = textField_3.getText(); // Last Name
				String position = textField_4.getText(); // Position
				String salary = textField_5.getText(); // Salary
				double salaryDouble = Double.parseDouble(salary); // Convert salary to double
				String phone = textField_6.getText(); // Phone Number
				String street = textField_7.getText(); // Street
				String district = textField_8.getText(); // District
				String postal = textField_9.getText(); // Postal Code
				String city = textField_10.getText(); // City
				String nationality = textField_11.getText(); // Nationality
				String bcode = textField_12.getText(); // Branch Code

				if (stat != null) {
				    try {
				        stat.executeUpdate("INSERT INTO `blancadatabase`.`Employee` VALUES('" 
				                + id + "', '" 
				                + fname + "', '" 
				                + mname + "', '" 
				                + lname + "', '" 
				                + position + "', '" 
				                + salaryDouble + "', '" 
				                + phone + "', '" 
				                + street + "', '" 
				                + district + "', '" 
				                + postal + "', '" 
				                + city + "', '" 
				                + nationality + "', '" 
				                + bcode + "');");
				        table_load();
				        JOptionPane.showMessageDialog(null, "Employee added successfully!");
				    } catch (Exception e1) {
				        System.out.println(e1.getMessage());
				        JOptionPane.showMessageDialog(null, "Insert operation failed: " + e1.getMessage());
				    }
				} else {
				    JOptionPane.showMessageDialog(null, "Database connection not established.");
				}

			}
		});
		btnInsert.setBounds(680, 71, 150, 49);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText();

				//========================
				if (stat != null) {
					try {
						stat.executeUpdate("DELETE FROM Employee WHERE ID = '" + id + "';");
						table_load();
						JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Delete operation failed: " + e1.getMessage());
					}
				} else {
						JOptionPane.showMessageDialog(null, "Database connection not established.");
					}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(680, 133, 150, 49);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText(); // The ID used to identify the employee to update

				// Retrieve values from text fields
				String fname = textField_1.getText();
				String mname = textField_2.getText();
				String lname = textField_3.getText();
				String position = textField_4.getText();
				String salary = textField_5.getText();
				String phone = textField_6.getText();
				String street = textField_7.getText();
				String district = textField_8.getText();
				String postal = textField_9.getText();
				String city = textField_10.getText();
				String nationality = textField_11.getText();
				String bcode = textField_12.getText();

				if (id.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Please enter an ID to update.");
				} else {
				    StringBuilder query = new StringBuilder("UPDATE `blancadatabase`.`employee` SET ");

				    // Check each field and append only if it's filled
				    if (!fname.isEmpty()) query.append("`E_Fname` = '").append(fname).append("', ");
				    if (!mname.isEmpty()) query.append("`E_Mname` = '").append(mname).append("', ");
				    if (!lname.isEmpty()) query.append("`E_Lname` = '").append(lname).append("', ");
				    if (!position.isEmpty()) query.append("`Position` = '").append(position).append("', ");
				    if (!salary.isEmpty()) query.append("`Salary` = ").append(Double.parseDouble(salary)).append(", ");
				    if (!phone.isEmpty()) query.append("`Ephone_num` = '").append(phone).append("', ");
				    if (!street.isEmpty()) query.append("`Street` = '").append(street).append("', ");
				    if (!district.isEmpty()) query.append("`District` = '").append(district).append("', ");
				    if (!postal.isEmpty()) query.append("`Postal_code` = '").append(postal).append("', ");
				    if (!city.isEmpty()) query.append("`City` = '").append(city).append("', ");
				    if (!nationality.isEmpty()) query.append("`Nationality` = '").append(nationality).append("', ");
				    if (!bcode.isEmpty()) query.append("`Bcode` = '").append(bcode).append("', ");

				    // Remove the trailing comma and space from the last field, then add WHERE clause
				    query.setLength(query.length() - 2); // Remove trailing comma and space
				    query.append(" WHERE `ID` = '").append(id).append("';");

				    if (stat != null) {
				        try {
				            // Execute the dynamic update query
				            stat.executeUpdate(query.toString());
				            table_load();
				            JOptionPane.showMessageDialog(null, "Employee updated successfully!");
				        } catch (Exception e1) {
				            System.out.println(e1.getMessage());
				            JOptionPane.showMessageDialog(null, "Update operation failed: " + e1.getMessage());
				        }
				    } else {
				        JOptionPane.showMessageDialog(null, "Database connection not established.");
				    }
				}

				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(680, 193, 150, 49);
		contentPane.add(btnUpdate);
		
		JLabel lblNoteToDelete = new JLabel("<html> Note: To delete an Employee, enter the ID number only. To update info, enter the Employee ID and the updated info.</html>");
		lblNoteToDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoteToDelete.setBounds(680, 253, 150, 118);
		contentPane.add(lblNoteToDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 382, 832, 181);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton btnInsert_1 = new JButton("Back");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame7Manger f7 = new frame7Manger();
				setVisible(false);
				f7.setVisible(true);
			}
		});
		btnInsert_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnInsert_1.setBounds(10, 10, 112, 25);
		contentPane.add(btnInsert_1);
		table_load();
	}
	
	public static void table_load() {
		if (stat != null) {
	    try {
	        rs = stat.executeQuery("SELECT * FROM Employee");
	        
	        // Assuming ResultSet has columns that match your JTable structure
	        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "E_Fname", "E_Mname", "E_Lname","Position","Salary","Ephone_num","Street","District","Postal Code","City","Nationallity","Branch Code"}, 0); // Define your column names
	        while (rs.next())
	            model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)});
	        
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
