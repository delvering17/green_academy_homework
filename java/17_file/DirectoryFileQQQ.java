package Q;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.regex.Pattern;

public class DirectoryFileQQQ {

	class FileCon {

		String imageNameCon = ".*(bmp|jpg|gif|png|jpeg)";
		String musicNameCon = ".*(mp3|wma|wav)";
		String doNameCon = ".*(doc|hwp|ppt|xls|pptx|xlsx|docs)";
		String[] concon = "image/,music/,document/,guitar/".split(",");
		int no = 0 ;
		public FileCon(File ff) throws Exception {
			//이미지
			if (Pattern.matches(imageNameCon, ff.getName().toLowerCase())) {
				new Cons(ff, concon[0]);
			// 음악
			} else if (Pattern.matches(musicNameCon, ff.getName().toLowerCase())) {
				new Cons(ff, concon[1]);
			// 문서	
			} else if (Pattern.matches(doNameCon, ff.getName().toLowerCase())) {
				new Cons(ff, concon[2]);
			// 기타	
			} else {
				new Cons(ff, concon[3]);
			}
		}
		
		

	}
	
	
	class FolderCon {
		
		public FolderCon(File ff) throws Exception {
		
			File[] arr = ff.listFiles();
			
			
			for (File aa : arr) {

				if (aa.isFile()) {
					new FileCon(aa);
				} else {
					new FolderCon(aa);
					
				}
			}

			
			

		} 
	}
	
	class Cons {
		
	
		public Cons(File ff, String concon) throws Exception {
			FileInputStream fis = new FileInputStream(ff);
			byte [] arr = new byte[(int)ff.length()];
			FileOutputStream fos = new FileOutputStream(concon+ff.getName());
			
			fis.read(arr);
			fos.write(arr);
			
			fos.close();
			fis.close();
		}
	}
	
	
	
	public DirectoryFileQQQ() throws Exception {
		
		File[] arr = new File("gogogo").listFiles();
		
		new File("image").mkdir();
		new File("music").mkdir();
		new File("document").mkdir();
		new File("guitar").mkdir();
		
		for (File ff : arr) {
			
			if (ff.isFile()) {			// 파일거르기
				new FileCon(ff);
			} else {					// 폴더 거르기
				new FolderCon(ff);
			}
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		

		new DirectoryFileQQQ();
		
	}

}
//지정한 폴더의 파일을 각각 종류별로 지정 폴더에 저장하시오

/// 하위 폴더까지 검색하세요

/// 같은 파일명인 경우 중복 처리 하세요

//이미지 : bmp, jpg, gif, png , jpeg

//음악 : mp3, wma, wav

//문서 :doc, hwp, ppt, xls, pptx, xlsx. docx

//기타 : 위의 분류 이외

//확장자의 대소문자 구분하지 않음