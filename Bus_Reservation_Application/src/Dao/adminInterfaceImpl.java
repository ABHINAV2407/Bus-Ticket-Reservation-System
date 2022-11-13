package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Model.bus;
import Utility.DbUtil;

public class adminInterfaceImpl implements adminInterface{

	@Override
	public String addbusdao(bus bus) {
		String mgs= "try to add again";
		
		
		
		        try (Connection conn = DbUtil.preConnection()){
					PreparedStatement ps = conn.prepareStatement("insert into bus values(?,?,?,?,?,?,?,?,?,?)");
					
					ps.setInt(1, bus.getBusno());
					ps.setString(2, bus.getBusname());
					ps.setString(3, bus.getSource());
					ps.setString(4, bus.getDestination());
					ps.setString(5, bus.getBustype());
					ps.setString(6, bus.getDeparturetime());
					ps.setString(7, bus.getArrivaltime());
					ps.setInt(8,bus.getTotalseats());
					ps.setInt(9, bus.getAvailableseasts());
					ps.setInt(10, bus.getTotalfare());
					
					int x = ps.executeUpdate();
					if (x>0) mgs="bus added ";
					
				} catch (SQLException e) {
					mgs = e.getMessage();
				}

		return mgs;
	}

	
	
	@Override
	public String updateticket(int cid) {
	  
		 String mgs = "pending";
		
		 try (Connection conn = DbUtil.preConnection()) {
			PreparedStatement ps = conn.prepareStatement("update booking set status = true where cid = ?");
			ps.setInt(1, cid);
			
			int x = ps.executeUpdate();
			if (x > 0) mgs = "Status successfully updated for customer Id : " + cid;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			mgs=e.getMessage();
		}
		
		
		return mgs;
	}



	
	
	@Override
	public void viewallticket() {
		 
		try (Connection conn = DbUtil.preConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from booking");
			ResultSet rs = ps.executeQuery();  
			boolean flag =false;
			while (rs.next()) {
				flag=true;
				
				System.out.println( "----------------------------------------------------" );
				System.out.println( "Bus Id : " + rs.getInt("bookingid") );
				System.out.println( "Bus No : " + rs.getInt("BusNo") );
				System.out.println("Total tickets : " + (rs.getInt("seatTo") - rs.getInt("seatFrom") + 1) );
				if (rs.getInt("status") == 1) System.out.println( "Status : Booked" );
				else System.out.println( "Status : Pending" );
				
				System.out.println( "----------------------------------------------------" );
				
			}
			
			if(flag==false) System.out.println("no ticket found");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}



	
	
	@Override
	public void providecontactnumber() {
		Scanner sc = new Scanner (System.in);
		try (Connection conn = DbUtil.preConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from booking");
			ResultSet rs = ps.executeQuery();  
			boolean flag =false;
			while (rs.next()) {
				flag=true;
				
				if (rs.getInt("status") == 1) {
					System.out.println( "Status : Booked");
					System.out.println( "Booking Id : " + rs.getInt("bookingid") );
					System.out.println( "Bus No : " + rs.getInt("BusNo") );
					System.out.println("enter contact number to provide to customer");
					int number =sc.nextInt();
					System.out.println( number+ " number send to customer");
					System.out.println("------------------------------------------------");
					System.out.println("------------------------------------------------");
				}else 
				{
					System.out.println( "Status : Pending" );
					System.out.println( "Booking Id : " + rs.getInt("bookingid") );
					System.out.println( "Bus No : " + rs.getInt("BusNo") );
					System.out.println("first confirm the ticket then provide contact number");
					System.out.println("------------------------------------------------");
					System.out.println("------------------------------------------------");
				}
				
				
			}
			
			if(flag==false) System.out.println("no ticket found");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
