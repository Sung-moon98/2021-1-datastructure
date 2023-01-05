package Kim;

public class Animal {
	private String name;		// 동물의 이름
	private String type;		// 동물의 종류
	private Animal next; 
	
	public Animal(String name, String type) {	// 생성자
		this.name = name;
		this.type = type;
	}
	
	public String getName() { return name; }
	public String getType() { return type; }
	
	public void setName(String name) { this.name = name; }
	public void setType(String type) { this.type = type; }

}
