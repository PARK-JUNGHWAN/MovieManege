package javagers.jjy;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javagers.pjh.ReservationMovie;

public class MyLoginEvent implements ActionListener {
	LoginSystem log; 
	RealMain main;	
	ReservationMovieButton btnnn;
	ReservationMovie rm;
	public MyLoginEvent(LoginSystem log, RealMain main, ReservationMovieButton btnnn) {
		this.log = log;
		this.main = main;		//추가한 main도 생성자로 받도록 추가해준다.
		this.btnnn = btnnn;
		rm = new ReservationMovie(main);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == log.login || obj == log.pwd_txt) {	//로그인 버튼을 누른 경우
			//로그인 버튼을 누르거나 암호를 입력하고 엔터를 누른 경우
			//DB에 접속한 후, customer_info 테이블에서 계정과 암호를 찾는다.
			//찾은 계정과 암호를 비교한다.
			String id = log.id_txt.getText();	//입력한 ID를 id에 저장
			String pwd = log.pwd_txt.getText();	//입력한 암호를 pwd에 저장
			UserIdPwd idPwd = new UserIdPwd();
			idPwd.setId(id);
			idPwd.setPwd(pwd);
			CRUDprocess crud = new CRUDprocess();
			Customer_Info info = crud.selectIdAndPwd(idPwd);
			
			if(info == null) {	//로그인실패
//				String title = "정보관리 시스템 TEST ver 0.2 계정과 암호를 확인하세요.";
				//title을 윈도우의 제목으로 출력
//				log.setTitle(title);		//패널로 바뀌어서 제목설정이 안된다.
//				ts.setTitle(title);
				//다이얼로그 생성//////////
				JOptionPane.showMessageDialog(main, "ID와 암호를 확인하세요.");
			} else if(info.getCustomer_id().equals("admin") && info.getCustomer_pwd().equals("admin")){
				main.card.show(main.slide, "admin");
				JOptionPane.showMessageDialog(main, "관리자 페이지로 안내합니다.");
//				main.login.setText("Logout");
//				main.notUserSearch.setText("Admin Menu");
				main.btnn.setVisible(false);
				
				
			}	else { //로그인 성공
//				String title = "정보관리 시스템 TEST ver 0.2 환영합니다. [ " + id + " ]님 ";
				//title을 윈도우의 제목으로 출력
//				main.setTitle(title);
				JOptionPane.showMessageDialog(main, "환영합니다, " + id + " 님 !");
				main.card.show(main.slide, "home");
				main.login.setText("Logout");
				String imgPath5 = "src\\javagers\\image\\logoutButton.jpg";
				ImageIcon originIcon5 = new ImageIcon(imgPath5);
				Image originImg5 = originIcon5.getImage();
				Image changedImg5 = originImg5.getScaledInstance(70, 70, Image.SCALE_SMOOTH );
				ImageIcon Icon5 = new ImageIcon(changedImg5);
				main.login.setIcon(Icon5);
				main.notUserSearch.setText("MyPage");
			}
		} 
		if(obj == log.createnew) {
			main.card.show(main.slide, "newMember");
		}
		if(obj == log.findIDPW) {
			main.card.show(main.slide, "idpwFind");
		}
		if(obj == btnnn.btn) {
			main.card.show(main.slide, "reserve");
		}
		
//		else if(obj == log.cancel) {	//다시입력 버튼을 누른 경우
//			//계정 텍스트필드와 암호 텍스트필드를 지운다.
//			log.id_txt.setText(" ");	//계정 텍스트필드를 지움
//			log.id_txt.setText("");
//			log.pwd_txt.setText(" ");//암호 텍스트필드를 지움
//			log.pwd_txt.setText("");
//		}
		
	}

}
