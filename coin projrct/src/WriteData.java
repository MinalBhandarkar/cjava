import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteData {

	public static void main(String[] args) {
		FileOutputStream fin;
		try {
			fin = new FileOutputStream("text1.txt");
			ObjectOutputStream objectIn = new ObjectOutputStream(fin);
			Coin c1=new Coin("a",1,1,1,"1/1/1999");
			Coin c2=new Coin("b",2,2,2,"2/2/1999");
			ArrayList<Coin>al =new ArrayList<>();
			al.add(c1);
			al.add(c2);
			objectIn.writeObject(al);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
