package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class MyPage extends JPanel implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj == correct) {
			this.card.show(slide, "correct");
		} 
		 else if(obj == notUserSearch) {
			this.card.show(slide, "ni");
		} 
	}
	
	CardLayout card;
	JPanel slide, btnn;
	JButton correct,Mypage,notUserSearch,login;
	MyPageInfoChangePanel mpic;
	NotUserReserveSearch notUserSearch_info;
	Font font;
	public MyPage() {
//		super(str);
		this.setLayout(new BorderLayout());
		font = new Font("휴먼매직체",Font.PLAIN, 15);
		card = new CardLayout();
		slide = new JPanel();
		slide.setLayout(card);
		btnn = new JPanel();
		correct = new JButton("Modify");
		String imgPath2 = "src\\javagers\\image\\signUpButtonBlack.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(70, 50, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		correct.setIcon(Icon2);
		correct.setForeground(Color.white);
		correct.setBackground(Color.black);
		correct.addActionListener(this);
		correct.setFont(font);
		
		notUserSearch = new JButton("Reservation Check");
		
		String imgPath1 = "src\\javagers\\image\\searchButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		notUserSearch.setIcon(Icon1);
		notUserSearch.setForeground(Color.white);
		notUserSearch.setBackground(Color.black);
		notUserSearch.addActionListener(this);
		notUserSearch.setFont(font);
		login = new JButton();
		login.setText("로그인");
		login.addActionListener(this);
		btnn.setLayout(new GridLayout(1,4));
		btnn.add(correct);
		btnn.add(notUserSearch);
		btnn.setPreferredSize(new Dimension(100, 60));
		
		mpic = new MyPageInfoChangePanel();
		notUserSearch_info = new NotUserReserveSearch();
		slide.add(mpic,"correct");
		slide.add(notUserSearch_info,"ni");
		
		this.add("North",btnn);
		this.add("Center",slide);
		this.setSize(1200,800); 
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
//		new MyPage();
	}

}



