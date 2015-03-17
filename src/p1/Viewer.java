package p1;

import javax.swing.*;

import java.awt.*;

/**
 * Viewer class to show all books in the library
 * @author Kristoffer Freiholtz
 * @version 1.0
 */
public class Viewer {
	private JTextArea textArea = new JTextArea();

	/**
	 * Constructor of the Viewer. Setup the windows where the library shall be displayed
	 * @param title the title for the window
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
	 * Adds a row to the text area
	 * Only used by the assignments test code. I'm not calling it in my code 
	 * I choose to use my own method update instead because when a new book is added it should clear and update the viewer
	 * But i saved this so the test can run 
	 * @param book the book to be added to the text area
	 */
	public void addRow(String book) {
		textArea.append(book + "\n");
	}

	/**
	 * Updates the viewer with the library changes. 
	 * Clears the text area and then adds the books of the library to the text area 
	 * @param library the library to be displayed in the viewer
	 */
	public void update(Library library) {
		clear();
		Book[] books = library.list();
		for (int i = 0; i < books.length; i++) {
			textArea.append(books[i].toString() + "\n");
		}
	}

	/**
	 * Clear the viewers text area.
	 */
	public void clear() {
		textArea.setText("");
	}

}
