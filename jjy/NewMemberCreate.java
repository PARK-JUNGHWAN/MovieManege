package javagers.jjy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class NewMemberCreate extends JPanel implements ActionListener,ItemListener{
	JLabel id_new, name_new, birth_new, address_new, gen_new, num_new, pwd_new;
	JTextField id_txt, name_txt, address_txt, gen_txt, num_txt;
	JButton register, reset;
	JPanel pan_birth_new;
	JComboBox year_com, month_com,day_com, gen_com;
	JPasswordField pwd_txt;
	Font font;
	 final String PATH = "src\\javagers\\image\\signupImageBlack.jpg";
		Image img;
		
		@Override
		protected void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
		}
		
	public NewMemberCreate() {
//    	super(str);
		img = Toolkit.getDefaultToolkit().getImage(PATH);
		font = new Font("굴림체", font.PLAIN, 15);
		this.setLayout(new GridLayout(12,2));
		
		//아이디
		id_new = new JLabel("ID"); 
		id_new.setForeground(Color.white);
		id_txt = new JTextField(10); 
		id_txt.setBackground(Color.LIGHT_GRAY);
		
		//비밀번호
		pwd_new = new JLabel("PASSWORD");
		pwd_new.setForeground(Color.white);
		pwd_txt = new JPasswordField(10); 
		pwd_txt.setBackground(Color.LIGHT_GRAY);
		pwd_txt.setEchoChar('*');
		
		//이름
		name_new = new JLabel("이름"); 
		name_new.setForeground(Color.white);
		name_txt = new JTextField(10); 
		name_txt.setBackground(Color.LIGHT_GRAY);
		
		//생년월일
		birth_new = new JLabel("생년월일");
		birth_new.setForeground(Color.white);
		year_com = new JComboBox();
		year_com.addItem("태어난 년도");
		for(int i = 2019; i>=1970; i--) {	//1980년부터 2019
			year_com.addItem(i+"");		//정수를 문자열로 바꿔서 초이스에 붙임
		}
		month_com = new JComboBox();
		
		month_com.addItem("월");
		for(int i = 1; i <= 12; i++) {
			month_com.addItem(i+"");
		}
		month_com.addItemListener(this);
		day_com = new JComboBox();

//		 주소
		address_new = new JLabel("주소");
		address_new.setForeground(Color.white);
		address_txt = new JTextField(30);
		address_txt.setBackground(Color.LIGHT_GRAY);
		
		// 성별
		gen_new = new JLabel("성별");
		gen_new.setForeground(Color.white);
		gen_com = new JComboBox();
		gen_com.addItem("남자");
		gen_com.addItem("여자");
		
				
		// 폰번호
		num_new = new JLabel("휴대폰 번호 ( ' - ' 없이 입력하세요.)");
		num_new.setForeground(Color.white);
		num_txt = new JTextField(20);
		num_txt.setBackground(Color.LIGHT_GRAY);

		pan_birth_new = new JPanel(); // 생일이 들어갈 패널
		pan_birth_new.add(birth_new);
		pan_birth_new.add(year_com);
		pan_birth_new.add(month_com);
		pan_birth_new.add(day_com);
		
		String imgPath1 = "src\\javagers\\image\\vcheckButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		String imgPath2 = "src\\javagers\\image\\resetButtonBlack.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		
		register = new JButton("Commit !");  
		register.setIcon(Icon1);
		register.setForeground(Color.white);
		register.setBackground(Color.black);
		register.addActionListener(this);
		register.setBorderPainted(false);
		reset = new JButton("Reset");
		reset.setIcon(Icon2);
		reset.setForeground(Color.white);
		reset.setBackground(Color.black);
		reset.addActionListener(this);
		reset.setBorderPainted(false);
		
		this.add(id_new);
		this.add(id_txt);
		this.add(pwd_new);
		this.add(pwd_txt);
		this.add(name_new);
		this.add(name_txt);
		this.add(birth_new);
		this.add(pan_birth_new);
		this.add(address_new);
		this.add(address_txt);
		this.add(gen_new);
		this.add(gen_com);
		this.add(num_new);
		this.add(num_txt);
		this.add(register);
		this.add(reset);
//     	this.setVisible(true);
	}

	public static void main(String[] args) {
//		new NewMemberCreate("My page");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String pw = "";
		if(obj==register) {					//회원가입 버튼을 눌렀을 경우
			String name = name_txt.getText();
			String id = id_txt.getText();
			char[] secret_pw = pwd_txt.getPassword();
			for(char cha : secret_pw){ 
				Character.toString(cha); //cha에 저장된 값 String으로 변환
				pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
			}
			String pwd = pw;
//			String pwd;
			String address = address_txt.getText();
			String year = (String) year_com.getSelectedItem();
			String month = (String) month_com.getSelectedItem();
			String day = (String) day_com.getSelectedItem();
			String gen = (String) gen_com.getSelectedItem();
			String num = num_txt.getText();
			String birth = year+"/"+month+"/"+day;
			int pnt = 0;
			if(name.equals("")||id.equals("")||pwd.equals("")||address.equals("")
					||year.equals("")||
					month.equals("")||
					day.equals("")||
					gen.equals("")
					||num.equals("")){					//하나라도 입력하지 않은 경우
				JOptionPane.showMessageDialog(this, 
					"입력되지 않은 사항이 있습니다.");
			} else {
				CRUDprocess crud = new CRUDprocess();
				Customer_Info ci = new Customer_Info();
				
				ci.setCustomer_name(name);
				ci.setCustomer_id(id);
				ci.setCustomer_pwd(pw);
				ci.setCustomer_birth(birth);
				ci.setCustomer_addr(address);
				ci.setCustomer_gen(gen);
				ci.setCustomer_num(num);
				ci.setCustomer_pnt(pnt);
				
				int r = crud.insertCustomer(ci);
				if(r > 0) {
					JOptionPane.showMessageDialog(this, 
							"회원정보가 등록되었습니다.");
				}else {
					JOptionPane.showMessageDialog(this, 
						"회원정보 등록 중 오류가 발생했습니다.");
				}
			}
				//위의 두가지를 통과하면 삽입
			} else {
				JOptionPane.showMessageDialog(this, "이미 동일한 ID가 존재합니다.");
			}
		if(obj == reset) {
			name_txt.setText("  ");
			name_txt.setText("");
			id_txt.setText("  ");
			id_txt.setText("");
			pwd_txt.setText("  ");
			pwd_txt.setText("");
			address_txt.setText("  ");
			address_txt.setText("");
			year_com.setSelectedIndex(0);
			month_com.setSelectedIndex(0);
			day_com.setSelectedIndex(0);
			gen_com.setSelectedIndex(0);
			num_txt.setText("  ");
			num_txt.setText("");
			
		}
		}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if(obj == month_com) {
			day_com.removeAllItems();
			day_com.addItem("일");
			//선택한 월을 찾는다.
			int month = month_com.getSelectedIndex();
			//선택한 위치 즉, 첫번째 항목이면 0, 두번째 항목이면 1,,,
			switch(month) {
			case 4:
			case 6:
			case 9:
			case 11:
				for(int i=1; i<=30; i++) {
					day_com.addItem(i+"");
				}//1부터 30을 채운다.
				break;
			case 2:
				for(int i=1; i<=28; i++) {
					day_com.addItem(i+"");
				}
				break;
			default : 
				for(int i=1; i<=31; i++) {
					day_com.addItem(i+"");
				}
			}
		}
	}
}

