package p1;

/**
 * @author Stationary
 *
 */
public class StartP1 {
	public static void main(String[] args) {
		Library library = new Library(5);
		library.add(new Book("How to Program", "Deitel", "0131290142"));
		library.add(new Book("En oväntad semester", "Keyes", "9176436314"));
		library.add(new Book("Testamentet", "Grisham", "9176437175"));
		library.add(new Book("Legionärerna", "Enquist", "9174483463"));
		Viewer viewer = new Viewer("Bokvisare");
		Controller controller = new Controller(library, viewer);
		Input input = new Input(controller);
		// String res="";
		// Library library = new Library(100); // Max 100 böcker kan lagras
		// for (int i = 0; i < 0; i++){
		// library.add(new Book("test", "test", "" + (i+1)));
		// }
		//
		// res += "Antal lagrade böcker: " + library.size();
		// res += "\n" + library.toString();
		// Book[] books = library.list();
		// res += "\nKapacitet på böcker: " + books.length;
		// for(int i=0; i<books.length; i++){
		// res += books[i].toString();
		// if((i%5) == 0){
		// res += "\n";
		// }
		// }
		//
		// javax.swing.JOptionPane.showMessageDialog(null, res);

	}
}
