package p1;

public class Book {

	private String mTitle;
	private String mAuthor;
	private String mIsbn;
	
	public Book(String title, String author, String isbn){
		mTitle = title;
		mAuthor = author;
		mIsbn = isbn;
	}
	
	public String getTitle(){
		return mTitle;
	}
	
	public String getAuthor(){
		return mAuthor;
	}
	
	public String getIsbn(){
		return mIsbn;
	}
	
	public String toString(){
		return mTitle + ", " + mAuthor + ", ISBN: " + mIsbn;
	}
	
	public int compareTo(Book book){
		if(mIsbn.compareTo(book.getIsbn()) > 0){
			return 1;
		}
		return -1;
	}
		
}
