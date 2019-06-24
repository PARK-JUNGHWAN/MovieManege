package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.ui.Screen;


public class DepMovieSet extends JPanel implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == Calandar) {
			new CalendarMovie(this).setLocation(0, 0);
						
		} else if (o == select) {
				table.setModel(new TimeTableModel());


		} else if(o==moviesearch) {
//			combo1.removeAllItems();
//			CRUDprocess crud = new CRUDprocess();
//			List<Screen_Info> info = crud.selectAllMovieNameInfo();
//			Iterator it = info.iterator();
//			rows = info.size();
//			tableData = new Object[rows];
//			int r = 0;
//			while(it.hasNext()) {
//				Screen_Info mi = (Screen_Info)it.next();//조회결과를 가져옴
//				tableData[r]= mi.getScreen_mname();
//				combo1.addItem(mi.getScreen_mname());
//				r++;
			
			combo1.removeAllItems();
			CRUDprocess crud = new CRUDprocess();
			List<Movie_Info> info = crud.AllMovieNameInfo();
			Iterator it = info.iterator();
			rows = info.size();
			tableData = new Object[rows];
			int r = 0;
			while(it.hasNext()) {
				Movie_Info mi = (Movie_Info)it.next();//조회결과를 가져옴
				tableData[r]= mi.getMovie_name();
				combo1.addItem(mi.getMovie_name());
				r++;	
				
				
			}
			
		} else if(o==ok) {
			String code = combo1.getSelectedItem().toString();
			int code2 = screen.getSelectedIndex();
			int code3 = round.getSelectedIndex();
			String code4 = birtextField_1[0].getText();
			String code5 = birtextField_1[1].getText();
			if(code.equals("영화를 선택하세요.")) { //
				JOptionPane.showMessageDialog(sm, "영화를 선택하세요.");
			}else if(code2==0) {
				JOptionPane.showMessageDialog(sm, "상영관를 선택하세요.");
			}else if(code3==0) {
				JOptionPane.showMessageDialog(sm, "회차를 선택하세요.");
			}else if(code4.equals("")) {
				JOptionPane.showMessageDialog(sm, "상영 시작시간을 선택하세요.");
			}else if(code5.equals("")) {
				JOptionPane.showMessageDialog(sm, "상영 종료시간을 선택하세요.");
			}
			else {
				CRUDprocess crud = new CRUDprocess();
				List<Screen_Info> screen_info = crud.selectAllScreenInfo();
					if(screen_info!=null) {

						String first = (String)combo1.getSelectedItem();//영화명
						int secend = screen.getSelectedIndex();
						int third = round.getSelectedIndex();
						String forth = birtextField_1[0].getText();
						String fifth = birtextField_1[1].getText();
						
						Screen_Info cust= new Screen_Info();
						cust.setScreen_mname(first);
						cust.setScreen_screen(secend);
						cust.setScreen_round(third);
						cust.setScreen_begin(forth);
						cust.setScreen_end(fifth);
						int r = crud.insertTime(cust);
						if(r > 0) {
							JOptionPane.showMessageDialog(sm, 
								"영화정보가 등록되었습니다.");
						} else {
							JOptionPane.showMessageDialog(sm, "영화정보 등록 중 문제가 발생했습니다.");
						}
				}
			
				
			}
		} else if(o == cancel) {
			textField[0].setText("");
			screen.setSelectedItem("  상영관 선택  ");
			round.setSelectedItem("  회차 선택  ");
			birtextField_1[0].setText("");
			birtextField_1[1].setText("");
		} else if(o == remove) {
			
			System.out.println("삭제");
		}

	}
	Object[] tableData;
	int rows;
	JTable table;
	DefaultTableModel dtm;
	String[] tcolume = {"상영 시작시간", "상영 종료시간"};
	

	Font font;
	JPanel NorthPanel;
	JPanel DepMovieSet;
	JButton	select,Calandar;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"   영화명  ","            상영일  ","   ", "   "};
	JComboBox combo1;
	
	JPanel[] panels;
	JLabel[] labels_1;
	JTextField[] birtextField_1;
	String[] labels_1_title = {"상영관     ","회차     ","상영 시작시간   ","상영 종료시간   "};
	JPanel textarea;
	JScrollPane scrollPane;
	
	JPanel SouthPanel;
	JButton ok;
	JButton cancel;
	JLabel empty,empty2,empty3;
	Subbutton_Movie sm;
	ReservationBoardPan1 rbp;
	
	JComboBox screen,round;
	JButton moviesearch;
	JButton remove;
	
	void screen() {
		screen = new JComboBox();		
		screen.addItem("  상영관 선택  ");
		screen.addItem(1);
		screen.addItem(2);
		screen.addItem(3);
		screen.addItem(4);
		
	}
	
	void round() {
		round = new JComboBox();		
		round.addItem("  회차 선택  ");
		round.addItem(1);
		round.addItem(2);
		round.addItem(3);
		round.addItem(4);
		round.addItem(5);
		
	}
	
	void makeLabel() {
		labels = new JLabel[4];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(label_title[i]);//레이블 생성
			labels[i].setFont(font);
		}
		labels_1 = new JLabel[4];
		for(int i=0; i<labels_1.length; i++) {
			labels_1[i] = new JLabel(labels_1_title[i]);//레이블 생성
			labels_1[i].setFont(font);
		}
	}
	void makeTextField() {
		textField = new JTextField[4];//배열 생성
		for(int i=0; i<textField.length; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
		}
		
		birtextField_1 = new JTextField[2];
			birtextField_1[0] = new JTextField(20);
			birtextField_1[0].setFont(font);
			birtextField_1[1] = new JTextField(20);
			birtextField_1[1].setFont(font);
		
	}
	void makePanel() {
		panels = new JPanel[5];
		for(int i=0; i<panels.length;i++) {
			panels[i] = new JPanel();
			panels[i].setLayout(new FlowLayout());
		}
	}
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		DepMovieSet = new JPanel();
		SouthPanel = new JPanel();
		Calandar = new JButton("달력");
		select = new JButton("조회");
		moviesearch = new JButton("영화 조회");
		remove = new JButton("삭제");
		
		table = new JTable(dtm);
		textarea = new JPanel();
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textarea.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(600,600));
		
		dtm = new DefaultTableModel(tcolume,0);

		select.setFont(font);
		Calandar.setFont(font);
		makeLabel(); makeTextField(); makePanel();screen();round();
		
		
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		combo1 = new JComboBox();
		combo1.addItem("영화를 선택하세요.");
