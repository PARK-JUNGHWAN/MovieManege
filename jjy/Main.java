package javagers.jjy;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javagers.kjs.DepMovieRegister;
import javagers.kjs.Subbutton_Movie;


public class Main extends JPanel implements ActionListener {
	MovieList mList;
	RealMain main;
	MovieInfoText mit1;
	final String PATH = "src\\javagers\\image\\mainImage.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o==mList.btn[0]) {
			main.card.show(main.slide, "mInfo1");
		}
		
		if(o==mList.btn[1]) {
			main.card.show(main.slide, "mInfo2");
		}
		if(o==mList.btn[2]) {
			main.card.show(main.slide, "mInfo3");
		}
		if(o==mList.btn[3]) {
			main.card.show(main.slide, "mInfo4");
		}
	}
	
	public Main(RealMain main) {
//		super(str);
		this.main = main;
		img = Toolkit.getDefaultToolkit().getImage(PATH);
		mit1 = new MovieInfoText();
		mList = new MovieList();
		mList.btn[0].addActionListener(this);
		mList.btn[1].addActionListener(this);
		mList.btn[2].addActionListener(this);
		mList.btn[3].addActionListener(this);
//		this.setLayout(new BorderLayout());
//		this.add("Center",mList);
		this.add(mList);
		this.setSize(1000, 300);
		this.setLocation(180, 40);
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setPreferredSize(new Dimension(1200, 300));
		
	}
	public static void main(String[] args) {
		//		new Main();
	}
}

//class Drawing extends JPanel{
//	final String PATH = "src\\javagers\\jjy\\mainImage.jpg";
//	Image img;
//	
//	Drawing() {
//	img = Toolkit.getDefaultToolkit().getImage(PATH);
//	}
//	@Override
//	public void paint(Graphics g) {
//		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
//	}
//}