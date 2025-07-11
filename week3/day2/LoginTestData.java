package week3.day2;

//Creating subclass LoginTestData and inheriting Superclass TestData
public class LoginTestData extends TestData {
	
	//Creating methods in the subclass LoginTestData
	public void enterUsername() {
		System.out.println("Username: rsravpar@amazon.com");
	}
	public void enterPassword() {
		System.out.println("Password: 2025@RamSra");
	}
	public static void main(String[] args) {
		//Creating object to call methods from subclass LoginTestData and Superclass TestData
		LoginTestData Ltd = new LoginTestData();
		Ltd.enterPassword();
		Ltd.enterUsername();
		Ltd.enterCredentials();
		Ltd.navigateToHomePage();
		
	}

}