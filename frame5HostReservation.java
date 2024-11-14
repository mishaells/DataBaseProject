package blancaDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;

public class frame5HostReservation extends JFrame {

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
	
	static Connection con = null;
	static Statement stat = null;
	static ResultSet rs;
	private static JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame5HostReservation frame = new frame5HostReservation();
					frame.setVisible(true);
					table_load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public frame5HostReservation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blancadatabase", "root", "12345Abcde.");
			stat = con.createStatement();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
			e.printStackTrace();
		}

		
		setBounds(100, 100, 525, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 511, 330);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Reservation Information", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("Button.darkShadow")));
		panel.setBounds(8, 11, 344, 187);
		contentPane_1.add(panel);
		
		JLabel lblRefrenceNumber = new JLabel("Refrence Number");
		lblRefrenceNumber.setBounds(6, 16, 81, 17);
		panel.add(lblRefrenceNumber);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 15, 237, 17);
		panel.add(textField);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(6, 36, 81, 17);
		panel.add(lblDate);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(6, 56, 81, 17);
		panel.add(lblStartTime);
		
		JLabel lblNumberOfPeople = new JLabel("Number of people");
		lblNumberOfPeople.setBounds(6, 96, 81, 17);
		panel.add(lblNumberOfPeople);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 35, 237, 17);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 55, 237, 17);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 75, 237, 17);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 95, 237, 17);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(97, 115, 237, 17);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(97, 135, 237, 17);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(97, 155, 237, 17);
		panel.add(textField_7);
		
		JLabel lblBcode = new JLabel("Bcode");
		lblBcode.setBounds(6, 116, 81, 17);
		panel.add(lblBcode);
		
		JLabel lblServersId = new JLabel("Servers ID");
		lblServersId.setBounds(6, 136, 81, 17);
		panel.add(lblServersId);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(6, 156, 81, 17);
		panel.add(lblPhoneNumber);
		
		JLabel lblTableNumber_4 = new JLabel("Table Number");
		lblTableNumber_4.setBounds(6, 76, 81, 17);
		panel.add(lblTableNumber_4);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ref = textField.getText();
				String date = textField_1.getText();
				String time = textField_2.getText();
				String table = textField_3.getText();
				int tableint = Integer.parseInt(table);
				String ppl = textField_4.getText();
				int pplint = Integer.parseInt(ppl);
				String code = textField_5.getText();
				String id = textField_6.getText();
				String phone = textField_7.getText();
				
				if (stat != null) {
					try {
						stat.executeUpdate("INSERT INTO RESERVATION VALUES('" + ref + "', '" + date + "', '" + time + ":00', '"
								+ tableint + "', '" + pplint + "', '" + code + "', '" + id + "', '" + phone + "');");
						table_load();
						JOptionPane.showMessageDialog(null, "Reservation added successfully!");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Insert operation failed: " + e1.getMessage());
					}
				} else {
						JOptionPane.showMessageDialog(null, "Database connection not established.");
					}	
			
				
			}
		});
		
		btnInsert.setBounds(354, 15, 150, 49);
		contentPane_1.add(btnInsert);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ref = textField.getText();

				//========================
				if (stat != null) {
					try {
						stat.executeUpdate("DELETE FROM RESERVATION WHERE Ref_no = '" + ref + "';");
						table_load();
						JOptionPane.showMessageDialog(null, "Reservation deleted successfully!");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Delete operation failed: " + e1.getMessage());
					}
				} else {
						JOptionPane.showMessageDialog(null, "Database connection not established.");
					}
				//=======================
				
			}
		});
		btnDelete.setBounds(354, 66, 150, 49);
		contentPane_1.add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ref = textField.getText();
				String ppl = textField_4.getText();
				int pplint = Integer.parseInt(ppl);
				
				if (stat != null) {
					try {
						stat.executeUpdate("UPDATE RESERVATION SET Num_of_ppl = " + pplint + " WHERE Ref_no = '" + ref + "';");
						table_load();
						JOptionPane.showMessageDialog(null, "Reservation updated successfully!");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						JOptionPane.showMessageDialog(null, "Update operation failed: " + e1.getMessage());
					}
				} else {
						JOptionPane.showMessageDialog(null, "Database connection not established.");
					}
				
			}
		});
		btnUpdate.setBounds(354, 117, 150, 49);
		contentPane_1.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 494, 110);
		contentPane_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("<html> Note: To delete a reservation, enter the reference number only. To update number of people, enter the refrence number and the updated number of people only.</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 7));
		lblNewLabel.setBounds(354, 169, 150, 38);
		contentPane_1.add(lblNewLabel);
		table_load();
	}
	
	
	public static void table_load() {
		if (stat != null) {
	    try {
	        rs = stat.executeQuery("SELECT * FROM reservation");
	        
	        // Assuming ResultSet has columns that match your JTable structure
	        DefaultTableModel model = new DefaultTableModel(new String[]{"Refrence Number", "Date", "Start time", "Table Number","Number of people","Branch code","Servers ID","Phone number"}, 0); // Define your column names
	        while (rs.next())
	            model.addRow(new Object[]{rs.getString("Ref_no"), rs.getString("Date"),rs.getString("Start_time"),rs.getString("Table_num"),rs.getString("Num_of_ppl"),rs.getString("Bcode"),rs.getString("Servers_ID"),rs.getString("Cphone_num")});
	        
	        table_1.setModel(model);
	    } catch (SQLException e1) {
	    e1.printStackTrace();
	    }
	}
	 else {
		JOptionPane.showMessageDialog(null, "Database connection not established.");
	}
	}
}
