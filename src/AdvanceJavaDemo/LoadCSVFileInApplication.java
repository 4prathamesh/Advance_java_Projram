package AdvanceJavaDemo;
import java.io.*;
import java.sql.*;
public class LoadCSVFileInApplication {

	public static void main(String[] args)throws SQLException,IOException,ClassNotFoundException{
		
		FileReader fr = new FileReader("E:\\java\\ppppp\\check.csv");
		BufferedReader br= new BufferedReader(fr);
		
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","12345");
		String line;
		int value=0;
		while((line=br.readLine())!=null)
		{
			String coStr[]=line.split(",");
			PreparedStatement ps= conn.prepareStatement("insert into student values(?,?,?,?,? )");
			
			ps.setInt(1, Integer.parseInt(coStr[0]));
			ps.setString(2, coStr[1]);
			ps.setString(3, coStr[2]);
			ps.setString(4, coStr[3]);
			ps.setString(5, coStr[4]);
			value = ps.executeUpdate();
		}
		if(value!=0)
		{
			System.out.println("value is insert into");
		}
		else
		{
			System.out.println("value is not insert");
		}	
	}

}
