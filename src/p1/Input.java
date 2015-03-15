package p1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class Input extends JFrame{
	final String[] mLabels = {"Titel", "Författare", "ISBN"};
	
	public Input() {
		JPanel panel = new JPanel();
		for (int i = 0; i < mLabels.length; i++){
			JLabel label = new JLabel(mLabels[i], JLabel.HORIZONTAL);
			panel.add(label);
			JTextField textField = new JTextField(10);
			label.setLabelFor(textField);		
			panel.add(textField);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JLabel label = new JLabel("Testlabel", SwingConstants.CENTER);
		//label.setPreferredSize(new Dimension(300, 100));
		//getContentPane().add(label, BorderLayout.CENTER);
		panel.setOpaque(true);
		setContentPane(panel);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
}
