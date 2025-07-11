package week3.day2;

//Creating a class JavaConnection2 and inheriting the abstract class MySqlConnection
public class JavaConnection2 extends MySqlConnection {
	
	//Calling unimplemented Methods from abstract class MySqlConnection and interface DatabaseConnection appear as MySqlConnection inplements interface DatabaseConnection
	@Override
	public void connect() {
		System.out.println("Connect to Java Database");		
	}

	@Override
	public void disconnect() {
		System.out.println("Diconnect from Java Database");
	}

	@Override
	public void executeUpdate() {
		System.out.println("Execution is done");
	}

	@Override
	public void executeQuery() {
		System.out.println("Execute");
		
	}
	public static void main(String[] args) {
		//Creating an object to call the methods from abstract class MySqlConnection, interface DatabaseConnection
		JavaConnection2 jc2= new JavaConnection2();
		jc2.connect();
		jc2.disconnect();
		jc2.executeUpdate();
		jc2.executeQuery();

	}
}
