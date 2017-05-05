package dekany.infrend.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean(name="report")
@SessionScoped
public class ReportBean {
	
	
	private Date date = new Date();
	
    public Date getDate() {
        return date;
    }
 
    public void setDate(Date date1) {
        this.date = date1;
    }
	
	
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
     
    }
    
	public void dateSelectedAction(SelectEvent e){
		Date date = (Date)e.getObject();
	
	}
    
	public void showDate(){
		System.out.println("Dátum: " + getDate().toString());
	}

}
