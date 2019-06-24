package javagers.jjy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ReservationMovieButton extends JPanel{
	
	JButton btn;
	RealMain main;
	LoginSystem log;
	final String PATH = "src\\javagers\\image\\111.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	
	public ReservationMovieButton(RealMain main, LoginSystem log) {
//    	super(str);
		this.main = main;
		this.log = log;
		img = Toolkit.getDefaultToolkit().getImage(PATH);
		
		String imgPath1 = "src\\javagers\\image\\searchButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		btn = new JButton("영화 조회");
		btn.addActionListener(new MyLoginEvent(log, main, this));
		btn.setIcon(Icon1);
		btn.setForeground(Color.white);
		btn.setBackground(Color.black);
		btn.setBorderPainted(false);
		this.add(btn);
		
//    	this.setSize(400,300);
//     	this.setVisible(true);
//		this.setPreferredSize(new Dimension(1100, 600));
	}

	public static void main(String[] args) {
//		new LoginSystem("영화정보시스템");
		
	}
}

