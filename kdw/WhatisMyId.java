package javagers.kdw;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WhatisMyId extends JFrame implements ItemListener,ActionListener{
	JLabel name_info, pwd_info;
	JTextField name_txt, num_txt;
	JButton login, notuserIdReserve, createnew, findID, checkReserve;
	JPanel pan_id, pan_pwd, pan_button;


	public WhatisMyId(String str) {
    	super(str);
    	this.setLayout(new BorderLayout());
		name_info = new JLabel("이름"); 
		name_txt = new JTextField(10); 
		pwd_info = new JLabel("전화번호"); 
		num_txt = new JTextField(10); 
		pan_id = new JPanel();
		pan_id.add(name_info); pan_id.add(name_txt);
		pan_pwd = new JPanel();
		pan_pwd.add(pwd_info); pan_pwd.add(num_txt);
		
		
		login = new JButton("로그인");
		notuserIdReserve = new JButton("비회원 예매");
		findID = new JButton("아이디 찾기");
		createnew = new JButton("회원가입");
		checkReserve = new JButton("예매조회");
		
		findID.addActionListener(this);
		
		
		pan_button = new JPanel();
//		pan_button.add(login); 
//		pan_button.add(notuserIdReserve);
		pan_button.add(findID);
//		pan_button.add(checkReserve);
//		pan_button.add(createnew);
	
	
		
		JPanel north = new JPanel(); north.setLayout(new GridLayout(2,1));
		north.add(pan_id); north.add(pan_pwd);
		
		
		this.add("North",north); this.add("South",pan_button);
		this.setBackground(Color.ORANGE);
    	this.setSize(400,300);
		this.setBackground(Color.orange);
     	this.setVisible(true);
	}

	public static void main(String[] args) {
		new WhatisMyId("영화정보시스템");

		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	CRUDprocess crud = new CRUDprocess();
	
	
	
	
	String name = name_txt.getText();
	String num = num_txt.getText();
	
		Object obj = e.getSource();
		
		if(obj == findID) {
			Customer_info ci =crud.selectnameCustomerInfo(name);
			if(name.equals("")||num.equals("")) {
				JOptionPane.showMessageDialog(this, "빈칸없이 입력해주세요");
			}
			
			else if(name.equals(ci.getCustomer_name())&&num.equals(ci.getCustomer_num())) 
			{
				String id = ci.getCustomer_id();
				System.out.println(id);
				JOptionPane.showMessageDialog(this,"당신의 아이디는:"+ id);
			}
			
			else {
				JOptionPane.showMessageDialog(this, "잘못된 정보입니다. 다시 입력해주세요");
			}
	
			
		}
	}

}


