package p1;

/**
 * Main class of DA147AP1
 * I use m notation on member variables throughout the project
 * @author Kristoffer Freiholtz
 * @version 1.0
 */
public class StartP1 {
	public static void main(String[] args) {
		Library library = new Library(100);
		library.add(new Book("How to Program", "Deitel", "0131290142"));
		library.add(new Book("En ov�ntad semester", "Keyes", "9176436314"));
		library.add(new Book("Testamentet", "Grisham", "9176437175"));
		library.add(new Book("Legion�rerna", "Enquist", "9174483463"));
		Viewer viewer = new Viewer("Bokvisare");
		Controller controller = new Controller(library, viewer);
		Input input = new Input(controller);
	}
}
