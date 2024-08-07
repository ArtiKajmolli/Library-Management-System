package Library;

import java.util.Scanner;

public class AddBook implements IOOperation{

	@Override                                                              
	public void oper(Database database, User user) {
		Scanner s = new Scanner(System.in);
		Book book = new Book();
		System.out.println("\nEnter Book Name: ");
		String name = s.next();
		if(database.getBook(name)>-1) {
			System.out.println("There is a book with this name!\n");
			user.menu(database, user);
			return;
		}else {
			book.setName(name);	
			System.out.println("Enter Book Author: ");
			book.setAuthor(s.next());
			System.out.println("Enter Book Publisher: ");
			book.setPublisher(s.next());
			System.out.println("Enter Book Collection Address: ");
			book.setAddress(s.next());
			System.out.println("Enter Book Quantity: ");
			book.setQty(s.nextInt());
			System.out.println("Enter Price: ");
			book.setPrice(s.nextDouble());
			System.out.println("Enter Borrowing Copies: ");
			book.setBrwCopies(s.nextInt());
			database.AddBook(book);
			System.out.println("Book added Successfully\n");
			user.menu(database, user);
			s.close();
		}
		
	}

}
