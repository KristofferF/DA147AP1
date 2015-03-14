package p1;
import javax.swing.*;
import java.awt.*;

public class Viewer {
	private JTextArea textArea = new JTextArea();
	
	public Viewer(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea.setPreferredSize(new Dimension(500, 400));
		JScrollPane scroll = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addRow(String book){
		textArea.append(book + "\n");		
	}
	
	public void clear(){
		textArea.setText("");
	}
	
}
