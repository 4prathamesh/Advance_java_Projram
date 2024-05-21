//Q 2.Write The Jdbc Program To Perfrom All Operation Using Prepared Statement:
//
//Case 1 :  Create Table Name As Student.
//Case 2 : Insert 10 records in Student tables using studid , studname ,
//			studemail , studcontact , studaddress.
//Case 3 : Display All Record Of Student Table.
//Case 4 : Write SQL Query to display all student record using all columns values.
//Case 5 : Write SQL Query to display only name, email and contact from student table.
//Case 6 : Write a SQL Query to display distinct name from student table.
//Case 7 : Write SQL Query to delete Student whose id is 1. 
//Case 8 : Write SQL Query to delete Student whose id is 4 and name is ram. 
//Case 9 : Write SQL Query to update student whose id is 1 or name is shyam.
//Case 10 : Write SQL Query to change name, email and contact of student whose is id 3.
package AdvanceJavaDemo;

import java.sql.*;
import java.util.*;

public class Practical_Q2_PreparedStatement_24_04 {

	public static void main(String[] args) throws SQLException {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "12345");
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		if (conn != null) {
			do {
				System.out.println("\n1. Create Table Name As Student.");
				System.out.println("2. Insert 10 records in Student tables using studid , studname ,\r\n"
						+ "studemail , studcontact , studaddress.");
				System.out.println("3. Display All Record Of Student Table.");
				System.out.println("4. Write SQL Query to display all student record using all columns values.");
				System.out.println("5. Write SQL Query to display only name, email and contact from student table.");
				System.out.println("6. Write a SQL Query to display distinct name from student table.");
				System.out.println("7. Write SQL Query to delete Student whose id is 1");
				System.out.println("8. Write SQL Query to delete Student whose id is 4 and name is ram");
				System.out.println("9. Write SQL Query to update student whose id is 1 or name is shyam");
				System.out.println("10. Write SQL Query to change name, email and contact of student whose is id 3");
				
				System.out.println("enter the chocie");
				int choice = sc.nextInt();

				switch (choice) {
				case 1: // Create Table Name As Student.
					PreparedStatement p = conn.prepareStatement(
							"create table student ( id int primary key , name varchar(12) not null , email varchar(15) not null unique , contact varchar(10) , addres varchar(15)  )");
					int value = p.executeUpdate();
					if (value == 0) {
						System.out.println("table create");
					} else {
						System.out.println("table not create ");
					}
					break;
				case 2: // Insert 10 records in Student tables

					p = conn.prepareStatement("insert into student values ( ?,?,?,?,? )");
//					for(int i=1;i<=2;i++)
//					{
					System.out.println("enter the id ");
					int sid = sc.nextInt();
					System.out.println("enter the name ");
					String sname = sc.next();
					System.out.println("enter the email");
					String semail = sc.next();
					System.out.println("enter the contact");
					String scontact = sc.next();
					System.out.println("enter the addres");
					String saddres = sc.next();

					p.setInt(1, sid);
					p.setString(2, sname);
					p.setString(3, semail);
					p.setString(4, scontact);
					p.setString(5, saddres);

					value = p.executeUpdate();
					if (value != 0) {
						System.out.println("value insert\n");
					} else {
						System.out.println("value not insert\n");
					}

					break;
				case 3: // Display All Record Of Student Table.
					p = conn.prepareStatement("select *from student");
					ResultSet rs = p.executeQuery();
					boolean flag1 = true;			
					while (rs.next()) {
						flag1 = false;
						System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("email")
								+ "\t" + rs.getString("contact") + "\t" + rs.getString("addres"));
					}
					if (flag1) 
					{
						System.out.println("data is not prasent");
					}
					break;
				case 4: // Write SQL Query to display all student record using all columns values.
					p = conn.prepareStatement("select *from student");
					rs = p.executeQuery();
					System.out.println(rs);
					if (rs.next()) {
						while (rs.next()) {
							System.out.println(
									rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("email") + "\t"
											+ rs.getString("contact") + "\t" + rs.getString("addres"));
						}
					} else {
						System.out.println("Data is not present ..........");
					}
					break;
				case 5: // Write SQL Query to display only name, email and contact from student table.
					PreparedStatement ps = conn.prepareStatement("Select name, email, contact from student ");
					ResultSet rs1 = ps.executeQuery();
					while (rs1.next()) {
						System.out.println(rs1.getString("name") + "\t" + rs1.getString("email") + "\t"
								+ rs1.getString("contact"));
					}

					break;
				case 6:  //Write a SQL Query to display distinct name from student table.
					PreparedStatement ps2= conn.prepareStatement("select distinct name from student");
					ResultSet rs2=ps2.executeQuery();
					while(rs2.next())
					{
						System.out.println(rs2.getString("name"));
					}
					break;
				case 7:  //Write SQL Query to delete Student whose id is 1
					System.out.println("enter the id for delete record");
					int Sid=sc.nextInt();
					PreparedStatement ps3=conn.prepareStatement("delete from student where id="+Sid);
					value=ps3.executeUpdate();
					if(value!=0)
					{
						System.out.println("delete record");
					}
					else {
						System.out.println("not delete record");
					}
					break;
				case 8:  //Write SQL Query to delete Student whose id is 4 and name is ram.
					System.out.println("enter the id and name");
					Sid=sc.nextInt();
					String Sname=sc.next();
					PreparedStatement ps4=conn.prepareStatement("delete from student where id="+Sid+" and name="+Sname);
					ResultSet rs4=ps4.executeQuery();
					while(rs4.next())
					{
						System.out.println(rs4.getInt("id") + "\t" + rs4.getString("name") + "\t" + rs4.getString("email")
						+ "\t" + rs4.getString("contact") + "\t" + rs4.getString("addres"));
					}
					break;
				case 9:   //Write SQL Query to update student whose id is 1 or name is shyam
					break;
				case 10:
					break;
				default:
					flag = true;
				}
				if (flag) {
					break;
				}
			} while (true);

		} else {
			System.out.println("connection fill!!....");
		}

	}

}
