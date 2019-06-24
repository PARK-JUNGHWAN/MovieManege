package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import javagers.kjs.DepMovieUpdate;
import javagers.kjs.Subbutton_Movie;
import javagers.kjs.Test;
import javagers.pjh.ReservationMovie;
import javagers.jjy.CRUDprocess;
import sun.net.www.content.text.plain;

public class RealMain extends JFrame implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj == home) {
			this.card.show(slide, "home");
		} else if(obj == reserve) {
//			this.card.show(slide, "reserve");
			this.card.show(slide, "btn");
		} else if(obj == notUserSearch && notUserSearch.getText()=="Reservation Check") {
			this.card.show(slide, "notUserSearch");
		} 
		
		 if(obj == login&&login.getText()=="Login") {
			this.card.show(slide, "login");
			notUserSearch_info.nursOne.ticketNumberText.setText("  ");
			notUserSearch_info.nursOne.ticketNumberText.setText("");
			notUserSearch_info.nursOne.phoneNumberText.setText("  ");
			notUserSearch_info.nursOne.phoneNumberText.setText("");
			notUserSearch_info.nursTwo.reserveNumText.setText("  ");
			notUserSearch_info.nursTwo.reserveNumText.setText("");
			notUserSearch_info.nursTwo.movieText.setText("  ");
			notUserSearch_info.nursTwo.movieText.setText("");
			notUserSearch_info.nursTwo.scrennText.setText("  ");
			notUserSearch_info.nursTwo.scrennText.setText("");
			notUserSearch_info.nursTwo.seatText.setText("  ");
			notUserSearch_info.nursTwo.seatText.setText("");
			notUserSearch_info.nursTwo.timeText.setText("  ");
			notUserSearch_info.nursTwo.timeText.setText("");
		} else if(obj == login && login.getText() == "Logout") {
			this.card.show(slide, "home");
			notUserSearch.setText("Reservation Check");
			login.setText("Login");
			String imgPath4 = "src\\javagers\\image\\loginButton.jpg";
			ImageIcon originIcon4 = new ImageIcon(imgPath4);
			Image originImg4 = originIcon4.getImage();
			Image changedImg4 = originImg4.getScaledInstance(70, 70, Image.SCALE_SMOOTH );
			ImageIcon Icon4 = new ImageIcon(changedImg4);
			login.setIcon(Icon4);
			login_info.id_txt.setText("  ");
			login_info.id_txt.setText("");
			login_info.pwd_txt.setText("  ");
			login_info.pwd_txt.setText("");
			
		}
		 if(obj == notUserSearch && notUserSearch.getText()=="MyPage") {
			 this.card.show(slide, "myPage");
			 myPage_info.notUserSearch_info.nursOne.ticketNumberText.setText("  ");
			 myPage_info.notUserSearch_info.nursOne.ticketNumberText.setText("");
			 myPage_info.notUserSearch_info.nursOne.phoneNumberText.setText("  ");
			 myPage_info.notUserSearch_info.nursOne.phoneNumberText.setText("");
			 myPage_info.notUserSearch_info.nursTwo.reserveNumText.setText("  ");
			 myPage_info.notUserSearch_info.nursTwo.reserveNumText.setText("");
			 myPage_info.notUserSearch_info.nursTwo.movieText.setText("  ");
			 myPage_info.notUserSearch_info.nursTwo.movieText.setText("");
			 myPage_info.notUserSearch_info.nursTwo.scrennText.setText("  ");
			 myPage_info.notUserSearch_info.nursTwo.scrennText.setText("");
			 myPage_info.notUserSearch_info.nursTwo.seatText.setText("  ");
			 myPage_info.notUserSearch_info.nursTwo.seatText.setText("");
			 myPage_info.notUserSearch_info.nursTwo.timeText.setText("  ");
			 myPage_info.notUserSearch_info.nursTwo.timeText.setText("");
		 }
		 if(obj == notUserSearch && notUserSearch.getText()=="Admin Menu") {
			 this.card.show(this.slide, "admin");
		 } 
	}
	
	CardLayout card;
	JPanel slide, btnn, backgroundImage;
	JButton home,reserve,notUserSearch,login;
	Main home_info;
	ReservationMovie reserve_info;
	NotUserReserveSearch notUserSearch_info;
	LoginSystem login_info;
	Font font;
	MyPage myPage_info;
	IdPwdSearchPanel idpwFind;
	NewMemberCreate newMember;
	JScrollPane scrollPane;
	ImageIcon homeButton,reserveButton,notUserSearchButton,loginButton,logoutButton;
	MovieInformation1 mInfo1;
	MovieInformation2 mInfo2;
	MovieInformation3 mInfo3;
	MovieInformation4 mInfo4;
	Image image;
	javagers.pjh.ReservationMovie rm;
	NursOne no;
	NursTwo nt;
	NursThree ntt;
	ReservationMovieButton btn;
	Test test;
	
	public RealMain() {
//		super(str);
		this.setLayout(new BorderLayout());
		font = new Font("휴먼매직체",Font.PLAIN, 16);
		card = new CardLayout();
		slide = new JPanel();
		slide.setLayout(card);
		btnn = new JPanel();
		homeButton = new ImageIcon("src\\javagers\\image\\homebutton.jpg");
		reserveButton = new ImageIcon("src\\javagers\\image\\reserveButton.jpg");
		notUserSearchButton = new ImageIcon("src\\javagers\\image\\selectButton.jpg");
		loginButton = new ImageIcon("src\\javagers\\image\\loginButton.jpg");
		logoutButton = new ImageIcon("src\\javagers\\image\\logoutButton.jpg");
		
		String imgPath1 = "src\\javagers\\image\\homebutton.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(65, 65, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		String imgPath2 = "src\\javagers\\image\\reserveButton.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		
		String imgPath3 = "src\\javagers\\image\\selectButton.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changedImg3 = originImg3.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		
		String imgPath4 = "src\\javagers\\image\\loginButton.jpg";
		ImageIcon originIcon4 = new ImageIcon(imgPath4);
		Image originImg4 = originIcon4.getImage();
		Image changedImg4 = originImg4.getScaledInstance(70, 70, Image.SCALE_SMOOTH );
		ImageIcon Icon4 = new ImageIcon(changedImg4);
		
		home = new JButton("Home");
		home.addActionListener(this);
		home.setIcon(Icon1);	
		home.setBackground(Color.black);
		home.setForeground(Color.white);
		home.setFont(font);
		reserve = new JButton("Ticketing");
		reserve.addActionListener(this);
		reserve.setIcon(Icon2);	
		reserve.setBackground(Color.black);
		reserve.setForeground(Color.white);
		reserve.setFont(font);
		notUserSearch = new JButton("Reservation Check");
		notUserSearch.addActionListener(this);
		notUserSearch.addActionListener(ntt);
		notUserSearch.setIcon(Icon3);	
		notUserSearch.setBackground(Color.black);
		notUserSearch.setForeground(Color.white);
		notUserSearch.setFont(font);
		login = new JButton();
		login.setText("Login");
		login.addActionListener(this);
		login.setIcon(Icon4);	
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.setFont(font);
		btnn.setLayout(new GridLayout(1,4));
		btnn.add(home);
		btnn.add(reserve);
		btnn.add(notUserSearch);
		btnn.add(login);
		btnn.setPreferredSize(new Dimension(100, 60));
		test = new Test();
		mInfo1 = new MovieInformation1();
		mInfo2 = new MovieInformation2();
		mInfo3 = new MovieInformation3();
		mInfo4 = new MovieInformation4();
		backgroundImage = new SystemBackgroundImage();
		idpwFind = new IdPwdSearchPanel();
		newMember = new NewMemberCreate();
		home_info = new Main(this);
		reserve_info = new ReservationMovie(this);
		notUserSearch_info = new NotUserReserveSearch();
		login_info = new LoginSystem(this, btn);
		myPage_info = new MyPage();
		
		no = new NursOne();
		nt = new NursTwo();
		ntt = new NursThree(no, nt);
		btn = new ReservationMovieButton(this, login_info);
		slide.add(backgroundImage,"background");
		slide.add(home_info,"home");
		slide.add(reserve_info,"reserve");
		slide.add(notUserSearch_info,"notUserSearch");
		slide.add(login_info,"login");
		slide.add(myPage_info,"myPage");
		slide.add(newMember,"newMember");
		slide.add(idpwFind,"idpwFind");
		slide.add(mInfo1,"mInfo1");
		slide.add(mInfo2,"mInfo2");
		slide.add(mInfo3,"mInfo3");
		slide.add(mInfo4,"mInfo4");
		slide.add(test,"admin");
		slide.add(btn,"btn");

		this.add("North",btnn);
		this.add("Center",slide);
		this.setSize(1150,800);
		this.setLocation(200,20);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	class SystemBackgroundImage extends JPanel{
		
		final String PATH = "src\\javagers\\image\\mainImage.jpg";
		
		Image img;
		SystemBackgroundImage(){
			img = Toolkit.getDefaultToolkit().getImage(PATH);
			
		}
		@Override
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
			
		}
	}
	
	public static void main(String[] args) {

		new RealMain();
	}
}


