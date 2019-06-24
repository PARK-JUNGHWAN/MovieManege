package javagers.kjs;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;



class CustomerModelFive extends AbstractTableModel{
	
	String[] str;
	
	
	DepCustomSerch dcs;
	Subbutton_Custom sc;
	Test ts;
	CustomerInfoJtable cij;
	

	
private Object[][] tableData;
	
	private int cols, rows;
	
	private String [] columnName = { "회원이름", "회원ID","회원 생년월일","회원주소",
			"회원성별", "회원 전화번호", "회원포인트"};
	
	public List<Customer_info> list;


	
	//생성자
	public CustomerModelFive(DepCustomSerch dcs, String birth) {
		CRUDprocess crud = new CRUDprocess();
		
		

		
		list =  crud.selectbirthCustomer(birth);//DB조회 결과가 list에 저장됨.
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData3();
	  
		
		
	}
	
private void setData3() {
		
		java.util.Iterator<Customer_info> it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];//배열생성
		
		
			
			int r = 0;
			while(it.hasNext()) {
				Customer_info cs = it.next();//조회결과를 가져오기		김도완
				
				
				
				tableData[r][0] = cs.getCustomer_name();//고객 이름
				tableData[r][1] = cs.getCustomer_id();//고객 아이디
				tableData[r][2] = cs.getCustomer_birth();//고객생일
				tableData[r][3] = cs.getCustomer_addr();//고객 주소
				tableData[r][4] = cs.getCustomer_gen();//고객 성별
			    tableData[r][5] = cs.getCustomer_num();//고객 전화번호
			    tableData[r][6] = cs.getCustomer_pnt();//고객 포인트


				r++;
				
			}
			
		

			
		
		
		
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableData[rowIndex][columnIndex];
	}
	
	
	
}










class CustomerModelFour extends AbstractTableModel{
	
	String[] str;
	
	
	DepCustomSerch dcs;
	Subbutton_Custom sc;
	Test ts;
	CustomerInfoJtable cij;
	

	
private Object[][] tableData;
	
	private int cols, rows;
	
	private String [] columnName = { "회원이름", "회원아이디","회원 생년월일","회원주소",
			"회원성별", "회원 전화번호", "회원포인트"};
	
	public List<Customer_info> list;


	
	//생성자
	public CustomerModelFour(DepCustomSerch dcs, String num) {
		CRUDprocess crud = new CRUDprocess();
		
		

		
		list =  crud.selectnumCustomer(num);//DB조회 결과가 list에 저장됨.
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData3();
	  
		
		
	}
	
private void setData3() {
		
		java.util.Iterator<Customer_info> it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];//배열생성
		
		
			
			int r = 0;
			while(it.hasNext()) {
				Customer_info cs = it.next();//조회결과를 가져오기		김도완
				
				
				
				tableData[r][0] = cs.getCustomer_name();//고객 이름
				tableData[r][1] = cs.getCustomer_id();//고객 아이디
				tableData[r][2] = cs.getCustomer_birth();//고객생일
				tableData[r][3] = cs.getCustomer_addr();//고객 주소
				tableData[r][4] = cs.getCustomer_gen();//고객 성별
			    tableData[r][5] = cs.getCustomer_num();//고객 전화번호
			    tableData[r][6] = cs.getCustomer_pnt();//고객 포인트


				r++;
				
			}
			
		

			
		
		
		
	}
@Override
public String getColumnName(int column) {
	return columnName[column];
	
}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableData[rowIndex][columnIndex];
	}
	
	
	
}











class CustomerModelThree extends AbstractTableModel{
	
	String[] str;
	
	
	DepCustomSerch dcs;
	Subbutton_Custom sc;
	Test ts;
	CustomerInfoJtable cij;
	

	
private Object[][] tableData;
	
	private int cols, rows;
	
	private String [] columnName = { "회원이름", "회원아이디","회원 생년월일","회원주소",
			"회원성별", "회원 전화번호", "회원포인트"};
	
