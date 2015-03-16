package p1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Input extends JFrame{
	private final String[] mLabels = {"Titel", "F�rfattare", "ISBN"};
	private JTextField[] mTextFields = new JTextField[mLabels.length];
	public Input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500,150));
		JPanel westPanel = new JPanel(new GridLayout(mLabels.length,1));
		JPanel eastPanel = new JPanel(new GridLayout(mLabels.length,1));
		JPanel southPanel = new JPanel(new BorderLayout());
		JButton addButton = new JButton("L�gg Till Bok");
		
		southPanel.add(addButton);
		for (int i = 0; i < mLabels.length; i++){
			JLabel label = new JLabel(mLabels[i]);
			westPanel.add(label);
			JTextField textField = new JTextField();
			mTextFields[i] = textField;
			label.setLabelFor(textField);		
			eastPanel.add(textField, BorderLayout.WEST);	
		}
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "";
				
				for (int i = 0; i < mLabels.length; i++){
					text += mTextFields[i].getText() + "\n";
				}
				System.out.println(text);
			}
		});
		eastPanel.setOpaque(true);		
		setLayout(new BorderLayout());
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
}
