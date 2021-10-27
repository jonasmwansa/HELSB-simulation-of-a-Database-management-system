/* 
 * THE COPPERBELT UNIVERSITY
 * SCHOOL OF INFORMATION COMMUNICATION TECHNOLOGY
 * CS350 TEST 2
 * NAME   : JONAS MWANSA
 * SIN    :  17118239
 * PROGRAM: COMPUTER ENGINEERING
 *  
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Scanner;
import java.sql.Statement;

//class DbTest
public class TestingDatabase
{

	
//main method
	public static void main(String[] args)
	{
	
		Scanner input=new Scanner(System.in);
		Scanner in =new Scanner(System.in);

		//This methods enclosed in a do while loop enables the user to select an option from options	
		int option = 0;
		do 
		{
			//ThIS MAIN MENU from which the user can choose an action to be performed
			System.out.println("\n\n--------------MAIN MENU-----------\nKINDLY ENTER AN OPTION (enter 4 to EXIT )");
			System.out.println("\t1. ADD DATA INTO HELSB DATABASE");
			System.out.println("\t2. DISPLAY DATA IN HELSB DATABASE");
			System.out.println("\t3. DELETE DATA FROM THE HELSB DATABSE");

			System.out.print("\n>>");
			option = input.nextInt();
			
			switch(option)
			{
				case 1:
					//Prompts User to enter data
					System.out.println("INSERTING A RECORD");	
					System.out.print("ENTER STUDENT ID : \n>>");
			        int StudentID = input.nextInt();
			        
			        System.out.print("ENTER FIRST NAME : \n>>");
			        String FirstName = input.next();
	
			        System.out.print("ENTER LAST NAME : \n>>");
			        String LastName = input.next();
	
			        System.out.print("ENTER PROGRAMME OF SSTUDY : \n>>");
			        String Programme = in.nextLine();
			        
			        System.out.print("ENTER NAME OF YOUR INSTITUTION : \n>>");
			        String Institution = in.nextLine();
					
			        //This Method Automatically calls the insert method that is used 
			        //to pass in data into HELSB database
					insertData(StudentID, FirstName,LastName, Programme, Institution);
					
					break;
					
				//method used to Display and read all data in Database
				case 2:
					
					readAllData();	
					break;
					
					//method used to remove specific data from HELSB database
				case 3:
				
					System.out.println("DELETING A ROW IN A DATABASE");
					System.out.print("Enter STUDENT ID record to delete\n>>"); 
					int ID = input.nextInt();
			        
					//This method to deletes specific data FROM THE HELSB database
			        DeleteRow(ID);
			        break;					
			      
				case 4:
					System.out.println("succesfully terminated");
					return;
				default:
					System.out.println("you entered an INVALID option");
			}
			
		} while(option!=4);		
		
		
		
		//end loop
		
	}//end of main

	// method for inserting data into HELSB database
	private static void insertData(int StudentID,String FirstName,String LastName, String Programme, String Institution)
	{
		Connection conn = DatabaseConnection.connect();
		PreparedStatement state = null;
		
		try
		{
			String sqlite = "INSERT INTO PersonalDetails (StudentID, FirstName, LastName, Programme, Institution) VALUES ( ?, ?, ?, ?, ?)";
		
			PreparedStatement st= conn.prepareStatement(sqlite);
            st.setInt(1, StudentID);		
            st.setString(2, FirstName);		
            st.setString(3,LastName);
            st.setString(4,Programme);
            st.setString(5,Institution);		
        
        int rowsInserted = st.executeUpdate();	
        if (rowsInserted > 0)
        {
            System.out.println("Details Entered Successfully!");
        }

		}
		catch(SQLException e)
		{
			System.out.println(e.toString());
		}
	}
	
	//Method Reads all data from the HELSB database
	private static void readAllData()
	{
		Connection conn = DatabaseConnection.connect();
		PreparedStatement state = null;
		ResultSet result = null;
		
		try
		{
			//select all "*"
	 		String sqlite = "SELECT * FROM PersonalDetails";
	 		state = conn.prepareStatement(sqlite);
	 		result = state.executeQuery();
	 		
 			//prints all data
 			System.out.println("\nALL RECORDS IN HELSB DATABASE\n");
	 		
 			while(result.next())
	 		{
	 			int StudentID = result.getInt("StudentID");
	 			String FirstName = result.getString("FirstName");
	 			String LastName = result.getString("LastName");
	 			String Programme = result.getString("Programme");
	 			String Institution = result.getString("Institution");
	 			
	 			System.out.println
	            (
	            		result.getInt("StudentID")+ "\t" + result.getString("FirstName")+
	            		"\t" +result.getString("LastName") + "\t" + result.getString("Programme")+
	            		"\t" + result.getString("Institution")
	            );
	 		}
	 		
		}
		
		catch(SQLException e)
		{
			System.out.println(e.toString());
		}
		
        finally
        {   
        	try { 
                
        		result.close();
        		state.close();
                conn.close();
            } 
            
            catch (SQLException e)
            {
            	e.printStackTrace();
            }
         }
        
	}
	
	
	//method to delete data by searching a specific id in HELSB Database
	private static void DeleteRow(int StudentID)
	{
		Connection conn = DatabaseConnection.connect();
		PreparedStatement state = null;
		
		try 
		{
			//delete PersonalDetailsbase
	       String sqlite = "DELETE FROM PersonalDetails WHERE StudentID = ?";

	        state = conn.prepareStatement(sqlite);

	        	state.setInt(1, StudentID);
	        	
	        //method update HELSB database if any deletion occurred
	        int rowsDeleted = state.executeUpdate();
	                if (rowsDeleted > 0)
	                {
	    				System.out.println("DELETED SUCCESSFULLY");
	    			}
	                else
	                	System.out.println("INVALID RECORD");
	        }
				//if it's not there flag an error
	                    catch (Exception e)
	                    {
	                    	System.out.println(e.toString());
	                   	}
				//closing
							finally
							{
							try {
								state.close();
								conn.close();
							}
							catch (SQLException e)
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							}
	       }//end of method to delete data
	
} //end of class
