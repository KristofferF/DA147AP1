package p1;

public class Library {
	private Book[] mBooks;
	private int mSize = 0;
	private int mCapacity;

	public Library(int capacity) {
		mBooks = new Book[capacity];
		mCapacity = capacity;
	}

	public void add(Book book) {
		if (mSize < mCapacity) {
			mBooks[mSize] = book;
			if (mSize < (mCapacity - 1)) {
				mSize++;
			}
			//sortLibrary();
		}
	}

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

	public Book[] list() {
		Book[] books;
		if(mSize < (mCapacity-1)){
			books = new Book[mSize+1];
			System.arraycopy(mBooks, 0, books, 0, mSize+1);
		}
		else{
			books = new Book[mSize];
			System.arraycopy(mBooks, 0, books, 0, mSize);
		}
		
		
		return books;
	}

	public int size() {
		return mSize;
	}
}
