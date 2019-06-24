package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DepMovieSerch3 extends JPanel implements ActionListener{
		
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o==moviesearch) {
//			combo1.removeAllItems();
//			CRUDprocess crud = new CRUDprocess();
//			List<Screen_Info> info = crud.selectAllMovieNameInfo();
//			Iterator it = info.iterator();
//			dms.rows = info.size();
//			dms.tableData = new Object[dms.rows];
//			int r = 0;
//			while(it.hasNext()) {
//				Screen_Info mi = (Screen_Info)it.next();//조회결과를 가져옴
//				dms.tableData[r]= mi.getScreen_mname();
//				combo1.addItem(mi.getScreen_mname());
//				r++;
			
			combo1.removeAllItems();
			CRUDprocess crud = new CRUDprocess();
			List<Movie_Info> info = crud.AllMovieNameInfo();
			Iterator it = info.iterator();
			dms.rows = info.size();
			dms.tableData = new Object[dms.rows];
			int r = 0;
			while(it.hasNext()) {
				Movie_Info mi = (Movie_Info)it.next();//조회결과를 가져옴
				dms.tableData[r]= mi.getMovie_name();
				combo1.addItem(mi.getMovie_name());
				r++;	
				
				
			}
		} else if(o==Allselect) {
			jtable.setModel(new TimeTableModel());

		} else if(o==select2_1){
			String code = combo1.getSelectedItem().toString();
			String code2 = combo2.getSelectedItem().toString();
			if(code.equals("영화를 선택하세요.")) {
				JOptionPane.showMessageDialog(sm, "영화를 선택하세요.");
			} else {
				
			}
		}
		
	}
	Object[] tableData;
	int rows;
	JTable jtable;
	DefaultTableModel dtm;
	JPanel textarea;
	JScrollPane scrollPane;
	
	Font font;
	JPanel NorthPanel;
	JButton	select2_1,Allselect;
	JLabel[] labels;
	JTextField[] textField;
	String[] label_title= {"영화명","   상영관","  "};
	JComboBox combo1;
	JComboBox combo2;
	Subbutton_Movie sm;
	JButton moviesearch;
	DepMovieSet dms;
	
	void makeLabel() {
		labels = new JLabel[3];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(label_title[i]);//레이블 생성
			labels[i].setFont(font);
		}
	}
	void makeTextField() {
		textField = new JTextField[2];//배열 생성
		for(int i=0; i<textField.length; i++) {
			textField[i] = new JTextField(10);
			textField[i].setFont(font);
		}
	}	
	void init() {
		font = new Font("굴림", Font.BOLD,15);
		NorthPanel = new JPanel();
		select2_1 = new JButton("조회");
		select2_1.setFont(font);
		Allselect = new JButton("전체 조회");
		Allselect.setFont(font);
		Allselect.setBackground(new Color(051,255,000));
		moviesearch = new JButton("영화 조회");
		dms = new DepMovieSet(sm);
		
		jtable = new JTable();
		textarea = new JPanel();
		scrollPane = new JScrollPane(jtable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textarea.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(600,300));
		
		makeLabel(); makeTextField();
		NorthPanel.setPreferredSize(new Dimension(200,60)); 
		combo1 = new JComboBox();
		combo1.addItem("영화를 선택하세요.");
//		combo1.addItem("    악인전    ");combo1.addItem("    앤드게임    ");
//		combo1.addItem("    피카츄    ");combo1.addItem("    배심원들    ");
		combo2 = new JComboBox();
		combo2.addItem(1);combo2.addItem(2);
		combo2.addItem(3);combo2.addItem(4);
		NorthPanel.add(labels[0]);
		NorthPanel.add(combo1);
		NorthPanel.add(moviesearch);
		NorthPanel.add(labels[1]);
		NorthPanel.add(combo2);
		NorthPanel.add(labels[2]);

		NorthPanel.add(select2_1);
		NorthPanel.add(Allselect);
		
		moviesearch.addActionListener(this);
		Allselect.addActionListener(this);
	}
	public DepMovieSerch3(Subbutton_Movie sm) {
//		super(str);
		this.sm = sm;
		init();
		this.setLayout(new BorderLayout());
		this.add("North", NorthPanel);
		this.add("Center", scrollPane);

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
		private String[] columnName = {"영화번호","영화명","영화장르","영화등급","상영관"
				,"가격","감독","주연"};
		private List<Movie_Info> list;
		TimeTableModel(){
			CRUDprocess crud = new CRUDprocess();
			list = crud.selectAllMovieInfo();
			setData();
			

		}
		private void setData() {
			rows = list.size();
			cols = columnName.length;
			tableData = new Object[rows][cols];
			Iterator it = list.iterator();
			int r = 0;
			while(it.hasNext()) {
				Movie_Info screen = (Movie_Info)it.next();

				tableData[r][0] = screen.getMovie_num();
				tableData[r][1] = screen.getMovie_name();
				tableData[r][2] = screen.getMovie_genre();
				tableData[r][3] = screen.getMovie_age();
				tableData[r][4] = screen.getMovie_screen();
				tableData[r][5] = screen.getMovie_price();
				tableData[r][6] = screen.getMovie_director();
				tableData[r][7] = screen.getMovie_actor();


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