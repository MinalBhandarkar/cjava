import java.util.Scanner;

public class Loan extends Account {
	
	public static float yearlyrate=0.2f;
	@Override
	public void accept() {
		
		
	}

	public float withdraw(int id,int bal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display() {
		System.out.println("Total amount is");
		
	}

	@Override
	public float deposit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float calculateinterest()
	{
		System.out.println("enter the year");
		Scanner sc= new Scanner(System.in);
		int year=sc.nextInt();
		
		System.out.println("enter the amount");
	
		float amount=sc.nextFloat();
		
		
		
		 for (int i = 0; i <= year; i++ )
		 {
	            amount = amount + yearlyrate;
	             System.out.println(i + "   " + amount);                     
	        }
		return amount;
	}
}
