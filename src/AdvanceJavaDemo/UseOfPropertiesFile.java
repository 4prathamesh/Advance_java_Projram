package AdvanceJavaDemo;
import java.io.*;
import java.util.*;

interface ABC
{
	void show();
}
public class UseOfPropertiesFile {

	public static void main(String[] args) {
		
		ABC a= new ABC() {
			public void show()
			{
				System.out.println("pratham");
			}
		};
		a.show();
		
//		FileInputStream fr= new FileInputStream("C:\\Users\\PRATHAMESH\\eclipse-workspace\\AdvanceJava\\resourse\\db.properties");
//		Properties p= new Properties();
//		p.load(fr);
//		System.out.println("class name "+p.getProperty("driver.classname"));

	}

}
