package Q;

import java.awt.Color;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignUpQQQ {

	public static void main(String[] args) {
		JFrame f = new JFrame("회원가입");
		f.setBounds(400,200,1000,800);
		f.setLayout(null);
		
		JLabel tttitle = new JLabel("회원가입");
		tttitle.setBounds(100,10, 100, 50);
		f.add(tttitle);
		
		// 아이디
		JLabel ttid = new JLabel("아이디");
		ttid.setBounds(50, 50, 100, 20);
		f.add(ttid);
		JTextField id = new JTextField();
		id.setBounds(100, 50, 100, 20);
		f.add(id);
		// 비밀번호
		JLabel ttpw = new JLabel("비밀번호");
		ttpw.setBounds(50, 80, 100, 20);
		f.add(ttpw);
		JPasswordField pw = new JPasswordField();
		pw.setBounds(100, 80, 100, 20);
		f.add(pw);
	
		// 성별		 남 여 해당없음 
		JLabel ttgender = new JLabel("성별");
		ttgender.setBounds(50, 130, 100, 20);
		f.add(ttgender);
		JRadioButton gender1 = new JRadioButton("남");
		JRadioButton gender2 = new JRadioButton("여");
		JRadioButton gender3 = new JRadioButton("해당없음");
		gender1.setBounds(100, 130, 100, 20);
		gender2.setBounds(200, 130, 100, 20);
		gender3.setBounds(300, 130, 100, 20);
		f.add(gender1);
		f.add(gender2);
		f.add(gender3);
		
		ButtonGroup genderbg = new ButtonGroup();
		genderbg.add(gender1);
		genderbg.add(gender2);
		genderbg.add(gender3);
		
		// 민트 초코를 좋아합니까?
		JLabel mincho = new JLabel("민트초코");
		mincho.setBounds(50, 160, 100, 20);
		f.add(mincho);
		JRadioButton mincho1 = new JRadioButton("좋아합니다");
		JRadioButton mincho2 = new JRadioButton("사랑합니다");
		JRadioButton mincho3 = new JRadioButton("밥도둑");
		mincho1.setBounds(100, 160, 100, 20);
		mincho2.setBounds(200, 160, 100, 20);
		mincho3.setBounds(300, 160, 100, 20);
		f.add(mincho1);
		f.add(mincho2);
		f.add(mincho3);
		
		ButtonGroup minchobg = new ButtonGroup();
		genderbg.add(mincho1); 
		genderbg.add(mincho2);
		genderbg.add(mincho3);

		//	생년월일
		JLabel ttbirth = new JLabel("생년월일");
		ttbirth.setBounds(50, 200, 100, 20);
		f.add(ttbirth);
		
		Vector<String> birth  = new Vector<String>();	
		birth.add("2022년");
		birth.add("BC 100");
		birth.add("방금");
		birth.add("금방");
		
		
		JComboBox<String> box = new JComboBox<String>(birth);
		box.setBounds(100, 200, 100, 20);
		f.add(box);
		
		JTextArea month = new JTextArea();
		month.setBounds(210, 200, 50, 20);
		f.add(month);
		JTextArea date = new JTextArea();
		date.setBounds(270, 200, 50, 20);
		f.add(date);
		
		
		// 전화 번호 010 011 070
		JLabel ttphone = new JLabel("핸드폰");
		ttphone.setBounds(50, 240, 100, 20);
		f.add(ttphone);
		
		Vector<String> phone  = new Vector<String>();	
		phone.add("010");
		phone.add("011");
		phone.add("016");
		phone.add("070");
		
		
		JComboBox<String> phonebox = new JComboBox<String>(phone);
		phonebox.setBounds(100, 240, 100, 20);
		f.add(phonebox);
		
		JTextArea middle = new JTextArea();
		middle.setBounds(210, 240, 50, 20);
		f.add(middle);
		JTextArea end = new JTextArea();
		end.setBounds(270, 240, 50, 20);
		f.add(end);
		
		// 주소
		
		JLabel ttaddress = new JLabel("주소");
		ttaddress.setBounds(50, 300, 100, 20);
		f.add(ttaddress);
		
		JTextArea areaaddress = new JTextArea("주소입력");
		JScrollPane addressts = new JScrollPane(areaaddress);
		addressts.setBounds(110, 300, 300, 30);
		f.add(addressts);
	
		// 이메일  @naver.com daum.com hanmail.com 
		JLabel ttemail = new JLabel("이메일");
		ttemail.setBounds(50, 340, 100, 20);
		f.add(ttemail);
		
		JTextArea emailfirst = new JTextArea();
		emailfirst.setBounds(110, 340, 100, 20);
		f.add(emailfirst);
	
	
		Vector<String> domain  = new Vector<String>();	
		domain.add("@naver.com");
		domain.add("@daum.com");
		domain.add("@hanmail.net");
	
		JComboBox<String> domainbox = new JComboBox<String>(domain);
		domainbox.setBounds(220, 340, 150, 20);
		f.add(domainbox);
		
		// 회원가입 버튼
	
		ImageIcon aa = new ImageIcon("fff/IMG_0430.jpeg");
		
		JButton b4 = new JButton("완료", aa);			// JButten(txt) 버튼 나옴 
		b4.setBounds(270, 500, 200, 200);

		b4.setOpaque(true);
		b4.setBorderPainted(false);
		b4.setVerticalTextPosition(0);
		b4.setHorizontalTextPosition(0);

		f.add(b4);
		
		
		f.setVisible(true);							
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

}
