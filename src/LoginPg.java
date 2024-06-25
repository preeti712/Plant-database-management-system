import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPg extends JFrame implements ActionListener{
	
	JFrame loginFrame;
    JLabel label1, label2, loginlabel;
    JButton loginBtn;
    JButton back;
    JTextField User;
    JPasswordField Password;
    JPanel centralPanel;

    LoginPg() {
    	loginFrame = new JFrame("Login");
    	loginFrame.setTitle("Login Page");
    	loginFrame.setSize(600, 400);          
    	loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	loginFrame.setResizable(true);
    	
        centralPanel = new JPanel();
        centralPanel.setLayout(null); 
        centralPanel.setBackground(new Color(182, 239, 255));
        centralPanel.setBounds(0, 0, 600, 500);
        loginFrame.add(centralPanel);
        
        loginlabel = new JLabel("Login");
        loginlabel.setFont(new Font("Consolas", Font.BOLD, 30));
        loginlabel.setBounds(200, 30, 150, 30);
        centralPanel.add(loginlabel);
        
        label1 = new JLabel("Username:");
        label2 = new JLabel("Password:");
        label1.setBounds(100, 100, 200, 30);
        label1.setFont(new Font("Consolas", Font.BOLD, 23));
        label2.setBounds(100, 160, 200, 30);
        label2.setFont(new Font("Consolas", Font.BOLD, 23));
        centralPanel.add(label1);
        centralPanel.add(label2);
        
        User = new JTextField();
        User.setBounds(250, 100, 150, 30);
        centralPanel.add(User);
        
        Password = new JPasswordField();
        Password.setBounds(250, 160, 150, 30);
        centralPanel.add(Password);
        
        loginBtn = new JButton("Login now");
        loginBtn.setBounds(200, 220, 100, 40);
        loginBtn.setBackground(new Color(59, 238, 216));
        loginBtn.addActionListener((ActionListener) this);
        centralPanel.add(loginBtn);
        
        back = new JButton("Back");
        back.setBounds(200, 270, 100, 40);
        back.setBackground(Color.white);        
        centralPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose();
                System.out.println("Disposing Login frame frame...");
            }
        });

        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String button1 = e.getActionCommand();
        if (button1.equals("Login now")) {
            String username = User.getText();
            String password = new String(Password.getPassword());

            if (validateUser(username, password)) {
                JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                new Home_page();
                loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid username or password. Please try again.");
            }
	}
}
	
	private boolean validateUser(String username, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LogInDetails", "root", "root");

           // String sql = "SELECT * FROM Details WHERE Email = ? AND Password = ?";
            String sql = "SELECT * FROM Details WHERE Name = ? AND Password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            boolean userExists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return userExists;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(loginFrame, "Error: " + e.getMessage());
            return false;
        }
    }
}
