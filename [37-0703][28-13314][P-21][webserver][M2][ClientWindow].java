import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.util.StringTokenizer;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.JRadioButton;
import javax.swing.JEditorPane;


public class ClientWindow {
	Socket s;
	inFromClient in;
	OutToClient out;
	String connection="Keep-alive";
	static boolean flag= true ;
	boolean close=true;
	boolean createdOnce=false;
	JLabel reply;
	private JFrame frame;
	private JTextField textField;
	private JTextField txtPleaseEnterYour;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow window = new ClientWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientWindow() {
		initialize();
		try {
			s=new Socket("Isras-MacBook-Pro.local",8080);
		    in=new inFromClient(this,s);
		    out=new OutToClient(this, s);
			in.start();
			out.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 21, 720, 482);
		frame.getContentPane().add(panel);
		JLabel respone=new JLabel("Please enter your username:");
		panel.add(respone);
		panel.revalidate();
		
		JButton btnImagejpeg_1 = new JButton("Image2.JPEG");
		btnImagejpeg_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image2.JPEG Isra'sWebserver JPEG "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image2.JPEG");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				String reply=out.getReply();
				JLabel respone=new JLabel(reply);
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		
		btnImagejpeg_1.setBounds(207, 527, 117, 29);
		frame.getContentPane().add(btnImagejpeg_1);
		
		JButton btnImagejpeg = new JButton("Image1.JPEG");
		btnImagejpeg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((connection.equals("Keep-alive")) || (close==true)){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image1.JPEG Isra'sWebserver JPEG "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image1.JPEG");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		
		btnImagejpeg.setBounds(55, 527, 117, 29);
		frame.getContentPane().add(btnImagejpeg);
		
		JButton btnImagepng = new JButton("Image3.PNG");
		btnImagepng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image3.PNG Isra'sWebserver PNG "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image3.PNG");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		btnImagepng.setBounds(348, 527, 117, 29);
		frame.getContentPane().add(btnImagepng);
		
		JButton btnImagepng_1 = new JButton("Image4.PNG");
		btnImagepng_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image4.PNG Isra'sWebserver PNG "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Image4.PNG");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		btnImagepng_1.setBounds(494, 527, 117, 29);
		frame.getContentPane().add(btnImagepng_1);
		
		JButton btnTexttxt = new JButton("text1.txt");
		btnTexttxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text1.txt Isra'sWebserver txt "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text1.txt");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		btnTexttxt.setBounds(623, 527, 117, 29);
		frame.getContentPane().add(btnTexttxt);
		
		JButton btnTexttxt_1 = new JButton("text2.txt");
		btnTexttxt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text2.txt Isra'sWebserver txt "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text2.txt");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		btnTexttxt_1.setBounds(55, 573, 117, 29);
		frame.getContentPane().add(btnTexttxt_1);
		
		JButton btnTexttxt_2 = new JButton("text3.txt");
		btnTexttxt_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text3.txt Isra'sWebserver txt "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text3.txt");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		btnTexttxt_2.setBounds(207, 573, 117, 29);
		frame.getContentPane().add(btnTexttxt_2);
		
		JButton btnTexttxt_3 = new JButton("text4.txt");
		btnTexttxt_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive")  || close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text4.txt Isra'sWebserver txt "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/Text4.txt");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
			}
		});
		btnTexttxt_3.setBounds(348, 573, 117, 29);
		frame.getContentPane().add(btnTexttxt_3);
		
		JButton btnMpmp = new JButton("MP41.mp4");
		btnMpmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") ||close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/MP41.mp4 Isra'sWebserver mp4 "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/MP41.mp4");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
				 close=false;
				}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		btnMpmp.setBounds(494, 573, 117, 29);
		frame.getContentPane().add(btnMpmp);
		
		JButton btnMpmp_1 = new JButton("MP42.mp4");
		btnMpmp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") ||close==true){
				in.setInFromUser("Get /Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/MP42.mp4 Isra'sWebserver mp4 "+connection);
				File file = new File("/Users/israragheb/Desktop/NetworksLab/Project2/DocRoot/MP42.mp4");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
				
				
			}
		});
		btnMpmp_1.setBounds(623, 573, 117, 29);
		frame.getContentPane().add(btnMpmp_1);
		
		txtPleaseEnterYour = new JTextField();
		txtPleaseEnterYour.setText("Please enter Your username :)");
		txtPleaseEnterYour.setBounds(24, 625, 203, 26);
		frame.getContentPane().add(txtPleaseEnterYour);
		txtPleaseEnterYour.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connection.equals("Keep-alive") || close==true){
					txtPleaseEnterYour.revalidate();
					txtPleaseEnterYour.revalidate();
					String name=txtPleaseEnterYour.getText();
				in.setInFromUser("Join "+name);
				JLabel respone=new JLabel(out.getReply());
				panel.add(respone);
				panel.revalidate();
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
			
		});
		btnEnter.setBounds(239, 625, 117, 29);
		frame.getContentPane().add(btnEnter);
		
		textField_1 = new JTextField();
		textField_1.setBounds(396, 625, 192, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOtherUrl = new JButton("Other URL");
		btnOtherUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				if(connection.equals("Keep-alive") || close==true){
				String URL=textField_1.getText();
				in.setInFromUser("Get "+URL+" Isra'sWebserver mp4 "+connection);
				
				JLabel respone=new JLabel(out.getReply());
				panel.removeAll();
				panel.add(respone);
				panel.revalidate();
				
				File file = new File(URL);
				Desktop desktop = Desktop.getDesktop();
				if(file.exists()){
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}
				
				if(connection.equals("close")){
					 close=false;
					}
				}
				else{
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		btnOtherUrl.setBounds(623, 625, 117, 29);
		frame.getContentPane().add(btnOtherUrl);
		
		JRadioButton rdbtnCloseConnection = new JRadioButton("Close Connection");
		rdbtnCloseConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection="close";
			}
		});
		rdbtnCloseConnection.setBounds(24, 682, 181, 23);
		frame.getContentPane().add(rdbtnCloseConnection);
		

		
		
		
	
		
		
	}
}
