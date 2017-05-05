package dekany.infrend.bean;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import dekany.infrend.DAO.SearchDAO;
import dekany.infrend.model.*;

@ManagedBean(name="dtUserSelect")
@SessionScoped
public class UserControlBean implements Serializable  {


	private static final long serialVersionUID = 1L;
	

	private String searchfirstName;		
	private String searchlastName;	
	private String searchID;	
	private int searchCID;
	
	private UserModel selectedUser;
	private List<UserModel> users;
	
	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	
	
	public void searchUsersbyfirstName() throws IOException{
		
		if( (searchfirstName != null) && (searchfirstName.matches("^[^0-9()]+$")) && (searchfirstName.length()>2) && (searchfirstName.matches("\\w+\\.?"))){
		
			
			List<UserModel> lista = SearchDAO.searchUserbyfName(searchfirstName);
			
		if(searchfirstName.equals(lista.get(0).getFirstname())){
			users = lista;
			FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager/faces/searchuser.xhtml");

		}else{
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Not found", 
					"Nouser with firstname: " + searchfirstName)); 
		}
		}else{
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"A vezetéknév nem tartalmazhat üres karaktert és számot","")); 
			
		}
	}
	
	public void searchUsersbylasttName() throws IOException{
		
		
		if( (searchlastName != null) && (searchlastName.matches("^[^0-9()]+$")) && (searchlastName.length()>2) && (searchlastName.matches("\\w+\\.?"))){
			
			List<UserModel> lista = SearchDAO.searchUserbylName(searchlastName);

	
		if(searchlastName.equals(lista.get(0).getLastname())){
			users = lista;
			FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager/faces/searchuser.xhtml");

		}else{
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Not found", 
					"Nouser with lastname: " + searchlastName)); 
		}
	}else{
		FacesContext.getCurrentInstance().addMessage( 
				null, 
				new FacesMessage(FacesMessage.SEVERITY_WARN, 
				"A keresztnév nem tartalmazhat üres karaktert és számot","")); 
		
	}
	}

	
	
	public void searchUsersbyCID() throws IOException{

	}
	
	
	public void searchUsersbyID() throws IOException{
		
		if(searchID !=null && searchID.matches("\\w+\\.?") && searchID.length()==8)
		{		
			List<UserModel> lista = SearchDAO.searchUserbyPersonalID(searchID);
			
		
		if(searchID.equals(lista.get(0).getPersonalID())){
			users = lista;
			FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager/faces/searchuser.xhtml");

		}else{
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"Not found", 
					"Nouser with ID: " + searchID)); 
		}
		
		}else{
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
					"A személyigazolványszámnak 8karakterből kell állnia és nem tartalmazhat szóközt","")); 
		}
		
	}
	
	public String getSearchfirstName() {
		return searchfirstName;
	}

	public void setSearchfirstName(String searchfirstName) {
		this.searchfirstName = searchfirstName;
	}

	public String getSearchlastName() {
		return searchlastName;
	}

	public void setSearchlastName(String searchlastName) {
		this.searchlastName = searchlastName;
	}
	public String getSearchID() {
		return searchID;
	}

	public void setSearchID(String searchID) {
		this.searchID = searchID;
	}

	public int getSearchCID() {
		return searchCID;
	}

	public void setSearchCID(int searchCID) {
		this.searchCID = searchCID;
	}

	public UserModel getSelectedUser() {
	        return selectedUser;
	    }
	 
	    public void setselectedUser(UserModel selectedUser) {
	        this.selectedUser = selectedUser;
	    }
	 
	    	 
		
		public List<UserModel> getUsers() {
			return users;
		}

		public void setUsers(List<UserModel> users) {
			this.users = users;
		}
		
		

		public String modify() throws IOException {
			
			
			session.setAttribute("firstName", selectedUser.getFirstname());
			session.setAttribute("lastName", selectedUser.getLastname());
			session.setAttribute("postalCode", selectedUser.getPostalCode());
			session.setAttribute("city", selectedUser.getCity());
			session.setAttribute("street", selectedUser.getStreet());
			session.setAttribute("phone", selectedUser.getPhone());
			session.setAttribute("userCode", selectedUser.getUserCode());
			session.setAttribute("personalID", selectedUser.getPersonalID());
			session.setAttribute("passw", selectedUser.getPass());
			return "edit.xhtml";
		    }
		

		
		public String showAccounts(){
			session.setAttribute("userCode", selectedUser.getUserCode());
			
			
			return "accounts.xhtml";
		}
		
		

	
}
