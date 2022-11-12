package Use_cases;

import java.util.Scanner;

import Dao.customerInterface;
import Dao.customerInterfaceImpl;
import Exception.BusException;
import Model.customer;

public class cancelticket {
   public static void cancelticketinput() {
	   Scanner sc = new Scanner(System.in);
		
			System.out.println( "Enter Booking id" );
			int bookingid = sc.nextInt();
			
			customerInterface dao = new customerInterfaceImpl();
			try {
				
				String message = dao.cancelticket(bookingid);
				
				System.out.println( message );
				
			}catch (BusException e) {
				System.out.println( e.getMessage() );
			}
   }
}
