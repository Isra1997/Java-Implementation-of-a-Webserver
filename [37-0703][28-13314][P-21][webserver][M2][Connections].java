import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Connections extends Thread{
	
	WebServer server;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	Boolean ShouldRun=true;
	String usrename;
	boolean join=false;
	
	public String getUsrename() {
		return usrename;
	}


	ArrayList <requests> processingQueue =new ArrayList<requests>();
	
	public Connections(Socket socket,WebServer server){
		super("connection threads");
		this.server=server;
		this.socket=socket;
	}
	
	
	
	
public void JoinReresponse(String name){
		 this.setUsrename(name);
		for(int i=0;i<WebServer.clients.size()-1;i++){
			String sc=WebServer.clients.get(i).getUsrename();
			if(sc.equals(name)){
				try {
					out.writeUTF("Join Request Reject.Username already in use.Welcome to Isra's chat application :)");
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	         try {
				out.writeUTF("Join Request accepted.");
				join=true;
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	
	
	
	public void  ProcessRequest() {
		        requests req=processingQueue.get(0);
					if(req.CheckURL()){
							response res=new response("200 OK", 1.1, req.getAcceptedFormat(), req.getConnections());
							try {
								if(req.CheckConnection()==false){
								String zz="Method:"+req.getMethod()+"<br> URL: "+req.getURL()+"<br> Version: "+req.getVersion()+"<br> Format :"+req.getAcceptedFormat()+"<br> Connection:"+req.getConnections()+"<br>";
								String xx="<html>"+"Request<br>"+zz+"<br>Response<br>Status:"+res.getStatus()+"<br> Version: "+res.getVersion()+"<br> TimeStamp: "+res.getTimestamp()+"<br> Format :"+res.getFormat()+"<br> Connection:"+res.getConnection()+"</html>";
								out.writeUTF("R"+xx);
								}
								else{
									String zz="Method:"+req.getMethod()+"<br> URL: "+req.getURL()+"<br> Version: "+req.getVersion()+"<br> Format :"+req.getAcceptedFormat()+"<br> Connection:"+req.getConnections()+"<br>";
									String xx="<html>"+"Request<br>"+zz+"<br>Response<br>Status:"+res.getStatus()+"<br> Version: "+res.getVersion()+"<br> TimeStamp: "+res.getTimestamp()+"<br> Format :"+res.getFormat()+"<br> Connection:"+res.getConnection()+"</html>";
									out.writeUTF(xx);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					
						else{
							response res=new response("404 Not found", 1.1, req.getAcceptedFormat(),req.getConnections());
							try {
								if(req.CheckConnection()==false){
								String zz="Method:"+req.getMethod()+"<br> URL: "+req.getURL()+"<br> Version: "+req.getVersion()+"<br> Format :"+req.getAcceptedFormat()+"<br> Connection:"+req.getConnections()+"<br>";
								String xx="<html>"+"Request<br>"+zz+"<br>Response<br>Status:"+res.getStatus()+"<br> Version: "+res.getVersion()+"<br> TimeStamp: "+res.getTimestamp()+"<br> Format :"+res.getFormat()+"<br> Connection:"+res.getConnection()+"</html>";
								out.writeUTF("R"+xx);
								}
								else{
									String zz="Method:"+req.getMethod()+"<br> URL: "+req.getURL()+"<br> Version: "+req.getVersion()+"<br> Format :"+req.getAcceptedFormat()+"<br> Connection:"+req.getConnections()+"<br>";
									String xx="<html>"+"Request<br>"+zz+"<br>Response<br>Status:"+res.getStatus()+"<br> Version: "+res.getVersion()+"<br> TimeStamp: "+res.getTimestamp()+"<br> Format :"+res.getFormat()+"<br> Connection:"+res.getConnection()+"</html>";
									out.writeUTF(xx);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					
					if(req.CheckConnection()==false){
						System.out.println("here");
						try {
							this.out.writeUTF("quit");
							in.close();
							out.close();
							server.clients.remove(this);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
					
					
					processingQueue.remove(0);
						
}
				
		

		
		
		
		
		
		
		
	
	
	public void run(){
		 try {
			in=new DataInputStream(socket.getInputStream());
			out=new DataOutputStream(socket.getOutputStream());
			
			while(ShouldRun){
				try{
				String textin=in.readUTF();
				StringTokenizer st=new StringTokenizer(textin," ");
				String method="";
				String URL="";
				String Host="";
				String AcceptedFormat="";
				String Connection="";
				
				if(st.hasMoreTokens()){
					 method=st.nextToken();
					if(st.hasMoreTokens()){
						URL=st.nextToken();
					if(st.hasMoreTokens()){
						Host=st.nextToken();
					if(st.hasMoreTokens()){
						AcceptedFormat=st.nextToken();
					if(st.hasMoreTokens()){
						Connection=st.nextToken();
										}
								}
						   
						}
					}
				}
					else{
						System.out.println("Please enter a vaild message");
					}
			
				
			
		   switch (method){
			 case "Join":
				if(URL.equals("")){
					out.writeUTF("Please enter a username:");
					break;
				}
				this.JoinReresponse(URL);
				break;
			case "Get":
				if(join){
					requests req=new requests(method, URL,1.1, Host, AcceptedFormat, Connection);
					processingQueue.add(req);
//					out.writeUTF("Request");
//					out.writeUTF("Method:"+" "+processingQueue.get(0).getMethod());
//					out.writeUTF("URL:" +" "+ processingQueue.get(0).getURL());
//					out.writeUTF("Version:" +" "+ processingQueue.get(0).getVersion());
//					out.writeUTF("Host:"+" "+processingQueue.get(0).getHost());
//					out.writeUTF("Accepted Format:"+" "+processingQueue.get(0).getAcceptedFormat());
//					out.writeUTF("Connection:"+" "+processingQueue.get(0).getConnections());
//					
					//////////////////////////////////////
				
//					System.out.println(" ");
//					System.out.println("Request");
//					System.out.println("Method:"+" "+processingQueue.get(0).getMethod());
//					System.out.println("URL:" +" "+ processingQueue.get(0).getURL());
//					System.out.println("Version:" +" "+ processingQueue.get(0).getVersion());
//					System.out.println("Host:"+" "+processingQueue.get(0).getHost());
//					System.out.println("Accepted Format:"+" "+processingQueue.get(0).getAcceptedFormat());
//					System.out.println("Connection:"+" "+processingQueue.get(0).getConnections());
//						
						
				
					ProcessRequest();
				}
				else{
					out.writeUTF("Please enter your username:");
				}
				break;
			default:
				out.writeUTF("Please enter a Valid HTTP Request.");
				break;
			   }
		   
			}catch(SocketException e){
				socket.close();
			}
				
		  }
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
}
	
		
public void setUsrename(String usrename) {
		this.usrename = usrename;
}
	



}
