package Library;

import java.util.Scanner;

public class DeleteBook implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book Name: ");
		String bookName = s.next();
		
		int i = database.getBook(bookName);
		if(i>-1) {
			database.deleteBook(i);
			System.out.println("Book Successfully Deleted!\n");
		}else {
			System.out.println("Book Doesn't Exist!\n");
		}
		user.menu(database, user);
	}

}
