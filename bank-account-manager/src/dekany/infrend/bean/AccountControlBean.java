package dekany.infrend.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dekany.infrend.DAO.AccountDAO;
import dekany.infrend.model.*;

@ManagedBean(name="dtAccountSelect")
@SessionScoped
public class AccountControlBean implements Serializable{

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = request.getSession();
	private List<AccountModel> accounts = createAccount();
	private AccountModel selectedAccount;
	private String cash;
	
	private List<AccountModel> createAccount(){
		String user = session.getAttribute("userCode").toString();
		
		
		List<AccountModel> accounts = AccountDAO.showAccount(user);
		
		
		return accounts;
	}

	public List<AccountModel> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountModel> accounts) {
		this.accounts = accounts;
	}

	public AccountModel getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(AccountModel selectedAccount) {
		this.selectedAccount = selectedAccount;
	}
	
	public void newAccount(){
		AccountDAO.addAccount(session.getAttribute("userCode").toString(), cash);
		System.out.println("HELLO");
	}
	
	
	

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String startTranzaction(int val){
		
		session.setAttribute("accountNum", selectedAccount.getAccountNumber());
		switch (val) {
		case 1:
			
			return "transfer.xhtml";
			
		case 2:
			
			return "cashin.xhtml";
			
		case 3:
			
			return "cashout.xhtml";

		default:
			return "error.xhtml";
		}
	}
	
	
	
	
}
