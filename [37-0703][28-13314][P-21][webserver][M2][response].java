
import java.util.Date;
import java.sql.*;


public class response {
	String Status;
	double Version;
	Date date;
	Timestamp timestamp;
	String Format;
	String Connection;
	
	
	
	public response(String Status,double Version,String Format,String Connection) {
		this.Status=Status;
		this.Version=Version;
		this.date=new Date();
		this.timestamp=new Timestamp(date.getTime());
		this.Format=Format;
		this.Connection=Connection;
	}



	public String getStatus() {
		return Status;
	}



	public double getVersion() {
		return Version;
	}



	public Date getDate() {
		return date;
	}



	public Timestamp getTimestamp() {
		return timestamp;
	}



	public String getFormat() {
		return Format;
	}



	public String getConnection() {
		return Connection;
	}
	

}
