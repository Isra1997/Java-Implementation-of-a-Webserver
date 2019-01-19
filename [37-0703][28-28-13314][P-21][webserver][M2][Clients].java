	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.Socket;
	import java.nio.Buffer;
	import java.util.ArrayList;
	import java.util.Scanner;

	import javax.sound.sampled.ReverbType;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextArea;

public class Clients{
	Socket s;
	inFromClient in;
	OutToClient out;
	static boolean flag= true ;
	boolean createdOnce=false;
	
	
	public static void main(String[] args) {
			new Clients();
	}



	public Clients(){
		try {
			s=new Socket("Isras-MacBook-Pro.local",8080);
//		    in=new inFromClient(this,s);
//		    out=new OutToClient(this, s);
			in.start();
			out.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	}
		
		
		






