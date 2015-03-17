package p1;

import javax.swing.*;

import java.awt.*;

/**
 * @author Stationary
 *
 */
public class Viewer {
	private JTextArea textArea = new JTextArea();

	/**
	 * @param title
	 */
	public Viewer(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea.setPreferredSize(new Dimension(500, 400));
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * @param book
	 */
	public void addRow(String book) {
		textArea.append(book + "\n");
	}

	/**
	 * @param library
	 */
	public void update(Library library) {
		clear();
		Book[] books = library.list();
		for (int i = 0; i < books.length; i++) {
			textArea.append(books[i].toString() + "\n");
		}
	}

	/**
	 * 
	 */
	public void clear() {
		textArea.setText("");
	}

}
