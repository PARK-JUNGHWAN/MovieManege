 package javagers.jjy;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javagers.kdw.Customer_info;
import javagers.kjs.Screen_Info;


public class CRUDprocess {
//이 클래스의 목적:MyBatis의 매퍼를 호출한다.
//무슨일을 하나? 
//	1. MyBaits환경설정파일을 읽는다.
//  2. 위의 1의 작업으로 매퍼를 호출할 객체(SqlSession)를 생성한다.
//특이사항:SqlSession은 SqlSessionFactory가 생성한다.
//		 SqlSessionFactory는 SqlSessionFactoryBuilder가 생성한다.
//////////////////SqlSession을 만드는 메서드/////////////
	private SqlSession getSession() {
		String path="javagers/jjy/mybatis_config.xml";//환경설정파일의 경로
		InputStream is = null;//파일의 내용을 읽을 객체
		try {
			is = Resources.getResourceAsStream(path);
		}catch(Exception e) {
			System.out.println("환경설정파일을 읽는 중 예외발생");
		}//예외처리
		SqlSessionFactoryBuilder builder = 
			new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is);
		SqlSession session = factory.openSession();
		return session;
	}
	public int insertCustomer(Customer_Info customer) {
		SqlSession s = getSession();
		int result = 0;//작업의 성공유무를 위한 변수
		try {
			result = s.insert("loginmapper.insertCustomer",customer);
			if(result > 0) s.commit();
			else s.rollback();
			return result;
		}finally {
			s.close();
		}
	}
	
	public Customer_Info selectIdAndPwd(UserIdPwd uip){			//로그인
		SqlSession s = getSession();
		try {
			Customer_Info info = s.selectOne("loginmapper.selectIdPwd",uip);
			return info;
		} finally {	
			s.close();
		}
	}
	
	public List<Customer_info> selectidCustomer(String id) {		//도완형 회원정보수정 조회
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.selectidCustomer");
			return info;
		}finally {
			s.close();
		}
	}
	
	public Reserve_Info selectReserveInfo(String rnum){			//예매조회 -> 조회
		SqlSession s = getSession();
		Reserve_Info ci = null;
		try {
			ci = s.selectOne("loginmapper.selectReserveInfo",rnum);
			return ci;
		}finally {
			s.close();
		}
	}
	
	public Reserve_Info selectReserveInfo2(String num){			//예매조회 -> 조회
		SqlSession s = getSession();
		Reserve_Info ci = null;
		try {
			ci = s.selectOne("loginmapper.selectReserveInfo2",num);
			return ci;
		}finally {
			s.close();
		}
	}
	
	public Customer_Info selectCustomerInfo(String id){
		SqlSession s = getSession();
		Customer_Info ci = null;
		try {
			ci = s.selectOne("loginmapper.selectCustomerInfo",id);
			return ci;
		}finally {
			s.close();
		}
	}
	
	public int updateCustomerInfo(Customer_Info customer) {
		SqlSession s = getSession();
		int result = 0;			//작업의 성공유무를 위한 변수
		try {
			result = s.update("loginmapper.updateCustomerInfo",customer);
			if(result > 0) s.commit();
			else s.rollback();
			return result;
		}finally {
			s.close();
		}
	}
	
	public int deleteCustomerID(String id) {		
		SqlSession s = getSession();
		int result = 0;
		try {
			result = s.delete("loginmapper.deleteCustomerId", id);
			if(result > 0) {
				s.commit();
			} else {
				s.rollback();
			}
			return result;
		} finally {
			s.close();
		}
	}
	
public Customer_Info selectnameCustomerInfo(String name) {		//ID/PW 찾기 
		
		SqlSession s = getSession();
		Customer_Info ci = null;
		try {
			ci = s.selectOne("loginmapper.selectnameCustomerInfo", name);
			return ci;
		}finally {
			s.close();
		}

	}
	
public SalesGraph_Info selectSalesGraph_Info() {
		SqlSession s = getSession();
		SalesGraph_Info outputs;
		try {
			outputs = s.selectOne("loginmapper.selectSalesGraph_Info");
			return outputs;
		} finally {
			s.close();
		}
	}

	public javagers.jjy.Movie_Info selectMovie(String num){					//영화조회
		SqlSession s = getSession();
		javagers.jjy.Movie_Info movie = null;
		try {
			movie = s.selectOne("loginmapper.selectMovie",num);
			return movie;
		}finally {
			s.close();
		}
	}

	public int insertMovie(javagers.jjy.Movie_Info movie) {					//영화입력
		SqlSession s = getSession();
		int result = 0;//작업의 성공유무를 위한 변수
		try {
			result = s.insert("loginmapper.insertMovie", movie);
			if(result > 0) s.commit();
			else s.rollback();
			return result;
		}finally {
			s.close();
		}
	}
		public List<javagers.jjy.Screen_Info> selectAllMovieNameInfo() {
			SqlSession s = getSession();
			List<javagers.jjy.Screen_Info> info = null;
			try {
				info = s.selectList("loginmapper.selectAllMovieNameInfo");
				return info;
			}finally {
				s.close();
			}
		}
		
		public List<javagers.jjy.Screen_Info> selectAllScreenInfo() {
			SqlSession s = getSession();
			List<javagers.jjy.Screen_Info> info = null;
			try {
				info = s.selectList("loginmapper.selectAllScreenInfo");
				return info;
			}finally {
				s.close();
			}
		}
		
		public javagers.jjy.Screen_Info selectTime(String mnum){
			SqlSession s = getSession();
			javagers.jjy.Screen_Info  screen;
			try {
				screen = s.selectOne("loginmapper.selectTime",mnum);
				return screen;
			}finally {
				s.close();
			}
		}
		
		public int insertTime(javagers.jjy.Screen_Info screen) {
			SqlSession s = getSession();
			int result = 0;//작업의 성공유무를 위한 변수
			try {
				result = s.insert("loginmapper.insertTime", screen);
				if(result > 0) s.commit();
				else s.rollback();
				return result;
			}finally {
				s.close();
			}
		}
		
		public javagers.jjy.Screen_Info selectScreenInfo(String num){		
			SqlSession s = getSession();
			javagers.jjy.Screen_Info ci = null;
			try {
				ci = s.selectOne("loginmapper.selectScreenInfo",num);
				return ci;
			}finally {
				s.close();
			}
		}
		
		
		
		
	
	
	}
	
	
	










