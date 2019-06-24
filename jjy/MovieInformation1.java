package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovieInformation1 extends JPanel {

	ImageIcon m1;
	JButton btn1;
	MovieInfoText movieInfoText;

	public MovieInformation1() {
//		super(str);
		m1 = new ImageIcon("src\\javagers\\image\\m1.jpg");
		String imgPath1 = "src\\javagers\\image\\m1.jpg";
		btn1 = new JButton();
		movieInfoText = new MovieInfoText();
		movieInfoText.setPreferredSize(new Dimension(890, 100));
		
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1= originImg1.getScaledInstance(210, 200, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		btn1.setIcon(Icon1);		//버튼에 이미지 설정
		btn1.setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.add("West",btn1);
		this.add("East",movieInfoText);
//		this.setSize(1200, 400);
//		this.setPreferredSize(new Dimension(1200,700));
//		this.setLocation(180, 80);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
//		new MovieInformation1("영화정보 테스트1");
	}
	
}


	class MovieInformation2 extends JPanel{
	
	ImageIcon m2;
	JButton btn1;
	MovieInfoText2 movieInfoText;
	
	public MovieInformation2() {
//		super(str);
		m2 = new ImageIcon("src\\javagers\\image\\m2.jpg");
		String imgPath1 = "src\\javagers\\image\\m2.jpg";
		btn1 = new JButton();
		movieInfoText = new MovieInfoText2();
		movieInfoText.setPreferredSize(new Dimension(890, 100));
		
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1= originImg1.getScaledInstance(210, 200, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		btn1.setIcon(Icon1);		
		btn1.setBackground(Color.black);
		this.setLayout(new BorderLayout());
		this.add("West",btn1);
		this.add("East",movieInfoText);
//		this.setSize(1200, 800);
		this.setPreferredSize(new Dimension(1200, 700));
//		this.setLocation(180, 80);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
//	public static void main(String[] args) {
//		new MovieInformation2("영화정보 테스트2");
//	}
	
}
	
	class MovieInformation3 extends JPanel{

		ImageIcon m3;
		JButton btn1;
		MovieInfoText3 movieInfoText;
		
		public MovieInformation3() {
//			super(str);
			m3 = new ImageIcon("src\\javagers\\image\\m3.jpg");
			String imgPath1 = "src\\javagers\\image\\m3.jpg";
			btn1 = new JButton();
			movieInfoText = new MovieInfoText3();
			movieInfoText.setPreferredSize(new Dimension(890, 100));
			
			ImageIcon originIcon1 = new ImageIcon(imgPath1);
			Image originImg1 = originIcon1.getImage();
			Image changedImg1= originImg1.getScaledInstance(210, 200, Image.SCALE_SMOOTH );
			ImageIcon Icon1 = new ImageIcon(changedImg1);
			
			btn1.setIcon(Icon1);		//버튼에 이미지 설정
			btn1.setBackground(Color.black);
			this.setLayout(new BorderLayout());
			this.add("West",btn1);
			this.add("East",movieInfoText);
//			this.setSize(1200, 800);
			this.setPreferredSize(new Dimension(1200, 700));
//			this.setLocation(180, 80);
//			this.setVisible(true);
//			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
//		public static void main(String[] args) {
//			new MovieInformation3("영화정보 테스트3");
//		}
		
	}
	
	class MovieInformation4 extends JPanel{

		ImageIcon m4;
		JButton btn1;
		MovieInfoText4 movieInfoText;
		
		public MovieInformation4() {
//			super(str);
			m4 = new ImageIcon("src\\javagers\\image\\m4.jpg");
			String imgPath1 = "src\\javagers\\image\\m4.jpg";
			btn1 = new JButton();
			movieInfoText = new MovieInfoText4();
			movieInfoText.setPreferredSize(new Dimension(890, 100));
			
			ImageIcon originIcon1 = new ImageIcon(imgPath1);
			Image originImg1 = originIcon1.getImage();
			Image changedImg1= originImg1.getScaledInstance(210, 200, Image.SCALE_SMOOTH );
			ImageIcon Icon1 = new ImageIcon(changedImg1);
			
			btn1.setIcon(Icon1);		
			btn1.setBackground(Color.black);
			this.setLayout(new BorderLayout());
			this.add("West",btn1);
			this.add("East",movieInfoText);
//			this.setSize(1200, 800);
			this.setPreferredSize(new Dimension(1200, 700));
//			this.setLocation(180, 80);
//			this.setVisible(true);
//			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		
//		public static void main(String[] args) {
//			new MovieInformation4("영화정보 테스트4");
//		}
		
	}
	
	