	public List<Customer_info> list;


	
	//생성자
	public CustomerModelThree(DepCustomSerch dcs, String name) {
		CRUDprocess crud = new CRUDprocess();
		
		

		
		list =  crud.selectnameCustomer(name);//DB조회 결과가 list에 저장됨.
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData3();
	  
		
		
	}
	
private void setData3() {
		
		java.util.Iterator<Customer_info> it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];//배열생성
		
		
			
			int r = 0;
			while(it.hasNext()) {
				Customer_info cs = it.next();//조회결과를 가져오기		김도완
				
				
				
				tableData[r][0] = cs.getCustomer_name();//고객 이름
				tableData[r][1] = cs.getCustomer_id();//고객 아이디
				tableData[r][2] = cs.getCustomer_birth();//고객생일
				tableData[r][3] = cs.getCustomer_addr();//고객 주소
				tableData[r][4] = cs.getCustomer_gen();//고객 성별
			    tableData[r][5] = cs.getCustomer_num();//고객 전화번호
			    tableData[r][6] = cs.getCustomer_pnt();//고객 포인트


				r++;
				
			}
			
		

			
		
		
		
	}


	@Override
public String getColumnName(int column) {
		return columnName[column];
		
}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableData[rowIndex][columnIndex];
	}
	
	
	
}




class CustomerModelTwo extends AbstractTableModel{
	
	String[] str;
	
	
	DepCustomSerch dcs;
	Subbutton_Custom sc;
	Test ts;
	CustomerInfoJtable cij;
	

	
private Object[][] tableData;
	
	private int cols, rows;
	
	private String [] columnName = { "회원이름", "회원아이디","회원 생년월일","회원주소",
			"회원성별", "회원 전화번호", "회원포인트"};
	
	public List<Customer_info> list;


	
	//생성자
	public CustomerModelTwo(DepCustomSerch dcs, String id) {
		CRUDprocess crud = new CRUDprocess();
		
		

		
		list =  crud.selectidCustomer(id);//DB조회 결과가 list에 저장됨.
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData2();
	  
		
		
	}
	
private void setData2() {
		
		java.util.Iterator<Customer_info> it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];//배열생성
		
		
			
