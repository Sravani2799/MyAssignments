package week3.day2;

	//Creating superclass TestData
	public class TestData {
		
		//Creating methods in superclass TestData
		public void enterCredentials()
		{
			System.out.println("RamSra@1234");
		}
		
		public void navigateToHomePage() 
		{
			System.out.println("Navigated to Home Page");
		}
		
		public static void main(String[] args)
		{
			//Creating an object to call the methods in superclass TestData
			TestData Td = new TestData();
			Td.enterCredentials();
			Td.navigateToHomePage();
		}

	}