package javagers.kdw;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepReserveTable extends JPanel {
	ReservationTableSearchPanOne reservationTableSearchPanOne;
	ReservationTableSearchPanTwo reservationTableSearchPanTwo;
	Subbutton_Reserve sr;
	
	public DepReserveTable(Subbutton_Reserve sr){
		this.sr=sr;
		reservationTableSearchPanOne = new ReservationTableSearchPanOne();
		reservationTableSearchPanTwo = new ReservationTableSearchPanTwo();
		
		this.add("North",reservationTableSearchPanOne);
		this.add("Center",reservationTableSearchPanTwo);
		
//		this.setBounds(0, 0, 1200, 800);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
//		new DepReserveTable();

	}

}

class ReservationTableSearchPanOne extends JPanel {
	
	JLabel name, reservationNumber, date, dateBar, movieName, screen;
	JTextField nameText, reservationNumberText, startDateText, endDateText, movieNameText, screenText;
	JButton search, totalSearch, calendar;
	String[] strMovie = {"명탐정 피카츄","어벤져스 엔드게임","걸캅스","자전거왕 엄복동"};
	String[] strScreen = {"1","2","3","4"};
	JPanel pan1, pan2; 
	JComboBox movieNameCombo, screenCombo;
	
	
	ReservationTableSearchPanOne(){
		this.setLayout(new GridLayout(2,1));
		
		name = new JLabel("회원명");
		reservationNumber = new JLabel("예매번호");
		date = new JLabel("상영기간");
		dateBar = new JLabel(" ~ ");
		movieName = new JLabel("영화명");
		screen = new JLabel("상영관");
		
		search = new JButton("조회"); totalSearch = new JButton("전체조회"); calendar = new JButton("달력");
		totalSearch.setBackground(Color.GREEN);
		
		nameText = new JTextField(10);
		reservationNumberText = new JTextField(20);
		startDateText = new JTextField(10);
		endDateText = new JTextField(10);
		movieNameCombo = new JComboBox<>();
		screenCombo = new JComboBox<>();
		
		for(int i=0;i<strMovie.length;i++) {
			movieNameCombo.addItem(strMovie[i]);
			screenCombo.addItem(i+1);
		}
		
		
		pan1 = new JPanel(); pan2 = new JPanel();
		
		pan1.add(name); pan1.add(nameText); pan1.add(reservationNumber); pan1.add(reservationNumberText); 
		pan1.add(date); pan1.add(startDateText); pan1.add(dateBar); pan1.add(endDateText); pan1.add(calendar); 
		pan2.add(movieName); pan2.add(movieNameCombo); pan2.add(screen); pan2.add(screenCombo); pan2.add(search); pan2.add(totalSearch);
		
		this.add(pan1); this.add(pan2);
	}
	
}

class ReservationTableSearchPanTwo extends JPanel {
	
	ReservationTableSearchPanTwo(){
		
	}
}
