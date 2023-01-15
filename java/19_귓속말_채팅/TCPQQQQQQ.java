package Q;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class TCPQQQQQQ {

	ArrayList<DataOutputStream> list;
	ArrayList<String> ipip;
	public TCPQQQQQQ() {
		try {
			list = new ArrayList<DataOutputStream>();
			
			ServerSocket server = new ServerSocket(8888);
			System.out.println("서버시작");
			
			while(true) {
				
				Socket client = server.accept();
		
				
				new TCPMulSeverReceiver(client).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	class TCPMulSeverReceiver extends Thread{
		
		DataInputStream dis;
		DataOutputStream dos;
		String name;
		
		public TCPMulSeverReceiver(Socket client) {
			try {
				
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());
				name = client.getInetAddress()+ "";
				
				System.out.println(name + "접속");
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				
				//System.out.println("서버 리시버 시작");
				
				sendToAll(name + " 접속");
				list.add(dos);
				ipip.add(dos.toString());
				sendToAll("[현재 접속자 수]" + list.size());
				
				while(dis != null) {
				
						sendToAll(dis.readUTF());
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally {
				
				list.remove(dos);
				sendToAll(name + " 퇴장");
			}
			
			
		}
	}
	
	void sendToAll(String msg) {
		
		for (DataOutputStream dd : list) {
			
			try {
				dd.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new TCPQQQQQQ();

	}

}



