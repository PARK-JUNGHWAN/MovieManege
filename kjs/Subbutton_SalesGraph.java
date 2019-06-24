package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Subbutton_SalesGraph extends JPanel{
	Font font;
	JPanel Main3_2;
	JPanel SouthPanel;
	JButton ok;
	Subbutton_SalesTable sst;

	void init() {
		font = new Font("굴림", Font.BOLD,15);
		Main3_2 = new JPanel();
		SouthPanel = new JPanel();
				
		ok = new JButton("pdf 조회");
		ok.setBackground(new Color(051,255,000));
		ok.setFont(font);

		SouthPanel.setPreferredSize(new Dimension(200,60)); 

		SouthPanel.add(ok);

	}
	public Subbutton_SalesGraph(Subbutton_SalesTable sst) {
//		super(str);
		this.sst=sst;
		init();
		this.setLayout(new BorderLayout());
		this.add("Center", Main3_2);
		this.add("South" , SouthPanel);
//		this.setSize(1200,650); 
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new Subbutton_SalesGraph("Admin Management");

	}

}