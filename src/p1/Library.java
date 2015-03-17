package p1;

/**
 * Library class to hold objects of type Book
 * @author Kristoffer Freiholtz
 * @version 1.0
 */
public class Library {
	private Book[] mBooks;
	private int mSize = 0;
	private int mCapacity;
	private boolean mFull = false;

	/**
	 * Constructor for the library. Sets up the new array to store books in.
	 * @param capacity The number of Books that can be stored.
	 */
	public Library(int capacity) {
		mBooks = new Book[capacity];
		mCapacity = capacity;
	}

	/**
	 * Add books to the library array. Increment mSize up to the value of
	 * mCapacity-1. When adding the last book the library becomes full and the
	 * boolean value of mFull changes.
	 * 
	 * @param book The Book to be added to the library
	 */
	public void add(Book book) {
		if (mSize < (mCapacity - 1)) {
			mBooks[mSize] = book;
			mSize++;
			sortLibrary();
		} else if (!mFull) {
			mBooks[mSize] = book;
			mFull = true;
			sortLibrary();
		}
	}

	/**
	 * Sorts the library according to the ISBN number, It uses the Book member function compareTo.
	 */
	private void sortLibrary() {
		for (int i = 0; i < getSize(); i++) {
			for (int j = i + 1; j < getSize(); j++) {
				if (mBooks[i].compareTo(mBooks[j]) == 1) {
					Book temp = mBooks[i];
					mBooks[i] = mBooks[j];
					mBooks[j] = temp;
				}
			}
		}
	}

	/**
	 * Returns the current stored books in an appropriate sized array.
	 * @return The array of currently stored books
	 */
	public Book[] list() {
		Book[] books;
		books = new Book[getSize()];
		System.arraycopy(mBooks, 0, books, 0, getSize());
		return books;
	}

	/**
	 * Returns the size of the library array. The size of the array is mSize
	 * unless the library is full then its mSize+1.
	 * @return the size of the library array
	 */
	public int getSize() {
		if (mFull) {
			return mSize + 1;
		}
		return mSize;
	}

	/**
	 * Returns the number of books in the library in a string.
	 * @return the string with the number of books.
	 */
	public String toString() {
		if (mSize == 0) {
			return "Biblioteket är tomt";
		}
		return "Bibliotek med " + getSize() + " böcker";
	}

	/**
	 * Empties the library and resets it.
	 */
	public void emptyLibrary() {
		mBooks = new Book[mCapacity];
		mSize = 0;
		mFull = false;
	}

	/**
	 * Check if the library is full
	 * @return the boolean variable mFull (true if full)
	 */
	public boolean isFull() {
		return mFull;
	}

	/**
	 * Doubles the size of the library
	 */
	public void doubleSize() {
		Book[] temp = new Book[mCapacity * 2];
		System.arraycopy(mBooks, 0, temp, 0, getSize());
		mBooks = temp;
		mCapacity *= 2;
		mSize++;
		mFull = false;
	}
}
