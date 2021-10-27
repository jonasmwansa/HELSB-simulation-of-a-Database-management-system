import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection   //creating a class 
{                                 //class begins
	public static Connection connect() // instance method with an error handling features
	{
		Connection con = null;
		try {                     
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:HELSB_DB.db"); 
			System.out.println("\nThe Database has been connected");
		}
		
		catch (ClassNotFoundException | SQLException e)
		{
	
			System.out.println(e+ " ");
			return con;
		}
		return con;
	}
	


}// end of class DatabaseConnection
