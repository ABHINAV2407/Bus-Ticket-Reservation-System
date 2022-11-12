package Dao;

import Exception.BusException;
import Exception.customerException;
import Model.customer;

public interface customerInterface {
	public String customersignup (String username, String password, String firstName, String lastName, String address, String mobile) ;
	
	public customer customerloginmethod(String username, String password) throws customerException;
	
	public String bookTicket(String busname,int cid,int no) throws BusException;
	
	public String cancelticket(int bookingid) throws BusException;
	
	public void viewticket(int cid, int bookingid);
}
