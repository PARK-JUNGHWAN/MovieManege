package javagers.kjs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DepMovieSearch extends JPanel{

	PanOne reservationTableSearchPanOne;
	Pantwo reservationTableSearchPanTwo;
	Subbutton_Movie sm;

	public DepMovieSearch(Subbutton_Movie sm){
		this.sm=sm;
		
//		super(str);
		reservationTableSearchPanOne = new PanOne(this);
		reservationTableSearchPanTwo = new Pantwo(this);
		
		this.setLayout(new BorderLayout());
		this.add("North",reservationTableSearchPanOne);
		this.add("Center",reservationTableSearchPanTwo);
		
//		this.setBounds(0, 0, 1200, 800);
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		new DepMovieSearch("");

	}
	
}
class PanOne extends JPanel {
	DepMovieSearch rt;
	JLabel label;
	JTextField txt;
	TableRowSorter<TableModel> trs;
	Font font;

	PanOne(DepMovieSearch rt){
		this.rt = rt;
		font = new Font("굴림", Font.BOLD,15);

		label = new JLabel("검색하고 싶은 필드의 정보를 입력하세요 :  ");
		label.setFont(font);
		txt = new JTextField(10);
		txt.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String val = txt.getText();
				trs = new TableRowSorter<TableModel>(rt.reservationTableSearchPanTwo.table.getModel());
				rt.reservationTableSearchPanTwo.table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
				
			}
			
		});
		
		
		this.add(label); this.add(txt);
	}
	
}

class Pantwo extends JPanel {
	
	JTable table;
	String[] columnName= {"영화 번호","영화명","영화 장르","영화 등급","상영관 회차","가격","감독","배우"};
	String[][] data; // db갯수로 행 크기 입력
	JPanel panel;
	JScrollPane scroll;
	List<Movie_Info> info;
	int number = 0;
	DepMovieSearch rt;
	TableRowSorter trs;


	Pantwo(DepMovieSearch rt){
		
		this.rt = rt;
		
		CRUDprocess crud = new CRUDprocess();
		Movie_Info ri = new Movie_Info();
		
		info = new ArrayList<>();
		info = crud.selectAllMovieInfo();
		
		data = new String[info.size()][10];
		
		for(Movie_Info i: info) {
			
			String date = i.getMovie_num();
			data[number][0] = String.valueOf(date);
			String num = i.getMovie_name();
			data[number][1] = String.valueOf(num);
			String id = i.getMovie_genre();
			data[number][2] = id;
			String p_num = i.getMovie_age();
			data[number][3] = p_num;
			String title = i.getMovie_screen();
			data[number][4] = title;
			String screen = i.getMovie_price();
			data[number][5] = String.valueOf(screen);
			String round = i.getMovie_director();
			data[number][6] = String.valueOf(round);
			String people = i.getMovie_actor();
			data[number][7] = String.valueOf(people);

		
			number++;
		}
		
		table = new JTable(data,columnName); table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(1000,500));
		scroll = new JScrollPane(table);
		panel = new JPanel();		
		panel.add(scroll);
		
		
		this.add(panel); this.setBackground(Color.ORANGE);
		
	}
}