package Use_cases;

import java.util.Scanner;

import Dao.customerInterface;
import Dao.customerInterfaceImpl;
import Exception.customerException;
import Model.customer;

public class customerlogin {
   public static customer customerlogindetail() {
	   customer cus = null;
	   Scanner sc = new Scanner (System.in);
	   
	   System.out.println("Enter Username" );
		String username = sc.next();
		
		System.out.println("Enter Password" );
		String password = sc.next();
		
		customerInterface dao = new customerInterfaceImpl();
		
		     try {
				 cus =  dao.customerloginmethod(username, password);
				 System.out.println("welcome to BTR Aplication "+ cus.getFirstname()+" "+ cus.getLastname());
			} catch (customerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		     return cus;
		
   }
}
