import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class Current extends Account {

	public void accept() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Account id");
		accId=sc.nextInt();
		
		System.out.println("Name");
		name=sc.next();
		
		System.out.println("how much ammount do you want to deposit");
		balance=sc.nextInt();
		
		if(balance>=10000)
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");  
			Date date = new Date();  
			date1=formatter.format(date);	
			System.out.println(date1);
		}
		else
		{
			System.out.println("Please deposit amount greater than 10000");
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/employeedetail1","root","root");  
			PreparedStatement smt=(PreparedStatement) con.prepareStatement("insert into bank values(?,?,?)");  
            smt.setInt(1,accId);
            smt.setString(2, name);
            smt.setInt(3,(int) balance);
            int i=smt.executeUpdate();  
    		System.out.println(i+" records inserted");  
			con.close();  
		}
		catch(Exception e){ System.out.println(e);
		}  
	}  
		
		
	

	public float withdraw(int id,int balance) 
	{
		System.out.println("Enter the amount to be withdrawn:");
		Scanner sc=new Scanner(System.in);
		int amt=sc.nextInt();

			balance=balance-amt;
			System.out.println("Amount withdrawn successfully");
			System.out.println("Balance is :"+balance);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/employeedetail1","root","root");  
			PreparedStatement smt=(PreparedStatement) con.prepareStatement("update bank set balance=? where id=?");  
            smt.setInt(2,id);
            smt.setInt(1, (int) balance);
            int i=smt.executeUpdate();  
    		System.out.println(i+" records updated");  
			con.close();  
		}
		catch(Exception e){ System.out.println(e);
		}
		return balance;
		
	}

	public void display() {
		System.out.println(" Account id:"+accId);
		System.out.println("balance is:"+balance);
		System.out.println("Account holder Name:"+name);
		System.out.println("opening date is:"+date1);
		
	}

	public float deposit() {
		System.out.println("Enter the amount to be deposited:");
		Scanner sc=new Scanner(System.in);
		int amt=sc.nextInt();
		balance+=amt;
		System.out.println("Amount Deposited successfully");
		return balance;
	}




	

}
