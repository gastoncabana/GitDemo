

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class jdbconection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gasto\\Desktop\\TCS\\Archivos\\webDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		String host = "localhost";
		String port = "3306";
		driver.get("https://login.salesforce.com");
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/qadbt", "root", "");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from credentials where scenario ='1'");

		while (rs.next())

		{


		

			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
			
			driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		}

	}

}