import java.io.Serializable;

public class Coin implements  Comparable,Serializable  
{
	
	String Country;
	int Denomination;
	int Yearofminting;
	int currentvalue;
	String acquireddate;

	public Coin(String country, int demonitization, int yearofminting, int currentvalue, String acquireddate) 
	{

	    this.Country = country;
		this.Denomination = demonitization;
		this.Yearofminting = yearofminting;
		this.currentvalue = currentvalue;
		this.acquireddate = acquireddate;
	}

	
public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public int getDenomination() {
		return Denomination;
	}


	public void setDenomination(int denomination) {
		Denomination = denomination;
	}


	public int getYearofminting() {
		return Yearofminting;
	}


	public void setYearofminting(int yearofminting) {
		Yearofminting = yearofminting;
	}


	public int getCurrentvalue() {
		return currentvalue;
	}


	public void setCurrentvalue(int currentvalue) {
		this.currentvalue = currentvalue;
	}


	public String getAcquireddate() {
		return acquireddate;
	}


	public void setAcquireddate(String acquireddate) {
		this.acquireddate = acquireddate;
	}


public void display()
{
	System.out.println(this.Country +" "+this.Denomination+" "+this.Yearofminting+" "+this.currentvalue+" "+this.acquireddate );
}


public int compareTo(Coin arg0) {
	// TODO Auto-generated method stub
	return 0;
}


public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}



}
