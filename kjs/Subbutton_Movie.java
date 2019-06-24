package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Subbutton_Movie extends JPanel implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == mselect) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "search");
		} else if( o == mset) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "set");
		} else if( o == mregister) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "register");
		} else if( o == mupdate) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "update");
		}
		
	}
	JPanel Subbutton_Movie;
	Font font;
	JButton	mselect, mset, mregister, mupdate;
	Test ts;
	
	CardLayout subcard;
	JPanel subpanel;
	JPanel Main1,Main2,Main3,Main4;
	DepMovieSearch depmovieserch;
	DepMovieSet depmovieset;
	DepMovieRegister depmovieregister;
	DepMovieUpdate depmovieupdate;
	
	void init() {
		font = new Font("굴림",Font.BOLD,20);
		Subbutton_Movie = new JPanel();
		Main1 = new JPanel();
		Main2 = new JPanel();
		Main3 = new JPanel();
		Main4 = new JPanel();
		mselect = new JButton("영화 목록 조회");
		mset = new JButton("상영관 설정");
		mregister = new JButton("영화 등록");
		mupdate = new JButton("영화 변경/삭제");
		mselect.setFont(font);
		mset.setFont(font);
		mregister.setFont(font);
		mupdate.setFont(font);
		Subbutton_Movie.setLayout(new GridLayout(1,4));
		Subbutton_Movie.add(mselect);
		Subbutton_Movie.add(mset);
		Subbutton_Movie.add(mregister);
		mselect.setBackground(new Color(235,235,90));
		mset.setBackground(new Color(235,235,90));
		mregister.setBackground(new Color(235,235,90));
		mupdate.setBackground(new Color(235,235,90));

		Subbutton_Movie.setPreferredSize(new Dimension(1200,60) );
		
		mselect.addActionListener(this);
		mset.addActionListener(this);
		mregister.addActionListener(this);
		
		subcard = new CardLayout();
		subpanel = new JPanel();
		subpanel.setLayout(subcard);
		
		depmovieserch = new DepMovieSearch(this);
		depmovieset = new DepMovieSet(this);
		depmovieregister = new DepMovieRegister(this);
		subpanel.add(depmovieserch,"search");
		subpanel.add(depmovieset,"set");
		subpanel.add(depmovieregister,"register");
	}
	public Subbutton_Movie(Test ts) {
//		super(str);
		this.ts=ts;
		init();
		this.setLayout(new BorderLayout());
		this.add("North", Subbutton_Movie);
		this.add("Center", subpanel);
		subpanel.setVisible(false);
		
//		this.setSize(1200,800); 
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new adminMain2("Admin Management");

	}
}
