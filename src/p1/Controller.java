package p1;

import javax.swing.JOptionPane;

/**
 * Controller class to direct the inputs from the input window to the library and viewer
 * @author Kristoffer Freiholtz
 * @version 1.0
 */
public class Controller {
	private Library mLibrary;
	private Viewer mViewer;

	/**
	 * Constructor of the Controller that sets the library and viewer
	 * @param library the library to be controlled
	 * @param viewer the viewer to be controlled
	 */
	public Controller(Library library, Viewer viewer) {
		mLibrary = library;
		mViewer = viewer;
		mViewer.update(library);
	}

	/**
	 * Adds a new book from the given inputs to the library
	 * If the library is full ask if the user wants to expand it
	 * @param title the title of the book to be added
	 * @param author the author of the book to be added
	 * @param isbn the isbn of the book to be added
	 */
	public void newBook(String title, String author, String isbn) {
		if (mLibrary.isFull()) {
			if(expandLibrary()){
				mLibrary.add(new Book(title, author, isbn));
				mViewer.update(mLibrary);
			}		
		} else {
			mLibrary.add(new Book(title, author, isbn));
			mViewer.update(mLibrary);
		}
	}
	

	/**
	 * Handles the dialog for asking the user if the library should be expanded when its full
	 * @return true if the user wants to expand it otherwise false
	 */
	private boolean expandLibrary() {
		int selectedOption =
				JOptionPane.showConfirmDialog(null, "Biblioteket är fullt. Vill du utöka kapaciteten?", "Välj",
						JOptionPane.YES_NO_OPTION);
		if (selectedOption == JOptionPane.YES_OPTION) {
			mLibrary.doubleSize();
			return true;
		}
		return false;
		
	}

	/**
	 * Handles the dialog for asking the user if the library should be emptied
	 */
	public void emptyLibrary() {
		if (mLibrary.getSize() == 0) {
			javax.swing.JOptionPane.showMessageDialog(null, "Biblioteket är redan tomt.");
		} else {
			int selectedOption =
					JOptionPane.showConfirmDialog(null, "Vill du verkligen ta bort hela biblioteket?\nDu kan inte ångra dig.", "Välj",
							JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				mLibrary.emptyLibrary();
				mViewer.update(mLibrary);
			}
		}
	}
}
