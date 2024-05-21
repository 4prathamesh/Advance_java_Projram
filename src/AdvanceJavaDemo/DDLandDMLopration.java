package AdvanceJavaDemo;
import java.sql.*;
import java.util.*;
//import java.sql.DriverManager;
public class DDLandDMLopration {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Driver registered");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo","root","12345");
		
		
		if(conn!=null)
		{
			
			Statement sta= conn.createStatement();
			boolean b=false;
		do
		{
			System.out.println("1. student table");
			System.out.println("2. Enter the data in table");
			System.out.println("3. delete data from table");
			System.out.println("4. update data from table");
			Scanner sc= new Scanner(System.in);
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
			case 1:
				
					System.out.println("connection is estiblace");
					
					int value=sta.executeUpdate("create table Student (id int primary key,name varchar(15) not null,email varchar(15))");
					if(value==0)
					{
						System.out.println("table create ");
					}
					else 
					{
						System.out.println("not create ");
					}
				
				break;
			case 2:
				System.out.println("enter the id");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("enter the name");
				String name=sc.nextLine();
				System.out.println("enter the email");
				String email=sc.nextLine();
				int value1=sta.executeUpdate("insert into student values("+id+",'"+name+"','"+email+"')");
				if(value1!=0)
				{
					System.out.println("data insert ");
				}
				break;
			case 3:
				System.out.println("enter the id ");
				id=sc.nextInt();
				value1=sta.executeUpdate("delete from student where id="+id);
				if(value1!=0)
				{
					System.out.println("delete data from table");
				}
				else
				{
					System.out.println("not delete");
				}
				break;
			case 4:
				System.out.println("enter the id");
				id=sc.nextInt();
				sc.nextLine();
				System.out.println("enter the update name");
				name=sc.nextLine();
				value1=sta.executeUpdate("Update student set name='"+name+"' where id="+id+"");
				if(value1!=0)
				{
					System.out.println("update data from table");
				}
				else
				{
					System.out.println("not update");
				}
				break;
			case 6:
				
				break;
			case 5:
				b=true;
				break;
			}
			if(b)
			{
				break;
			}
			
		}while(true);
		
		}
		else
		{
			System.out.println("connection not estibles");
		}

	}

}