			int r = 0;
			while(it.hasNext()) {
				Customer_info cs = it.next();//조회결과를 가져오기		김도완
				
				
				
				tableData[r][0] = cs.getCustomer_name();//고객 이름
				tableData[r][1] = cs.getCustomer_id();//고객 아이디
				tableData[r][2] = cs.getCustomer_birth();//고객생일
				tableData[r][3] = cs.getCustomer_addr();//고객 주소
				tableData[r][4] = cs.getCustomer_gen();//고객 성별
			    tableData[r][5] = cs.getCustomer_num();//고객 전화번호
			    tableData[r][6] = cs.getCustomer_pnt();//고객 포인트


				r++;
				
			}
			
	}
	

	@Override
	public String getColumnName(int column) {
		return columnName[column];
			
	}



	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		return cols;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableData[rowIndex][columnIndex];
	}
	
	
	
}


 class CustomerModel extends AbstractTableModel{

	private Object[][] tableData;
	
	private int cols, rows;
	
	private String [] columnName = { "회원이름", "회원아이디","회원 생년월일","회원주소",
			"회원성별", "회원 전화번호", "회원포인트"};
	
			
	public List<Customer_info> list;
	
	CustomerModel(){
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllCustomer();//DB조회 결과가 list에 저장됨.
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData();
	  
	  
	}
	
	DepCustomSerch dcs;
	
	private void setData() {
    //list에 있는 조회결과를 2차원 배열에 넣는다
		//컬렉션 프레임 워크에 저장된 데이터를 검색하는 방법 => iterator
		
		java.util.Iterator<Customer_info> it = list.iterator();
		rows = list.size();
		cols = columnName.length;
		tableData = new Object[rows][cols];//배열생성
		int r = 0;
		while(it.hasNext()) {
			Customer_info cs = it.next();//조회결과를 가져오기		김도완
			
			
			
			tableData[r][0] = cs.getCustomer_name();//고객 이름
			tableData[r][1] = cs.getCustomer_id();//고객 아이디
			tableData[r][2] = cs.getCustomer_birth();//고객생일
			tableData[r][3] = cs.getCustomer_addr();//고객 주소
			tableData[r][4] = cs.getCustomer_gen();//고객 성별
		    tableData[r][5] = cs.getCustomer_num();//고객 전화번호
		    tableData[r][6] = cs.getCustomer_pnt();//고객 포인트


			r++;
			
		}
	}



	@Override
	public String getColumnName(int column) {
		return columnName[column];
		
	}



	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getColumnCount() {
		return cols;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return tableData[arg0][arg1];
	}
	
 }
 
 
	public class CustomerInfoJtable extends JPanel implements ActionListener{

	
		CustomerModel cm;
		
		JButton select;
		JTable table;
		JPanel centerPanel,southPanel;
		JScrollPane scroll;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Object obj = arg0.getSource();
			
			if(obj == select) {
				table.setModel(new CustomerModel());
//				JOptionPane.showMessageDialog(this, "성공했습니다");
				
			}
		
				
			else if(obj == idsearch) {
				
				String id = findid.getText();
    			table.setModel(new CustomerModelTwo(dcs, id));
//				JOptionPane.showMessageDialog(this, "성공했습니다");

				
				
				
			}
			else if(obj == namesearch) {
			
				String name = findname.getText();
    			table.setModel(new CustomerModelThree(dcs, name));
//				JOptionPane.showMessageDialog(this, "성공했습니다");

				
				
				
			}
			else if(obj == numsearch) {
				
				String num = findnum.getText();
				table.setModel(new CustomerModelFour(dcs, num));
//				JOptionPane.showMessageDialog(this, "성공했습니다");
				
			}
			
			else if(obj == birthsearch) {
				
				String birth = findbirth.getText();
				table.setModel(new CustomerModelFive(dcs, birth));
//				JOptionPane.showMessageDialog(this, "성공했습니다");
				
			}
			
				
				
			}
			
			
		
		
			
			
		
		
		 DepCustomSerch dcs;

		

		TextField findid;
		TextField findname;
		TextField findnum;
		TextField findbirth;
		
		private JButton idsearch;
		private JButton namesearch;

		private JButton numsearch;

		private JButton birthsearch;

		
		public CustomerInfoJtable(DepCustomSerch dcs) {
		this.dcs =dcs;
			select = new JButton("전체 조회");
			idsearch = new JButton("id로 조회");
			namesearch = new JButton("이름으로 조회");
			numsearch = new JButton("전화번호 조화");
			birthsearch = new JButton("생일로 조회");
			
			findid = new TextField(10);
			findname = new TextField(10);
			findnum = new TextField(10);
			findbirth = new TextField(10);
			
			
			select.addActionListener(this);
			idsearch.addActionListener(this);
			namesearch.addActionListener(this);
			numsearch.addActionListener(this);
			birthsearch.addActionListener(this);
			
			table = new JTable();
			centerPanel = new JPanel();
			southPanel = new JPanel();
			scroll = new JScrollPane(table);
			scroll = new JScrollPane(table);
			centerPanel.add(scroll); southPanel.add(select);
			
			southPanel.add(idsearch); //아이디러 검색하는 버튼
			southPanel.add(findid); //검색할 ID를 쓰는 창
			
			
			southPanel.add(namesearch); // 이름으로 검색하는 버튼
			southPanel.add(findname); //검색할 이름을 쓰는 창
			
			southPanel.add(numsearch); //번호로 검색하는 버튼
			southPanel.add(findnum); //검색할 번호를 쓰는 창
//	
//			southPanel.add(birthsearch);//생일로 검색하는 버튼
//			southPanel.add(findbirth);//생일을 쓰는 창
//			
		
			
			scroll.setPreferredSize(new Dimension(800,450));
			this.add("Center",scroll); this.add("South", southPanel);
			this.setSize(500,400);
			this.setVisible(true);
			
		}
	}

	
	

