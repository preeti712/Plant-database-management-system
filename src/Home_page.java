import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Home_page extends JFrame implements ActionListener{
	
    JTable dataTable = new JTable();
	Connection connection;
    PreparedStatement preparedStatement;
    
	Home_page(){
		JFrame homeFrame = new JFrame("Home page");
		homeFrame.setSize(1370, 730);          
		homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeFrame.setLayout(null);
		homeFrame.setResizable(true);
		
		JPanel homePanel = new JPanel();
    	Image homeImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\OOP CP NEW\\oop cp images\\img2.jpeg");
    	homePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(homeImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        homePanel.setLayout(null);
        homePanel.setBounds(0, 0, 1370, 730);
        homeFrame.add(homePanel);
	    
		JButton poisonous = new JButton("Poisonous");
		poisonous.setBounds(350, 200, 200, 30);
		poisonous.setBackground(new Color(220, 249, 153));
		poisonous.addActionListener(this);
		homePanel.add(poisonous);
		
	    JButton medicinal=new JButton("Medicinal");  
	    medicinal.setBounds(350, 250, 200, 30);  	
	    medicinal.setBackground(new Color(194, 228, 112));
	    medicinal.addActionListener(this);
		homePanel.add(medicinal); 
				
		JButton spices=new JButton("Spices");  
		spices.setBounds(350, 300, 200, 30);
		spices.setBackground(new Color(134, 181, 64));
		spices.addActionListener(this);
		homePanel.add(spices);
				
		JButton indoor=new JButton("Indoor/Decorational");  
		indoor.setBounds(350, 350, 200, 30);
		indoor.setBackground(new Color(54, 109, 24));
		indoor.addActionListener(this);
		indoor.setForeground(Color.WHITE);
		homePanel.add(indoor);
				
		JButton edible=new JButton("Edible");  
		edible.setBounds(350, 400, 200, 30);
		edible.setBackground(new Color(31, 63, 13));
		edible.addActionListener(this);
		edible.setForeground(Color.WHITE);
		homePanel.add(edible);
		
		JButton aromatic=new JButton("Aromatic");
		aromatic.setBounds(750, 200, 200, 30);
		aromatic.setBackground(new Color(220, 249, 153));
		homePanel.add(aromatic);
			
		JButton commercial=new JButton("Commercial");
		commercial.setBounds(750, 250, 200, 30);
		commercial.setBackground(new Color(194, 228, 112)); 
		homePanel.add(commercial);
			
		JButton endangered=new JButton("Endangered");
		endangered.setBounds(750, 300, 200, 30);
		endangered.setBackground(new Color(134, 181, 64));	
		endangered.addActionListener(this);
		homePanel.add(endangered);
			
		JButton carnivores=new JButton("Carnivores");
		carnivores.setBounds(750, 350, 200, 30);
		carnivores.setBackground(new Color(54, 109, 24));
		carnivores.setForeground(Color.WHITE);
		homePanel.add(carnivores);
			
		JButton hybrid=new JButton("Hybrid/Experimented");  
		hybrid.setBounds(750, 400, 200, 30); 
		hybrid.setBackground(new Color(31, 63, 13));
		hybrid.setForeground(Color.WHITE);
		homePanel.add(hybrid);	  
			
		JButton back3 = new JButton("Back");
	    back3.setBounds(600, 500, 125, 30);
	    back3.setBackground(Color.WHITE);          
	    homePanel.add(back3);
	        back3.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	homeFrame.dispose();
	                System.out.println("Disposing Tables name frame...");
	            }
	        });
        
		homeFrame.setVisible(true);

        String url = "jdbc:mysql://localhost:3306/plants";
        String user = "root";
        String psw = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, psw);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to the database.");
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
        if (button.equals("Poisonous")) {
        	System.out.println("Creating Poisonous plants frame...");
        	new PoisonousPlants();
        } else if (button.equals("Medicinal")) {
        	System.out.println("Creating Medicinal plants frame...");
            displayMedicinalData();   
        } else if (button.equals("Spices")) {
        	System.out.println("Creating Spices plants frame...");
            displaySpicesData();    
        } else if (button.equals("Indoor/Decorational")) {
        	System.out.println("Creating Indoor/Decorational plants frame...");
            displayIndoorData();
        } else if (button.equals("Edible")) {
        	System.out.println("Creating Edible plants frame...");
            displayEdibleData();   
        } 
	}
    
    
    private void displayMedicinalData() {
        try {
            String selectSql = "SELECT * FROM medicinal";
            preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();


            DefaultTableModel model = new DefaultTableModel();
            dataTable.setModel(model);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }

            resultSet.close();
            preparedStatement.close();

            JFrame tableFrame = new JFrame("Display Data");
            tableFrame.add(new JScrollPane(dataTable));
            tableFrame.setSize(800, 400);
            tableFrame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data.");
        }
    }

    private void displaySpicesData() {
        try {
            String selectSql = "SELECT * FROM spices";
            preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();


            DefaultTableModel model = new DefaultTableModel();
            dataTable.setModel(model);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }

            resultSet.close();
            preparedStatement.close();

            JFrame tableFrame = new JFrame("Display Data");
            tableFrame.add(new JScrollPane(dataTable));
            tableFrame.setSize(800, 400);
            tableFrame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data.");
        }
    }


    private void displayIndoorData() {
        try {
            String selectSql = "SELECT * FROM indoor";
            preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();


            DefaultTableModel model = new DefaultTableModel();
            dataTable.setModel(model);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }

            resultSet.close();
            preparedStatement.close();

            JFrame tableFrame = new JFrame("Display Data");
            tableFrame.add(new JScrollPane(dataTable));
            tableFrame.setSize(800, 400);
            tableFrame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data.");
        }
    }
    
    
    private void displayEdibleData() {
        try {
            String selectSql = "SELECT * FROM Edible ";
            preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();


            DefaultTableModel model = new DefaultTableModel();
            dataTable.setModel(model);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }

            resultSet.close();
            preparedStatement.close();

            JFrame tableFrame = new JFrame("Display Data");
            tableFrame.add(new JScrollPane(dataTable));
            tableFrame.setSize(800, 400);
            tableFrame.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data.");
        }
    }
}