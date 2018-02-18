package pl.deruckiireneusz.model;

public class Vehicle {
	private int id;
	private int customer_id;
	private String model;
	private String brand;
	private String productionY;
	private String registrationNo;
	private String nextInspectionDate;
	
	
	public Vehicle(int customer_id, String model, String brand, String productionY, String registrationNo,
			String nextInspectionDate) {
		super();
		this.customer_id = customer_id;
		this.model = model;
		this.brand = brand;
		this.productionY = productionY;
		this.registrationNo = registrationNo;
		this.nextInspectionDate = nextInspectionDate;
	}
	public Vehicle() {}
	
	
	public int getId() {
		return id;
	}
	public Vehicle setId(int id) {
		this.id = id;
		return this;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public Vehicle setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
		return this;
	}
	public String getModel() {
		return model;
	}
	public Vehicle setModel(String model) {
		this.model = model;
		return this;
	}
	public String getBrand() {
		return brand;
	}
	public Vehicle setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	public String getProductionY() {
		return productionY;
	}
	public Vehicle setProductionY(String productionY) {
		this.productionY = productionY;
		return this;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public Vehicle setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
		return this;
	}
	public String getNextInspectionDate() {
		return nextInspectionDate;
	}
	public Vehicle setNextInspectionDate(String nextInspectionDate) {
		this.nextInspectionDate = nextInspectionDate;
		return this;
	}

}
