package Use_cases;

import java.util.Scanner;

import Dao.customerInterface;
import Dao.customerInterfaceImpl;
import Exception.BusException;
import Model.customer;

public class bookticket {
   public static void bookticketinput(customer cus) {
		
	
	   Scanner sc = new Scanner(System.in);
		
		System.out.println( "Enter Bus Name" );
		String busname = sc.next();
		
		customerInterface dao = new customerInterfaceImpl();
		try {
			System.out.println("Enter the number of Tickets for Booking" );
			int no = sc.nextInt();
			
			int cid = cus.getCid();
			String message = dao.bookTicket(busname, cid, no);
			
			System.out.println( message );
			
		}catch (BusException e) {
			System.out.println( e.getMessage() );
		}
		
   }
}
