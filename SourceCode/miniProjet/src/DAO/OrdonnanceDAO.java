
package DAO;

import MODEL.Medicament;
import MODEL.Ordonnace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdonnanceDAO {
    
     public static void AjouterLigneOrdonnace(Ordonnace o) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "insert into ordonnance (`Posologie`,`Qte`,`IdMed`) values (?,?,?);";
            PreparedStatement ps = cn.prepareStatement(req);
            
            ps.setString(1,o.getPosologie());
            ps.setInt(2,o.getQte());
            ps.setInt(3,o.getIdMed());
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println("Une nouvelle ligne ordonnance est ajoutée !");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
     
     
     
     public static void ModifierLigneOrdonnance(Ordonnace o) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "update ordonnance set Posologie=?, Qte=?, IdMed=?  where id=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            
            ps.setString(1,o.getPosologie());
            ps.setInt(2,o.getQte());
            ps.setInt(3,o.getIdMed());
            ps.setInt(4,o.getId());
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println("modification effectuée!");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
    
    
     
      public static void SupprimerLineOrdonnance(int id) {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "delete from ordonnance where id=?;";
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1,id);
            
            int res = ps.executeUpdate();

            if(res != 0){
            System.out.println(" Ligne supprimée ");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
      
      
       public static void EffacerTout() {
         Connection cn = Connexion.getConnection();
         if (cn != null) {
        try {
          
            String req = "truncate  table ordonnance;";
            PreparedStatement ps = cn.prepareStatement(req);
            
            int res = ps.executeUpdate();

            if(res == 0){
            System.out.println(" Toutes les Ligne sont supprimées ");
            }
            

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());
        }
         }
    }
    
      
    
}
