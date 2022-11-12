package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Exception.BusException;
import Exception.customerException;
import Model.customer;
import Utility.DbUtil;

public class customerInterfaceImpl implements customerInterface{

	@Override
	public String customersignup(String username, String password, String firstName, String lastName, String address,String mobile) {
		
		
		String mgs = "Sign up Failed";
		
		
		try (Connection conn = DbUtil.preConnection()){
			PreparedStatement ps =  conn.prepareStatement("insert into customer(username, password, firstName, lastName, address, mobile) values (?,?,?,?,?,?)");
		
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,  firstName);
			ps.setString(4,  lastName);
			ps.setString(5,  address);
			ps.setString(6,  mobile);
		

			int x = ps.executeUpdate();
			

			if (x > 0) mgs = "Sign up Successfull";
		
		} catch (SQLException e) {
			mgs=e.getMessage();
		}
		
		return mgs;
	
	}

	
	
	
	@Override
	public customer customerloginmethod(String username, String password) throws customerException {
          customer customer = null;
		
		try (Connection conn = DbUtil.preConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from customer where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =  ps.executeQuery();
			
			if (rs.next()) {
				int cid = rs.getInt("cid");
				String u =  rs.getString("username");
				String p = rs.getString("password");
				String f = rs.getString("firstname");		
				String l = rs.getString("lastname");			
				String a = rs.getString("address");			
				String m = rs.getString("mobile");
				
				customer = new customer(cid,u, p, f, l, a, m);
				
			}
			else {
				
				throw new customerException("Invalid username or password");
				
			}
			
		}
		catch (SQLException e) {
			
			throw new customerException(e.getMessage());
		}
		
		return customer;
	}




	

	@Override
	public String bookTicket(String busname, int cid, int no) throws BusException {
		String mgs = "Ticket Booking fail";
		
		try (Connection conn = DbUtil.preConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from bus where busname = ?");
			ps.setString(1, busname);
			
			ResultSet rs = ps.executeQuery();
			 
			if (rs.next()) {
				int busNo = rs.getInt("BusNo");
				int totalSeats = rs.getInt("TotalSeats");
				int availSeats = rs.getInt("availableSeats");
				Date departure = rs.getDate("departureTime");
				int fare = rs.getInt("TotalFare");
				PreparedStatement ps1 = conn.prepareStatement("select datediff(?,current_date()) as date");
				ps1.setDate(1, (java.sql.Date) departure);
				
				ResultSet rs1 = ps1.executeQuery();
				int days = 0;
				
						if (rs1.next()) {
							days = rs1.getInt("date");
						}
						
						if (days <= 0) {
							throw new BusException("Booking is not available for this date");
						}else if (availSeats >= no) {
							
							int seatFrom = totalSeats - availSeats + 1;
							int seatTo = seatFrom + no -1;
							fare = fare * no;
							PreparedStatement ps2 = conn.prepareStatement("insert into booking(cid, BusNo, seatFrom, seatTo) values (?, ?, ?, ?)");
							ps2.setInt(1, cid);
							ps2.setInt(2, busNo);
							ps2.setInt(3, seatFrom);
							ps2.setInt(4, seatTo);
							
							int x = ps2.executeUpdate();
							
							if (x > 0) {
								PreparedStatement ps3 = conn.prepareStatement("update bus set availableSeats = ? where busNo = ?");
								
								availSeats = availSeats - no;
								ps3.setInt(1, availSeats);
								ps3.setInt(2, busNo);
								
								int y = ps3.executeUpdate();
								if (y <= 0) throw new BusException("Available Seat is not updated");
								
								
								
//								
//			PreparedStatement ps4 = conn.prepareStatement("select * from booking where cid = ? AND busno=? and seatFrom=? and seatTo=?");
//								ps4.setInt(1, cid);
//								ps4.setInt(2,busNo );
//								ps4.setInt(3,seatFrom );
//								ps4.setInt(4,seatTo );
//								
//								ResultSet rs4 = ps.executeQuery();
//								int b=0;
//								if(rs4.next()) {
//									 b=rs4.getInt("bookingid");
//								}
//								
//								System.out.println(b);
								
								
									System.out.println( "--------------------------------------------" + "\n"			
											   + "Customer Id is : " + cid + "\n"
											   + "Bus No is : " + busNo + "\n"
											   + "Seat No is from : " + seatFrom + " to " + seatTo + "\n"
											   + "Bus fare is : " + fare + "\n"
											   + "Booking yet to be confirm by Adminstrator" + "\n" 
											   + "---------------------------------------------" );
									
									 mgs = "Ticket Booked Successfully";

							}
							
						}
						
				
				
			}else {
				throw new BusException("Bus with " + busname + " is not available");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BusException(e.getMessage());
		}
		
		return mgs;
	}




	
	
	@Override
	public String cancelticket(int bookingid) throws BusException {
		String mgs ="ticket cancellation failed";
		
		try (Connection conn = DbUtil.preConnection()) {
			
			PreparedStatement ps0 = conn.prepareStatement("select * from booking where bookingid = ?");
			 ps0.setInt(1, bookingid);
			 ResultSet rs = ps0.executeQuery();
			 if(rs.next()) {
				    int busno = rs.getInt("BusNo");
				    int seatFrom = rs.getInt("seatFrom");
					int seatTo = rs.getInt("seatTo");
					int count = seatTo - seatFrom + 1; 
					
					PreparedStatement ps = conn.prepareStatement("delete  from booking where bookingid = ?");
					ps.setInt(1, bookingid);
					int x = ps.executeUpdate();
					 if (x>0) {
						 mgs ="Ticket cancelled Successfully";
						 
						 PreparedStatement ps1 = conn.prepareStatement("update bus set availableSeats = availableSeats+? where BusNo = ?");
						 
						 ps1.setInt(1,count);
						 ps1.setInt(2, busno);
					 }
			 }else {
				 mgs="invalid booking id";
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BusException(e.getMessage());
		}
		
		return mgs;
	}




	
	
	@Override
	public void viewticket(int cid, int bookingid) {
		

			try (Connection conn = DbUtil.preConnection()){
				PreparedStatement ps = conn.prepareStatement("select * from booking where cid = ? AND bookingid=?");
				ps.setInt(1, cid);
				ps.setInt(2, bookingid);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					System.out.println( "---------------------------------------------" );
					System.out.println( "Booking Id : " + rs.getInt("bookingid"));
					System.out.println( "Bus No : " + rs.getInt("BusNo") );
					System.out.println( "Total tickets : " + (rs.getByte("seatTo") - rs.getInt("seatFrom") + 1) );
					if (rs.getBoolean("status")) System.out.println( "Status : Booked" );
					else System.out.println( "Status : Pending");
					
					System.out.println( "----------------------------------------------" );
				}else {
					System.out.println("invalid booking id or no ticket reserved ");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
         
		
	}

}
