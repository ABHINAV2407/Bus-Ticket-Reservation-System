package Use_cases;

import java.util.Scanner;

import Dao.customerInterface;
import Dao.customerInterfaceImpl;

public class customersignup {
 public static boolean customersignupdetails() {
	 boolean flag = false;
	 Scanner sc = new Scanner(System.in);
	 
	    System.out.println( "Enter Username" );
		String username = sc.next();
		
		System.out.println("Enter Password" );
		String password = sc.next();
		
		System.out.println( "Enter First Name" );
		String firstName = sc.next();
		
		System.out.println("Enter Last Name" );
		String lastName = sc.next();
		
		sc.nextLine();
		System.out.println("Enter Address" );
		String address = sc.nextLine();
		
		System.out.println("Enter Mobile" );
		String mobile = sc.next();
		
		customerInterface dao = new customerInterfaceImpl();
		 String result = dao.customersignup(username, password, firstName, lastName, address, mobile);
		 
		 if (result.equals("Sign up Successfull")) flag = true;
	 
	 return flag;
	 
 }
}
