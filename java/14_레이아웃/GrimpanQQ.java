package Q;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class GrimpanQQ extends JFrame {

	public GrimpanQQ (String name) {
		super(name);
		setBounds(600,250, 1000, 700);
		setLayout(null);
// 메인 메뉴 
		JMenuBar mainMenu = new JMenuBar();  
		setJMenuBar(mainMenu);
		
		// 메뉴 바 구성
		JMenu firMenu = new JMenu("파일");
		JMenu secMenu = new JMenu("홈");
//		JMenu thiMenu = new JMenu("보기");
		
		mainMenu.add(firMenu);
		mainMenu.add(secMenu);
	//	mainMenu.add(thiMenu);
		
	// firMenu "파일"
		JMenuItem fm_newFile = new JMenuItem("새로 만들기");
		firMenu.add(fm_newFile);
		fm_newFile.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_N, 
						KeyEvent.CTRL_MASK)			
				);
		
		
		JMenuItem fm_openFile = new JMenuItem("열기", new ImageIcon("fff/folder_clear.png"));
	//	JFrame fm_openFileWindow = new JFrame("열기");
	//	FileDialog fd = new FileDialog(fm_openFileWindow, "열기",  FileDialog.LOAD);	
	//  파일열기를 하려 했으나 버튼을 누르면 창이 열리는 구현을 못함
		fm_openFile.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_O, 
						KeyEvent.CTRL_MASK)			
				);
		firMenu.add(fm_openFile);
		
		JMenuItem fm_saveFile = new JMenuItem("저장", new ImageIcon("fff/card.png"));
		fm_saveFile.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_S, 
						KeyEvent.CTRL_MASK)			
				);
	
		firMenu.add(fm_saveFile);
		
		JMenu fm_otherSaveFile = new JMenu("다른 이름으로 저장");
		
		firMenu.add(fm_otherSaveFile);
		
		
		JMenuItem otherSaveName_PNG = new JMenuItem("PNG 그림");
		JMenuItem otherSaveName_JPG = new JMenuItem("JPG 그림");
		JMenuItem otherSaveName_BMP = new JMenuItem("BMP 그림");
		JMenuItem otherSaveName_GIF = new JMenuItem("GIF 그림");
		JMenuItem otherSaveName_otherFormat = new JMenuItem("다른 포맷");
		fm_otherSaveFile.add(otherSaveName_PNG);
		fm_otherSaveFile.add(otherSaveName_JPG);
		fm_otherSaveFile.add(otherSaveName_BMP);
		fm_otherSaveFile.add(otherSaveName_GIF);
		fm_otherSaveFile.add(otherSaveName_otherFormat);
		
		firMenu.addSeparator();

		
		JMenu fm_print = new JMenu("인쇄");
		firMenu.add(fm_print);
		
		
		
		
		JMenuItem print_print = new JMenuItem("인쇄", new ImageIcon("fff/printer.png"));
		JMenuItem print_pageSet = new JMenuItem("페이지 설정");
		JMenuItem print_preview = new JMenuItem("미리보기");
		fm_print.add(print_print);
		fm_print.add(print_pageSet);
		fm_print.add(print_preview);
		
		JMenuItem fm_scannerOrCamera = new JMenuItem("스캐너 또는 카메라");
		firMenu.add(fm_scannerOrCamera);
		fm_scannerOrCamera.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_M, 
						KeyEvent.CTRL_MASK)			
				);
		
		
		
		JMenuItem fm_emailSend = new JMenuItem("전자 메일로 보내기");
		firMenu.add(fm_emailSend);
		fm_emailSend.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_D, 
						KeyEvent.CTRL_MASK)			
				);
		
		
		firMenu.addSeparator();
		
		JMenu fm_wallpaperSet = new JMenu("바탕 화면 배경으로 설정");
		firMenu.add(fm_wallpaperSet);
		fm_wallpaperSet.setEnabled(false);
		
		firMenu.addSeparator();
		
		JMenuItem fm_attribute = new JMenuItem("속성");
		firMenu.add(fm_attribute);
		fm_attribute.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_E, 
						KeyEvent.CTRL_MASK)			
				);
		
		
		firMenu.addSeparator();
		
		JMenuItem fm_panInfo = new JMenuItem("그림판 정보");
		fm_panInfo.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_T, 
						KeyEvent.CTRL_MASK)			
				);
		
		
		firMenu.addSeparator();
		
		JMenuItem fm_endButton = new JMenuItem("끝내기");
		firMenu.add(fm_endButton);
		fm_endButton.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_X, 
						KeyEvent.CTRL_MASK)			
				);
	
	

		
		JPanel tm_zoom = new JPanel();
		tm_zoom.setBounds(0, 0, 200, 60);
		tm_zoom.setBackground(Color.gray); 
		tm_zoom.setLayout(new GridLayout(1,3));  
		add(tm_zoom);
		
		tm_zoom.add(new JButton("확대", new ImageIcon("fff/plus_alt.png")));
		tm_zoom.add(new JButton("축소", new ImageIcon("fff/minus_alt.png")));
		tm_zoom.add(new JButton("100%"));
		
		
		JPanel tm_showHide = new JPanel();
		tm_showHide.setBounds(200, 0, 150, 60);
		tm_showHide.setBackground(Color.gray); 
		tm_showHide.setLayout(new GridLayout(3,1));  
		add(tm_showHide);
	
	
		JCheckBoxMenuItem showHide_scale = new JCheckBoxMenuItem("눈금자");
		showHide_scale.setBackground(Color.gray); 
		JCheckBoxMenuItem showHide_grid = new JCheckBoxMenuItem("격자");
		showHide_grid.setBackground(Color.gray); 
		JCheckBoxMenuItem showHide_statusBar = new JCheckBoxMenuItem("상태 표시줄");
		showHide_statusBar.setBackground(Color.gray); 
		tm_showHide.add(showHide_scale);
		tm_showHide.add(showHide_grid);
		tm_showHide.add(showHide_statusBar);
		
		JPanel tm_showShow = new JPanel();
		tm_showShow.setBounds(350, 0, 150, 60);
		tm_showShow.setBackground(Color.gray); 
		tm_showShow.setLayout(new GridLayout(1,2));  
		add(tm_showShow);
	
		tm_showShow.add(new JButton("전체화면"));
		tm_showShow.add(new JButton("미리 보기"));
		
		
		
		JPanel pan = new JPanel();
		pan.setBackground(Color.white);
		pan.setBounds(0, 60, 1000, 640);
		add(pan);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		
		new GrimpanQQ("그림판");

	}

}









