package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
