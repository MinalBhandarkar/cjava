import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Account extends DatabaseConnection
{
	protected int accId;
	protected String name;
	protected float balance;
	protected String date1;
	
	public abstract void accept();
	public abstract float withdraw(int id,int bal);
	public abstract void display();
	public abstract float deposit();
	
	public Account()
	{
		this.accId = 0;
		this.name = "NULL";
		this.balance = 0;
	}
	
	public Account(int accId, String name, float balance, String date) 
	{
		this.accId = accId;
		this.name = name;
		this.balance = balance;
		this.date1 = date;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getDate() {
		return date1;
	}

	public void setDate(String date) {
		this.date1 = date;
	}
	

	
}
