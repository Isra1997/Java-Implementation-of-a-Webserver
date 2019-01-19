import java.io.IOException;


public class requests {
	
	String method;
	String URL;
	double version;
	String Host;
	String AcceptedFormat;
	String Connection;
	
	public requests(String method , String URL,double version, String Host,String AcceptedFormat,String Connection) {
		 this.method=method;
		 this.URL=URL;
		 this.version=version;
		 this.Host=Host;
		 this.AcceptedFormat=AcceptedFormat;
		 this.Connection=Connection;
		
	}
	
	//checks for get method
	public boolean CheckMethod(){
		if(method.equals("Get")){
			return true;
		}
		else{
			return true;
		}
	}
	
	//checks the accepted format
	public boolean CheckAcceptedformat(){
		switch (AcceptedFormat) {
		case "txt":
			return true;
		case "PNG":
			return true;
		case "JPEG":
			return true;
		case "mp4":
			return true;
		default:
				return false;
		}
		
	}
	
	//check for the connection
	public boolean CheckConnection(){
		if (Connection.equals("close")) {
			return false;
		}else {
			return true;
		}
	}
	
	//switch case for the available URL's
	public boolean CheckURL(){
		switch (URL) {
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image1.JPEG":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image2.JPEG":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image3.PNG":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image4.PNG":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text1.txt":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text2.txt":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text3.txt":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text4.txt":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/MP41.mp4":
			return true;
		case "/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/MP42.mp4":
			return true;
		default:
			return false;
		}
		
	}
	
	//check the host
	public boolean CheckHost(){
		if(Host.equals("Isra'sWebServer")){
			return true;
		}
		else{
			return false;
		}
	}

	public String getMethod() {
		return method;
	}

	public String getURL() {
		return URL;
	}

	public double getVersion() {
		return version;
	}

	public String getHost() {
		return Host;
	}

	public String getAcceptedFormat() {
		return AcceptedFormat;
	}

	public String getConnections() {
		return Connection;
	}
	
}
