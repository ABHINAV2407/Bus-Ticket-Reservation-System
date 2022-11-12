package Model;

public class booking {
   
	private int bookingid;
	private int cid;
	private int busno;
	private int seatfrom;
	private int seatto;
	private boolean status;
	
	
	public booking(int bookingid, int cid, int busno, int seatfrom, int seatto, boolean status) {
		super();
		this.bookingid = bookingid;
		this.cid = cid;
		this.busno = busno;
		this.seatfrom = seatfrom;
		this.seatto = seatto;
		this.status = status;
	}


	public int getBookingid() {
		return bookingid;
	}


	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getBusno() {
		return busno;
	}


	public void setBusno(int busno) {
		this.busno = busno;
	}


	public int getSeatfrom() {
		return seatfrom;
	}


	public void setSeatfrom(int seatfrom) {
		this.seatfrom = seatfrom;
	}


	public int getSeatto() {
		return seatto;
	}


	public void setSeatto(int seatto) {
		this.seatto = seatto;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "booking [bookingid=" + bookingid + ", cid=" + cid + ", busno=" + busno + ", seatfrom=" + seatfrom
				+ ", seatto=" + seatto + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
