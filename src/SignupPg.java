import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupPg extends JFrame {
    JTextField nameField, emailField, phoneField;
    JPasswordField passwordField;
    JButton signupButton;
    JFrame signupFrame;

    public SignupPg() {
        signupFrame = new JFrame("Signup Page");
        signupFrame.setSize(600, 400);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signupFrame.setResizable(true);
        
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        signupFrame.add(panel);

        JLabel titleLabel = new JLabel("Sign up Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 23));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Consolas", Font.BOLD, 23));

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Consolas", Font.BOLD, 23));

        JLabel passwordLabel = new JLabel("Create Password:");
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, 23));

        nameField = new JTextField(25);
        emailField = new JTextField(25);
        phoneField = new JTextField(25);
        passwordField = new JPasswordField(25);

        signupButton = new JButton("Signup");
        signupButton.setSize(new Dimension(80, 40));
        signupButton.setForeground(Color.WHITE);  
        signupButton.setBackground(Color.blue);
       // signupButton.setForeground(Color.white);

        panel.add(titleLabel);
        panel.add(new JLabel());

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(phoneLabel);
        panel.add(phoneField);

        panel.add(passwordLabel);
        panel.add(passwordField);


        panel.add(new JLabel());
        panel.add(signupButton);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                String password = new String(passwordField.getPassword());
               
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LogInDetails", "root", "root");

                    String sql = "INSERT INTO Details(Name,Email,Phone,Password) VALUES (?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3,phone);
                    ps.setString(4,password);

                    
                    int i = ps.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(signupFrame, "Signed Up Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(signupFrame, "Failed to Sign Up!");
                    }

                    
                    ps.close();
                    con.close();
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(signupFrame, "Error: " + e1.getMessage());
                }
                              
               JOptionPane.showMessageDialog(SignupPg.this, "Signup successful!");
                    new LoginPg();
                    signupFrame.dispose();
                
            }
        });

        signupFrame.setLayout(new BorderLayout());
        signupFrame.add(panel, BorderLayout.CENTER);
        signupFrame.setVisible(true);
    }
}