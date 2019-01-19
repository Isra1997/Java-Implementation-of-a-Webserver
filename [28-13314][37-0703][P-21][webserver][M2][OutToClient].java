	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.Socket;
public class OutToClient extends Thread{
	Socket s;
	DataInputStream fromserver;
	ClientWindow client;
	boolean ShouldRun=true;
	String reply;
	String FinalReply;

	public OutToClient(ClientWindow client,Socket s){
		try {
			fromserver=new DataInputStream(s.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.client=client;
		this.s=s;
	}

	public void close(){
		try {
			s.close();
			fromserver.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run(){
		while(ShouldRun){
			
			try {
				String x=fromserver.readUTF();
				if(Character.toString(x.charAt(0)).equals("R")){
					StringBuilder sb=new StringBuilder(x);
					sb.deleteCharAt(0);
					reply=sb.toString();
					System.out.println(reply);
					break;
				}
				else{
					reply=x;
				}
				System.out.println(reply);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//	  System.out.println("Your are now offline :/");
	  this.close();
		
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}
	
	

	}



