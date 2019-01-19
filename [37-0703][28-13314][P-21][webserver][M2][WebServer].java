import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class WebServer {

    static ArrayList <Connections> clients  = new ArrayList<Connections>();
	ServerSocket serverSocket;
	boolean ShouldRun=true;
	
	
	public static void main(String[] args) {
		new WebServer();
	}
	
	public WebServer (){
		try {
			serverSocket= new ServerSocket(8080);
			while(ShouldRun){
				//accept this connection
				Socket socket=serverSocket.accept();
				//create a connection with a client name
				Connections sc=new Connections(socket, this);
				sc.start();
				//add the client to the list
				clients.add(sc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
