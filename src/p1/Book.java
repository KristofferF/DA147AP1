package p1;

/**
 * @author Stationary
 *
 */
public class Book {

	private String mTitle;
	private String mAuthor;
	private String mIsbn;

	/**
	 * @param title
	 * @param author
	 * @param isbn
	 */
	public Book(String title, String author, String isbn) {
		mTitle = title;
		mAuthor = author;
		mIsbn = isbn;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return mTitle;
	}

	/**
	 * @return
	 */
	public String getAuthor() {
		return mAuthor;
	}

	/**
	 * @return
	 */
	public String getIsbn() {
		return mIsbn;
	}

	/**
	 * @return String
	 */
	public String toString() {
		return mTitle + ", " + mAuthor + ", ISBN: " + mIsbn;
	}

	/**
	 * @param book
	 * @return
	 */
	public int compareTo(Book book) {
		if (mIsbn.compareTo(book.getIsbn()) > 0) {
			return 1;
		}
		return -1;
	}

}
