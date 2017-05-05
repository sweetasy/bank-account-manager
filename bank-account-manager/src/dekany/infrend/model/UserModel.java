package dekany.infrend.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel {
	
	
	private int ID;
	
	@Size(min=3 , max=20, message="A vezetéknévnek 3 és 20 karakter között kell lennie")
	@Pattern(regexp="^[^0-9()]+$" , message="A vezetéknév nem tartalmazhat számot")
	private String firstname;	
	
	@Size(min=3 , max=20, message="A keresztnévnek 3 és 20 karakter között kell lennie")
	@Pattern(regexp="^[^0-9()]+$" , message="A keresztnév nem tartalmazhat számot")
	private String lastname;
	
	@Pattern(regexp="^[0-9]+ .+$", message="Az utca név után számnak kell következnie")
	private String street; 
	@Pattern(regexp="^[^0-9()]+$" , message="A város nem tartalmazhat számot")
	private String city;     
	@Pattern(regexp="\\d{4}", message="Az irányítószámnak 4 számból kell állnia") 
	private String postalCode;
	
	@Pattern(regexp="\\S{8}", message="A személyigazolvány számnak 8karakternek kell lennie")
	private String personalID;
	@Pattern(regexp="\\d{9}", message="A telefonszámnak 9 számból kell állnia") 
	private String phone;
	private boolean isActive = true;
	private int userCode;
	@NotNull
	@Size(min=6 , max=20, message="A jelszónak 6 és 20 karakter között kell lennie")
	private String pass;
	


	public UserModel(int iD, String firstname, String lastname, String street, String city, String postalCode,
			String personalID, String phone, boolean isActive, int userCode, String pass) {
		super();
		ID = iD;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.personalID = personalID;
		this.phone = phone;
		this.isActive = isActive;
		this.userCode = userCode;
		this.pass = pass;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public UserModel(){};
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPersonalID() {
		return personalID;
	}
	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserModel [ID=" + ID + ", firstname=" + firstname + ", lastname=" + lastname + ", street=" + street
				+ ", city=" + city + ", postalCode=" + postalCode + ", personalID=" + personalID + ", phone=" + phone
				+ ", isActive=" + isActive + ", userCode=" + userCode + ", pass=" + pass + "]";
	}
	
	

}
