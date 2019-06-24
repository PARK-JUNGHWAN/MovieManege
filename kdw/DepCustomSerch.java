package javagers.kdw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DepCustomSerch extends JPanel implements ActionListener{
	Font font;
	JPanel NorthPanel;
	JPanel Main1_1;
	JButton	select1_1;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"이름","   아이디","   전화번호","   생년월일"," ~ "};
	Subbutton_Custom sc;
	String searchId;
	
	
	CustomerInfoJtable cij;
	void makeLabel() {
		labels = new JLabel[5];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(label_title[i]);//레이블 생성
			labels[i].setFont(font);
		}
	}
	void makeTextField() {
		textField = new JTextField[5];//배열 생성
		for(int i=0; i<textField.length; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
		}
	}	
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		Main1_1 = new JPanel();
		cij = new CustomerInfoJtable(this);

		select1_1 = new JButton("조회");
		select1_1.addActionListener(this);
		select1_1.setFont(font);
		makeLabel(); makeTextField();
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		
//		NorthPanel.add(labels[0]);
//		NorthPanel.add(textField[0]);
//		NorthPanel.add(labels[1]);
//		NorthPanel.add(textField[1]);
//		NorthPanel.add(labels[2]);
//		NorthPanel.add(textField[2]);
//		NorthPanel.add(labels[3]);
//		NorthPanel.add(textField[3]);
//		NorthPanel.add(labels[4]);
//		NorthPanel.add(textField[4]);
//		NorthPanel.add(select1_1);
	}
	
	public DepCustomSerch(Subbutton_Custom sc) {
//		super(str);
		
		this.sc=sc;
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", cij);
		
		
		
//		this.setSize(1200,650); 
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new Main1_1("Admin Management");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == select1_1) {
			JOptionPane.showMessageDialog(this, "아래 부분조회 버튼을 클릭하시오");
		}
		
	}

}