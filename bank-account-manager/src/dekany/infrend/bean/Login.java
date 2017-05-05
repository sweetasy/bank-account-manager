package dekany.infrend.bean;

import javax.faces.bean.ManagedBean;


import javax.faces.context.*;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;

import dekany.infrend.DAO.UserDAO;

import java.io.IOException;

import javax.faces.application.*;;

@ManagedBean(name="Login")
public class Login {
	

	private String username;
	private String passwd;
	private String message;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
    public void validate() throws IOException {
   
        if(username != null && username.equals("admin") && passwd != null && passwd.equals("admin")) {
        	FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager/faces/admin.xhtml");	
        } else {
        	FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
							"Incorrect Username and Passowrd", 
							"Please enter correct username and Password"));} 
        
        if(username != null && username.equals("dekany") && passwd != null && passwd.equals("123456")) {
        	FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager/faces/userpage.xhtml");	
        } else {
        	FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
							"Incorrect Username and Passowrd", 
							"Please enter correct username and Password"));} 
        
    }  
    
    public void logout() throws IOException {
    	   
    		System.out.println("LOGOUT");
        	FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager");	
       
    }  
	
	
}
