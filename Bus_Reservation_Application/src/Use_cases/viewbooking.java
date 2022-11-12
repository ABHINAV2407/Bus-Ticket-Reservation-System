package Use_cases;

import Dao.adminInterface;
import Dao.adminInterfaceImpl;

public class viewbooking {
   public static  void viewbookinginput() {
	  adminInterface dao = new adminInterfaceImpl();
	  dao.viewallticket();
   }
}
