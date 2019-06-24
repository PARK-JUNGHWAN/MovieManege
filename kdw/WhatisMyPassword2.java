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

public class WhatisMyPassword2 extends JPanel implements ItemListener,ActionListener{
	JLabel name_info, pwd_info;
	JTextField name_txt, num_txt;
	JButton login, notuserIdReserve, createnew, findID, checkReserve;
	JPanel pan_name, pan_pwd, pan_button;
	private JLabel id_info;
	private JTextField id_txt;
	private JPanel pan_id;


	public WhatisMyPassword2() {
//    	super(str);
    	this.setLayout(new BorderLayout());
    	id_info = new JLabel("아이디");
    	id_txt = new JTextField(10);
		name_info = new JLabel("이름"); 
		name_txt = new JTextField(10); 
		pwd_info = new JLabel("전화번호"); 
		num_txt = new JTextField(10); 
		pan_name = new JPanel();
		pan_name.add(name_info); pan_name.add(name_txt);
		pan_pwd = new JPanel();
		pan_pwd.add(pwd_info); pan_pwd.add(num_txt);
		pan_id = new JPanel();
		pan_id.add(id_info); pan_id.add(id_txt);
		
		
		login = new JButton("로그인");
		notuserIdReserve = new JButton("비회원 예매");
		findID = new JButton("비밀번호 찾기");
		createnew = new JButton("회원가입");
		checkReserve = new JButton("예매조회");
		
		findID.addActionListener(this);
		
		
		pan_button = new JPanel();
//		pan_button.add(login); 
//		pan_button.add(notuserIdReserve);
		pan_button.add(findID);
//		pan_button.add(checkReserve);
//		pan_button.add(createnew);
	
	
		
		JPanel north = new JPanel(); north.setLayout(new GridLayout(3,1));
		north.add(pan_name); 
		north.add(pan_pwd);
		north.add(pan_id);
		
		this.add("North",north); this.add("South",pan_button);
		this.setBackground(Color.ORANGE);
    	this.setSize(400,300);
		this.setBackground(Color.orange);
     	this.setVisible(true);
	}

//	public static void main(String[] args) {
//		new WhatisMyPassword2("영화정보시스템");
//
//		
//	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	CRUDprocess crud = new CRUDprocess();
	
	
	
	
	String name = name_txt.getText();
	String num = num_txt.getText();
	String id = id_txt.getText();
		Object obj = e.getSource();
		
		if(obj == findID) {
			Customer_info ci =crud.selectnameCustomerInfo(name);
			if(name.equals("")||num.equals("")||id.equals("")) {
				JOptionPane.showMessageDialog(this, "빈칸없이 입력해주세요");
			}
			
			else if(name.equals(ci.getCustomer_name())&&num.equals(ci.getCustomer_num())
					&&id.equals(ci.getCustomer_id())) 
			{
				String pwd = ci.getCustomer_pwd();
				System.out.println(pwd);
				JOptionPane.showMessageDialog(this,"당신의 비밀번호는:"+ pwd);
			}
			
			else {
				JOptionPane.showMessageDialog(this, "잘못된 정보입니다. 다시 입력해주세요");
			}
	
			
		}
	}

}


