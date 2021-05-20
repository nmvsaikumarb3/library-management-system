import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	public static void main(String[] args) {
		  ConnectionDB obj=new ConnectionDB();
		  obj.get_Connection();
	}
		public Connection get_Connection() { 
			String host="sql6.freemysqlhosting.net";
	        String db_name="sql6400624";
	        String username="sql6400624";
	        String password="djZTpQeLFb";
	        String port="3306";
	        
	        Connection con=null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		con  = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db_name,username,password); 
	            if (con != null) {
	                System.out.println("Connection OK");
	            } else {
	                System.out.println("Connection Failed");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
		}


	}


