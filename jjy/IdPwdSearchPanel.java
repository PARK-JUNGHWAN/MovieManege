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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;

public class IdPwdSearchPanel extends JPanel implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == findIdButton) {
			this.card.show(slide, "Id");
		} 
		 else if(obj == findPwButton) {
			this.card.show(slide, "Password");
		} 
	}
	
	CardLayout card;
	JPanel slide, btnn;
	JButton findIdButton,findPwButton;
	WhatIsMyId wmi;
	WhatIsMyPassword wmp; 
	
	public IdPwdSearchPanel() {
//		super(str);
		this.setLayout(new BorderLayout());
		card = new CardLayout();
		slide = new JPanel();
		slide.setLayout(card);
		btnn = new JPanel();
		
		String imgPath1 = "src\\javagers\\image\\findButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(70, 70, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		findIdButton = new JButton("ID 찾기");
		findIdButton.setIcon(Icon1);
		findIdButton.setForeground(Color.white);
		findIdButton.setBackground(Color.black);
		findIdButton.addActionListener(this);
		findPwButton = new JButton("비밀번호 찾기");
		findPwButton.setIcon(Icon1);
		findPwButton.setForeground(Color.white);
		findPwButton.setBackground(Color.black);
		findPwButton.addActionListener(this);
		
		btnn.setLayout(new GridLayout(1,2));
		btnn.add(findIdButton);
		btnn.add(findPwButton);
		btnn.setPreferredSize(new Dimension(100, 60));
		
		wmi = new WhatIsMyId();
		wmp = new WhatIsMyPassword();
		slide.add(wmi,"Id");
		slide.add(wmp,"Password");
		
		this.add("North",btnn);
		this.add("Center",slide);
		this.setSize(1200,800); 
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
//		new IdPwdSearchPanel();
	}

}

	class WhatIsMyId extends JPanel implements ActionListener{
	JLabel name_info, number_info;
	JTextField name_txt, number_txt;
	JButton findID;
	JPanel pan_name, pan_number, pan_nameNumber, pan_button;

	final String PATH = "src\\javagers\\image\\findIdImageBlack.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	
	public WhatIsMyId() {
//    	super(str);
//    	this.setLayout(new BorderLayout());
		name_info = new JLabel("이름");
		name_info.setForeground(Color.white);
		name_txt = new JTextField(10); 
		number_info = new JLabel("전화번호");
		number_info.setForeground(Color.white);
		number_txt = new JTextField(10); 
		img = Toolkit.getDefaultToolkit().getImage(PATH);
//		pan_name = new JPanel();
//		pan_name.add(name_info); 
//		pan_name.add(name_txt);
//		pan_number = new JPanel();
//		pan_number.add(number_info); 
//		pan_number.add(number_txt);
		
		String imgPath1 = "src\\javagers\\image\\searchButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		findID = new JButton("ID 찾기");
		findID.setIcon(Icon1);
		findID.setForeground(Color.white);
		findID.setBackground(Color.black);
		findID.setBorderPainted(false);
		findID.addActionListener(this);

//		pan_button = new JPanel();
//		pan_button.add(findID);
//		pan_nameNumber = new JPanel(); 
//		pan_nameNumber.setLayout(new GridLayout(2,1));
//		pan_nameNumber.add(pan_name);
//		pan_nameNumber.add(pan_number);
		this.add(name_info); 
		this.add(name_txt);
		this.add(number_info); 
		this.add(number_txt);
		this.add(findID);
//		this.add(pan_name);
//		this.add(pan_number);
//		this.add(pan_nameNumber);
//		this.add(pan_button);
//		this.add("North",pan_nameNumber); 
//		this.add("Center",pan_button);
//    	this.setSize(400,300);
//     	this.setVisible(true);
	}

//	public static void main(String[] args) {
//		new WhatisMyId2("영화정보시스템");
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
	CRUDprocess crud = new CRUDprocess();
	
	String name = name_txt.getText();
	String num = number_txt.getText();
	
		Object obj = e.getSource();
		
		if(obj == findID) {
			Customer_Info ci =crud.selectnameCustomerInfo(name);
			if(name.equals("")||num.equals("")) {
				JOptionPane.showMessageDialog(this, "입력되지 않은 사항이 있습니다.");
			} else if(name.equals(ci.getCustomer_name())&&num.equals(ci.getCustomer_num())){
				String id = ci.getCustomer_id();
				JOptionPane.showMessageDialog(this,"당신의 ID는 [ "+ id + " ] 입니다.");
			} else {
				JOptionPane.showMessageDialog(this, "잘못된 정보입니다. 다시 입력해주세요.");
			}  
		}
		
	}
}
	
	 class WhatIsMyPassword extends JPanel implements ActionListener{
		JLabel name_info, number_info, id_info;
		JTextField name_txt, number_txt, id_txt;
		JButton findPw;
		JPanel pan_name, pan_number, pan_id, pan_nameNumber, pan_button;
		
		final String PATH = "src\\javagers\\image\\findPwdImageBlack.jpg";
		Image img;
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
		}

		public WhatIsMyPassword() {
//	    	super(str);
//	    	this.setLayout(new BorderLayout());
	    	id_info = new JLabel("ID");
	    	id_info.setForeground(Color.white);
	    	id_txt = new JTextField(10);
			name_info = new JLabel("이름"); 
			name_info.setForeground(Color.white);
			name_txt = new JTextField(10); 
			number_info = new JLabel("전화번호"); 
			number_info.setForeground(Color.white);
			number_txt = new JTextField(10); 
			img = Toolkit.getDefaultToolkit().getImage(PATH);
			
//			pan_name = new JPanel();
//			pan_name.add(name_info); 
//			pan_name.add(name_txt);
//			pan_number = new JPanel();
//			pan_number.add(number_info); 
//			pan_number.add(number_txt);
//			pan_id = new JPanel();
//			pan_id.add(id_info); 
//			pan_id.add(id_txt);
			
			String imgPath1 = "src\\javagers\\image\\searchButtonBlack.jpg";
			ImageIcon originIcon1 = new ImageIcon(imgPath1);
			Image originImg1 = originIcon1.getImage();
			Image changedImg1 = originImg1.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
			ImageIcon Icon1 = new ImageIcon(changedImg1);
			
			findPw = new JButton("비밀번호 찾기");
			findPw.setIcon(Icon1);
			findPw.setForeground(Color.white);
			findPw.setBackground(Color.black);
			findPw.setBorderPainted(false);
			findPw.addActionListener(this);
			
//			pan_button = new JPanel();
//			pan_button.add(findPw);
//			pan_nameNumber = new JPanel(); 
//			pan_nameNumber.setLayout(new GridLayout(3,1));
//			pan_nameNumber.add(pan_id);
//			pan_nameNumber.add(pan_name); 
//			pan_nameNumber.add(pan_number);
//			this.add("North",pan_nameNumber); 
//			this.add("Center",pan_button);
			this.add(id_info);
			this.add(id_txt);
			this.add(name_info); 
			this.add(name_txt);
			this.add(number_info); 
			this.add(number_txt);
			this.add(findPw);
//	    	this.setSize(400,300);
//	     	this.setVisible(true);
		}

//		public static void main(String[] args) {
//			new WhatisMyPassword2("영화정보시스템");
//		}

		@Override
		public void actionPerformed(ActionEvent e) {
		CRUDprocess crud = new CRUDprocess();
		
		String name = name_txt.getText();
		String num = number_txt.getText();
		String id = id_txt.getText();
			Object obj = e.getSource();
			
			if(obj == findPw) {
				Customer_Info ci =crud.selectnameCustomerInfo(name);
				if(name.equals("")||num.equals("")||id.equals("")) {
					JOptionPane.showMessageDialog(this, "빈칸 없이 입력해주세요.");
				} else if(name.equals(ci.getCustomer_name())&&num.equals(ci.getCustomer_num())
						&&id.equals(ci.getCustomer_id())){
					String pwd = ci.getCustomer_pwd();
					JOptionPane.showMessageDialog(this,"당신의 비밀번호는 [ "+ pwd + " ] 입니다.");
				} else {
					JOptionPane.showMessageDialog(this, "잘못된 정보입니다. 다시 입력해주세요");
				}
			}
		}
	}


