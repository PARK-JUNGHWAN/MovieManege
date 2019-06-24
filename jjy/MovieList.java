package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MovieList extends JPanel {
	JButton[] btn;
	ImageIcon m1, m2, m3, m4;
	ImageIcon m1_1;
	CardLayout card;
	JPanel slide, btnPanel;
	
	final String PATH = "src\\javagers\\image\\mainImage.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	
//	@Override
//	public void paint(Graphics g) {
//		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
//	}

	public MovieList() {
//		super(str);
		img = Toolkit.getDefaultToolkit().getImage(PATH);
		card = new CardLayout();
		slide = new JPanel();
		slide.setLayout(card);
		m1 = new ImageIcon("src\\javagers\\image\\m1.jpg");
		m2 = new ImageIcon("src\\javagers\\image\\m2.jpg");
		m3 = new ImageIcon("src\\javagers\\image\\m3.jpg");
		m4 = new ImageIcon("src\\javagers\\image\\m4.jpg");
		m1_1 = new ImageIcon("src\\javagers\\image\\m1_1.jpg");
		
		//이미지 사이즈 조정
		String imgPath1 = "src\\javagers\\image\\m1.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1= originImg1.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		String imgPath2 = "src\\javagers\\image\\m2.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2= originImg2.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		
		String imgPath3 = "src\\javagers\\image\\m3.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changedImg3= originImg3.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		
		String imgPath4 = "src\\javagers\\image\\m4.jpg";
		ImageIcon originIcon4 = new ImageIcon(imgPath4);
		Image originImg4 = originIcon4.getImage();
		Image changedImg4= originImg4.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon4 = new ImageIcon(changedImg4);
		
		String imgPath1_1 = "src\\javagers\\image\\m1_1.jpg";
		ImageIcon originIcon1_1 = new ImageIcon(imgPath1_1);
		Image originImg1_1 = originIcon1_1.getImage();
		Image changedImg1_1= originImg1_1.getScaledInstance(200, 300, Image.SCALE_SMOOTH );
		ImageIcon Icon1_1 = new ImageIcon(changedImg1_1);
		
		
		btn = new JButton[4];
		for(int i =0; i<btn.length; i++) {
			btn[i] = new JButton();
		}
		btnPanel = new JPanel();
		
		btn[0].setIcon(Icon1);		
//		btn[0].setPressedIcon(m1);	
//		btn[0].setRolloverIcon(Icon1_1);
		btn[1].setIcon(Icon2);
//		btn[1].setPressedIcon(m2);	
//		btn[1].setRolloverIcon(m2);	
		btn[2].setIcon(Icon3);
//		btn[2].setPressedIcon(m3);	
//		btn[2].setRolloverIcon(m3);	
		btn[3].setIcon(Icon4);
//		btn[3].setPressedIcon(m4);	
//		btn[3].setRolloverIcon(m4);	
		btnPanel.add(btn[0]);
		btnPanel.add(btn[1]);
		btnPanel.add(btn[2]);
		btnPanel.add(btn[3]);
		
		slide.add(btnPanel,"버튼메인");
		this.add(slide);
//		this.setPreferredSize(new Dimension(950, 325));
//		this.setSize(800, 300);
//		this.setLocation(380, 260);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
//		new MovieList("메인 영화목록");
	}
}

