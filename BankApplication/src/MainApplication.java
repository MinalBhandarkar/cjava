import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainApplication 
{
	public static void main(String [] args)
	{
		    String wish ;
			Scanner sc1=new Scanner(System.in);
			 Saving a1=new Saving();
			  Current a2=new Current();

		    do
			{
			System.out.println("1 .for open account 2. for deposit account 3. for withdraw 4.for remove account");
			int s1=sc1.nextInt();
		
			
				switch(s1)
				{
					  case 1:
					  System.out.println("which type of account do you want to open::");
					  String name=sc1.next();
					  if(name.equals("saving"))
					  {
						  a1.accept();  
					  }
					  else if(name.equals("salary"))
					  {
						  a1.accept();  
					  }
					  else if(name.equals("current") )
					  {
						  a2.accept();
					  }
					  break;
					  
					  case 2:
						  System.out.println("Enter your account id::");
						  int accnumber=sc1.nextInt();
						  int flag=1;
						  for(int i=0;i<3;i++)
						  {
							  if( a1.accId==accnumber)
							  {
								  a1.deposit();  
								  a1.display();
								  flag=0;
								  break;
							  } 
						  }
						  break;
						  
					  case 3:
						  System.out.println("Enter your account id::");
						  int accnumber1=sc1.nextInt();
						  
						  try
							{
							Class.forName("com.mysql.jdbc.Driver");  
							Connection con=DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/employeedetail1","root","root");  
							Statement stmt=con.createStatement();  
							ResultSet rs=stmt.executeQuery("select * from bank");  
							while(rs.next())
							{
								if(rs.getInt(1)==accnumber1)
								{
									 a2.withdraw(accnumber1,rs.getInt(3));  
									 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
								}
							}
						     con.close();  
							}
						  catch(Exception e){ System.out.println(e);}  
							
						 /* int flag1=1;
						  for(int i=0;i<3;i++)
						  {
							  System.out.println(a1[i].getAccId());
							  if(a1[i].getAccId()==accnumber1)
							  {
								  a1[i].withdraw(accnumber1);  
								  a1[i].display();
								  flag1=0;
								  break;
							  }  
						  }*/
						  
						  break;
				}
				 System.out.println("Do you want to continue");
				  wish=sc1.next();
			}while(wish.equals("y") || wish.equals("Y"));
			
}
}
				  
					

