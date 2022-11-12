package Use_cases;

import Dao.adminInterface;
import Dao.adminInterfaceImpl;

public class contactperson {
  public static void contactpersoninput() {
	    
	 adminInterface dao = new adminInterfaceImpl();
	 dao.providecontactnumber();
  }
}
