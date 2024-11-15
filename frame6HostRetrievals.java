package blancaDB;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

public class frame6HostRetrievals extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcategory;
	private JTextField txtprice;
	private JTextField txtrefnum;
	private JTextField txtdate;
	
	static Connection con = null;
	static Statement stat = null;
	static ResultSet rs;
	private static JTable table;
	
	private ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame6HostRetrievals frame = new frame6HostRetrievals();
					frame.setVisible(true);
					//table_load();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame6HostRetrievals() {
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
		
		
		setBounds(100, 100, 623, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 304, 205);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Retrieval Types", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
		contentPane.add(panel);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("<html>Retrieve NAMES of ITEMS of a specific catagory that exceed a specific price.</html>");
		rdbtnNewRadioButton.setBounds(22, 17, 260, 37);
		rdbtnNewRadioButton.setFont(new Font("Georgia", Font.PLAIN, 11));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected() == true ) {
					txtcategory.setEnabled(true);
					txtprice.setEnabled(true);
					txtrefnum.setEnabled(false);
					txtdate.setEnabled(false);
				}
			}
		});
		panel.setLayout(null);
		
		
		//==========================
		
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.TOP);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("<html>Retrieve the TABLE NUMBER of a specific reservation by intering its refernce number.</html>");
		rdbtnNewRadioButton_1.setBounds(22, 57, 260, 37);
		rdbtnNewRadioButton_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1.isSelected() == true ) {
					txtcategory.setEnabled(false);
					txtprice.setEnabled(false);
					txtrefnum.setEnabled(true);
					txtdate.setEnabled(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("<html>Retrieve the NAMES and PHONE NUMBERS of customers that have reservations on a specific date.</html>");
		rdbtnNewRadioButton_2.setBounds(22, 97, 260, 50);
		rdbtnNewRadioButton_2.setFont(new Font("Georgia", Font.PLAIN, 11));
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_2.isSelected() == true ) {
					txtcategory.setEnabled(false);
					txtprice.setEnabled(false);
					txtrefnum.setEnabled(false);
					txtdate.setEnabled(true);
				}
			}
		});
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.TOP);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("<html>Retrieve all RESRVATION DATES and the NAMES of customers and the ITEMS they ordered along with their QUANTITIES.</html>");
		rdbtnNewRadioButton_3.setBounds(22, 148, 260, 50);
		rdbtnNewRadioButton_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_3.isSelected() == true ) {
					txtcategory.setEnabled(false);
					txtprice.setEnabled(false);
					txtrefnum.setEnabled(false);
					txtdate.setEnabled(false);
				}
			}
		});
		rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.TOP);
		rdbtnNewRadioButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(rdbtnNewRadioButton_3);
		
		
		//=======================
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		bg.add(rdbtnNewRadioButton_3);

		//=======================
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(313, 11, 286, 205);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Retrieval information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Catagory");
		lblNewLabel.setBounds(22, 34, 96, 14);
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(22, 68, 85, 14);
		lblNewLabel_1.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Reference number");
		lblNewLabel_2.setBounds(22, 106, 96, 14);
		lblNewLabel_2.setFont(new Font("Georgia", Font.PLAIN, 10));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(22, 144, 47, 14);
		lblNewLabel_3.setFont(new Font("Georgia", Font.PLAIN, 11));
		panel_1.add(lblNewLabel_3);
		
		txtcategory = new JTextField();
		txtcategory.setBounds(130, 31, 130, 20);
		panel_1.add(txtcategory);
		txtcategory.setColumns(10);
		txtcategory.setEnabled(false);
		
		
		txtprice = new JTextField();
		txtprice.setBounds(130, 65, 130, 20);
		panel_1.add(txtprice);
		txtprice.setColumns(10);
		txtprice.setEnabled(false);
		
		txtrefnum = new JTextField();
		txtrefnum.setBounds(128, 103, 132, 20);
		panel_1.add(txtrefnum);
		txtrefnum.setColumns(10);
		txtrefnum.setEnabled(false);
		
		txtdate = new JTextField();
		txtdate.setBounds(130, 141, 130, 20);
		panel_1.add(txtdate);
		txtdate.setColumns(10);
		txtdate.setEnabled(false);
		
		JButton btnNewButton = new JButton("Retrieve");
		btnNewButton.setBounds(91, 171, 89, 23);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if ( rdbtnNewRadioButton.isSelected()== false && rdbtnNewRadioButton_1.isSelected()== false && rdbtnNewRadioButton_2.isSelected() == false && rdbtnNewRadioButton_3.isSelected() == false ) {
					JOptionPane.showMessageDialog(null, "Select retrieval type!");
					return;
				}
				
				
	if ( rdbtnNewRadioButton.isSelected() ) {
					
					String Category = txtcategory.getText();
					String Price = txtprice.getText();
					float Priceft = Float.parseFloat(Price);
					
					if (stat != null) {
						try {
							//===
							rs = stat.executeQuery("SELECT name FROM ITEM WHERE category = '" + Category + "'AND Price > " + Priceft); 
					       
					        DefaultTableModel model = new DefaultTableModel(new String[]{"Name"}, 0); // Define your column names
					        while (rs.next())
					            model.addRow(new Object[]{rs.getString("Name")});
					        
					        table.setModel(model);
							//===
      						} catch (Exception e1) {
							System.out.println(e1.getMessage());
							JOptionPane.showMessageDialog(null, "operation failed: " + e1.getMessage());
						}
					} else {
							JOptionPane.showMessageDialog(null, "Database connection not established.");
						}
			}	
				else if ( rdbtnNewRadioButton_1.isSelected() ) {
					
					String Ref_no = txtrefnum.getText();
					
					if (stat != null) {
						try {
							//================
							rs = stat.executeQuery("SELECT Table_num FROM RESERVATION WHERE Ref_no = '" + Ref_no + "';");
						       
					        DefaultTableModel model = new DefaultTableModel(new String[]{"Table Number"}, 0); // Define your column names
					        while (rs.next())
					            model.addRow(new Object[]{rs.getInt("Table_num")});
					        
					        table.setModel(model);
							//================
							
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
							JOptionPane.showMessageDialog(null, "operation failed: " + e1.getMessage());
						}
					} else {
							JOptionPane.showMessageDialog(null, "Database connection not established.");
						}
					
			}
				else if ( rdbtnNewRadioButton_2.isSelected() ) {
					
					String Date=txtdate.getText();
					
					if (stat != null) {
						try {

							//===================
							rs = stat.executeQuery("SELECT C_Fname, C_Lname, CUSTOMER.Cphone_num FROM CUSTOMER "
									+ "JOIN RESERVATION ON CUSTOMER.Cphone_num = RESERVATION.Cphone_num " + "WHERE RESERVATION.Date = '"
									+ Date + "';");
						       
					        DefaultTableModel model = new DefaultTableModel(new String[]{"Customer First Name","Customer Last Name","Phone Number"}, 0); // Define your column names
					        while (rs.next())
					            model.addRow(new Object[]{rs.getString("C_Fname"),rs.getString("C_Lname"),rs.getString("CUSTOMER.Cphone_num")});
					        
					        table.setModel(model);
							//===================
							
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
							JOptionPane.showMessageDialog(null, "operation failed: " + e1.getMessage());
						}
					} else {
							JOptionPane.showMessageDialog(null, "Database connection not established.");
						}
					
					
				}
				else if ( rdbtnNewRadioButton_3.isSelected() ) {
					
					if (stat != null) {
						try {

							//===================
							rs =  stat.executeQuery("SELECT RESERVATION.Ref_no, Date, C_Fname,C_Lname, Name, Quantity\n"
									+ "FROM RESERVATION, CUSTOMER, ITEM, ORDERED_BY\n"
									+ "WHERE CUSTOMER.Cphone_num = RESERVATION.Cphone_num AND RESERVATION.Ref_no = ORDERED_BY.Ref_no AND ORDERED_BY.Item_code = ITEM.Item_code;");
						       
					        DefaultTableModel model = new DefaultTableModel(new String[]{"Reference Number","Reservation Date","Customer First Name","Customer Last Name","Menu Item","Quantity"}, 0); // Define your column names
					        while (rs.next())
					            model.addRow(new Object[]{rs.getString("Ref_no"),rs.getString("Date"),rs.getString("C_Fname"),rs.getString("C_Lname"),rs.getString("Name"), rs.getInt("Quantity")});
					        
					        table.setModel(model);
							//===================
							
						} catch (Exception e1) {
							System.out.println(e1.getMessage());
							JOptionPane.showMessageDialog(null, "operation failed: " + e1.getMessage());
						}
					} else {
							JOptionPane.showMessageDialog(null, "Database connection not established.");
						}
					
				}
						
				
			}
		});
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 589, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
		
}
