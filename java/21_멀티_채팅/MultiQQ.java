package net_p;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiQQ extends JFrame {
	JTextArea ta ;
	JTextField tf ; 
	
	JTextField ip;
	JTextField port;
	JTextField name;
	JButton button_connect;
	InetAddress sender_addr;
	MulReceiver receiver;
	
	MulticastSocket sender_socket = null;
	
	public MultiQQ() {
		setBounds(50,50, 400, 600);
		
		
		JPanel np = new JPanel();
		
		ip = new JTextField("230.0.0.1");
		port = new JTextField("8888");
		name = new JTextField("전현우");
		button_connect = new JButton("연결");
		
		np.add(ip);
		np.add(port);
		np.add(name);
		np.add(button_connect);
		
		add(np, "North");
		
		
		ta = new JTextArea();
		ta.setEditable(false);
		
		add(new JScrollPane(ta),"Center");
		
			
		tf = new JTextField();
	
		add(tf, "South");
				
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 사용자 채팅 입력 하는 곳 
				// 근데 왜 if에 연결 종료인데 true에 입력하는 거가 들어가냐
				// => 알고보니 채팅 활성화 시에는 버튼이 "연결 종료" 상태인게 맞는거임
				if(button_connect.getText().equals("연결해제")) {
					
					try {
						
						byte [] buf = tf.getText().getBytes();
						
						
						DatagramPacket data = new DatagramPacket(
								buf,
								buf.length,
								sender_addr,
								Integer.parseInt(port.getText())
								);
						
						sender_socket.send(data);
						
						ta.append("[나]: " + tf.getText()+"\n");
						ta.setCaretPosition(ta.getDocument().getLength());
						
						tf.setText("");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
				}
				
				
				
			}
			
		}) ;
		
		button_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (button_connect.getText().equals("연결")) {
					
					try {
						
						sender_socket = new MulticastSocket();
						sender_addr = InetAddress.getByName(ip.getText());
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					receiver = new MulReceiver();
					receiver.start();
					
					ip.setEditable(false);
					port.setEditable(false);
					
					button_connect.setText("연결해제");
					
					tf.setEditable(true);
					tf.requestFocus();
					
					
				} else {
					
					sender_socket.close();
					sender_socket = null;
					
					receiver.stop();
					receiver.ms.close();
					receiver.ms = null;
					
					ip.setEditable(true);
					port.setEditable(true);
					
					button_connect.setText("연결");
					
					tf.setEditable(false);
				
					
				}
				
			}
		});
		
		
		
	}
	
	
	class MulReceiver extends Thread {
		MulticastSocket ms = null;
		InetAddress addr = null;
		
		@Override
		public void run() {
		
			try {
				ms = new MulticastSocket(Integer.parseInt(port.getText()));
				addr = InetAddress.getByName(ip.getText());
				ms.joinGroup(addr);
				
				
				while (true) {
				// 받아와서 보이기
					byte [] buf = new byte[1024];
					DatagramPacket data = new DatagramPacket(buf, buf.length);
					ms.receive(data);
					
					String msg = new String(buf);
					
					ta.append(data.getAddress()+":"+msg+"\n");
					// append() 문자열 뒤에 추가
					ta.setCaretPosition(ta.getDocument().getLength());
					// 맨 아래로 스크롤
					// 참고 api
					// https://docs.oracle.com/javase/7/docs/api/javax/swing/text/JTextComponent.html
					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ms.leaveGroup(addr);
					ms.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			

		}
	}
	
	public static void main(String[] args) {

		new MultiQQ();
	}
}







