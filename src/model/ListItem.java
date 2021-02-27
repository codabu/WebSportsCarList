package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cars")
public class ListItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="MAKE")
	private String make;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="YEAR")
	private String year;
	
	//default no-arg constructor
	public ListItem (){
		super();
	}
	
	//constructor that accepts a make, model and year
	public ListItem(String make, String model, String year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	//returnItemDetails method
	
	public String returnItemDetails( ) {
		return year + " " + make + " " + model;
	}
}
