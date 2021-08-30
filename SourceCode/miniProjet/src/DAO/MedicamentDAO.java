
package DAO;

import java.sql.PreparedStatement;
import MODEL.Medicament;
import DAO.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicamentDAO {
    
     public static void AjouterMedicament(Medicament m) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "insert into medicament (`IdMed`,`NomMed`) values (?,?);";
            PreparedStatement ps = cn.prepareStatement(req);
            
            ps.setString(1,m.getIdMed());
            ps.setString(2,m.getNomMed());
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println("Un nouveau medicament est ajoutÃ© !");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
     
     public static void SupprimerMedicament(String id) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "delete from medicament where IdMed=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1,id);
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println(" medicament est supprimé ");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
     
     
     
     public static void AfficherListeMedicament() {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "select * from medicament;";
            PreparedStatement ps = cn.prepareStatement(req);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
            String IdMed = res.getString("IdMed");
            String NomMed = res.getString("NomMed");
           
            System.out.println("id med est: " + IdMed + " & nom med est: " + NomMed );
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
     
     public ArrayList<Medicament> getAllMedicaments()
	{
		ArrayList<Medicament> allMedicaments = new ArrayList<Medicament>();
		
		// Ouverture de la connexion a la base de données
		Connection connexion = Connexion.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from medicament;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ResultSet res = ps.executeQuery();				
				while (res.next()) {
					Medicament m = new Medicament(res.getString("IdMed"),res.getString("NomMed"));
					allMedicaments.add(m);
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return allMedicaments;
	}
     
     
      public static void RechercherMedicament(String id) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "select * from medicament where IdMed=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1,id);
            ResultSet res = ps.executeQuery();
            
           while(res.next()){
            String IdMed = res.getString("IdMed");
            String NomMed = res.getString("NomMed");
           
            System.out.println("id med est: " + IdMed + " & nom med est: " + NomMed );
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
      
      
      
      public static void ModifierMedicament(Medicament m) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "update medicament set IdMed=?, NomMed=? where IdMed=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            
            ps.setString(1,m.getIdMed());
            ps.setString(2,m.getNomMed());
            ps.setString(3,m.getIdMed());
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println("modification effectuée!");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
      
      public void rechercherParNom(String NomMed)
	{
		Medicament m = null;
		// Ouverture de la connexion a la base de données
		Connection connexion = Connexion.getConnection();
				
		if(connexion != null)
		{
			String query = "select * from medicament where NomMed = ?;";
			try {
				PreparedStatement ps = connexion.prepareStatement(query);
						
				ps.setString(1, NomMed);
						
				ResultSet res = ps.executeQuery();				
				if (res.next()) {
					//m = new Medicament(res.getInt(1),res.getString(2));
				}else
				{
					System.out.println("Impossible de trouver le medicament!");
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//return m;
	}
    
}
