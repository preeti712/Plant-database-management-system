import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PoisonousPlants extends JFrame implements ActionListener{
	JFrame poisonousPlantsFrame;
	JPanel poisonousPanel;
	JButton clickHere1;
	JButton clickHere2;
	
	PoisonousPlants(){
		
		poisonousPlantsFrame = new JFrame();
		poisonousPlantsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		poisonousPlantsFrame.setSize(1000, 1000);
        poisonousPlantsFrame.setResizable(true);
        
        poisonousPanel = new JPanel();
        poisonousPanel.setBounds(0, 0, 1000, 800);
        poisonousPanel.setBackground(Color.WHITE);
        poisonousPlantsFrame.add(poisonousPanel);
        
		String htmlContent = "<html><body>" +
                "<center>" + 
                "<h1> Poisonous Plant Database</h1>" +
                "<table border='1' width='80%'>" +
                "<tr><th>ID</th><th>Name</th><th>Medicinal-use</th><th>For more information</th></tr>" +
                "<tr><td>1</td><td>Datura</td><td>treatment of stomach and intestinal pain that results from worm infestation, toothache, and fever from inflammation</td></tr>" +
                "<tr><td>2</td><td>Calotropic</td><td>People use calotropis for conditions such as digextive disorders,toothache,cramps,joint pain </td></tr>"+
                "<tr><td>3</td><td>Nerium Oleander</td><td>used for heart conditions, asthma, epilepsy, cancer, painful menstrual periods, leprosy, malaria, ringworm, indigestion, and venereal disease  </td></tr>"+
                "<tr><td>4</td><td>Plumeria</td><td>used in wounds and skin disease, diuretic, purgative</td></tr>"+
                "<tr><td>5</td><td>Crab's eye</td><td>Used for body inflammation and wounds</td></tr>"+
                "<tr><td>6</td><td> Cascabela thevatia</td><td>treatment of amenorrhea,malaria</td></tr>"+
                "<tr><td>7</td><td>Dieffenbachia</td><td>used against snakebites</td></tr>"+
                "<tr><td>8</td><td>Cerbera odollam     </td><td>used as an insecticide, pesticide, or antifungal agent.</td></tr>"+
                "<tr><td>9</td><td>Aconitum </td><td>used in fever,asthama</td></tr>"+
                "<tr><td>10</td><td>Nerium indicum</td><td>used in cardiac diseases,snake bites</td></tr>"+
                "<tr><td>11</td><td>Giant Stinging Tree </td><td>none</td></tr>"+
                "<tr><td>12</td><td>Jatropha</td><td>to treat bacterial and fungal infections</td></tr>"+
                "<tr><td>13</td><td>Sea mango</td><td>used in cardiac problem</td></tr>"+
                "</table>" +
                "</center>" +
                "</body></html>";

        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setText(htmlContent);
        editorPane.setEditable(false);
        
        clickHere1 = new JButton("Click here1");
        clickHere1.setBounds(861, 110, 125, 30);
        clickHere1.setBackground(Color.WHITE);
        editorPane.add(clickHere1);
        clickHere1.addActionListener((ActionListener) this);
        
        clickHere2 = new JButton("Click here2");
        clickHere2.setBounds(861, 155, 125, 30);
        clickHere2.setBackground(Color.WHITE);
        editorPane.add(clickHere2);
        //clickHere2.addActionListener(this);
        
        JScrollPane scrollPane = new JScrollPane(editorPane);
        poisonousPanel.add(scrollPane, BorderLayout.CENTER);
	
        JButton back2 = new JButton("Back");
        back2.setBounds(200, 1000, 125, 30);
        back2.setBackground(Color.WHITE);        
        poisonousPanel.add(back2);
        back2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	poisonousPlantsFrame.dispose();
            System.out.println("Disposing Tables name frame...");
        }
        });
        
        poisonousPlantsFrame.setLayout(null);
        poisonousPlantsFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
        if (button.equals("Click here1")) {
        	System.out.println("Creating Dhatura frame...");
        	new BackgroundPanel();
        }else if (button.equals("Click here2")) {
            System.out.println("Creating frame...");
        }
	}
}
