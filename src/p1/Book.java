package p1;

/**
 * Book class to create and store a book
 * @author Kristoffer Freiholtz
 * @version 1.0
 */
public class Book {

	private String mTitle;
	private String mAuthor;
	private String mIsbn;

	/**
	 * Constructor that sets the title, author and ISBN to a Book object
	 * @param title the title of the book
	 * @param author the author of the book
	 * @param isbn the ISBN of the book
	 */
	public Book(String title, String author, String isbn) {
		mTitle = title;
		mAuthor = author;
		mIsbn = isbn;
	}

	/**
	 * Returns the title of the book
	 * @return the title of the book
	 */
	public String getTitle() {
		return mTitle;
	}

	/**
	 * Returns the author of the book
	 * @return the author of the book
	 */
	public String getAuthor() {
		return mAuthor;
	}

	/**
	 * Returns the ISBN of the book
	 * @return the ISBN of the book
	 */
	public String getIsbn() {
		return mIsbn;
	}

	/**
	 * Returns the complete info of the book in String form
	 * @return String the string with the complete info
	 */
	public String toString() {
		return mTitle + ", " + mAuthor + ", ISBN: " + mIsbn;
	}

	/**
	 * Compare a book to another book using the ISBN number.
	 * @param book the book to be compared to the current book
	 * @return 1 if the current book is supposed to be sorted first and -1 otherwise.
	 */
	public int compareTo(Book book) {
		if (mIsbn.compareTo(book.getIsbn()) > 0) {
			return 1;
		}
		return -1;
	}

}
