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
import javax.swing.JSlider;

public class Feedback extends JFrame {
    JFrame feedback;
    Image bgImg;
    JPanel bgImgPanel;
    JLabel sliderLabel;
    JSlider slider;
    JLabel label;

    public Feedback() {
        feedback = new JFrame();
        feedback.setSize(1200, 1000);
        feedback.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        feedback.setResizable(true);
        
        bgImg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\OOP CP NEW\\oop cp images\\img4.jpeg");
        bgImgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        bgImgPanel.setBounds(0, 0, 1200, 1000);
        bgImgPanel.setLayout(null);
        feedback.add(bgImgPanel);

        sliderLabel = new JLabel("1");
        sliderLabel.setFont(new Font("Arial", Font.BOLD, 24));
        sliderLabel.setBounds(425, 250, 400, 20);
        bgImgPanel.add(sliderLabel);
        
		JLabel w=new JLabel("2");  
		w.setFont(new Font("Arial", Font.BOLD, 24));
		w.setBounds(512,250,400,20);  		          
		bgImgPanel.add(w); 
		
		JLabel x=new JLabel("3");  
		x.setFont(new Font("Arial", Font.BOLD, 24));
		x.setBounds(600,250,400,20);  		          
		bgImgPanel.add(x); 
		
		JLabel y=new JLabel("4");  
		y.setFont(new Font("Arial", Font.BOLD, 24));
		y.setBounds(678,250,400,20);  		          
		bgImgPanel.add(y); 
		
		JLabel z=new JLabel("5");  
		z.setFont(new Font("Arial", Font.BOLD, 24));
		z.setBounds(765,250,400,20);  		          
		bgImgPanel.add(z); 

        slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 120);
        slider.setBounds(400, 300, 400, 20);
        bgImgPanel.add(slider);

        label = new JLabel("Feedback");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(550, 100, 300, 30);
        bgImgPanel.add(label);

        JButton backButton = new JButton("Back");
        backButton.setBounds(525, 400, 150, 30);
        backButton.setBackground(Color.WHITE);
        bgImgPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedback.dispose();
                System.out.println("Disposing Feedback frame...");
            }
        });

        feedback.setLayout(null);
        feedback.setVisible(true);
    }
}
