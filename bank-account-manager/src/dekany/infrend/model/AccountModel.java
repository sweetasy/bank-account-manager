package dekany.infrend.model;

public class AccountModel {
	
	private String owner;
	private int balance;
	private String accountNumber;
	private String status;
	
	
	
	
	public AccountModel(){
		
	}
	
	
	
	public AccountModel(String owner, int balance, String accountNumber, String status) {
		super();
		this.owner = owner;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.status = status;
	}


	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	

}
