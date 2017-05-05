package dekany.infrend.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

@ManagedBean(name="tranzaction")
public class TranzactionBean{
	
	
	private String accountNo;
	private int balance;
	
	

	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	
	private String account;
	
	@Size(min=8, max=8)
	private String destAccount;
	private int money;
	private String comment;
	
	private boolean isAvaliableAccount = false;
	
	
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(String destAccount) {
		this.destAccount = destAccount;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void sendMoney(){
		
		//forrás acc balance - money és dest acc balance + money 
		
		System.out.println("DEBIG");
		
	}
	
	public void cashIn(){
		
		//TODO balance+=money
		
		System.out.println("Destination: "+account );
		System.out.println("Price: " + money );
		
		
		
	}
	
	public void cashOut(){
		
		// Balance-=money
		
	}
	
	public void checkDestination(){
		if(destAccount.equals("vagyok")){
			isAvaliableAccount = true;
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, 
							"van", 
							"MŰKÖDIK"));
		}else{
			isAvaliableAccount = false;
			FacesContext.getCurrentInstance().addMessage( 
					null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, 
							"NINCS", 
							"NEM MŰKÖDIK"));
		}
	}
	
	public void goBack() throws IOException{
    	FacesContext.getCurrentInstance().getExternalContext().redirect("/bank-account-manager/faces/admin.xhtml");	
	}
	
	public void listener(){
		account = (String) session.getAttribute("accountNum");
	}

}
