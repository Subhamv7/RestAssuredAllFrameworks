package practice_Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_DeserializationTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("./file.txt");
		
		ObjectInputStream objIS = new ObjectInputStream(fis);
		NFSGame user1Obj  = (NFSGame) objIS.readObject();
		
		System.out.println(user1Obj.name);
		System.out.println(user1Obj.score);
		System.out.println(user1Obj.level);
		System.out.println(user1Obj.life);
	}

}
