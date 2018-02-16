package pl.deruckiireneusz.model;

public class Customer {
	private int id;
	private String name;
	private String surname;
	private String birthday;
	
	public Customer(String name, String surname, String birthday) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}
	public Customer() 
	{}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + "]";
	}
	
	public int getId() {
		return id;
	}
	public Customer setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Customer setName(String name) {
		this.name = name;
		return this;
	}
	public String getSurname() {
		return surname;
	}
	public Customer setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public String getBirthday() {
		return birthday;
	}
	public Customer setBirthday(String birthday) {
		this.birthday = birthday;
		return this;
	}

}
