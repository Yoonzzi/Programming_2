package project_diary;

public class LoginData  {
	private String id;
	private String password;
	private String name;
	
	LoginData (String id, String password, String name) {
		this.id=id;
		this.password=password;
		this.name=name;
	}
	
	public void setId(String id){
		this.id=id;
		}
	
	public void setPassword(String password){
		this.password=password;
		}
	
	public void setName(String name){
		this.name=name;
		}
	
	
	public String getId(){
		return id;
		}
	
	public String getPassword(){
		return password;
		}
	
	public String getName(){
		return name;
		}
}


