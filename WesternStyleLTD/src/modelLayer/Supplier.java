package modelLayer;

public class Supplier {
	private int sid;
	private String name;
	private String address;
	private String country;
	private String phoneNo;
	private String email;
	
	
	
public Supplier(int sid) { 
	this.sid = sid;
	
}



public int getSid() {
	return sid;
}



public void setSid(int sid) {
	this.sid = sid;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getAddress() {
	return address;
}



public void setAddress(String address) {
	this.address = address;
}



public String getCountry() {
	return country;
}



public void setCountry(String country) {
	this.country = country;
}



public String getPhoneNo() {
	return phoneNo;
}



public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}


}
