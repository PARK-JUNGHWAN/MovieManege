package javagers.jjy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javagers.jjy.GraphPanel;
import javagers.jjy.CRUDprocess;
import javagers.jjy.SalesGraph_Info;;

class GraphPanel extends JPanel{
	private int total_dec, total_jan, total_feb;		//setter를 써야해서 private으로 은닉 
	private int total_mar, total_apr, total_may;
	
	public void setTotal_dec(int total_dec) {
		this.total_dec = total_dec;
	}

	public void setTotal_jan(int total_jan) {
		this.total_jan = total_jan;
	}

	public void setTotal_feb(int total_feb) {
		this.total_feb = total_feb;
	}

	public void setTotal_mar(int total_mar) {
		this.total_mar = total_mar;
	}

	public void setTotal_apr(int total_apr) {
		this.total_apr = total_apr;
	}

	public void setTotal_may(int total_may) {
		this.total_may = total_may;
	}
	
//	final String PATH = "src\\jjy\\mathimage2.jpg";
//	Image img;
//
//	GraphPanel(){
//		img = Toolkit.getDefaultToolkit().getImage(PATH);
//	}

	@Override
	public void paint(Graphics g) {
		//g.clearRect(0, 0, this.getWidth(), this.getHeight());	
		//그려질 영역을 지운다. (0,0) 에서 (패널의 가로길이, 패널의 세로길이) 까지 지운다.
		
//			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
		
		g.drawLine(50, 250, 650, 250);		//수평선을 그린다.
//		g.setColor(Color.white);
		for(int cnt = 1; cnt<11; cnt++) {
			g.drawString(cnt*10+"", 25, 255-20*cnt);	//문자열을 그리기 위해 "" 추가.
//			g.setColor(Color.white);
			//문자열 "10"을 x좌표 25만큼, y좌표 235에서 그린다.
			g.drawLine(50, 250-20*cnt, 650, 250-20*cnt);
//			g.setColor(Color.white);
			//x좌표 50에서 y좌표 230가 시작선, x좌표 350에서 y좌표 230이 끝나는 선으로 해서 수평선.
		}//10점부터 100점까지 점수와 수평선을 그린다. ( 10회 반복 )
		g.drawLine(50, 20, 50, 250);	//x좌표 50,y좌표20 ~ x좌표50,y좌표250의 수직선을 그린다.
		g.drawString("12월", 100, 270);
		g.drawString("1월", 200, 270);
		g.drawString("2월", 300, 270);
		g.drawString("3월", 400, 270);
		g.drawString("4월", 500, 270);
		g.drawString("5월", 600, 270);
		g.setColor(new Color(173, 216, 230));
		
		if(total_dec > 0) {
			g.fillRect(610, 250-total_dec*2, 10, total_dec*2);
		}
		if(total_jan > 0) {		//값이 있는 경우에만 그래프를 그림
			g.fillRect(110, 250-total_jan*2, 10, total_jan*2);
		}
		if(total_feb > 0) {
			g.fillRect(210, 250-total_feb*2, 10, total_feb*2);
		}
		if(total_mar > 0) {
			g.fillRect(310, 250-total_mar*2, 10, total_mar*2);
		}
		if(total_apr > 0) {
			g.fillRect(410, 250-total_apr*2, 10, total_apr*2);
		}
		if(total_may > 0) {
			g.fillRect(510, 250-total_may*2, 10, total_may*2);
		}
		
	}
}

public class SalesGraph extends JFrame implements ActionListener{

	Button btn;
	TextField[] textFields;
	Panel[] panels;
	GraphPanel graphPanel;
	@Override
	public void actionPerformed(ActionEvent e) {
		int dec = 0;
		int jan = 0;
		int feb = 0;
		int mar = 0;
		int apr = 0;
		int may = 0;
		CRUDprocess crud = new CRUDprocess();
		SalesGraph_Info output = crud.selectSalesGraph_Info();	//DB에서 매출정보 검색
		dec = output.getDec();
		jan = output.getJan();		
		feb = output.getFeb();		
		mar = output.getMar();		
		apr = output.getApr();
		may = output.getMay();
		
		
//		if(!textFields[0].getText().equals("")) {
//			jan = Integer.parseInt(textFields[0].getText());
//		}
//		if(!textFields[1].getText().equals("")) {
//			feb = Integer.parseInt(textFields[1].getText());
//		}
//		if(!textFields[2].getText().equals("")) {
//			mar = Integer.parseInt(textFields[2].getText());
//		}
		graphPanel.setTotal_dec(dec);
		graphPanel.setTotal_jan(jan);
		graphPanel.setTotal_feb(feb);
		graphPanel.setTotal_mar(mar);
		graphPanel.setTotal_apr(apr);
		graphPanel.setTotal_may(may);
		
		graphPanel.repaint();		//다시 그린다.	
			
	}
	
	void makeTextfield() {
		textFields = new TextField[3];
		for(int i = 0; i < textFields.length; i++) {
			textFields[i] = new TextField(5);
		}
	}
	
		public SalesGraph() {
//		super(str);
		this.setLayout(new BorderLayout());
//		makeLabel();
		makeTextfield();
		btn = new Button("그리기");
		btn.setBackground(new Color(255,235,205));
		btn.addActionListener(this);
		panels = new Panel[2];
		panels[0] = new Panel();
		panels[1] = new Panel();
//		for(int i = 0; i <labels.length;i++) {		//3회 반복
//			panels[1].add(labels[i]);		//레이블을 두번째 패널에 붙임
//			panels[1].add(textFields[i]);	//텍스트필드를 패널에 붙임
//		}
		
		panels[1].add(btn);	//두번째 패널에 버튼을 붙임
		//panels[0].setBackground(new Color(221,160,221));
		//graphPanel.setBackground(new Color(221,160,221));
		panels[1].setBackground(new Color(216,191,216));
		graphPanel = new GraphPanel();
		this.setBackground(new Color(221,160,221));
		
		this.add("Center",graphPanel);		//윈도 가운데에 첫번째패널 붙임
		this.add("South",panels[1]);;		//윈도 아래에 두번째패널 붙임
		
		this.setSize(700, 460);
		this.setLocation(380, 260);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public static void main(String[] args) {
		new SalesGraph();
	}

}
