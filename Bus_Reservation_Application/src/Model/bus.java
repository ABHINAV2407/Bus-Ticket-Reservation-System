package Model;

public class bus {
  private int busno;
  private String busname;
  private String source;
  private String destination;
  private String bustype;
  private String departuretime;
  private String arrivaltime;
  private int totalseats;
  private int availableseasts;
  private int totalfare;
  
  
public bus(int busno, String busname, String source, String destination, String bustype, String departuretime,
		String arrivaltime, int totalseats, int availableseasts, int totalfare) {
	super();
	this.busno = busno;
	this.busname = busname;
	this.source = source;
	this.destination = destination;
	this.bustype = bustype;
	this.departuretime = departuretime;
	this.arrivaltime = arrivaltime;
	this.totalseats = totalseats;
	this.availableseasts = availableseasts;
	this.totalfare = totalfare;
}


public int getBusno() {
	return busno;
}


public void setBusno(int busno) {
	this.busno = busno;
}


public String getBusname() {
	return busname;
}


public void setBusname(String busname) {
	this.busname = busname;
}


public String getSource() {
	return source;
}


public void setSource(String source) {
	this.source = source;
}


public String getDestination() {
	return destination;
}


public void setDestination(String destination) {
	this.destination = destination;
}


public String getBustype() {
	return bustype;
}


public void setBustype(String bustype) {
	this.bustype = bustype;
}


public String getDeparturetime() {
	return departuretime;
}


public void setDeparturetime(String departuretime) {
	this.departuretime = departuretime;
}


public String getArrivaltime() {
	return arrivaltime;
}


public void setArrivaltime(String arrivaltime) {
	this.arrivaltime = arrivaltime;
}


public int getTotalseats() {
	return totalseats;
}


public void setTotalseats(int totalseats) {
	this.totalseats = totalseats;
}


public int getAvailableseasts() {
	return availableseasts;
}


public void setAvailableseasts(int availableseasts) {
	this.availableseasts = availableseasts;
}


public int getTotalfare() {
	return totalfare;
}


public void setTotalfare(int totalfare) {
	this.totalfare = totalfare;
}


@Override
public String toString() {
	return "bus [busno=" + busno + ", busname=" + busname + ", source=" + source + ", destination=" + destination
			+ ", bustype=" + bustype + ", departuretime=" + departuretime + ", arrivaltime=" + arrivaltime
			+ ", totalseats=" + totalseats + ", availableseasts=" + availableseasts + ", totalfare=" + totalfare + "]";
}

}
