package p1;

public class Library {
	private Book[] mBooks;
	private int mSize = 0;
	private int mCapacity;
	private boolean mFull = false;

	/**
	 * Constructor for the library. Sets up the new array to store books in.
	 * mCapacity is set to capacity-1 to make the remaining functions more readable.
	 * Since mCapacity is now the highest value that mSize can increment to.
	 * 
	 * @param capacity The number of Books that can be safely stored.
	 */
	public Library(int capacity) {
		mBooks = new Book[capacity];
		mCapacity = capacity-1;
	}

	/**
	 * Add books to the library array. Increment mSize up to the value of mCapacity. 
	 * When adding the last book the library becomes full and the boolean value of mFull changes.
	 * 
	 * @param book The Book to be added to the library
	 */
	public void add(Book book) {
		if (mSize < mCapacity) {
			mBooks[mSize] = book;
			mSize++;
			sortLibrary();
		}
		else if(mSize == mCapacity && (!mFull)){
			mBooks[mSize] = book;
			mFull = true;
			sortLibrary();
		}
	}

	
	/**
	 * Sorts the library according to the ISBN number, It uses the Book member function compareTo.
	 */
	private void sortLibrary() {
		for (int i = 0; i < mSize; i++) {
			for (int j = i + 1; j < mSize; j++) {
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
	 * 
	 * @return The array of currently stored books
	 */
	public Book[] list() {
		Book[] books;		
		books = new Book[size()];
		System.arraycopy(mBooks, 0, books, 0, size());		
		return books;
	}
	
	/**
	 * Returns the size of the library array. The size of the array is mSize unless the library is full then its mSize+1.
	 * @return the size of the library array
	 */
	public int size() {
		if(mFull){
			return mSize+1;
		}
		return mSize;
	}
	
	
	/**
	 * Returns the number of books in the library in a string.
	 *
	 * @return the string with the number of books.
	 */
	public String toString(){
		if(mSize == 0){
			return "Biblioteket är tomt";
		}
		return "Bibliotek med " + size() + " böcker";
	}
}
