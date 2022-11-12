package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Use_cases.addbus;
import Use_cases.adminLogin;
import Use_cases.bookticket;
import Use_cases.cancelticket;
import Use_cases.customerlogin;
import Use_cases.customersignup;
import Use_cases.viewticket;

public class Main {

	public static void choice() {
		
		System.out.println("Enter the choice"+"\n"
		                   +"+------------------+"+"\n"
		                   + "| 1. Admin         |" + "\n"
 						   + "| 2. Customer      |" + "\n"
 						   + "| 3. Exit          |" + "\n"
 						   +"+------------------+");
		
		enterTheChoice();
		
	}
	
	static void enterTheChoice() {
		Scanner sc = new Scanner (System.in);
		
		int choice=0;
		
		try {
			choice = sc.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Input should be a number"+"\n"
					         + "------------------------");
			
			choice();
		}
		
		if(choice==1) {
			System.out.println("you choice option 1 ");
			admin();
		}else if (choice==2) {
			System.out.println("you choice option 2 ");
			customer();
		}else if (choice==3) {
			System.out.println("you choice option 3 ");
			System.out.println("Thank you for visiting us.It’s nice to have you with us today.");
			System.exit(0);
			
		}else {
			System.out.println("please enter a valid option");
			choice();
		}
	
	}
	
	
	public static void admin() {
		boolean status = adminLogin.adminlogindetails();
		if(status)adminmethods();
		else {
			int flag=0;
			int option=0;
			while(flag==0) {
			System.out.println("wrong credentials, press 1 to enter username/password again or press any number to back to  the main menu");
			Scanner sc = new Scanner (System.in);
			
			try{
				 option = sc.nextInt();
				 flag=1;
			}catch (InputMismatchException e) {
				System.out.println("Input should be a number"+"\n"
				         + "------------------------");
	        }
			}
			
			if(option==1) admin();
			else choice();
		}
	}
	
	public static void adminmethods(){
		
		System.out.println( "Enter the choice"+"\n"+
	                       "+-----------------------------------+" + "\n"
						 + "| Welcome Admin                     |" + "\n"
						 + "| 1. Add Bus                        |" + "\n"
						 + "| 2. Confirm Tickets of Customer    |" + "\n"
						 + "| 3. View All Bookings              |" + "\n"
						 + "| 4. provide contact person details |" + "\n"
						 + "| 5. Back                           |" + "\n"
						 + "| 6. Exit                           |" + "\n"
						 + "+-----------------------------------+" );
		
		Scanner sc = new Scanner (System.in);
		
		int choice=0;
		
		try {
			choice = sc.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Input should be a number"+"\n"
					         + "------------------------");
			
			adminmethods();
		}
		
		if(choice==1) {
			System.out.println("you choice option 1 ");
		  addbus.addbusmethod();
			adminmethods();
		}else if (choice==2) {
			System.out.println("you choice option 2 ");
//			ConfirmTicketsofCustomer();
		}else if (choice==3) {
			System.out.println("you choice option 3 ");
//			ViewAllBookings ();
		}else if (choice==4) {
			System.out.println("you choice option 4 ");
//			providecontactpersondetails ();
		}else if (choice==5) {
			System.out.println("you choice option 5 ");
			choice();
		}else if (choice==6) {
			System.out.println("you choice option 6 ");
			System.out.println("Thank you for visiting us.It’s nice to have you with us today.");
			System.exit(0);
			
		}else {
			System.out.println("please enter a valid option");
			adminmethods();
		}
	}
	
	
    public static void customer() {
		
    	System.out.println( "Enter the choice"+"\n"+
    	          "+--------------------------------+" + "\n"
                + "| 1. Login to your Account       |" + "\n"
                + "| 2. Don't have Account? Sign Up |" + "\n"
                + "| 3. Back                        |" + "\n"
                + "| 4. Exit                        |" + "\n"
                + "+--------------------------------+" );
    	
		Scanner sc = new Scanner (System.in);
		
		int choice=0;
		
		try {
			choice = sc.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Input should be a number"+"\n"
					         + "------------------------");
			
			customer();
		}
		
		if(choice==1) {
			System.out.println("you choice option 1 ");
		    Model.customer cus  =	customerlogin.customerlogindetail();
		    if(cus==null) {
		    	 cus  =	customerlogin.customerlogindetail();
		    }else {
		    	System.out.println("login successfull");
		    	customerMethods(cus);
		    }
	
		}else if (choice==2) {
			System.out.println("you choice option 2 ");
           boolean status = customersignup.customersignupdetails();
           if(status) System.out.println("login to your account");
           
           Model.customer cus  =	customerlogin.customerlogindetail();
		    if(cus==null) {
		    	 cus  =	customerlogin.customerlogindetail();
		    }else {
		    	System.out.println("login successfull");
		    	customerMethods(cus);
		    }
            
		}else if (choice==3) {
			System.out.println("you choice option 3 ");
			choice();
		}else if (choice==4) {
			System.out.println("you choice option 4 ");
			System.out.println("Thank you for visiting us.It’s nice to have you with us today.");
			System.exit(0);
			
		}else {
			System.out.println("please enter a valid option");
			customer();
		}
    	
	}
    
    
    public static void customerMethods(Model.customer cus) {
    	   System.out.println( "Enter the choice"+"\n"+
    			               "+--------------------------------+" + "\n"
					 		 + "| 1. Book Bus Ticket             |" + "\n"
					         + "| 2. Cancel Bus Ticket           |" + "\n"
					         + "| 3. View Status of your Tickets |" + "\n"
					         + "| 4. Back                        |" + "\n"
					         + "| 5. Exit                        |" + "\n"
					         + "+--------------------------------+" );
    	
		Scanner sc = new Scanner (System.in);
		
		int choice=0;
		
		try {
			choice = sc.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Input should be a number"+"\n"
					         + "------------------------");
			
			customerMethods(cus);
		}
		
		if(choice==1) {
			System.out.println("you choice option 1 ");		
		     bookticket.bookticketinput(cus);
		     customerMethods(cus);
		}else if (choice==2) {
			System.out.println("you choice option 2 ");
			 cancelticket.cancelticketinput();
		     customerMethods(cus);
		}else if (choice==3) {
			System.out.println("you choice option 3 ");
			viewticket.viewticketinput(cus);
			 customerMethods(cus);
		}else if (choice==4) {
			System.out.println("you choice option 4 ");
			customer();
		}else if (choice==5) {
			System.out.println("you choice option 5 ");
			System.out.println("Thank you for visiting us.It’s nice to have you with us today.");
			System.exit(0);
			
		}else {
			System.out.println("please enter a valid option");
			customerMethods(cus);
		}
    	
    }
	
	
	public static void main(String[] args) {
		
		choice();

	}

}
