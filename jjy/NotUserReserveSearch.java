package javagers.jjy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javagers.jjy.CRUDprocess;
import javagers.jjy.Reserve_Info;

public class NotUserReserveSearch extends JPanel{
	
	NursOne nursOne; NursTwo nursTwo; NursThree nursThree;
	
	final String PATH = "src\\javagers\\image\\reserveSearchImageBlack.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	public NotUserReserveSearch() {
//		this.setLayout(new GridLayout(3,1));
		this.setLayout(new FlowLayout());
		img = Toolkit.getDefaultToolkit().getImage(PATH);
		nursOne = new NursOne();
		nursTwo = new NursTwo();
		nursThree = new NursThree(nursOne, nursTwo);
		this.add(nursOne);
		this.add(nursTwo);
		this.add(nursThree);
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nursTwo.setPreferredSize(new Dimension(300, 300));
		this.setPreferredSize(new Dimension(300, 300));
	}

	public static void main(String[] args) {
//		new NotUserReserveSearch();
	}
}

class NursOne extends JPanel {
	JLabel ticketNumber, phoneNumber, warning;
	JTextField ticketNumberText, phoneNumberText;
	final String PATH = "src\\javagers\\image\\theater3.jpg";
	Image img;
	Font font;
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	NursOne(){
//		img = Toolkit.getDefaultToolkit().getImage(PATH);
		font = new Font("굴림", Font.ITALIC, 15);
		ticketNumber = new JLabel("예매번호");
		ticketNumber.setForeground(Color.white);
		phoneNumber = new JLabel("전화번호");
		phoneNumber.setForeground(Color.white);
		warning = new JLabel("둘 중 하나만 입력하세요.");
		warning.setForeground(Color.red);
		ticketNumberText = new JTextField(15);
		phoneNumberText = new JTextField(15);
		
		this.add(ticketNumber); 
		this.add(ticketNumberText);
		this.add(phoneNumber); 
		this.add(phoneNumberText);
		this.add(warning);
	}
}

class NursTwo extends JPanel {
	JLabel reserveNum, movie, screen, time, seat;
	JTextField reserveNumText, movieText, scrennText, timeText, seatText;
	JPanel[] panel;
	final String PATH = "src\\javagers\\image\\theater3.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	NursTwo(){
//		img = Toolkit.getDefaultToolkit().getImage(PATH);
		reserveNum = new JLabel("예매번호");
		reserveNum.setForeground(Color.white);
		movie = new JLabel("영       화");
		movie.setForeground(Color.white);
		screen = new JLabel("상 영 관");
		screen.setForeground(Color.white);
		time = new JLabel("시       간");
		time.setForeground(Color.white);
		seat = new JLabel("좌       석");
		seat.setForeground(Color.white);
		panel = new JPanel[5];
		for(int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		
		movieText = new JTextField(20);
		scrennText = new JTextField(20);
		timeText = new JTextField(20);
		seatText = new JTextField(20);
		reserveNumText = new JTextField(20);
		
		this.setLayout(new GridLayout(10,1));
		this.add(reserveNum);
		this.add(reserveNumText); 	    
		this.add(movie);
		this.add(movieText);
		this.add(screen);
		this.add(scrennText);
		this.add(time);
		this.add(timeText);
		this.add(seat);
		this.add(seatText);
		
	}
}
class NursThree extends JPanel implements ActionListener{
	JButton search, cancle;
	NursOne nursOne; NursTwo nursTwo;
	RealMain main;
	final String PATH = "src\\javagers\\image\\theater3.jpg";
	Image img;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == search) {		//조회버튼을 누른 경우
			String code1 = nursOne.ticketNumberText.getText();	//입력한 상품번호를 저장
			String code2 = nursOne.phoneNumberText.getText();
			String code3 = nursOne.ticketNumberText.getText();
			String code4 = nursOne.phoneNumberText.getText();
			CRUDprocess crud = new CRUDprocess();
			Reserve_Info info1 = crud.selectReserveInfo(code1);
			Reserve_Info info2 = crud.selectReserveInfo2(code2);
//			Screen_Info info3 = crud.selectScreenInfo(code3);
//			Screen_Info info4 = crud.selectScreenInfo(code4);
			if(info1 == null && info2 == null) {		//해당 상품정보가 없는 경우				//<< 개쩌는구현, 신의 구현
				JOptionPane.showMessageDialog(main, "해당 예매내역은 존재하지 않습니다.");
			} else if(info1 != null && info2 != null) {
				JOptionPane.showMessageDialog(main, "둘 중 하나의 정보만 입력해야합니다.");
			} else if(info2 == null){		//해당 상품정보가 있는 경우
			//DB의 검색정보를 윈도우 컴포넌트에 출력한다.
			nursTwo.reserveNumText.setText(info1.getReserve_rnum()+"");
			nursTwo.movieText.setText(info1.getReserve_title());
			nursTwo.scrennText.setText(info1.getReserve_screen());
			nursTwo.timeText.setText(info1.getReserve_time());		
			nursTwo.seatText.setText(info1.getReserve_seat());
			
			} else if(info1 == null) {
			nursTwo.reserveNumText.setText(info2.getReserve_rnum()+"");
			nursTwo.movieText.setText(info2.getReserve_title());
			nursTwo.scrennText.setText(info2.getReserve_screen());
			nursTwo.timeText.setText(info2.getReserve_time());
			nursTwo.seatText.setText(info2.getReserve_seat());
			} 
		}
			if(obj == cancle) {
			nursOne.ticketNumberText.setText("  ");
			nursOne.ticketNumberText.setText("");
			nursOne.phoneNumberText.setText("  ");
			nursOne.phoneNumberText.setText("");
			nursTwo.reserveNumText.setText("  ");
			nursTwo.reserveNumText.setText("");
			nursTwo.movieText.setText("  ");
			nursTwo.movieText.setText("");
			nursTwo.scrennText.setText("  ");
			nursTwo.scrennText.setText("");
			nursTwo.seatText.setText("  ");
			nursTwo.seatText.setText("");
			nursTwo.timeText.setText("  ");
			nursTwo.timeText.setText("");
	}
}
	NursThree(NursOne nursOne, NursTwo nursTwo){
//		img = Toolkit.getDefaultToolkit().getImage(PATH);
		this.nursOne = nursOne; this.nursTwo = nursTwo; 
		
		String imgPath1 = "src\\javagers\\image\\searchButtonBlack.jpg";
		ImageIcon originIcon1 = new ImageIcon(imgPath1);
		Image originImg1 = originIcon1.getImage();
		Image changedImg1 = originImg1.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon1 = new ImageIcon(changedImg1);
		
		String imgPath2 = "src\\javagers\\image\\resetButtonBlack.jpg";
		ImageIcon originIcon2 = new ImageIcon(imgPath2);
		Image originImg2 = originIcon2.getImage();
		Image changedImg2 = originImg2.getScaledInstance(22, 17, Image.SCALE_SMOOTH );
		ImageIcon Icon2 = new ImageIcon(changedImg2);
		
		search = new JButton("Search");
		search.setIcon(Icon1);
		search.setForeground(Color.white);
		search.setBackground(Color.black);
		search.addActionListener(this);
		search.setBorderPainted(false);
		
		cancle = new JButton("Reset");
		cancle.setIcon(Icon2);
		cancle.setForeground(Color.white);
		cancle.setBackground(Color.black);
		cancle.addActionListener(this);
		cancle.setBorderPainted(false);
		this.add(search); 
		this.add(cancle); 
		
	}

}