//		combo1.addItem("    악인전    ");combo1.addItem("    앤드게임    ");
//		combo1.addItem("    피카츄    ");combo1.addItem("    배심원들    ");
		
		
		ok = new JButton("등록");
		cancel = new JButton("취소");
		empty = new JLabel("     ");
		empty2 = new JLabel("     ");
		empty3 = new JLabel("     ");
		ok.setFont(font);
		cancel.setFont(font);
		remove.setFont(font);
		SouthPanel.setPreferredSize(new Dimension(200,60));
		
		NorthPanel.add(labels[1]);
		NorthPanel.add(textField[1]);
		NorthPanel.add(labels[2]);
		NorthPanel.add(Calandar);
		
		panels[0].add(labels[0]);
		panels[0].add(combo1);
		panels[0].add(moviesearch);
		panels[1].add(labels_1[0]);
		panels[1].add(screen);
		panels[2].add(labels_1[1]);
		panels[2].add(round);
		panels[2].add(labels[3]);
		panels[3].add(labels_1[2]);
		panels[3].add(birtextField_1[0]);
		panels[4].add(labels_1[3]);
		panels[4].add(birtextField_1[1]); 

		
//		textarea.add(scrollPane);
		
		
		SouthPanel.add(select);
		SouthPanel.add(empty);
		SouthPanel.add(ok);
		SouthPanel.add(empty2);
		SouthPanel.add(cancel);
		SouthPanel.add(empty3);
		SouthPanel.add(remove);
		
		select.addActionListener(this);
		Calandar.addActionListener(this);
		moviesearch.addActionListener(this);
		cancel.addActionListener(this);
		ok.addActionListener(this);
		remove.addActionListener(this);
	}
	public DepMovieSet(Subbutton_Movie sm) {
//		super(str);
		this.sm = sm;
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", DepMovieSet);
		this.add("East", panels[3].add(scrollPane));
		this.add("South", SouthPanel);
		DepMovieSet.setLayout(new GridLayout(7,1));
		for(int i=0; i<5; i++) {
			DepMovieSet.add(panels[i]);
		}
//		this.setSize(1200,650); 
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class TimeTableModel extends AbstractTableModel{
		@Override
		public String getColumnName(int column) {
			return columnName[column];
		}

		private Object[][] tableData; 
		private int rows, cols;
		private String[] columnName = {"영화명","상영관","회차","상영 시작시간","상영 종료시간"};
		private List<Screen_Info> list;
		TimeTableModel(){
			CRUDprocess crud = new CRUDprocess();
			list = crud.selectAllScreenInfo();
			setData();
			

		}
		private void setData() {
			rows = list.size();
			cols = columnName.length;
			tableData = new Object[rows][cols];
			Iterator it = list.iterator();
			int r = 0;
			while(it.hasNext()) {
				Screen_Info screen = (Screen_Info)it.next();
				tableData[r][0] = screen.getScreen_mname();
				tableData[r][1] = screen.getScreen_screen();
				tableData[r][2] = screen.getScreen_round();
				tableData[r][3] = screen.getScreen_begin();
				tableData[r][4] = screen.getScreen_end();
				r++;
			}
		}
		
		
		public int getRowCount() {
			// TODO Auto-generated method stub
			return rows;
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return cols;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			return tableData[rowIndex][columnIndex];
		}
		
		
		
	}
	

}