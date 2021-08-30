
package DAO;
import java.sql.*;

public class Connexion {
    // Params de la connexion
	private static String url = "jdbc:mysql://localhost:3306/projetjava";
	private static String user = "root";
	private static String passwd = "";

	private static Connection cn = null;

	// Constructeur privé pour limiter l'instanciation
	public Connexion() {
		try { 
			cn = DriverManager.getConnection(url, user, passwd);
		} 
		catch ( Exception e ) {
			e.printStackTrace();  
		}
	}

	// On n'instancie la connexion que si le cn est different de null
	public static Connection getConnection() {
		if (cn == null) {
			new Connexion();
		}
		return cn;
	}
	// Méthode de fermeture de la connexion
	public static void Fermer() {
		if (cn != null) {
			try {  cn.close(); }
			catch (SQLException e) { 
				e.printStackTrace();  
			}
		}
	}
    
}
