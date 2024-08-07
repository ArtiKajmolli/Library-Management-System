package Library;

import java.util.Scanner;

public class BorrowBook implements IOOperation{

	@Override
	public void oper(Database database, User user) {
 		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book Name: ");
		String bookName = s.next();
		
		int i = database.getBook(bookName);
		if(i>-1) {
			Book book = database.getBook(i);
			boolean n = true;
			for(Borrowing b : database.getBrws()) {
				if(b.getBook().getName().matches(bookName) &&
						b.getUser().getName().matches(user.getName())) {
					n = false;
					System.out.println("You have borrowed this book before!\n");
				}
			}
			
			if(n) {
				if(book.getBrwCopies()>1) {
					Borrowing borrowing = new Borrowing(book, user);
					book.setBrwCopies(book.getBrwCopies()-1);
					database.borrowBook(borrowing, book, i);
					System.out.println("You must return the book before 14 days from now\n"
							+ "Expiry date: "+borrowing.getFinish()+"\nEnjoy!\n");
				}else {
					System.out.println("This book isn't available for borrowing\n");
				}
			}
			
		}else {
			System.out.println("Book Doesn't Exist!\n");
		}
		user.menu(database, user);

	}

}
