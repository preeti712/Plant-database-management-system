
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plants extends JFrame implements ActionListener {
    Image img; 
    JFrame frame; 
    JLabel logoLabel; 
    JPanel headerPanel;
    JPanel imagePanel; 
    JButton signUpButton;
    JButton loginButton;
    JLabel titleLabel;
    JButton aboutButton;
    JButton feedbackButton;

    public Plants() {
        frame = new JFrame("Plant Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.setResizable(true);
        
        headerPanel = new JPanel();
        headerPanel.setBounds(10, 10, 1180, 100);
        headerPanel.setBackground(Color.DARK_GRAY);
        headerPanel.setLayout(null);
        frame.add(headerPanel);

        logoLabel = new JLabel("Plant Database");
        logoLabel.setForeground(Color.WHITE);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setBounds(100, 35, 200, 30);
        headerPanel.add(logoLabel);

        aboutButton = new JButton("About Us");
        aboutButton.setBounds(800, 35, 125, 30);
        aboutButton.setBackground(Color.WHITE);  
        headerPanel.add(aboutButton);
        aboutButton.addActionListener(this);

        feedbackButton = new JButton("Feedback");
        feedbackButton.setBounds(1000, 35, 125, 30);
        feedbackButton.setBackground(Color.WHITE);  
        headerPanel.add(feedbackButton);
        feedbackButton.addActionListener(this);

        img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\OOP CP NEW\\oop cp images\\img2.jpeg");
        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setBounds(0, 110, 1200, 670);
        imagePanel.setLayout(null);
        frame.add(imagePanel);

        titleLabel = new JLabel("Find the perfect plants for your home");
        titleLabel.setBounds(300, 200, 700, 100);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 34));
        titleLabel.setForeground(Color.BLACK);
        imagePanel.add(titleLabel);

        loginButton = new JButton("Login");
        loginButton.setBounds(600, 350, 150, 30);
        loginButton.setBackground(Color.WHITE);  
        imagePanel.add(loginButton);
        loginButton.addActionListener(this);

        signUpButton = new JButton("Sign up");
        signUpButton.setBounds(400, 350, 150, 30);
        signUpButton.setBackground(Color.WHITE);  
        imagePanel.add(signUpButton);
        signUpButton.addActionListener(this);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.equals("About Us")) {
            new About();
            System.out.println("Creating About Us frame...");
        } else if (button.equals("Feedback")) {
            System.out.println("Creating Feedback frame...");
            new Feedback();
        } else if (button.equals("Login")) {
            System.out.println("Creating Login frame...");
            new LoginPg();
        } else if (button.equals("Sign up")) {
            System.out.println("Creating Sign up frame...");
            new SignupPg();
        }
    }

    public static void main(String[] args) {
        new Plants();
    }
}

