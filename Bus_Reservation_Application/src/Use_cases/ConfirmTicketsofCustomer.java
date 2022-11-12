package Use_cases;

import java.util.Scanner;

import Dao.adminInterface;
import Dao.adminInterfaceImpl;

public class ConfirmTicketsofCustomer {
   public static void ConfirmTicketsofCustomerinput() {
	   Scanner sc = new Scanner(System.in);
		System.out.println( "Enter customer Id" );
		int cid = sc.nextInt();
		
		adminInterface dao = new adminInterfaceImpl();
		
		String result = dao.updateticket(cid);
		  System.out.println(result);
   }
}
