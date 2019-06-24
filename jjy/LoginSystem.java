package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSystem extends JPanel{
	
	JLabel id_info, pwd_info;
	public JTextField id_txt;
	JPasswordField pwd_txt;
	JButton login, createnew, findIDPW;
	JPanel pan_idpwd;
	RealMain main;
	ReservationMovieButton btn;
	final String PATH = "src\\javagers\\image\\theater1.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	
	public LoginSystem(RealMain main, ReservationMovieButton btn) {
//    	super(str);
		this.main = main;
		this.btn = btn;
		img = Toolkit.getDefaultToolkit().getImage(PATH);
//    	this.setLayout(new BorderLayout());
		
		String imgPath1 = "src\\javagers\\image\\signInButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		String imgPath2 = "src\\javagers\\image\\searchButtonBlack.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		
		String imgPath3 = "src\\javagers\\image\\signUpButtonBlack.jpg";
		ImageIcon originIcon3 = new ImageIcon(imgPath3);
		Image originImg3 = originIcon3.getImage();
		Image changedImg3 = originImg3.getScaledInstance(32, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon3 = new ImageIcon(changedImg3);
		
		id_info = new JLabel("ID"); 
		id_info.setForeground(Color.black);
		id_txt = new JTextField(15); 
		pwd_info = new JLabel("PASSWORD");
		pwd_info.setForeground(Color.black);
		pwd_txt = new JPasswordField(15);
		pwd_txt.setEchoChar('*');
		
		login = new JButton("Login");
		login.addActionListener(new MyLoginEvent(this, main, btn));
		login.setIcon(Icon1);
		login.setForeground(Color.white);
		login.setBackground(Color.black);
		login.setBorderPainted(false);
		
		findIDPW = new JButton("Find ID/PW");
		findIDPW.addActionListener(new MyLoginEvent(this, main, btn));
		findIDPW.setIcon(Icon2);
		findIDPW.setForeground(Color.white);
		findIDPW.setBackground(Color.black);
		findIDPW.setBorderPainted(false);
		
		createnew = new JButton("SignUp");
		createnew.addActionListener(new MyLoginEvent(this, main, btn));
		createnew.setIcon(Icon3);
		createnew.setForeground(Color.white);
		createnew.setBackground(Color.black);
		createnew.setBorderPainted(false);

		this.add(id_info);
		this.add(id_txt);
		this.add(pwd_info);
		this.add(pwd_txt);
		this.add(login);
		this.add(findIDPW);
		this.add(createnew);

//    	this.setSize(400,300);
//     	this.setVisible(true);
//		this.setPreferredSize(new Dimension(1100, 600));
	}

	public static void main(String[] args) {
//		new LoginSystem("영화정보시스템");
		
	}
}

