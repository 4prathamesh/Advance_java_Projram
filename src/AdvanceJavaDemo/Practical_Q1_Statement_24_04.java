//Q 1.Write The Jdbc Program To Perfrom All Operation Using Statement:
//
//Case 1: Create Table Name As Employee.
//Case 2: Insert Five Record Of  Employee Table Using Feild Eid , Ename , 
//			Eemail , Esal , Econtact.
//Case 3: Display All Record Of Employee Table.
//Case 4: Update Employee Record By Id.
//Case 5: Delete Employee Record By Name.
package AdvanceJavaDemo;

import java.util.*;
import java.sql.*;

public class Practical_Q1_Statement_24_04 {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver dri = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(dri);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "12345");
		if (conn != null) {
			Statement stat = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			boolean b = false;
			do {
				System.out.println("\n1. Create Table Name As Employee.");
				System.out.println("2. Insert Five Record Of  Employee Table"
						+ " Using Feild Eid , Ename , Eemail , Esal , Econtact.");
				System.out.println("3. Display All Record Of Employee Table.");
				System.out.println("4. Update Employee Record By Id.");
				System.out.println("5. Delete Employee Record By Name");
				System.out.println("6. exit");
				System.out.println("enter the choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:  // Create Table Name As Employee.
					int value = stat.executeUpdate(
							"create table employee ( Eid int primary key , Ename varchar(15) not null, "
									+ "Eemail varchar(15) not null , Esal decimal(10,2) ,Econtace varchar(10) )");
					if(value==0)
					{
						System.out.println("table create ");
					}
					else {
						System.out.println("table alrody present");
					}
					break;
				case 2: //Insert Five Record Of  Employee Table Using Feild Eid , Ename , 
//							Eemail , Esal , Econtact.
					for(int i=0;i<2;i++)
					{
						System.out.println("enter the id , sal , name , email , contact");
						int id=sc.nextInt();
						float sal=sc.nextFloat();
						sc.nextLine();
						String name = sc.nextLine();
						String email=sc.nextLine();
						String contact=sc.nextLine();
						value=stat.executeUpdate("insert into employee values ( "+id+" , '"+name+"' , '"+email+"' ,'"+sal+"' , '"+contact+"' )");
						if(value!=0)
						{
							System.out.println("data insert");
						}
						else
						{
							System.out.println("data is not insert ");
						}
					}
					break;
				case 3:  //Display All Record Of Employee Table.
					ResultSet rs= stat.executeQuery("select *from employee");
					while(rs.next())
					{
						int id=rs.getInt("Eid");
						String name =rs.getString("Ename");
						String email=rs.getString("Eemail");
						float sal=rs.getFloat("Esal");
						String contact=rs.getString("Econtace");
						System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
					}
					break;
				case 4:  //Update Employee Record By Id.
					System.out.println("enter the name for update");
					String name =sc.next();
					System.out.println("Enter the id of employee for update name");
					int id=sc.nextInt();
					value = stat.executeUpdate("update employee set name="+name+" where id="+id+"");
					if(value!=0)
					{
						System.out.println("name is Update");
					}
					else
					{
						System.out.println("not Update");
					}
					break;
				case 5:   //Delete Employee Record By Name
					System.out.println("Enter name for delete the employee record");
					name=sc.next();
					value=stat.executeUpdate("delete employee where name="+name+"");
					if(value!=0)
					{
						System.out.println("delete record");
					}
					else {
						System.out.println("not delete record");
					}
					break;
				default:
					b = true;
				}
				if(b) 
				{
					break;
				}
			} while (true);
		} 
		else {
			System.out.println("connection not estibles");
		}

	}

}
