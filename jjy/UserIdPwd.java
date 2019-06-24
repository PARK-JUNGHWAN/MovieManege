package javagers.jjy;	
//자바에서는 정보를 클래스에만 담을 수 있다.
//윈도우창에서 입력한 ID와 PASSWORD가 자바의 [이 클래스]에 들어오고
//이 클래스를 myMapper의 parameterType에 넣어주는 것이다.


public class UserIdPwd {

	private String id;		//DB와 연동되는 객체들은 전부 은닉시켜야 한다.
	private String pwd;
	
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	
	//은닉된 변수에 데이터를 넣어주는 메소드를 만든다.
	//이런 메소드를 세터(setter)메소드라고 한다.
	
}
