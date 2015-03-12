package p1;

public class StartP1 {
	public static void main(String[] args) {
//		Library library = new Library(100);
//		library.add(new Book("How to Program", "Deitel", "0131290142"));
//		library.add(new Book("En oväntad semester", "Keyes", "9176436314"));
//		library.add(new Book("Testamentet", "Grisham", "9176437175"));
//		library.add(new Book("Legionärerna", "Enquist", "9174483463"));
//		Viewer viewer = new Viewer("Bokvisare");
//		Controller controller = new Controller(library, viewer);
//		Input input = new Input(controller);
		
		String res="";
		Library library = new Library(100); // Max 100 böcker kan lagras
		for (int i =0; i < 100; i++){
			library.add(new Book("book", "author", Integer.toString(i+1)));
			System.out.println(i);
		}
		
		res += "Antal lagrade böcker: " + library.size();
		System.out.println(res);
		res += "\n" + library.toString();
		Book[] books = library.list();
		res += "\nKapacitet på böcker: " + books.length + "\n";
		System.out.println(res);
		for(int i=0; i<books.length; i++){
			res += books[i].toString() + "      ";
			if (i%5 == 0 && i != 0){
				res += "\n";
			}
		}
		
		//res += books[99].toString();
		
		javax.swing.JOptionPane.showMessageDialog(null, res);
	}
}
