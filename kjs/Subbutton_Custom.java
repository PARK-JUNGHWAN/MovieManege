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

public class Subbutton_Custom extends JPanel implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == cselect) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "search");
		} else if( o == cupdate) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "update");
		} else if( o == cdelete) {
			subpanel.setVisible(true);
			this.subcard.show(subpanel, "delete");
		}
		
	}
	JPanel Subbutton_Custom;
	Font font;
	JButton cselect, cupdate, cdelete; 
	Test ts;
	
	CardLayout subcard;
	JPanel subpanel;
	JPanel Main1,Main2,Main3;
	DepCustomSerch depsustomserch;
//	DepCustomUpdate depcustomupdate;
	DepCustomDelete depcustomdelete;
	
	CustomerInfoChange mpic;
	
	Customerdelete cd;
	
	void init() {
		font = new Font("굴림",Font.BOLD,20);
		Subbutton_Custom = new JPanel();
		Main1 = new JPanel();
		Main2 = new JPanel();
		Main3 = new JPanel();
		cselect = new JButton("회원 조회");
		cupdate = new JButton("회원 수정");
		cdelete = new JButton("회원 삭제");
		cselect.setFont(font);
		cupdate.setFont(font);
		cdelete.setFont(font);
		Subbutton_Custom.setLayout(new GridLayout(1,3));
		Subbutton_Custom.add(cselect);
		Subbutton_Custom.add(cupdate);
		Subbutton_Custom.add(cdelete);
		cselect.setBackground(new Color(225,225,100));
		cupdate.setBackground(new Color(225,225,100));
		cdelete.setBackground(new Color(225,225,100));

		Subbutton_Custom.setPreferredSize(new Dimension(1200,60));
		
		cselect.addActionListener(this);
		cupdate.addActionListener(this);
		cdelete.addActionListener(this);
		
		subcard = new CardLayout();
		subpanel = new JPanel();
		subpanel.setLayout(subcard);
		
		depsustomserch = new DepCustomSerch(this);
//		depcustomupdate = new DepCustomUpdate(this);
		depcustomdelete = new DepCustomDelete(this);
		cd = new Customerdelete();
		mpic = new CustomerInfoChange();
		
	
		subpanel.add(depsustomserch,"search");
		subpanel.add(mpic,"update");
		subpanel.add(cd,"delete");
	
	}
	public Subbutton_Custom(Test ts) {
//		super(ts);
		this.ts=ts;
		init();
		this.setLayout(new BorderLayout());
		this.add("North", Subbutton_Custom);
		this.add("Center", subpanel);
		subpanel.setVisible(false);

//		this.setSize(1200,800); 
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new Subbutton_Custom("Admin Management");

	}

}