package practice_Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame  implements Serializable{
	
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
		
	}


public class Run1_Serialization {
	public static void main(String[] args) throws IOException {
		
		NFSGame user1Obj = new NFSGame("Subham" , 10 , 50000 , 2);
		FileOutputStream fos = new FileOutputStream("./file.txt");
		
		ObjectOutputStream objOut = new ObjectOutputStream(fos);
		objOut.writeObject(user1Obj);
		System.out.println("end");
		
	}
	
	
	
	

}
