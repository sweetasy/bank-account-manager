package dekany.infrend.bean;


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import java.util.Random;

import dekany.infrend.DAO.UserDAO;
import dekany.infrend.model.UserModel;
 
@ManagedBean(name="userWizard")
@ViewScoped
public class UserWizard implements Serializable {
 
    private UserModel user = new UserModel();
          
    public UserModel getUser() {
        return user;
    }
 
    public void setUser(UserModel user) {
        this.user = user;
    }
     
    public void save() { 
    	
    	if(user!=null){
    	UserDAO.createUser(user.getFirstname(), user.getLastname(), user.getStreet(), user.getCity(), user.getPostalCode(), user.getPersonalID(), user.getPhone(), user.isActive(), 12345678, user.getPass());
    	System.out.println(user.toString());
        FacesMessage msg = new FacesMessage("Successful", "Added : " + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    	}
    	
    	UserDAO.testUser();
    }
     
    
    public int generatePasswd(){
    	
    	Random rand= new Random(System.currentTimeMillis());
    	int n = rand.nextInt(20000)+10000;
    	System.out.println(n);
    	return n;
    }
     
    public String onFlowProcess(FlowEvent event) {
      
    	    user.setPass(Integer.toString((generatePasswd())));
            return event.getNewStep();
            
        
    }	
}