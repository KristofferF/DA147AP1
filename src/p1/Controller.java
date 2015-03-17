package p1;

import javax.swing.JOptionPane;

/**
 * @author Stationary
 *
 */
public class Controller {
	private Library mLibrary;
	private Viewer mViewer;

	/**
	 * @param library
	 * @param viewer
	 */
	public Controller(Library library, Viewer viewer) {
		mLibrary = library;
		mViewer = viewer;
		mViewer.update(library);
	}

	/**
	 * @param title
	 * @param author
	 * @param isbn
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
//		mLibrary.add(new Book(title, author, isbn));
//		mViewer.update(mLibrary);

	}

	private boolean expandLibrary() {
		int selectedOption =
				JOptionPane.showConfirmDialog(null, "Biblioteket är fullt. Vill du utöka kapaciteten?", "Välj",
						JOptionPane.YES_NO_OPTION);
		if (selectedOption == JOptionPane.YES_OPTION) {
			mLibrary.doubleSize();
			mViewer.update(mLibrary);
			return true;
		}
		return false;
		
	}

	/**
	 * 
	 */
	public void emptyLibrary() {
		if (mLibrary.size() == 0) {
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
