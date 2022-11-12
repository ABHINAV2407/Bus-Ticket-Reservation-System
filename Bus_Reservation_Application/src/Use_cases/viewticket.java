package Use_cases;

import java.util.Scanner;

import Dao.customerInterface;
import Dao.customerInterfaceImpl;
import Model.customer;

public class viewticket {
   public static void viewticketinput(customer cus) {
	   Scanner sc =new Scanner(System.in);
	   System.out.println("enter booking id");
	   int bookingid = sc.nextInt();
	   customerInterface dao = new customerInterfaceImpl();
	   
	   dao.viewticket(cus.getCid(),bookingid);
	   
   }
}
