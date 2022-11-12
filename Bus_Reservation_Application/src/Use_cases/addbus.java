package Use_cases;

import java.util.Scanner;

import Dao.adminInterface;
import Dao.adminInterfaceImpl;
import Model.bus;

public class addbus {
   public static void addbusmethod() {
	   Scanner sc = new Scanner(System.in);
	   try {
		   
		   System.out.println("Enter Bus number");
			int busno = sc.nextInt();
			
			System.out.println( "Enter bus name" );
			String busname = sc.next();
			
	
			System.out.println("Enter Route from" );
			String source = sc.next();
			
			System.out.println("Enter Routo To" );
			String destination = sc.next();
			
			System.out.println( "Enter Bus Type - AC / NonAC");
			String bustype = sc.next();
			
			sc.nextLine();
			System.out.println( "Enter Departure date and time in format (YYYY-MM-DD HH:MI:SS)" );
			String departuretime = sc.nextLine();
			
			System.out.println( "Enter Arrival date and time in format (YYYY-MM-DD HH:MI:SS)");
			String arrivaltime = sc.nextLine();
			
			System.out.println("Enter Total Seats");
			int totalSeats = sc.nextInt();
			
			System.out.println( "Enter Available Seats");
			int availableSeats = sc.nextInt();
			
			System.out.println("Enter fare" );
			int totalfare = sc.nextInt();
			
			bus bus = new bus(busno, busname, source, destination, bustype, departuretime, arrivaltime, totalSeats, availableSeats, totalfare);
			
			adminInterface dao = new adminInterfaceImpl();
			String result = dao.addbusdao(bus);
			System.out.println(result);
	   }catch (Exception e) {
		System.out.println("invalid input");
	}
   }
}
