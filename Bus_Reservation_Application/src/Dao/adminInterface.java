package Dao;

import Model.bus;

public interface adminInterface {
   
	public  String addbusdao(bus bus);
	
	public String updateticket(int cid);
	
	public void viewallticket();
	
	public void providecontactnumber();
}
