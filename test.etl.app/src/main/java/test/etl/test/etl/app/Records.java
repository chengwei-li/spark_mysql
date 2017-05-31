package test.etl.test.etl.app;

import java.io.Serializable;

public class Records implements Serializable{
	String id;
	String first_name;
	String last_name;
	String mail;
	String salary;
	String phone;
	String cost;
	
	public Records(String id, String first_name, String last_name, String mail,
			String salary, String phone, String cost) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mail = mail;
		this.salary = salary;
		this.phone = phone;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "id=" + id + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", mail=" + mail + ", salary="
				+ salary + ", phone=" + phone + ", cost=" + cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
}
