package javagers.kdw;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.BoldAction;


public class IdPwdSearchPanel extends JFrame implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj == correct) {
			this.card.show(slide, "id");
		} 
		 else if(obj == notUserSearch) {
			this.card.show(slide, "password");
		} 
	
	}
	
	CardLayout card;
	JPanel slide, btnn;
	JButton correct,Mypage,notUserSearch,login;

	WhatisMyId2 wmi;
	WhatisMyPassword2 wmp; 

	
	public IdPwdSearchPanel() {
//		super(str);
		this.setLayout(new BorderLayout());
		card = new CardLayout();
		slide = new JPanel();
		slide.setLayout(card);
		btnn = new JPanel();
		correct = new JButton("아이디 찾기");
		correct.addActionListener(this);
		
	
		
		notUserSearch = new JButton("비밀번호 찾기");
		notUserSearch.addActionListener(this);
		login = new JButton();
		login.setText("로그인");
		login.addActionListener(this);
		btnn.setLayout(new GridLayout(1,4));
		btnn.add(correct);
		btnn.add(notUserSearch);
	
		btnn.setPreferredSize(new Dimension(100, 80));
		
		wmi = new WhatisMyId2();
		wmp = new WhatisMyPassword2();
	
		slide.add(wmi,"id");
		slide.add(wmp,"password");

		
		this.add("North",btnn);
		this.add("Center",slide);
		this.setSize(1200,800); 
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		new IdPwdSearchPanel();
		
	}
	

}



