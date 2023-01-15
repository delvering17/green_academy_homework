package net_p;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class TCPMulFrame extends JFrame implements ActionListener{
	
	String name;
	ObjectOutputStream dos;
	ObjectInputStream dis;
	
	JTextArea ta;
	JTextField tf;
	JComboBox<String> dstTF;
	
	class TCPSingleReceiver extends Thread{
		
		@Override
		public void run() {
			try {
				TCPChatData first = new TCPChatData();
				first.src = name;
				first.dst = "서버";
				first.msg = "서버는 처음이야";
				dos.writeObject(first);
				dos.flush();
				dos.reset();
				
				while(dis!=null) {
					
					TCPChatData data = (TCPChatData)dis.readObject();
					System.out.println(data);
					
					if(data.dst.equals("서버")) {
						//화면을 갱신해주셈
						dstTF.removeAllItems();
						dstTF.addItem("a");
						
						for (String vv: data.mems) {
							dstTF.addItem(vv);	
						}
						
						getContentPane().revalidate();
					}
					
					
					if(name.equals(data.src)) {
						ta.append("[나]"+data.msg+"\n");
					}else {
						ta.append("["+data.src+"]"+data.msg+"\n");
					}
					
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public TCPMulFrame(Socket soc, String name) {
		super(name);
	
		try {
			//name = "["+InetAddress.getLocalHost()+"]";
			this.name =  name;
			dos = new ObjectOutputStream(soc.getOutputStream());
			dis = new ObjectInputStream(soc.getInputStream());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setBounds(1920+50, 50, 400,500);
		ta = new JTextArea();
		ta.setEditable(false);
		
		tf = new JTextField();
		
		Vector<String>items = new Vector<String>(); 
		items.add("a");

		
		dstTF = new JComboBox<String>(items);				// 클라이언트 닉네임들
		dstTF.setPreferredSize(new Dimension(100, 50));
		
		tf.setPreferredSize(new Dimension(270, 50));
		
		
		add(new JScrollPane(ta),"Center");
		JPanel jp = new JPanel();
		
		jp.add(dstTF);
		jp.add(tf);
		add(jp,"South");
		
		setVisible(true);
		
		tf.requestFocus();
		tf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		new TCPSingleReceiver().start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//ta.setCaretPosition(ta.getDocument().getLength());
		try {
			//dos.writeUTF(msg);
			TCPChatData data = new TCPChatData();
			
			//String [] arr = msg.split("_");
			//data.dst = arr[0];
			//data.msg = arr[1];
			
			data.src = name;
			data.dst = (String)dstTF.getSelectedItem();
			data.msg = tf.getText();
			
			dos.writeObject(data);
			dos.flush();
			dos.reset();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		tf.setText("");
		tf.requestFocus();
	
	}
}


public class TCPMulClientMain {
	public static void main(String[] args) {
		
		try {
			
			// 참고 Notion 정리 - OptionPane
			String name = JOptionPane.showInputDialog("사용할 닉네임 입력해주세요", "전현우");
			String addr = JOptionPane.showInputDialog("IP를 입력해주세요", "192.168.20.28");
			int portNum =  Integer.parseInt(JOptionPane.showInputDialog("port번호를 입력해주세요", "8888"));
			
			Socket socket = new Socket(addr, portNum);
			System.out.println("클라이언트 : "+addr+"접속 성공");
		
			// 참고 Notion 정리 - OptionPane
			
			
			new TCPMulFrame(socket,name);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// 1. JPanel 만들기 
// 2. TextField 3개 (이름, ip, port)
// 3. 연결과 연결해제 버튼 만들기
// 4. actionlistener로 연결해서 만약 연결을 누르면 연결 해제로 바뀌게 하기 (remove와 add)
// 4-1. 이때 repaint()를 넣어준 패널에 해줘야한다 찬욱아
// 4-2. actionlistener에 연결을 누르게 되면 그 적용값(TextField)을 getText()로 소켓과 프레임을 연결시킴
// 4-3. 연결 해제 시, 소켓.close()로 닫아버림. 다음 연결을 위해 연결 버튼 활성화
// 4-4. 이 연결하는 자체가 while()로 돌려서 if 통신이 끊겼다면 새로 프레임을 가져오거나 or 그 채팅 패널을 새로고침하거나







