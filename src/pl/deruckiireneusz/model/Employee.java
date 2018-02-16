package pl.deruckiireneusz.model;

public class Employee {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String cellNo;
	private String notice;
	private double manHourCost;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", cellNo="
				+ cellNo + ", notice=" + notice + ", manHourCost=" + manHourCost + "]";
	}
	
	
	public Employee(String name, String surname, String address, String cellNo, String notice, double manHourCost) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.cellNo = cellNo;
		this.notice = notice;
		this.manHourCost = manHourCost;
	}
	public Employee() 
	{}


	public int getId() {
		return id;
	}
	public Employee setId(int id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Employee setName(String name) {
		this.name = name;
		return this;
	}
	public String getSurname() {
		return surname;
	}
	public Employee setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public Employee setAddress(String address) {
		this.address = address;
		return this;
	}
	public String getCellNo() {
		return cellNo;
	}
	public Employee setCellNo(String cellNo) {
		this.cellNo = cellNo;
		return this;
	}
	public String getNotice() {
		return notice;
	}
	public Employee setNotice(String notice) {
		this.notice = notice;
		return this;
	}
	public double getManHourCost() {
		return manHourCost;
	}
	public Employee setManHourCost(double manHourCost) {
		this.manHourCost = manHourCost;
		return this;
	}

}
