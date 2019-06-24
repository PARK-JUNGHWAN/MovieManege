package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javagers.jjy.RealMain;


public class DepMovieRegister extends JPanel implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn1) {
			String num = textField[0].getText();//영화 번호를 불러옴
			if(num.equals("")) { //영화번호를 입력하지 않은 경우
				JOptionPane.showMessageDialog(sm, 
					"영화 번호를 입력해 주세요.");
			} else { //동일한 영화번호가 DB에 존재하는지 검사
				CRUDprocess crud = new CRUDprocess();
				Movie_Info mi = crud.selectMovie(num);
				if(mi != null) { //동일한 사번이 존재하는 경우
					 JOptionPane.showMessageDialog(sm, "동일한 영화 번호가 이미 존재합니다.");
				} else { //동일한 사번이 존재하지 않는 경우
					String number=textField[0].getText();//이름
					String name=textField[1].getText();//주소
					String genre=textField[2].getText();//가입일
					String age=(String) movieAge.getSelectedItem();
					String screen=(String) movieScreen.getSelectedItem();
					String price=textField[3].getText();
					String image=imagesystem.text.getText();
					String infos=movieInfo.getText();
					String director=textField[4].getText();
					String actor=textField[5].getText();
					Movie_Info cust=new Movie_Info();
					cust.setMovie_num(number); 
					cust.setMovie_name(name);
					cust.setMovie_genre(genre);
					cust.setMovie_age(age);
					cust.setMovie_screen(screen);
					cust.setMovie_price(price);
					cust.setMovie_image(image);
					cust.setMovie_infos(infos);
					cust.setMovie_director(director);
					cust.setMovie_actor(actor);
					
					int r = crud.insertMovie(cust);
					if(r > 0) {
						JOptionPane.showMessageDialog(sm, 
							"영화정보가 등록되었습니다.");
					} else {
						JOptionPane.showMessageDialog(sm, "영화정보 등록 중 문제가 발생했습니다.");
					}
			}
		}
		
		
	} else if(obj == btn2) {
		textField[0].setText("");
		textField[1].setText("");
		textField[2].setText("");
		
		movieAge.setSelectedItem("관람등급 선택");
		movieScreen.setSelectedItem("상영관 선택");
		imagesystem.text.setText("");

		textField[3].setText(" ");
		movieInfo.setText("");
		textField[4].setText("");
		textField[5].setText("");
		
	} else if(obj==search) {
		String code = textField[1].getText();//입력한 상품번호
		CRUDprocess crud = new CRUDprocess();
		Movie_Info info = crud.selectMovie(code);
		if(info == null) { //해당 상품정보가 없는 경우
			JOptionPane.showMessageDialog(sm, "해당 영화 정보가 없습니다.");
		}else { //있는 경우 DB의 검색정보를 윈도우 컴포넌트에 출력한다.
			textField[0].setText(info.getMovie_num());
			textField[1].setText(info.getMovie_name());
			textField[2].setText(info.getMovie_genre());
			movieAge.setSelectedItem(info.getMovie_age());
			movieScreen.setSelectedItem(info.getMovie_screen());
			textField[3].setText(info.getMovie_price());
			imagesystem.text.setText(info.getMovie_image());
			movieInfo.setText(info.getMovie_infos());
			textField[4].setText(info.getMovie_director());
			textField[5].setText(info.getMovie_actor());
				
		}
	} else if(obj==delete) {
		int result = JOptionPane.showConfirmDialog(
				sm,"정말 삭제를 원하십니까?","delete confirmation",JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			//DB에서 삭제 작업을 진행
			String code = textField[1].getText();
			if(code.equals("")) {
				JOptionPane.showMessageDialog(sm, "영화 정보가 없어서 진행할 수 없습니다.");
			} else {
				//DB에서 해당 상품번호를 삭제
				CRUDprocess crud = new CRUDprocess();
				int r = crud.deleteMovie(code);
				if (r>0) {
					JOptionPane.showMessageDialog(sm, "삭제 완료.");
				} else {
					JOptionPane.showMessageDialog(sm, "삭제 중 문제가 발생했습니다.");
				}
			}
		} else if(result == JOptionPane.NO_OPTION) {

		} 
		
	} else if(obj==update) {
		int result = JOptionPane.showConfirmDialog(
				sm,"정말 진행하시겠습니까?","update confirmation",JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			String code = textField[1].getText();
			if(code.equals("")) {
				JOptionPane.showMessageDialog(sm, "먼저 조회해 주세요.");
			} else {
				//DB에서 해당 상품의 정보를 변경
				CRUDprocess crud = new CRUDprocess();
				String number=textField[0].getText();
				String genre=textField[2].getText();
				String age=(String) movieAge.getSelectedItem();
				String screen=(String) movieScreen.getSelectedItem();
				String price=textField[3].getText();
				String image=imagesystem.text.getText();
				String infos=movieInfo.getText();
				String director=textField[4].getText();
				String actor=textField[5].getText();
				Movie_Info cust=new Movie_Info();
				cust.setMovie_num(number); 
				cust.setMovie_name(code);
				cust.setMovie_genre(genre);
				cust.setMovie_age(age);
				cust.setMovie_screen(screen);
				cust.setMovie_price(price);
				cust.setMovie_image(image);
				cust.setMovie_infos(infos);
				cust.setMovie_director(director);
				cust.setMovie_actor(actor);
				
				int r = crud.updateMovie(cust);
				if(r>0) {
					JOptionPane.showMessageDialog(sm, "성공적으로 수정 되었습니다.");
				}else {
					JOptionPane.showMessageDialog(sm, "문제 발생");
				}
			}
		} else if(result == JOptionPane.NO_OPTION) {
			
		}
	}

	}
	Font font;
	JButton btn1, btn2;
