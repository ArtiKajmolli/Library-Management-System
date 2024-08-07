package Library;

import java.util.Scanner;

public class Search implements IOOperation{

	@Override
	public void oper(Database database, User user) {
		// TODO Auto-generated method stub
		System.out.println("\nEnter Book Name: ");
		Scanner s = new Scanner(System.in);
		String name = s.next();
		
		int i = database.getBook(name);
		if(i>-1) {
			System.out.println("\n"+database.getBook(i).toString()+"\n");
		}else {
			System.out.println("Book Doesn't Exist!\n");
		}
		user.menu(database, user);
	}

}
