package week3.day2;

 	//Creating an interface with name DatabaseConnection
	public interface DatabaseConnection {
		
		//creating abstract method in interface DatabaseConnection
		public abstract void connect();
		public abstract void disconnect();
		public abstract void executeUpdate();
		default void loginStatus() 
		{
			System.out.println("Log in Success");
		}
		

	}