//	JPanel listPanel;
	JPanel[] panels;
	JPanel main;
	JLabel[] labels;
	JList jlist;
	JTextField[] textField;
	JComboBox movieAge, movieScreen;
	JTextArea movieTime, movieInfo;
	String[] labels_title = {"영화번호", "영화명", "영화장르", "영화등급", "상영관", "회차", "금액",
								"영화이미지","영화설명","감독","주연"};
	
	Subbutton_Movie sm;
	ImageSystem imagesystem;
	Test test;
	JScrollPane scrollPane;
	JPanel textPanel;
	JButton search;
	JButton delete;
	JButton update;
	RealMain realmain;
	public void makeButton() {
		btn1 = new JButton("등 록"); btn1.setFont(font);
		btn2 = new JButton("취 소"); btn2.setFont(font);
		search = new JButton("조 회"); search.setFont(font);
		delete = new JButton("삭 제"); delete.setFont(font);
		update = new JButton("변 경"); update.setFont(font);
	}
	
//	void makeJlist() {
//		listPanel = new JPanel();
//		String[] listModel = {"09:00~11:00","11:30~13:30","14:00~16:00","16:30~18:30","19:00~21:00"
//								,"21:30~23:30"};
//		jlist = new JList(listModel);
//		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		jlist.setBorder(BorderFactory.createLineBorder(Color.black,1));
//		jlist.setVisibleRowCount(4);
//		JScrollPane scrollPane = new JScrollPane(jlist);
//		scrollPane.setPreferredSize(new Dimension(200, 50));
//		listPanel.add(scrollPane);
//			
//	}

	public void makeJTextArea() {
		textPanel = new JPanel();
		movieInfo = new JTextArea(3,50);
		scrollPane = new JScrollPane(movieInfo);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		movieInfo.setPreferredSize(new Dimension(200,50));
		movieInfo.setCaretPosition(movieInfo.getDocument().getLength());
		textPanel.add(scrollPane);
	}
	
	
	public void makeAge() {
		movieAge = new JComboBox();		
		movieAge.addItem("관람등급 선택"); movieAge.setFont(font);
		movieAge.addItem("전체관람가");
		movieAge.addItem("12세 관람가");
		movieAge.addItem("15세 관람가");
		movieAge.addItem("청소년 관람불가");
		
		panels[3].add(movieAge);
	}
	
	public void makeScreen() {
		movieScreen = new JComboBox();		movieScreen.setFont(font);
		movieScreen.addItem("상영관 선택");
		movieScreen.addItem("1관");
		movieScreen.addItem("2관");
		movieScreen.addItem("3관");
		movieScreen.addItem("4관");
		
		panels[4].add(movieScreen);	
	}
	
	public void makePanel() {
		panels = new JPanel[11];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new JPanel();
		}
	}
	
	public void makeTextField() {
		textField = new JTextField[6];	
		for(int i = 0 ; i < textField.length; i++) {
			textField[i] = new JTextField(15);
		}
	}
	
	public void makeLabel() {
		labels = new JLabel[11];
		for(int i = 0 ; i < labels.length; i++) {
			labels[i] = new JLabel(labels_title[i]);
			labels[i].setFont(font);
		}
	}
	public DepMovieRegister(Test test) {
		
	}
	
	public DepMovieRegister(Subbutton_Movie sm) {
//		super(str);
		this.sm=sm;
		font = new Font("굴림", Font.BOLD,15);
		this.setLayout(new BorderLayout());
		main = new JPanel();
		main.setLayout(new GridLayout(11, 1));
//		makeJlist();
		makePanel();
		makeAge();
		makeJTextArea();
		makeLabel();
		makeScreen();
		makeTextField();
		makeButton();
		imagesystem = new ImageSystem(realmain); 

		panels[0].add(labels[0]);
		panels[0].add(textField[0]);
		panels[1].add(labels[1]);
		panels[1].add(textField[1]);
		panels[2].add(labels[2]);
		panels[2].add(textField[2]);
		panels[3].add(labels[3]);
		panels[3].add(movieAge);
		panels[4].add(labels[4]);
		panels[4].add(movieScreen);
//		panels[5].add(labels[5]);
//		panels[5].add(listPanel);
		panels[5].add(labels[6]);
		panels[5].add(textField[3]);
		panels[6].add(labels[7]);
		panels[6].add(imagesystem.southPanel);
		panels[7].add(labels[8]);
		panels[7].add(textPanel);
//		panels[7].setBorder(new TitledBorder(new EtchedBorder(),"영화내용",TitledBorder.LEFT,TitledBorder.TOP,
//				new Font("굴림",Font.PLAIN,11),Color.BLACK));
		panels[8].setPreferredSize(new Dimension(300,1));
		
		panels[8].add(labels[9]);
		panels[8].add(textField[4]);
		panels[9].add(labels[10]);
		panels[9].add(textField[5]);
		panels[10].add(btn1);
		panels[10].add(search);
		panels[10].add(update);
		panels[10].add(delete);
		panels[10].add(btn2);
		for(int i = 0 ; i < panels.length; i++) {
			main.add(panels[i]);
		}
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		search.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
//		this.setVisible(true);
//		this.setLocation(550, 50);
//		this.setSize(1200, 650);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add("West",main);
		this.add("Center",imagesystem.imagePanel);
		
	}
	
		
	public static void main(String[] args) {
//		new Main2_3("테스트");

	}

}