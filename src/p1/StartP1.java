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
		Viewer viewer = new Viewer("Bokvisare");
		Book b1 = new Book("En oväntad semester", "Keyes", "9176436314");
		Book b2 = new Book("How to Program", "Deitel", "0131290142");
		Book b3 = new Book("Testamentet", "Grisham", "9176437175");
		Book b4 = new Book("Legionärerna", "Enquist", "9174483463");
		viewer.clear();
		viewer.addRow(b1.toString());
		viewer.addRow(b2.toString());
		viewer.addRow(b3.toString());
		viewer.addRow(b4.toString());
		for(int i = 0; i < 100; i ++){
			viewer.addRow(b1.toString());
		}
	}
}
