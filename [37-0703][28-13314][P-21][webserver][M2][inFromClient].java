	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.Socket;
	import java.net.UnknownHostException;
	import java.util.Scanner;
	import java.util.StringTokenizer;
public class inFromClient extends Thread {



	Socket s;
	DataOutputStream toserver;
	ClientWindow client;
	boolean ShouldRun=true;
	boolean notnamed=false;
	String inFromUser="";
	String tokens;


	

	public inFromClient(ClientWindow client,Socket s){
//		System.out.println("Please enter your username:");
		this.client=client;
		this.s=s;	
	}

	//sends the join method to server
	public void Join(String input){
		try {
			toserver.writeUTF(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//sends the message to the server
	public void Chat(String Message){
		try {
			toserver.writeUTF(Message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//gets the list of the clients
	public void GetMemberList(){
		try {
			toserver.writeUTF("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//closes all the connections with the server
	public void close(){
		try {
			toserver.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void quit(){
		try {
			toserver.writeUTF("quit");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getInFromUser() {
		return inFromUser;
	}

	public void setInFromUser(String inFromUser) {
		this.inFromUser = inFromUser;
	}
	
	

	//waits for the reply from the server
	public void run(){
		try {
			toserver=new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(ShouldRun){
//			Scanner console=new Scanner(System.in);
//			String input=console.nextLine();
			StringTokenizer st=new StringTokenizer(inFromUser," ");
			String Token1="";
	if(st.hasMoreTokens()){
		Token1=st.nextToken();
		}

			switch (Token1) {
			case "Join":
				Join(inFromUser);
				inFromUser="";
				break;
			case "list":
				GetMemberList();
				inFromUser="";
				break;
			case "quit":
				quit();
				inFromUser="";
				break;
			case "Get":
			   Chat(inFromUser);
			   inFromUser="";
			   break;
			case "":
				break;
			default:
				try {
					toserver.writeUTF("error");
				} catch (IOException e) {
					e.printStackTrace();
				}
			  break;
			}
		
		}
		
	}







	}

