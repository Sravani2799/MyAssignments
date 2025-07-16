package week4.day1;

//Implementing the Overloading in Java
//Class has been created with name :APIClient
public class APIClient {
	
	//two methods with the same name passing different input arguments has been created
	public void sendRequest(String endpoint) {
		System.out.println("The String is: " + endpoint);
	}
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("String name is: " + endpoint + ". And your current request is: " + requestBody + ". And the Request Status is: " + requestStatus);
	}

	public static void main(String[] args) {
		
		//object has been created for the APIClient class
		APIClient sR = new APIClient();
		
		//Called both versions of the sendRequest method with different sets of input arguments
		sR.sendRequest("Browser");
		sR.sendRequest("Browser", "Your installation is not successful", false);
		
	}

}
