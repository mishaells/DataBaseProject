import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frame9MangerRetrievals extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static Connection con = null;
	static Statement stat = null;
	static ResultSet rs;
	private JTextField inputField;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame9MangerRetrievals frame = new frame9MangerRetrievals();
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
	public frame9MangerRetrievals() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blancadatabase", "root", "12345Abcde.");
			stat = con.createStatement();
			//System.out.println("Database connected successfully.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(137, 54, 627, 22);
		contentPane.add(comboBox);
		
		comboBox.addItem("Employee's first and last name by ID number");
		comboBox.addItem("Employees names working in a specific branch, along with the branch's district and city");
		comboBox.addItem("Total number of branches");
		comboBox.addItem("All customers and reservations details assigned to a specific server (waiter)");

		
        String selectedItem = (String) comboBox.getSelectedItem();
        
        
        


		
		JLabel lblNewLabel = new JLabel("Choose a retrieve option");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(303, 11, 259, 32);
		contentPane.add(lblNewLabel);
		
		inputField = new JTextField();
		inputField.setBounds(267, 128, 295, 20);
		contentPane.add(inputField);
		inputField.setColumns(10);
        inputField.setVisible(false);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(262, 103, 219, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JButton retrieveButton = new JButton("Retrieve");
		retrieveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        retrieveButton.setVisible(false);

       
        retrieveButton.setBounds(614, 127, 89, 23);
		contentPane.add(retrieveButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 230, 832, 287);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel();
	    table.setModel(tableModel);
	    
		scrollPane.setViewportView(table);
	
		
		comboBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedItem = (String) comboBox.getSelectedItem();

		        // Reset input field, labels, and table
		        inputField.setVisible(false);
		        lblNewLabel_1.setVisible(false);
		        retrieveButton.setVisible(false);
		        tableModel.setRowCount(0); // Clear previous table data

		        // Adjust UI based on selected option
		        if (selectedItem.equals("Employee's first and last name by ID number")) {
		            lblNewLabel_1.setText("Enter Employee ID:");
		            lblNewLabel_1.setVisible(true);
		            inputField.setVisible(true);
		            retrieveButton.setVisible(true);
		            tableModel.setColumnIdentifiers(new String[]{"First Name", "Last Name"});
		        } else if (selectedItem.equals("Employees names working in a specific branch, along with the branch's district and city")) {
		            lblNewLabel_1.setText("Enter Branch Code:");
		            lblNewLabel_1.setVisible(true);
		            inputField.setVisible(true);
		            retrieveButton.setVisible(true);
		            tableModel.setColumnIdentifiers(new String[]{"First Name", "Last Name", "District", "City"});
		        } else if (selectedItem.equals("Total number of branches")) {
		            lblNewLabel_1.setVisible(false);
		            inputField.setVisible(false);
		            retrieveButton.setVisible(true);
		            tableModel.setColumnIdentifiers(new String[]{"Total Branches"});
		        } else if (selectedItem.equals("All customers and reservations details assigned to a specific server (waiter)")) {
		            lblNewLabel_1.setText("Enter Server ID:");
		            lblNewLabel_1.setVisible(true);
		            inputField.setVisible(true);
		            retrieveButton.setVisible(true);
		            tableModel.setColumnIdentifiers(new String[]{"Reference Number", "Reservation Date", "Customer Name", "Server Name"});
		        }
		    }
		});

		retrieveButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedItem = (String) comboBox.getSelectedItem();
		        String input = inputField.getText().trim();
		        
		        //System.out.println("Selected Item: " + selectedItem);
		        //System.out.println("Input Field Value: '" + input + "'"); // just checking if input is empty or has spaces


		        try {
		            String query = "";

		            // Define queries based on the selected dropdown case
		            if (selectedItem.equals("Employee's first and last name by ID number") && !input.isEmpty()) {
		                query = "SELECT E_Fname, E_Lname FROM employee WHERE ID = '" + input + "'";
		            } else if (selectedItem.equals("Employees names working in a specific branch, along with the branch's district and city") && !input.isEmpty()) {
		                query = "SELECT e.E_Fname, e.E_Lname, b.District, b.City " +
		                        "FROM employee e JOIN branch b ON e.Bcode = b.Bcode " +
		                        "WHERE b.Bcode = '" + input + "'";
		            } else if (selectedItem.equals("Total number of branches")) {
		                query = "SELECT COUNT(*) AS TotalBranches FROM branch";
		            }  else if (selectedItem.equals("All customers and reservations details assigned to a specific server (waiter)") && !input.isEmpty()) {
		                query = "SELECT RESERVATION.Ref_no, RESERVATION.Date, " +
		                        "CUSTOMER.C_Fname, CUSTOMER.C_Lname, " +
		                        "EMPLOYEE.E_Fname, EMPLOYEE.E_Lname " +
		                        "FROM RESERVATION " +
		                        "JOIN CUSTOMER ON RESERVATION.Cphone_num = CUSTOMER.Cphone_num " +
		                        "JOIN EMPLOYEE ON RESERVATION.Servers_ID = EMPLOYEE.ID " +
		                        "WHERE RESERVATION.Servers_ID = '" + input + "'";
		            }

		            // Debugging output to verify the constructed query
		            //System.out.println("Constructed Query: " + query);

		            // Execute query and update the table
		            if (!query.isEmpty()) {
		                rs = stat.executeQuery(query);
		                tableModel.setRowCount(0);

		                while (rs.next()) {
		                    if (selectedItem.equals("All customers and reservations details assigned to a specific server (waiter)")) {
		                        String refNo = rs.getString("Ref_no");
		                        String date = rs.getString("Date");
		                        String customerName = rs.getString("C_Fname") + " " + rs.getString("C_Lname");
		                        String serverName = rs.getString("E_Fname") + " " + rs.getString("E_Lname");
		                        tableModel.addRow(new Object[]{refNo, date, customerName, serverName});
		                    } else {
		                        int columnCount = rs.getMetaData().getColumnCount();
		                        Object[] row = new Object[columnCount];
		                        for (int i = 1; i <= columnCount; i++) {
		                            row[i - 1] = rs.getObject(i);
		                        }
		                        tableModel.addRow(row);
		                    }
		                }
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Invalid input or query selection.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "Error: " + ex.getMessage());
		        }
		    }
		});


		
	}
}
