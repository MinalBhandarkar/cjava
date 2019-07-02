import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public interface Array extends Collection {
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		//ArrayList <Coin> ref=new ArrayList();
		 ArrayList<Coin>ref =new ArrayList();
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
			  System.out.println("enter the elements do you want to add");
			  int n=sc.nextInt();
			  for(int i=0;i<n;i++)
			  {
				  
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
			  
			 /* Object[] st = ref.toArray();
			  for (Object s : ref) {
				    System.out.println("Distinct List "+ref.indexOf(s));
				    System.out.println("Distinct List "+ref.lastIndexOf(s));
			        if (ref.indexOf(s) != ref.lastIndexOf(s)) {
			            ref.remove(ref.lastIndexOf(s));
			         }
			      }
			    System.out.println("Distinct List "+ref);*/
			  
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
			  }
		      break;
		  case 2:
			  System.out.println("do you want to search on 1.country 2. for year minting 3. for current value ");
			  int ch2=sc.nextInt();
			  switch(ch2)
			  { 
			  case 1:
					 try 
					  {
						fin=new FileInputStream("text1.txt");
						objectIn = new ObjectInputStream(fin);
						ArrayList <Coin> st=new ArrayList();
						//Object obj = objectIn.readObject();
						st=(ArrayList<Coin>) objectIn.readObject();
						System.out.println("Enter the country Name::");
						String s1=sc.next();
						for(int c=0;c<((ArrayList<Coin>) st).size();c++)
						{
									//ref.get(c).display();
									if(st.get(c).getCountry().equals(s1))
									{
										st.get(c).display();
									}
							//ref.add(new Coin(st.Country,st.Denomination,st.Yearofminting,st.currentvalue,st.acquireddate));
						}
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
					break;
			  case 2:
				  System.out.println("Enter the Year");
				  int year=sc.nextInt();
					for(int c=0;c<ref.size();c++)
					{
						//ref.get(c).display();
						if(ref.get(c).getYearofminting()==year)
						{
							ref.get(c).display();
						}
					}
					break;
			  }
			  break;
		}
		System.out.println("do you want to continue");
		 ch=sc.next();
		}while(ch.equals("Y") || ch.equals("y") );
}
}
