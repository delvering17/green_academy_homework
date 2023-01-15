package Q;

import java.io.FileInputStream;
import java.util.Arrays;


class FileMember {
	String id ; 
	int age ;
	boolean marriage;
	
	
	public FileMember(String ttt) {
		
		
		String [] arr = ttt.split(",");  // mac은 \r이 없어야한다. \r - 커서를 맨 앞으로 보내라  win - "\r\n"
		//System.out.println("생성자: " + Arrays.toString(arr));
		id = arr[0];
		age = Integer.parseInt(arr[1]);
		marriage = Boolean.parseBoolean(arr[2]);
	
		
	}
	
	
	@Override
	public String toString() {
		return "FileMember [id=" + id + ", age=" + age + ", marriage=" + marriage + "]";
	}
	
	
	
	
	
}


public class FileMemberMainQQQ {

	public static void main(String[] args) {
		String [] aaa ;
		String ttt = "";
		try {
			FileInputStream fis = new FileInputStream("fff/qqq2.txt");
			
			
			int data;
			while((data = fis.read()) != -1) {
				//System.out.print((char)data);
				for (int j = 0 ; (data = fis.read()) != -1; j++) {
					
					ttt += (char)data;
		
					
			
				}
				
			}
			
		
			
		
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println(ttt);
		aaa = ttt.split("\n");
		
		for (int i = 0 ; i < aaa.length ; i ++) {
			
			System.out.println(new FileMember(aaa[i]));
			
		}
		
	
	}
}
