
public class Konto 
{

	private String accountName;
	private int balance;
	private int password;
	
	public Konto(String name, int balancee, int safePassword) 
	{
		accountName = name;
		balance = balancee;
		password = safePassword;
	}
	
	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPassword() {
		return password;
	}

	

}
