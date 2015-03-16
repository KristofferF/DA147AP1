package p1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Input extends JFrame{
	final String[] mLabels = {"Titel", "Författare", "ISBN"};
	
	public Input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,200));
		JPanel westPanel = new JPanel(new GridLayout(mLabels.length,1));
		JPanel eastPanel = new JPanel(new GridLayout(mLabels.length,1));
		JPanel southPanel = new JPanel(new BorderLayout());
		JButton addButton = new JButton("Lägg Till Bok");
		southPanel.add(addButton);
		for (int i = 0; i < mLabels.length; i++){
			JLabel label = new JLabel(mLabels[i]);
			westPanel.add(label);
			JTextField textField = new JTextField();
			//label.setLabelFor(textField);		
			eastPanel.add(textField, BorderLayout.WEST);	
		}
		eastPanel.setOpaque(true);		
		setLayout(new BorderLayout());
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		 

		
		//JLabel label = new JLabel("Testlabel", SwingConstants.CENTER);
		//label.setPreferredSize(new Dimension(300, 100));
		//getContentPane().add(label, BorderLayout.CENTER);
		//panel.setOpaque(true);
		//add(panel);
		//add(panel2, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
}
