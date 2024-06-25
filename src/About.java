import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JFrame {
    JFrame aboutUS;
    JPanel contentPanel;
    Image backgroundImg;
    JLabel groupInfo;
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JLabel label_5;

    public About() {
        aboutUS = new JFrame();
        aboutUS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aboutUS.setSize(1200, 1000);
        aboutUS.setTitle("About Us");
        aboutUS.setResizable(true);
        
        backgroundImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\OOP CP NEW\\oop cp images\\img1.jpeg");
        contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPanel.setBounds(0, 0, 1200, 1000);
        contentPanel.setLayout(null);
        aboutUS.add(contentPanel);

        groupInfo = new JLabel("IT-A Batch 2, Group 5");
        groupInfo.setFont(new Font("Arial", Font.BOLD, 24));
        groupInfo.setBounds(480, 100, 300, 30);
        contentPanel.add(groupInfo);

        label_1 = new JLabel("36) Gayatri Dere");
        label_1.setBounds(530, 150, 200, 30);
        contentPanel.add(label_1);

        label_2 = new JLabel("37) Preeti Desai");
        label_2.setBounds(530, 200, 200, 30);
        contentPanel.add(label_2);

        label_3 = new JLabel("48) Ayush Dongardive");
        label_3.setBounds(530, 250, 200, 30);
        contentPanel.add(label_3);

        label_4 = new JLabel("49) Snehal Elkiwar");
        label_4.setBounds(530, 300, 200, 30);
        contentPanel.add(label_4);

        label_5 = new JLabel("50) Prasanna Fuse");
        label_5.setBounds(530, 350, 200, 30);
        contentPanel.add(label_5);

        JButton backButton = new JButton("Back");
        backButton.setBounds(510, 400, 150, 30);
        backButton.setBackground(Color.WHITE);  
        contentPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aboutUS.dispose();
                System.out.println("Disposing About Us frame...");
            }
        });

        aboutUS.setLayout(null);
        aboutUS.setVisible(true);
    }
}
