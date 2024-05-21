package AdvanceJavaDemo;
import java.sql.*;
import java.util.*;
public class ProcedureForOutputParamater {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/day9","root","12345");
		if(conn!=null)
		{
			Scanner sc=  new Scanner(System.in);
			System.out.println("enter the student id");
			int sid=sc.nextInt();
			
			CallableStatement cs=conn.prepareCall("{call pppp(?,?)}");
			cs.setInt(1, sid);
			cs.registerOutParameter(2, Types.VARCHAR);
			boolean b=cs.execute();
			if(b)
			{
				System.out.println("data is "+cs.getString(2));
				
			}
			
		}
	}

}
