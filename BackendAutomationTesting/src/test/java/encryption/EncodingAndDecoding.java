package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodingAndDecoding {

	@Test
	public void sampleTest1() {
		
		String encodeData = new String(Base64.getEncoder().encode("rmgyantra:rmg@9999".getBytes())); 
			System.out.println(encodeData);

}
	
	@Test
	public void sampleTest2() {
		
		String decodeData = new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ0A5OTk5".getBytes())); 
			System.out.println(decodeData);
}
}
