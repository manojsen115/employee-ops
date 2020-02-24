package manoj.sen.employeeops.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="mid_name")
	private String mid_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="dob")
	private String date;
	@Column(name="mob")
	private int mob;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	
	public Employee() {
		
	}
	
	public Employee(long id, String first_name, String mid_name, String last_name, String date, int mob, String email,
			String address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.mid_name = mid_name;
		this.last_name = last_name;
		this.date = date;
		this.mob = mob;
		this.email = email;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMid_name() {
		return mid_name;
	}
	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Empolyee [id=" + id + ", first_name=" + first_name + ", mid_name=" + mid_name + ", last_name="
				+ last_name + ", date=" + date + ", mob=" + mob + ", email=" + email + ", address=" + address + "]";
	}

}
