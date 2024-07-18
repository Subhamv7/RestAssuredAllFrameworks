package panCardMock;

import org.mockito.Mockito;

class PANCard {

	public  String isValid(String panCard) {

		if (panCard.matches("[A-Z] {5} [0-9] {4} [A-Z]") == true) {

			return "is valid PAN";

		} else {
			return "is not valid";
		}
	}

	public static PANCard getMockObject() {
		PANCard mocObj = Mockito.mock(PANCard.class);
		Mockito.when(mocObj.isValid("ABCDE1234A")).thenReturn("Valid PANCard");
		Mockito.when(mocObj.isValid("ABCDE1234B")).thenReturn("Valid PANCard");
		Mockito.when(mocObj.isValid("ABCDE1234C")).thenReturn("Invalid PANCard");
		return mocObj;

	}
}

	public class MockingTest {
		public static void main(String[] args) {
			
		PANCard obj = PANCard.getMockObject();
		System.out.println(obj.isValid("ABCDE1234B"));
		 
			
			
			
		}


}
