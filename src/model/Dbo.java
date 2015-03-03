/**
 * @author MohamedAmine
 */
package zma;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class Dbo 
{
		private static  Connection connection;
		private Statement requete;
		
		
		/**
		 * Contructeur, ou à vrai dire, initialiseur.
		 * @param url
		 * @param driver
		 * @param log
		 * @param pwd
		 */
		public Dbo(String url, String driver, String log, String pwd){
			super();
			try{
				Class.forName(driver);
				connection = (Connection) DriverManager.getConnection(url, log, pwd);
				requete =  (Statement) connection.createStatement();	
				}catch(Exception e){}
		}
		

		/**
		 * Exécuter une requête SQL qui retourne pas de résultat.
		 * @param sql
		 */
		public void Requete(String sql){
			try{
				requete.execute(sql);
			}catch(Exception e){	e.printStackTrace();	}
		}
		
		
		/**
		 * Exécuter une requête SQL qui retourne un resultat.
		 * @param sql
		 * @return
		 */
		public ResultSet Extract(String sql){
			ResultSet res = null;
			try{
				 res = requete.executeQuery(sql);
				}catch(Exception e){	e.printStackTrace();	}	
			return res;
		}
}
