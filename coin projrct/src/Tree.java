import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.Iterator;

public interface Tree extends Collection 
{
	public static void main(String [] args) throws IOException
	{
		 TreeSet <Coin> ref=new TreeSet();
		 Scanner sc=new Scanner(System.in);
		 String ch;
		 ObjectInputStream objectIn=null;
		 FileInputStream fin=null;
		 FileOutputStream fout=null;
		 ObjectOutputStream objectOut=null;
		do
		{
			System.out.println("Enter 1. for Addition 2.for search 3.auction");
			int choice=sc.nextInt();
		switch(choice)
		{
		  case 1:
			  System.out.println("Enter country ");
			  String countryName=sc.next();

			  System.out.println("Enter denomination");
			  int denomination=sc.nextInt();

			  System.out.println("Enter Yearofminting ");
			  int Yearofminting=sc.nextInt();

			  System.out.println("Enter currentvalue ");
			  int currentvalue=sc.nextInt();
			  
			  System.out.println("Enter acquireddate ");
			  String acquireddate=sc.next();
			  
			  try 
				{
					fout = new FileOutputStream("text1.txt");
					objectOut = new ObjectOutputStream(fout);
					
					ref.add(new Coin(countryName,denomination,Yearofminting,currentvalue,acquireddate));
					objectOut.writeObject(ref);
				} 
			  
				catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      break;
		  case 2:
			  System.out.println("Enter the country name");
			  String s1=sc.next();
			  try 
			  {
				fin=new FileInputStream("text1.txt");
				objectIn = new ObjectInputStream(fin);
				TreeSet <Coin> st=new TreeSet();
				//Object obj = objectIn.readObject();
				st=(TreeSet<Coin>) objectIn.readObject();
				Iterator <Coin> itr= st.iterator();
				while(itr.hasNext())
				{
					Coin x=itr.next();
					if(x.getCountry().equals(s1))
					{
						//System.out.println(x.getAcquireddate());
						System.out.println(x.getAcquireddate()+" "+x.getCurrentvalue()+" "+x.getDenomination());
					}
				}
					//ref.add(new Coin(st.Country,st.Denomination,st.Yearofminting,st.currentvalue,st.acquireddate));
			  }
			  catch (Exception e)
			  {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
			  finally
			  {
				  fin.close();
				  objectIn.close();
			  }			 
		}
		System.out.println("do you want to continue");
		  ch=sc.next();
		}
		while(ch.equals("Y") || ch.equals("y") );
	}
}

