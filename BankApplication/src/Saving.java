import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Saving extends Account
{
	public void accept()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Account id");
		accId=sc.nextInt();
		
		System.out.println("Name");
		name=sc.next();
		
		System.out.println("how much ammount do you want to deposit");
		balance=sc.nextInt();
		
			try
			{
				if(balance<=10000)
				{
				   throw new LowBalanceException("you have insufficient balance!!!");
				}
			}
			
			catch(LowBalanceException e)
			{
				System.out.println(e);
			}
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			Date date = new Date();  
			date1=formatter.format(date);
			
			
	}
	
	public void display()
	{
		System.out.println(" Account id:"+accId);
		System.out.println("balance is:"+balance);
		System.out.println("Account holder Name:"+name);
		System.out.println("opening date is:"+date1);
	}

	@Override
	public float withdraw(int id,int bal) 
	{
		System.out.println("Enter the amount to be withdrawn:");
		Scanner sc=new Scanner(System.in);
		int amt=sc.nextInt();
		if(balance>0)
		{
			balance=balance-amt;
			System.out.println("Amount withdrawn successfully");
		}
		else
		{
			System.out.println("Insufficient balance");
		}
		return balance;
	}

	@Override
	public float deposit()
	{
		System.out.println("Enter the amount to be deposited:");
		Scanner sc=new Scanner(System.in);
		int amt=sc.nextInt();
		balance+=amt;
		System.out.println("Amount Deposited successfully");
		return balance;
	}
	
}