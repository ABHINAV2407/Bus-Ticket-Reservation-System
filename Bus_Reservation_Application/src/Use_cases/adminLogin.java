package Use_cases;

import java.util.Scanner;

public class adminLogin {
    
	public static  boolean adminlogindetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter username");
		String username = sc.next();
		System.out.println("enter password");
		String password = sc.next();
		
		if(username.equals("Abhinav") && password.equals("123456789")) {
			return true;
		}else {
			return false;
		}
	}
	
}
