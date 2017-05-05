package dekany.infrend.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

@ManagedBean(name="modifyUser")
@SessionScoped
public class ModifyUserBean {
	
	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();

	
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
	private String pass;
	
	
	
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

	
	public void listener(){
		firstname = (String) session.getAttribute("firstName");
		lastname = (String) session.getAttribute("lastName");
		postalCode = (String) session.getAttribute("postalCode");
		city = (String) session.getAttribute("city");
		street = (String) session.getAttribute("street");
		personalID = (String) session.getAttribute("personalID");
		phone = (String) session.getAttribute("phone");
		userCode = (int) session.getAttribute("userCode");
		pass = (String) session.getAttribute("passw");
		
	}
	
	
	public void modify(){
		System.out.println("Session: " + session.getAttribute("firstName"));
		System.out.println("Get: " + getFirstname());
		System.out.println("FN: " + firstname);
		session.removeAttribute("firstName");
		firstname = null;
		System.out.println("Session Invalidate: " + session.getAttribute("firstName"));
	}
	
	public void delete(){
		
		this.isActive = false;
		System.out.println("DEWBUG: " + isActive);
	
	}
	
	public String back(){
		
		return "admin.xhtml";
	}


}
