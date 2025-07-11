package week3.day2;

	//Creating JavaConnection class and calling interface DatabaseConnection
	public class JavaConnection implements DatabaseConnection {

		//The unimplemented methods from the interface have been called
		@Override
		public void connect() {
			System.out.println("Connect to Java Database");
		}
		@Override
		public void disconnect() {
			System.out.println("Disconnect from Java Database");
		}
		@Override
		public void executeUpdate() {
			System.out.println("Execution done");
		}
		//Creating a method in JavaConnection class
		public void Javadata() {
			System.out.println("Captured the Xpath for elements");
		}
		public static void main(String[] args) {
			//Created an object to call the methods in JavaConnection class and interface DatabaseConnection
			JavaConnection jc = new JavaConnection();
			jc.connect();
			jc.disconnect();
			jc.executeUpdate();
			jc.Javadata();
			jc.loginStatus();
			
		}

	}