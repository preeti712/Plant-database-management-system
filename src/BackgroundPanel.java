import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	JFrame tablesDataFrame;
	Image backgroundImage;
    JPanel backgroundPanel;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JButton back1;
    BackgroundPanel(){
    	tablesDataFrame = new JFrame();
    	tablesDataFrame.setSize(1300, 720);
    	tablesDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	tablesDataFrame.setResizable(true);
    	
    	backgroundImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\OOP CP NEW\\oop cp images\\img5.jpeg");
    	backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 960, 720);
        
        l1 = new JLabel("First Label");        
        l1.setForeground(Color.WHITE);  
        l1.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\OOP CP NEW\\oop cp images\\img3.jpeg"));
        l1.setBorder(BorderFactory.createLineBorder(new Color(179, 172, 145)));
        l1.setFont(new Font("Verdana", Font.ITALIC, 18));
        l1.setBounds(50, 150, 430, 285);
        backgroundPanel.add(l1);
        
        l2 = new JLabel("Datura stramonium");        
        l2.setForeground(Color.WHITE);
        //l2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        l2.setFont(new Font("Castellar", Font.PLAIN, 48));
        l2.setBounds(350, 30, 800, 50);
        backgroundPanel.add(l2);
        
        
        l3 = new JLabel("<html><p><b>  &ensp; Hindi Name: </b>Dhatura<br> &ensp;  <b>English Name: </b>Jimsonweed, Thorn  Apple, <br>&ensp; Devil's Snare<br>  &ensp; <b>Scientific Name:</b><i> Datura stramonium</i></p></html>");        
        l3.setForeground(new Color(164, 149, 181));
        l3.setBorder(BorderFactory.createLineBorder(new Color(93, 106, 135 )));
        l3.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 30));
        l3.setBounds(550, 145, 680, 200);
        backgroundPanel.add(l3);
        
        
        l4 = new JLabel("<html><p ><i>Datura stramonium</i>, known by the common names thorn apple, <br>jimsonweed (jimson weed), devil's snare, or devil's trumpet,is a <br>poisonous flowering plant of the nightshade family Solanaceae.</p></html>");        
        l4.setForeground(new Color(136, 164, 143));
        //l2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        l4.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 22));
        l4.setBounds(550, 350, 800, 100);
        backgroundPanel.add(l4);
        
        l5 = new JLabel("<html><p style=\"line-height:3.5em;\"><b> Life Span:</b> Annual</p><p><b>Weather:</b> Warm Climate, Summer</p><p><b>Medicinal Use</b>:For treatement of stomach and intestinal pain that results from worm infestation, toothache, and fever from inflamation</p><p><b>Favourable Location:</b> Open areas, disturbed soils</p><p><b>Flowering: </b>Yes</p><p><b>Fruit Position: </b>Spiny capsules contain seeds</p></html>");        
        l5.setForeground(new Color(136, 164, 143));
        //l2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        l5.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 22));
        l5.setBounds(50, 400, 1200, 300);
        backgroundPanel.add(l5);
        
        back1 = new JButton("Back");
        back1.setBounds(575, 650, 125, 30);
        back1.setBackground(new Color(10, 10, 10));        
        backgroundPanel.add(back1);
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tablesDataFrame.dispose();
                System.out.println("Disposing Tables name frame...");
            }
        });

     
        tablesDataFrame.add(backgroundPanel);          
        tablesDataFrame.setVisible(true);
    }
}
