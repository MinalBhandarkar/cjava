package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

//import com.mysql.jdbc.PreparedStatement;

public class mydb {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
	try
	{
	  Class.forName("com.mysql.jdbc.Driver");
	
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
     Statement stmt=con.createStatement();
     ResultSet rs=stmt.executeQuery("select * from priya");
     while(rs.next())
     {
	   System.out.println("id "+rs.getInt(1)+"name "+rs.getString(2)+"salary"+rs.getInt(3));
     }
    
     
     //insert
     System.out.println("enter id");
     int id=sc.nextInt();
     System.out.println("enter name");
     String name=sc.next();
     System.out.println("enter salary");
     int salary=sc.nextInt();
     String s1="insert into priya values(?,?,?)";
     PreparedStatement stmt1=con.prepareStatement(s1);
     stmt1.setInt(1, id);
     stmt1.setString(2,name);
     stmt1.setInt(3, salary);
     int rs1=stmt1.executeUpdate();
     if(rs1>0)
     {
    	 System.out.println("inserted..");
     }
     else
     {
    	 System.out.println("not inserted");
     }
    
     //update
    // System.out.println("enter id for update");
    // id=sc.nextInt();
     System.out.println("enter new  name and salary");
     
      name=sc.next();
    salary=sc.nextInt();
    id=sc.nextInt();
     String up="update priya set  name=?,salary=? where id=?";
     PreparedStatement stmt2=con.prepareStatement(up);
    
     stmt2.setString(1,name);
     stmt2.setInt(2, salary);
     stmt2.setInt(3, id);
     int rs2=stmt2.executeUpdate();
     if(rs2>0)
     {
    	 System.out.println("updated..");
     }
     else
     {
    	 System.out.println("not notupdated");
     }
     
     
     //delete
     System.out.println("enter id for delete");
     id=sc.nextInt();
     String de="delete from priya where id=?";
     PreparedStatement rs3=con.prepareStatement(de);
     rs3.setInt(1, id);
     int r2=rs3.executeUpdate();
     
     if(r2>0)
     {
    	 System.out.println("deleted..");
     }
     else
     {
    	 System.out.println("not deleted");
     }
     
     
     con.close();
	
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
		
	}
   

}
