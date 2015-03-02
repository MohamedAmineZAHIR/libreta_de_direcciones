package zma;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Dbo 
{
		private String url, driver, log, pwd;
		private static  Connection connection;
		private Statement requete;
		
		public Dbo(String url, String driver, String log, String pwd){
			super();
			this.driver = driver;
			this.log = log;
			this.pwd = pwd;
			this.url = url;
			try{
				Class.forName(driver);
				connection = (Connection) DriverManager.getConnection(url, log, pwd);
				requete =  (Statement) connection.createStatement();	
				}catch(Exception e){}
		}
		
		
		public void Requete(String sql){
			try{
				requete.execute(sql);
			}catch(Exception e){	e.printStackTrace();	}
		}
		
		
		public ResultSet Extract(String sql){
			ResultSet res = null;
			try{
				 res = requete.executeQuery(sql);
				}catch(Exception e){	e.printStackTrace();	}	
			return res;
		}
			

}
