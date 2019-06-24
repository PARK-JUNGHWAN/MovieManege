package javagers.kdw;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;






public class CRUDprocess {
//이 클래스의 목적:MyBatis의 매퍼를 호출한다.
//무슨일을 하나? 
//	1. MyBaits환경설정파일을 읽는다.
//  2. 위의 1의 작업으로 매퍼를 호출할 객체(SqlSession)를 생성한다.
//특이사항:SqlSession은 SqlSessionFactory가 생성한다.
//		 SqlSessionFactory는 SqlSessionFactoryBuilder가 생성한다.
//////////////////SqlSession을 만드는 메서드/////////////
	private SqlSession getSession() {
		String path="javagers/kdw/mybatis_config.xml";//환경설정파일의 경로
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
	public int insertCustomer(Customer_info customer) {
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
	
	
	
	public int updateCustomerInfo(Customer_info customer) {
		SqlSession s = getSession();
		int result = 0;//작업의 성공유무를 위한 변수
		try {
			result = s.update("loginmapper.updateCustomerInfo",customer);
			if(result > 0) s.commit();
			else s.rollback();
			return result;
		}finally {
			s.close();
		}
	}
	
	public Customer_info selectCustomerInfo(String id){
		SqlSession s = getSession();
		Customer_info ci = null;
		try {
			ci = s.selectOne("loginmapper.selectCustomerInfo",id);
			return ci;
		}finally {
			s.close();
		}
	}
	
	public List<Customer_info> selectAllCustomer() {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.selectAllCustomerInfo");
			return info;
		}finally {
			s.close();
		}
	}
	
	public List<Customer_info> selectidCustomer(String id) {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.selectidCustomer", id);
			return info;
		}finally {
			s.close();
		}
	}
	
	
	public List<Customer_info> selectnameCustomer(String name) {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.selectnameCustomer", name);
			return info;
		}finally {
			s.close();
		}
	}
	public List<Customer_info> selectnumCustomer(String num) {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.selectnumCustomer", num);
			return info;
		}finally {
			s.close();
		}
		
	
	}
	public List<Customer_info> selectbirthCustomer(String birth) {
		SqlSession s = getSession();
		List<Customer_info> info = null;
		try {
			info = s.selectList("loginmapper.selectbirthCustomer", birth);
			return info;
		}finally {
			s.close();
		}
	}
	
	
	public Customer_info selectnameCustomerInfo(String name) {
		
		SqlSession s = getSession();
		Customer_info ci = null;

		try {
			ci = s.selectOne("loginmapper.selectnameCustomerInfo", name);
			return ci;
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
	

}
	
	










