package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ReservationMovie extends JPanel {
	ReservationMoviePan reservationMoviePan;
	MovieList mList;
	JButton button;
	Font font;
	
	ReservationMovie(){
		reservationMoviePan = new ReservationMoviePan();
		font = new Font("굴림",Font.ITALIC, 16);
		mList = new MovieList();
		button = new JButton("다음");
//		this.setLayout(new BorderLayout());
		this.add("North",reservationMoviePan);
		this.add("Center", button);
		this.add("South",mList);
		this.setPreferredSize(new Dimension(800, 300));
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		new ReservationMovie();

	}
}

class ReservationMoviePan extends JPanel {
	
	String [] movie = {"악인전","어벤져스 엔드게임","명탐정 피카츄","배심원들"};
	ButtonGroup group;
	JRadioButton[] button;

	ReservationMoviePan(){
		group = new ButtonGroup();
		button = new JRadioButton[movie.length];
		for(int i = 0; i < movie.length; i++) {
			button[i] = new JRadioButton();
			button[i].setText(movie[i]);
			group.add(button[i]);
			this.add(button[i]);
		}
	}
}

