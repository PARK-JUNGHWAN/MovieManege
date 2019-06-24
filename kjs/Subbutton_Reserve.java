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

import javagers.jjy.RealMain;
import javagers.pjh.*;

public class Subbutton_Reserve extends JPanel implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == rtselect) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "table");
		} else if(o == rpselect) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "board");
		} else if(o == rregister) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "place");
		} 
		
	}
	JPanel Subbutton_Reserve;
	Font font;
	JButton rtselect, rpselect, rregister;
	Test ts;
	RealMain rmain;
	
	
	CardLayout subcard;
	JPanel subpanel;
	DepReserveTable depreservetable;
	ReservationMovie rm;
	ReservationTable rt;
	ReservationBoard rb;
	void init() {
		font = new Font("굴림",Font.BOLD,20);
		Subbutton_Reserve = new JPanel();
		rtselect = new JButton("테이블 조회");
		rpselect = new JButton("현황판 조회");
		rregister = new JButton("현장 등록");
		rtselect.setFont(font);
		rpselect.setFont(font);
		rregister.setFont(font);
		Subbutton_Reserve.setLayout(new GridLayout(1,3));
		Subbutton_Reserve.add(rtselect);
		Subbutton_Reserve.add(rpselect);
		Subbutton_Reserve.add(rregister);
		rtselect.setBackground(new Color(240,240,90));
		rpselect.setBackground(new Color(240,240,90));
		rregister.setBackground(new Color(240,240,90));
	
		Subbutton_Reserve.setPreferredSize(new Dimension(1200,60) );
		
		rtselect.addActionListener(this);
		rpselect.addActionListener(this);
		rregister.addActionListener(this);		
		
		subcard = new CardLayout();
		subpanel = new JPanel();
		subpanel.setLayout(subcard);
		
		depreservetable = new DepReserveTable(this);
		rm = new ReservationMovie(rmain);
		rb = new ReservationBoard();
		rt = new ReservationTable();
		subpanel.add(rt, "table");
		subpanel.add(rb, "board");
		subpanel.add(rm, "place");
	}
	public Subbutton_Reserve(Test ts) {
//		super(str);
		
		this.ts = ts;
		init();
		this.setLayout(new BorderLayout());
		this.add("North", Subbutton_Reserve);
		this.add("Center", subpanel);
		subpanel.setVisible(false);
		
//		this.setSize(1200,800); 
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new adminMain4("Admin Management");

	}
}
