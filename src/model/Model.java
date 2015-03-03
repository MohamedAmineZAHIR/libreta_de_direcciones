/**
 * @author MohamedAmine
 */

package model;

import java.sql.ResultSet;
import zma.Dbo;


public class Model 
{
	public Dbo adsl;
	
	
	public Model() {
		super();
		this.adsl = new Dbo("jdbc:mysql://localhost/adress_book", "com.mysql.jdbc.Driver", "root", "");
	}
	
	
	/**
	 * Fonction qui enregistre un contact dans la bdd.
	 * @param first_name
	 * @param family_name
	 * @param adress
	 * @param phone
	 */
	public void save_contact(String first_name, String family_name, String adress, String phone){
		adsl.Requete("INSERT INTO contacts VALUES(Null, '"+first_name+"', '"+family_name+"', '"+adress+"', '"+phone+"') ");
		System.out.println("ajoutée avec succés!");
	}
	
	
	/**
	 * Fonction qui liste le contenu de la bdd.
	 */
	public ResultSet contacts_list(){
		return adsl.Extract("SELECT * FROM contacts");
	}
	
	
	/**
	 * Fonction qui recherche un ou des contacts donnés.
	 * @param first_name
	 * @param family_name
	 * @return Fct retoune un objet ResultSet pour l'envoyer à la vue jsp afin qu'elle garde son aspect "model".
	 */
	public ResultSet find_contact(String first_name, String family_name){
		
		if (first_name != "")
			return adsl.Extract("SELECT * FROM contacts WHERE first_name='"+first_name+"' AND family_name='"+family_name+"'");
		else
			return adsl.Extract("SELECT * FROM contacts WHERE family_name='"+family_name+"'");
	}
	
	
	/**
	 * Fonction qui mis à jour un contact donné.
	 * @param first_name
	 * @param family_name
	 * @param column
	 * @param value
	 */
	public void update(String first_name, String family_name, String column, String value){
		adsl.Requete("UPDATE contacts SET " + column + "='"+value+"' WHERE first_name='"+first_name+"' AND family_name='"+family_name+"'");
	}
	
	
	/**
	 * Fonction qui supprime un contact donné de la bdd.
	 * @param first_name
	 * @param family_name
	 */
	public void delete(String first_name, String family_name){
		adsl.Requete("DELETE FROM contacts WHERE first_name='"+first_name+"' AND family_name='"+family_name+"'");
	}
}
